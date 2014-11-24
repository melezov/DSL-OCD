package com.dslplatform.ocd.aggregates;

import java.io.IOException;

public class AggregateTypeWithSurrogateKeyAndNullableListOfNullableTimestampsPropertyTest {

    private static com.dslplatform.client.JsonSerialization jsonSerialization;
    private static com.dslplatform.patterns.PersistableRepository<ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts> aggregate0L0TsRepository;

    @org.junit.BeforeClass
    public static void initialize() throws IOException {
        final com.dslplatform.patterns.ServiceLocator locator = com.dslplatform.client.Bootstrap.init(AggregateTypeWithSurrogateKeyAndNullableListOfNullableTimestampsPropertyTest.class.getResourceAsStream("/dsl-project.ini"));
        jsonSerialization = locator.resolve(com.dslplatform.client.JsonSerialization.class);
        aggregate0L0TsRepository = locator.resolve(ocd.AggregateSurrogateTimestamp.repositories.Aggregate0L0TsRepository.class);
    }

    /* Testing the "p0L0Ts" Default aggregate property JSON serialization */
    @org.junit.Test
    public void testP0L0TsDefaultPropertyInAggregateJsonSerialization() throws java.io.IOException {
        final ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts aggregate =
                new ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts();
        final java.util.List<org.joda.time.DateTime> testValue = aggregate.getP0L0Ts();

        // check that the property was properly assigned
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregate.getP0L0Ts());

        final String serialized = com.dslplatform.client.JsonSerialization.serialize(aggregate);
        final ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts aggregateDeserialized = jsonSerialization.deserialize(
                com.dslplatform.client.JsonSerialization.buildType(ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts.class),
                serialized);

        // check that the property was properly deserialized
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregateDeserialized.getP0L0Ts());
    }

    /* Testing the "p0L0Ts" Default property value after active record persist */
    @org.junit.Test
    public void testP0L0TsDefaultPropertyValueInAggregateAfterActiveRecordPersist() throws java.io.IOException {
        final ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts aggregate =
                new ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts();
        final java.util.List<org.joda.time.DateTime> testValue = aggregate.getP0L0Ts();

        // persist via active record pattern
        aggregate.persist();

        // check that the property retrieved from revenj (persist will mutate the aggregate)
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregate.getP0L0Ts().getP0L0Ts());

        final ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts aggregateFound =
                ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts.find(aggregate.getURI());

        final ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts aggregateFound =
                ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts.find(aggregate.getURI());

        // check the property retrieved from the database
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregateFound.getP0L0Ts());

        // aggregates are compared via URI equality - both URIs have be initialized at this point
        org.junit.Assert.assertEquals(aggregate, aggregateFound);

        // hashCodes are generated from the URI
        org.junit.Assert.assertEquals(aggregate.hashCode(), aggregateFound.hashCode());
    }

    /* Testing the "p0L0Ts" NonDefault1 aggregate property JSON serialization */
    @org.junit.Test
    public void testP0L0TsNonDefault1PropertyInAggregateJsonSerialization() throws java.io.IOException {
        final java.util.List<org.joda.time.DateTime> testValue = new java.util.ArrayList<org.joda.time.DateTime>() {{ add(null); }};
        final ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts aggregate =
                new ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts()
                .setP0L0Ts(testValue);

        // check that the property was properly assigned
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregate.getP0L0Ts());

        final String serialized = com.dslplatform.client.JsonSerialization.serialize(aggregate);
        final ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts aggregateDeserialized = jsonSerialization.deserialize(
                com.dslplatform.client.JsonSerialization.buildType(ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts.class),
                serialized);

        // check that the property was properly deserialized
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregateDeserialized.getP0L0Ts());
    }

    /* Testing the "p0L0Ts" NonDefault1 property value after active record persist */
    @org.junit.Test
    public void testP0L0TsNonDefault1PropertyValueInAggregateAfterActiveRecordPersist() throws java.io.IOException {
        final java.util.List<org.joda.time.DateTime> testValue = new java.util.ArrayList<org.joda.time.DateTime>() {{ add(null); }};
        final ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts aggregate =
                new ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts()
                .setP0L0Ts(testValue);

        // persist via active record pattern
        aggregate.persist();

        // check that the property retrieved from revenj (persist will mutate the aggregate)
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregate.getP0L0Ts().getP0L0Ts());

        final ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts aggregateFound =
                ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts.find(aggregate.getURI());

        final ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts aggregateFound =
                ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts.find(aggregate.getURI());

        // check the property retrieved from the database
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregateFound.getP0L0Ts());

        // aggregates are compared via URI equality - both URIs have be initialized at this point
        org.junit.Assert.assertEquals(aggregate, aggregateFound);

        // hashCodes are generated from the URI
        org.junit.Assert.assertEquals(aggregate.hashCode(), aggregateFound.hashCode());
    }

    /* Testing the "p0L0Ts" NonDefault2 aggregate property JSON serialization */
    @org.junit.Test
    public void testP0L0TsNonDefault2PropertyInAggregateJsonSerialization() throws java.io.IOException {
        final java.util.List<org.joda.time.DateTime> testValue = new java.util.ArrayList<org.joda.time.DateTime>() {{ add(org.joda.time.DateTime.now()); }};
        final ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts aggregate =
                new ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts()
                .setP0L0Ts(testValue);

        // check that the property was properly assigned
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregate.getP0L0Ts());

        final String serialized = com.dslplatform.client.JsonSerialization.serialize(aggregate);
        final ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts aggregateDeserialized = jsonSerialization.deserialize(
                com.dslplatform.client.JsonSerialization.buildType(ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts.class),
                serialized);

        // check that the property was properly deserialized
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregateDeserialized.getP0L0Ts());
    }

    /* Testing the "p0L0Ts" NonDefault2 property value after active record persist */
    @org.junit.Test
    public void testP0L0TsNonDefault2PropertyValueInAggregateAfterActiveRecordPersist() throws java.io.IOException {
        final java.util.List<org.joda.time.DateTime> testValue = new java.util.ArrayList<org.joda.time.DateTime>() {{ add(org.joda.time.DateTime.now()); }};
        final ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts aggregate =
                new ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts()
                .setP0L0Ts(testValue);

        // persist via active record pattern
        aggregate.persist();

        // check that the property retrieved from revenj (persist will mutate the aggregate)
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregate.getP0L0Ts().getP0L0Ts());

        final ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts aggregateFound =
                ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts.find(aggregate.getURI());

        final ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts aggregateFound =
                ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts.find(aggregate.getURI());

        // check the property retrieved from the database
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregateFound.getP0L0Ts());

        // aggregates are compared via URI equality - both URIs have be initialized at this point
        org.junit.Assert.assertEquals(aggregate, aggregateFound);

        // hashCodes are generated from the URI
        org.junit.Assert.assertEquals(aggregate.hashCode(), aggregateFound.hashCode());
    }

    /* Testing the "p0L0Ts" NonDefault3 aggregate property JSON serialization */
    @org.junit.Test
    public void testP0L0TsNonDefault3PropertyInAggregateJsonSerialization() throws java.io.IOException {
        final java.util.List<org.joda.time.DateTime> testValue = new java.util.ArrayList<org.joda.time.DateTime>() {{ add(new org.joda.time.DateTime(Integer.MAX_VALUE * 1001L)); }};
        final ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts aggregate =
                new ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts()
                .setP0L0Ts(testValue);

        // check that the property was properly assigned
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregate.getP0L0Ts());

        final String serialized = com.dslplatform.client.JsonSerialization.serialize(aggregate);
        final ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts aggregateDeserialized = jsonSerialization.deserialize(
                com.dslplatform.client.JsonSerialization.buildType(ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts.class),
                serialized);

        // check that the property was properly deserialized
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregateDeserialized.getP0L0Ts());
    }

    /* Testing the "p0L0Ts" NonDefault3 property value after active record persist */
    @org.junit.Test
    public void testP0L0TsNonDefault3PropertyValueInAggregateAfterActiveRecordPersist() throws java.io.IOException {
        final java.util.List<org.joda.time.DateTime> testValue = new java.util.ArrayList<org.joda.time.DateTime>() {{ add(new org.joda.time.DateTime(Integer.MAX_VALUE * 1001L)); }};
        final ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts aggregate =
                new ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts()
                .setP0L0Ts(testValue);

        // persist via active record pattern
        aggregate.persist();

        // check that the property retrieved from revenj (persist will mutate the aggregate)
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregate.getP0L0Ts().getP0L0Ts());

        final ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts aggregateFound =
                ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts.find(aggregate.getURI());

        final ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts aggregateFound =
                ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts.find(aggregate.getURI());

        // check the property retrieved from the database
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregateFound.getP0L0Ts());

        // aggregates are compared via URI equality - both URIs have be initialized at this point
        org.junit.Assert.assertEquals(aggregate, aggregateFound);

        // hashCodes are generated from the URI
        org.junit.Assert.assertEquals(aggregate.hashCode(), aggregateFound.hashCode());
    }

    /* Testing the "p0L0Ts" NonDefault4 aggregate property JSON serialization */
    @org.junit.Test
    public void testP0L0TsNonDefault4PropertyInAggregateJsonSerialization() throws java.io.IOException {
        final java.util.List<org.joda.time.DateTime> testValue = new java.util.ArrayList<org.joda.time.DateTime>() {{ add(org.joda.time.DateTime.now()); add(new org.joda.time.DateTime(0)); add(new org.joda.time.DateTime(1, 1, 1, 0, 0)); add(new org.joda.time.DateTime(Integer.MAX_VALUE * 1001L)); }};
        final ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts aggregate =
                new ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts()
                .setP0L0Ts(testValue);

        // check that the property was properly assigned
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregate.getP0L0Ts());

        final String serialized = com.dslplatform.client.JsonSerialization.serialize(aggregate);
        final ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts aggregateDeserialized = jsonSerialization.deserialize(
                com.dslplatform.client.JsonSerialization.buildType(ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts.class),
                serialized);

        // check that the property was properly deserialized
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregateDeserialized.getP0L0Ts());
    }

    /* Testing the "p0L0Ts" NonDefault4 property value after active record persist */
    @org.junit.Test
    public void testP0L0TsNonDefault4PropertyValueInAggregateAfterActiveRecordPersist() throws java.io.IOException {
        final java.util.List<org.joda.time.DateTime> testValue = new java.util.ArrayList<org.joda.time.DateTime>() {{ add(org.joda.time.DateTime.now()); add(new org.joda.time.DateTime(0)); add(new org.joda.time.DateTime(1, 1, 1, 0, 0)); add(new org.joda.time.DateTime(Integer.MAX_VALUE * 1001L)); }};
        final ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts aggregate =
                new ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts()
                .setP0L0Ts(testValue);

        // persist via active record pattern
        aggregate.persist();

        // check that the property retrieved from revenj (persist will mutate the aggregate)
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregate.getP0L0Ts().getP0L0Ts());

        final ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts aggregateFound =
                ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts.find(aggregate.getURI());

        final ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts aggregateFound =
                ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts.find(aggregate.getURI());

        // check the property retrieved from the database
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregateFound.getP0L0Ts());

        // aggregates are compared via URI equality - both URIs have be initialized at this point
        org.junit.Assert.assertEquals(aggregate, aggregateFound);

        // hashCodes are generated from the URI
        org.junit.Assert.assertEquals(aggregate.hashCode(), aggregateFound.hashCode());
    }

    /* Testing the "p0L0Ts" NonDefault5 aggregate property JSON serialization */
    @org.junit.Test
    public void testP0L0TsNonDefault5PropertyInAggregateJsonSerialization() throws java.io.IOException {
        final java.util.List<org.joda.time.DateTime> testValue = new java.util.ArrayList<org.joda.time.DateTime>() {{ add(null); add(org.joda.time.DateTime.now()); add(new org.joda.time.DateTime(0)); add(new org.joda.time.DateTime(1, 1, 1, 0, 0)); add(new org.joda.time.DateTime(Integer.MAX_VALUE * 1001L)); }};
        final ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts aggregate =
                new ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts()
                .setP0L0Ts(testValue);

        // check that the property was properly assigned
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregate.getP0L0Ts());

        final String serialized = com.dslplatform.client.JsonSerialization.serialize(aggregate);
        final ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts aggregateDeserialized = jsonSerialization.deserialize(
                com.dslplatform.client.JsonSerialization.buildType(ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts.class),
                serialized);

        // check that the property was properly deserialized
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregateDeserialized.getP0L0Ts());
    }

    /* Testing the "p0L0Ts" NonDefault5 property value after active record persist */
    @org.junit.Test
    public void testP0L0TsNonDefault5PropertyValueInAggregateAfterActiveRecordPersist() throws java.io.IOException {
        final java.util.List<org.joda.time.DateTime> testValue = new java.util.ArrayList<org.joda.time.DateTime>() {{ add(null); add(org.joda.time.DateTime.now()); add(new org.joda.time.DateTime(0)); add(new org.joda.time.DateTime(1, 1, 1, 0, 0)); add(new org.joda.time.DateTime(Integer.MAX_VALUE * 1001L)); }};
        final ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts aggregate =
                new ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts()
                .setP0L0Ts(testValue);

        // persist via active record pattern
        aggregate.persist();

        // check that the property retrieved from revenj (persist will mutate the aggregate)
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregate.getP0L0Ts().getP0L0Ts());

        final ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts aggregateFound =
                ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts.find(aggregate.getURI());

        final ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts aggregateFound =
                ocd.AggregateSurrogateTimestamp.Aggregate0L0Ts.find(aggregate.getURI());

        // check the property retrieved from the database
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregateFound.getP0L0Ts());

        // aggregates are compared via URI equality - both URIs have be initialized at this point
        org.junit.Assert.assertEquals(aggregate, aggregateFound);

        // hashCodes are generated from the URI
        org.junit.Assert.assertEquals(aggregate.hashCode(), aggregateFound.hashCode());
    }
}