package com.dslplatform.ocd.aggregates;

import java.io.IOException;

public class AggregateTypeWithSurrogateKeyAndOneSetOfOneDatesPropertyTest {

    private static com.dslplatform.client.JsonSerialization jsonSerialization;
    private static com.dslplatform.patterns.PersistableRepository<ocd.AggregateSurrogateDate.Aggregate1S1Da> aggregate1S1DaRepository;

    @org.junit.BeforeClass
    public static void initialize() throws IOException {
        final com.dslplatform.patterns.ServiceLocator locator = com.dslplatform.client.Bootstrap.init(AggregateTypeWithSurrogateKeyAndOneSetOfOneDatesPropertyTest.class.getResourceAsStream("/dsl-project.ini"));
        jsonSerialization = locator.resolve(com.dslplatform.client.JsonSerialization.class);
        aggregate1S1DaRepository = locator.resolve(ocd.AggregateSurrogateDate.repositories.Aggregate1S1DaRepository.class);
    }

    /* Testing the "p1S1Da" Default aggregate property JSON serialization */
    @org.junit.Test
    public void testP1S1DaDefaultPropertyInAggregateJsonSerialization() throws java.io.IOException {
        final ocd.AggregateSurrogateDate.Aggregate1S1Da aggregate =
                new ocd.AggregateSurrogateDate.Aggregate1S1Da();
        final java.util.Set<org.joda.time.LocalDate> testValue = aggregate.getP1S1Da();

        // check that the property was properly assigned
        com.dslplatform.ocd.javaasserts.DateAsserts.assertOneSetOfOneEquals(
                testValue,
                aggregate.getP1S1Da());

        final String serialized = com.dslplatform.client.JsonSerialization.serialize(aggregate);
        final ocd.AggregateSurrogateDate.Aggregate1S1Da aggregateDeserialized = jsonSerialization.deserialize(
                com.dslplatform.client.JsonSerialization.buildType(ocd.AggregateSurrogateDate.Aggregate1S1Da.class),
                serialized);

        // check that the property was properly deserialized
        com.dslplatform.ocd.javaasserts.DateAsserts.assertOneSetOfOneEquals(
                testValue,
                aggregateDeserialized.getP1S1Da());
    }

    /* Testing the "p1S1Da" Default property value after active record persist */
    @org.junit.Test
    public void testP1S1DaDefaultPropertyValueInAggregateAfterActiveRecordPersist() throws java.io.IOException {
        final ocd.AggregateSurrogateDate.Aggregate1S1Da aggregate =
                new ocd.AggregateSurrogateDate.Aggregate1S1Da();
        final java.util.Set<org.joda.time.LocalDate> testValue = aggregate.getP1S1Da();

        // persist via active record pattern
        aggregate.persist();

        // check that the property retrieved from revenj (persist will mutate the aggregate)
        com.dslplatform.ocd.javaasserts.DateAsserts.assertOneSetOfOneEquals(
                testValue,
                aggregate.getP1S1Da().getP1S1Da());

        final ocd.AggregateSurrogateDate.Aggregate1S1Da aggregateFound =
                ocd.AggregateSurrogateDate.Aggregate1S1Da.find(aggregate.getURI());

        final ocd.AggregateSurrogateDate.Aggregate1S1Da aggregateFound =
                ocd.AggregateSurrogateDate.Aggregate1S1Da.find(aggregate.getURI());

        // check the property retrieved from the database
        com.dslplatform.ocd.javaasserts.DateAsserts.assertOneSetOfOneEquals(
                testValue,
                aggregateFound.getP1S1Da());

        // aggregates are compared via URI equality - both URIs have be initialized at this point
        org.junit.Assert.assertEquals(aggregate, aggregateFound);

        // hashCodes are generated from the URI
        org.junit.Assert.assertEquals(aggregate.hashCode(), aggregateFound.hashCode());
    }

    /* Testing the "p1S1Da" NonDefault1 aggregate property JSON serialization */
    @org.junit.Test
    public void testP1S1DaNonDefault1PropertyInAggregateJsonSerialization() throws java.io.IOException {
        final java.util.Set<org.joda.time.LocalDate> testValue = new java.util.HashSet<org.joda.time.LocalDate>() {{ add(org.joda.time.LocalDate.now()); }};
        final ocd.AggregateSurrogateDate.Aggregate1S1Da aggregate =
                new ocd.AggregateSurrogateDate.Aggregate1S1Da()
                .setP1S1Da(testValue);

        // check that the property was properly assigned
        com.dslplatform.ocd.javaasserts.DateAsserts.assertOneSetOfOneEquals(
                testValue,
                aggregate.getP1S1Da());

        final String serialized = com.dslplatform.client.JsonSerialization.serialize(aggregate);
        final ocd.AggregateSurrogateDate.Aggregate1S1Da aggregateDeserialized = jsonSerialization.deserialize(
                com.dslplatform.client.JsonSerialization.buildType(ocd.AggregateSurrogateDate.Aggregate1S1Da.class),
                serialized);

        // check that the property was properly deserialized
        com.dslplatform.ocd.javaasserts.DateAsserts.assertOneSetOfOneEquals(
                testValue,
                aggregateDeserialized.getP1S1Da());
    }

    /* Testing the "p1S1Da" NonDefault1 property value after active record persist */
    @org.junit.Test
    public void testP1S1DaNonDefault1PropertyValueInAggregateAfterActiveRecordPersist() throws java.io.IOException {
        final java.util.Set<org.joda.time.LocalDate> testValue = new java.util.HashSet<org.joda.time.LocalDate>() {{ add(org.joda.time.LocalDate.now()); }};
        final ocd.AggregateSurrogateDate.Aggregate1S1Da aggregate =
                new ocd.AggregateSurrogateDate.Aggregate1S1Da()
                .setP1S1Da(testValue);

        // persist via active record pattern
        aggregate.persist();

        // check that the property retrieved from revenj (persist will mutate the aggregate)
        com.dslplatform.ocd.javaasserts.DateAsserts.assertOneSetOfOneEquals(
                testValue,
                aggregate.getP1S1Da().getP1S1Da());

        final ocd.AggregateSurrogateDate.Aggregate1S1Da aggregateFound =
                ocd.AggregateSurrogateDate.Aggregate1S1Da.find(aggregate.getURI());

        final ocd.AggregateSurrogateDate.Aggregate1S1Da aggregateFound =
                ocd.AggregateSurrogateDate.Aggregate1S1Da.find(aggregate.getURI());

        // check the property retrieved from the database
        com.dslplatform.ocd.javaasserts.DateAsserts.assertOneSetOfOneEquals(
                testValue,
                aggregateFound.getP1S1Da());

        // aggregates are compared via URI equality - both URIs have be initialized at this point
        org.junit.Assert.assertEquals(aggregate, aggregateFound);

        // hashCodes are generated from the URI
        org.junit.Assert.assertEquals(aggregate.hashCode(), aggregateFound.hashCode());
    }

    /* Testing the "p1S1Da" NonDefault2 aggregate property JSON serialization */
    @org.junit.Test
    public void testP1S1DaNonDefault2PropertyInAggregateJsonSerialization() throws java.io.IOException {
        final java.util.Set<org.joda.time.LocalDate> testValue = new java.util.HashSet<org.joda.time.LocalDate>() {{ add(new org.joda.time.LocalDate(9999, 12, 31)); }};
        final ocd.AggregateSurrogateDate.Aggregate1S1Da aggregate =
                new ocd.AggregateSurrogateDate.Aggregate1S1Da()
                .setP1S1Da(testValue);

        // check that the property was properly assigned
        com.dslplatform.ocd.javaasserts.DateAsserts.assertOneSetOfOneEquals(
                testValue,
                aggregate.getP1S1Da());

        final String serialized = com.dslplatform.client.JsonSerialization.serialize(aggregate);
        final ocd.AggregateSurrogateDate.Aggregate1S1Da aggregateDeserialized = jsonSerialization.deserialize(
                com.dslplatform.client.JsonSerialization.buildType(ocd.AggregateSurrogateDate.Aggregate1S1Da.class),
                serialized);

        // check that the property was properly deserialized
        com.dslplatform.ocd.javaasserts.DateAsserts.assertOneSetOfOneEquals(
                testValue,
                aggregateDeserialized.getP1S1Da());
    }

    /* Testing the "p1S1Da" NonDefault2 property value after active record persist */
    @org.junit.Test
    public void testP1S1DaNonDefault2PropertyValueInAggregateAfterActiveRecordPersist() throws java.io.IOException {
        final java.util.Set<org.joda.time.LocalDate> testValue = new java.util.HashSet<org.joda.time.LocalDate>() {{ add(new org.joda.time.LocalDate(9999, 12, 31)); }};
        final ocd.AggregateSurrogateDate.Aggregate1S1Da aggregate =
                new ocd.AggregateSurrogateDate.Aggregate1S1Da()
                .setP1S1Da(testValue);

        // persist via active record pattern
        aggregate.persist();

        // check that the property retrieved from revenj (persist will mutate the aggregate)
        com.dslplatform.ocd.javaasserts.DateAsserts.assertOneSetOfOneEquals(
                testValue,
                aggregate.getP1S1Da().getP1S1Da());

        final ocd.AggregateSurrogateDate.Aggregate1S1Da aggregateFound =
                ocd.AggregateSurrogateDate.Aggregate1S1Da.find(aggregate.getURI());

        final ocd.AggregateSurrogateDate.Aggregate1S1Da aggregateFound =
                ocd.AggregateSurrogateDate.Aggregate1S1Da.find(aggregate.getURI());

        // check the property retrieved from the database
        com.dslplatform.ocd.javaasserts.DateAsserts.assertOneSetOfOneEquals(
                testValue,
                aggregateFound.getP1S1Da());

        // aggregates are compared via URI equality - both URIs have be initialized at this point
        org.junit.Assert.assertEquals(aggregate, aggregateFound);

        // hashCodes are generated from the URI
        org.junit.Assert.assertEquals(aggregate.hashCode(), aggregateFound.hashCode());
    }

    /* Testing the "p1S1Da" NonDefault3 aggregate property JSON serialization */
    @org.junit.Test
    public void testP1S1DaNonDefault3PropertyInAggregateJsonSerialization() throws java.io.IOException {
        final java.util.Set<org.joda.time.LocalDate> testValue = new java.util.HashSet<org.joda.time.LocalDate>() {{ add(org.joda.time.LocalDate.now()); add(new org.joda.time.LocalDate(1, 2, 3)); add(new org.joda.time.LocalDate(1, 1, 1)); add(new org.joda.time.LocalDate(0)); add(new org.joda.time.LocalDate(Integer.MAX_VALUE * 1001L)); add(new org.joda.time.LocalDate(9999, 12, 31)); }};
        final ocd.AggregateSurrogateDate.Aggregate1S1Da aggregate =
                new ocd.AggregateSurrogateDate.Aggregate1S1Da()
                .setP1S1Da(testValue);

        // check that the property was properly assigned
        com.dslplatform.ocd.javaasserts.DateAsserts.assertOneSetOfOneEquals(
                testValue,
                aggregate.getP1S1Da());

        final String serialized = com.dslplatform.client.JsonSerialization.serialize(aggregate);
        final ocd.AggregateSurrogateDate.Aggregate1S1Da aggregateDeserialized = jsonSerialization.deserialize(
                com.dslplatform.client.JsonSerialization.buildType(ocd.AggregateSurrogateDate.Aggregate1S1Da.class),
                serialized);

        // check that the property was properly deserialized
        com.dslplatform.ocd.javaasserts.DateAsserts.assertOneSetOfOneEquals(
                testValue,
                aggregateDeserialized.getP1S1Da());
    }

    /* Testing the "p1S1Da" NonDefault3 property value after active record persist */
    @org.junit.Test
    public void testP1S1DaNonDefault3PropertyValueInAggregateAfterActiveRecordPersist() throws java.io.IOException {
        final java.util.Set<org.joda.time.LocalDate> testValue = new java.util.HashSet<org.joda.time.LocalDate>() {{ add(org.joda.time.LocalDate.now()); add(new org.joda.time.LocalDate(1, 2, 3)); add(new org.joda.time.LocalDate(1, 1, 1)); add(new org.joda.time.LocalDate(0)); add(new org.joda.time.LocalDate(Integer.MAX_VALUE * 1001L)); add(new org.joda.time.LocalDate(9999, 12, 31)); }};
        final ocd.AggregateSurrogateDate.Aggregate1S1Da aggregate =
                new ocd.AggregateSurrogateDate.Aggregate1S1Da()
                .setP1S1Da(testValue);

        // persist via active record pattern
        aggregate.persist();

        // check that the property retrieved from revenj (persist will mutate the aggregate)
        com.dslplatform.ocd.javaasserts.DateAsserts.assertOneSetOfOneEquals(
                testValue,
                aggregate.getP1S1Da().getP1S1Da());

        final ocd.AggregateSurrogateDate.Aggregate1S1Da aggregateFound =
                ocd.AggregateSurrogateDate.Aggregate1S1Da.find(aggregate.getURI());

        final ocd.AggregateSurrogateDate.Aggregate1S1Da aggregateFound =
                ocd.AggregateSurrogateDate.Aggregate1S1Da.find(aggregate.getURI());

        // check the property retrieved from the database
        com.dslplatform.ocd.javaasserts.DateAsserts.assertOneSetOfOneEquals(
                testValue,
                aggregateFound.getP1S1Da());

        // aggregates are compared via URI equality - both URIs have be initialized at this point
        org.junit.Assert.assertEquals(aggregate, aggregateFound);

        // hashCodes are generated from the URI
        org.junit.Assert.assertEquals(aggregate.hashCode(), aggregateFound.hashCode());
    }
}