package com.dslplatform.ocd
package test
package javatest
package property

import types._
import javas._

trait TestJavaOneValueInOneEntityInAggregate
    extends TestComponentWithProperty {

  def testID: String
  def isDefault: Boolean
  def testValue: JavaValue
  def setupBlock: String = ""

  def valueName: String
  def ValueName = valueName.fciu

  def entityName: String
  def EntityName = entityName.fciu

  def repositoryName: String

  def testComponentBody = (
    jsonSerializationTest
  + (!isDisallowed(isDefault)).ifTrue(activeRecordPersistTest)
  + (!isDisallowed(isDefault)).ifTrue(repositoryPersistTest)
  )

  private def assertEquals(target: String) = property match {
    case _ if isDisallowed(isDefault) =>
      s"""// special null check for disallowed null value in a non-nullable property
        org.junit.Assert.assertNull(${target}.get${EntityName}().get${ValueName}().get${PropertyName}());"""

    case p: OcdJavaBoxTypeProperty if p.boxType.isPrecise =>
      s"""com.dslplatform.ocd.javaasserts.${p.boxType.typeSingleName}Asserts.assert${p.box.boxName}Equals(
                testValue,
                ${target}.get${EntityName}().get${ValueName}().get${PropertyName}(),
                2);"""

    case p: OcdJavaBoxTypeProperty =>
      s"""com.dslplatform.ocd.javaasserts.${p.boxType.typeSingleName}Asserts.assert${p.box.boxName}Equals(
                testValue,
                ${target}.get${EntityName}().get${ValueName}().get${PropertyName}());"""

    case _ => ???
  }

  private def assertValueEqualityAndHashCode =
    s"""// nested values must be equal
        com.dslplatform.ocd.test.FancyAsserts.assertEquals(
                aggregate.get${EntityName}().get${ValueName}(),
                aggregateFound.get${EntityName}().get${ValueName}());

        // nested values hashCode() must be equal
        com.dslplatform.ocd.test.FancyAsserts.assertEquals(
                aggregate.get${EntityName}().get${ValueName}().hashCode(),
                aggregateFound.get${EntityName}().get${ValueName}().hashCode());"""

  def jsonSerializationTest = s"""
    /* Testing the "${propertyName}" within one ${ValueName} within one ${EntityName} ${testID} aggregate property JSON serialization */
    @org.junit.Test
    public void test${PropertyName}WithinOne${ValueName}WithinOne${EntityName}${testID}PropertyInAggregateJsonSerialization() throws IOException {${isDefault match {
      case true => s"""
        final ${conceptName} aggregate = new ${conceptName}();
        final ${propertyType.javaClass} testValue = aggregate.get${EntityName}().get${ValueName}().get${PropertyName}();"""

      case _ => s"""
        final ${propertyType.javaClass} testValue = ${testValue};
        final ${conceptName} aggregate = new ${conceptName}();
        aggregate.get${EntityName}().get${ValueName}().set${PropertyName}(testValue);"""}}

        // check that the property was properly assigned
        ${assertEquals("aggregate")}

        logger.trace("Serializing ${conceptName}: {}", aggregate);
        final com.dslplatform.patterns.Bytes serialized = jsonSerialization.serialize(aggregate);
        logger.debug("Serialized ${conceptName}: {}", serialized.toUtf8());

        final ${conceptName} aggregateDeserialized = jsonSerialization.deserialize(
                ${conceptName}.class,
                serialized.content,
                serialized.length);
        logger.trace("Deserialized ${conceptName}: {}", aggregateDeserialized);

        // check that the property was properly deserialized
        ${assertEquals("aggregateDeserialized")}
    }
"""
  def activeRecordPersistTest = s"""
    /* Testing the "${propertyName}" within one ${ValueName} within one ${EntityName} ${testID} property value after active record persist */
    @org.junit.Test
    public void test${PropertyName}WithinOne${ValueName}WithinOne${EntityName}${testID}PropertyEntityInAggregateAfterActiveRecordPersist() throws IOException {${setupBlock}${isDefault match {
      case true => s"""
        final ${conceptName} aggregate = new ${conceptName}();
        final ${propertyType.javaClass} testValue = aggregate.get${EntityName}().get${ValueName}().get${PropertyName}();"""

      case _ => s"""
        final ${propertyType.javaClass} testValue = ${testValue};
        final ${conceptName} aggregate = new ${conceptName}();
        aggregate.get${EntityName}().get${ValueName}().set${PropertyName}(testValue);"""}}

        // persist via active record pattern
        aggregate.create();

        // check that the property retrieved from revenj (create will mutate the aggregate)
        ${assertEquals(s"aggregate")}

        final ${conceptName} aggregateFound = ${conceptName}.find(aggregate.getURI());
        // check the property retrieved from the database
        ${assertEquals("aggregateFound")}

        ${assertValueEqualityAndHashCode}

        // aggregates are compared via URI equality - both URIs have be initialized at this point
        com.dslplatform.ocd.test.FancyAsserts.assertEquals(aggregate, aggregateFound);

        // hashCodes are generated from the URI
        com.dslplatform.ocd.test.FancyAsserts.assertEquals(aggregate.hashCode(), aggregateFound.hashCode());
    }
"""

  def repositoryPersistTest = s"""
    /* Testing the "${propertyName}" within one ${ValueName} within one ${EntityName} ${testID} property value after repository persist */
    @org.junit.Test
    public void test${PropertyName}WithinOne${ValueName}WithinOne${EntityName}${testID}PropertyEntityInAggregateAfterRepositoryPersist() throws IOException, InterruptedException, ExecutionException {${setupBlock}${isDefault match {
      case true => s"""
        final ${conceptName} aggregate = new ${conceptName}();
        final ${propertyType.javaClass} testValue = aggregate.get${EntityName}().get${ValueName}().get${PropertyName}();"""

      case _ => s"""
        final ${propertyType.javaClass} testValue = ${testValue};
        final ${conceptName} aggregate = new ${conceptName}();
        aggregate.get${EntityName}().get${ValueName}().set${PropertyName}(testValue);"""}}

        // persist via repository interface for collections
        final String uri = ${repositoryName}.insert(new ${conceptName}[] { aggregate }).get().get(0);

        final ${conceptName} aggregateFound = ${repositoryName}.find(uri).get();

        // compare URIs
        com.dslplatform.ocd.test.FancyAsserts.assertEquals(uri, aggregateFound.getURI());

        // check the property retrieved from the database
        ${assertEquals("aggregateFound")}

        ${assertValueEqualityAndHashCode}
    }
"""
}
