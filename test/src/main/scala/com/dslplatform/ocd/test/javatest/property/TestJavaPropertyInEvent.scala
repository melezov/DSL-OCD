package com.dslplatform.ocd
package test
package javatest
package property

import types._
import javas._

trait TestJavaPropertyInEvent
    extends TestComponentWithProperty {

  def testID: String
  def isDefault: Boolean
  def testValue: JavaValue
  def setupBlock: String = ""

  def testComponentBody = (
    jsonSerializationTest
  + (!isDisallowed(isDefault)).ifTrue(activeRecordPersistTest)
  + (!isDisallowed(isDefault)).ifTrue(repositoryPersistTest)
  )

  private def assertEquals(target: String) = property match {
    case _ if isDisallowed(isDefault) =>
      s"""// special null check for disallowed null value in a non-nullable property
        org.junit.Assert.assertNull(${target}.get${PropertyName}());"""

    case p: OcdJavaBoxTypeProperty if p.boxType.isPrecise =>
      s"""com.dslplatform.ocd.javaasserts.${p.boxType.typeSingleName}Asserts.assert${p.box.boxName}Equals(
                testValue,
                ${target}.get${PropertyName}(),
                2);"""

    case p: OcdJavaBoxTypeProperty =>
      s"""com.dslplatform.ocd.javaasserts.${p.boxType.typeSingleName}Asserts.assert${p.box.boxName}Equals(
                testValue,
                ${target}.get${PropertyName}());"""

    case _ => ???
  }

  def jsonSerializationTest = s"""
    /* Testing the "${propertyName}" ${testID} event property JSON serialization */
    @org.junit.Test
    public void test${PropertyName}${testID}PropertyInEventJsonSerialization() throws IOException {${isDefault match {
      case true => s"""
        final ${conceptName} event = new ${conceptName}();
        final ${propertyType.javaClass} testValue = event.get${PropertyName}();"""

      case _ => s"""
        final ${propertyType.javaClass} testValue = ${testValue};
        final ${conceptName} event = new ${conceptName}()
                .set${PropertyName}(testValue);"""}}

        // check that the property was properly assigned
        ${assertEquals("event")}

        logger.trace("Serializing ${conceptName}: {}", event);
        final com.dslplatform.patterns.Bytes serialized = jsonSerialization.serialize(event);
        logger.debug("Serialized ${conceptName}: {}", serialized.toUtf8());

        final ${conceptName} eventDeserialized = jsonSerialization.deserialize(
                ${conceptName}.class,
                serialized.content,
                serialized.length);
        logger.trace("Deserialized ${conceptName}: {}", eventDeserialized);

        // check that the property was properly deserialized
        ${assertEquals("eventDeserialized")}
    }
"""

  def activeRecordPersistTest = s"""
    /* Testing the "${propertyName}" ${testID} property value after active record persist */
    @org.junit.Test
    public void test${PropertyName}${testID}PropertyValueInEventAfterActiveRecordPersist() throws IOException, InterruptedException, ExecutionException {${setupBlock}${isDefault match {
      case true => s"""
        final ${conceptName} event = new ${conceptName}();
        final ${propertyType.javaClass} testValue = event.get${PropertyName}();"""

      case _ => s"""
        final ${propertyType.javaClass} testValue = ${testValue};
        final ${conceptName} event = new ${conceptName}()
                .set${PropertyName}(testValue);"""}}

        // submit via active record pattern
        final String uri = event.submit();

        // check if URI was a (big) integer
        com.dslplatform.ocd.test.FancyAsserts.assertEquals(
          uri,
          new Long(uri).toString());

        // TODO: check that the property retrieved from revenj (submit will mutate the event)
/*
        ${assertEquals(s"event")}
*/

        final ${conceptName} eventFound = domainProxy.find(${conceptName}.class, new String[] {uri}).get().get(0);
        // check the property retrieved from the database
        ${assertEquals("eventFound")}

        // TODO: events are compared via URI equality - both URIs have be initialized at this point
//        com.dslplatform.ocd.test.FancyAsserts.assertEquals(event, eventFound);

        // TODO: hashCodes are generated from the URI
//        com.dslplatform.ocd.test.FancyAsserts.assertEquals(event.hashCode(), eventFound.hashCode());
    }
"""

  def repositoryPersistTest = s"""
    /* Testing the "${propertyName}" ${testID} property value after repository persist */
    @org.junit.Test
    public void test${PropertyName}${testID}PropertyValueInEventAfterRepositoryPersist() throws IOException, InterruptedException, ExecutionException {${setupBlock}${isDefault match {
      case true => s"""
        final ${conceptName} event = new ${conceptName}();
        final ${propertyType.javaClass} testValue = event.get${PropertyName}();"""

      case _ => s"""
        final ${propertyType.javaClass} testValue = ${testValue};
        final ${conceptName} event = new ${conceptName}()
                .set${PropertyName}(testValue);"""}}

        // submit via store interface
        final String uri = domainProxy.submit(event).get();

        // check if URI was a (big) integer
        com.dslplatform.ocd.test.FancyAsserts.assertEquals(
          uri,
          new Long(uri).toString());

        final ${conceptName} eventFound = domainProxy.find(${conceptName}.class, new String[] {uri}).get().get(0);

        // compare URIs
        com.dslplatform.ocd.test.FancyAsserts.assertEquals(uri, eventFound.getURI());

        // check the property retrieved from the database
        ${assertEquals("eventFound")}
    }
"""
}
