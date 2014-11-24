package com.dslplatform.ocd.aggregates;

import java.io.IOException;

public class AggregateTypeWithSurrogateKeyAndNullableArrayOfNullableTimestampsPropertyTest {

    private static com.dslplatform.client.JsonSerialization jsonSerialization;
    private static com.dslplatform.patterns.PersistableRepository<ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts> aggregate0A0TsRepository;

    @org.junit.BeforeClass
    public static void initialize() throws IOException {
        final com.dslplatform.patterns.ServiceLocator locator = com.dslplatform.client.Bootstrap.init(AggregateTypeWithSurrogateKeyAndNullableArrayOfNullableTimestampsPropertyTest.class.getResourceAsStream("/dsl-project.ini"));
        jsonSerialization = locator.resolve(com.dslplatform.client.JsonSerialization.class);
        aggregate0A0TsRepository = locator.resolve(ocd.AggregateSurrogateTimestamp.repositories.Aggregate0A0TsRepository.class);
    }

    /* Testing the "p0A0Ts" Default aggregate property JSON serialization */
    @org.junit.Test
    public void testP0A0TsDefaultPropertyInAggregateJsonSerialization() throws java.io.IOException {
        final ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts aggregate =
                new ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts();
        final org.joda.time.DateTime[] testValue = aggregate.getP0A0Ts();

        // check that the property was properly assigned
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableArrayOfNullableEquals(
                testValue,
                aggregate.getP0A0Ts());

        final String serialized = com.dslplatform.client.JsonSerialization.serialize(aggregate);
        final ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts aggregateDeserialized = jsonSerialization.deserialize(
                com.dslplatform.client.JsonSerialization.buildType(ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts.class),
                serialized);

        // check that the property was properly deserialized
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableArrayOfNullableEquals(
                testValue,
                aggregateDeserialized.getP0A0Ts());
    }

    /* Testing the "p0A0Ts" Default property value after active record persist */
    @org.junit.Test
    public void testP0A0TsDefaultPropertyValueInAggregateAfterActiveRecordPersist() throws java.io.IOException {
        final ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts aggregate =
                new ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts();
        final org.joda.time.DateTime[] testValue = aggregate.getP0A0Ts();

        // persist via active record pattern
        aggregate.persist();

        // check that the property retrieved from revenj (persist will mutate the aggregate)
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableArrayOfNullableEquals(
                testValue,
                aggregate.getP0A0Ts().getP0A0Ts());

        final ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts aggregateFound =
                ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts.find(aggregate.getURI());

        final ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts aggregateFound =
                ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts.find(aggregate.getURI());

        // check the property retrieved from the database
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableArrayOfNullableEquals(
                testValue,
                aggregateFound.getP0A0Ts());

        // aggregates are compared via URI equality - both URIs have be initialized at this point
        org.junit.Assert.assertEquals(aggregate, aggregateFound);

        // hashCodes are generated from the URI
        org.junit.Assert.assertEquals(aggregate.hashCode(), aggregateFound.hashCode());
    }

    /* Testing the "p0A0Ts" NonDefault1 aggregate property JSON serialization */
    @org.junit.Test
    public void testP0A0TsNonDefault1PropertyInAggregateJsonSerialization() throws java.io.IOException {
        final org.joda.time.DateTime[] testValue = new org.joda.time.DateTime[] { null };
        final ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts aggregate =
                new ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts()
                .setP0A0Ts(testValue);

        // check that the property was properly assigned
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableArrayOfNullableEquals(
                testValue,
                aggregate.getP0A0Ts());

        final String serialized = com.dslplatform.client.JsonSerialization.serialize(aggregate);
        final ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts aggregateDeserialized = jsonSerialization.deserialize(
                com.dslplatform.client.JsonSerialization.buildType(ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts.class),
                serialized);

        // check that the property was properly deserialized
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableArrayOfNullableEquals(
                testValue,
                aggregateDeserialized.getP0A0Ts());
    }

    /* Testing the "p0A0Ts" NonDefault1 property value after active record persist */
    @org.junit.Test
    public void testP0A0TsNonDefault1PropertyValueInAggregateAfterActiveRecordPersist() throws java.io.IOException {
        final org.joda.time.DateTime[] testValue = new org.joda.time.DateTime[] { null };
        final ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts aggregate =
                new ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts()
                .setP0A0Ts(testValue);

        // persist via active record pattern
        aggregate.persist();

        // check that the property retrieved from revenj (persist will mutate the aggregate)
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableArrayOfNullableEquals(
                testValue,
                aggregate.getP0A0Ts().getP0A0Ts());

        final ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts aggregateFound =
                ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts.find(aggregate.getURI());

        final ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts aggregateFound =
                ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts.find(aggregate.getURI());

        // check the property retrieved from the database
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableArrayOfNullableEquals(
                testValue,
                aggregateFound.getP0A0Ts());

        // aggregates are compared via URI equality - both URIs have be initialized at this point
        org.junit.Assert.assertEquals(aggregate, aggregateFound);

        // hashCodes are generated from the URI
        org.junit.Assert.assertEquals(aggregate.hashCode(), aggregateFound.hashCode());
    }

    /* Testing the "p0A0Ts" NonDefault2 aggregate property JSON serialization */
    @org.junit.Test
    public void testP0A0TsNonDefault2PropertyInAggregateJsonSerialization() throws java.io.IOException {
        final org.joda.time.DateTime[] testValue = new org.joda.time.DateTime[] { org.joda.time.DateTime.now() };
        final ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts aggregate =
                new ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts()
                .setP0A0Ts(testValue);

        // check that the property was properly assigned
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableArrayOfNullableEquals(
                testValue,
                aggregate.getP0A0Ts());

        final String serialized = com.dslplatform.client.JsonSerialization.serialize(aggregate);
        final ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts aggregateDeserialized = jsonSerialization.deserialize(
                com.dslplatform.client.JsonSerialization.buildType(ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts.class),
                serialized);

        // check that the property was properly deserialized
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableArrayOfNullableEquals(
                testValue,
                aggregateDeserialized.getP0A0Ts());
    }

    /* Testing the "p0A0Ts" NonDefault2 property value after active record persist */
    @org.junit.Test
    public void testP0A0TsNonDefault2PropertyValueInAggregateAfterActiveRecordPersist() throws java.io.IOException {
        final org.joda.time.DateTime[] testValue = new org.joda.time.DateTime[] { org.joda.time.DateTime.now() };
        final ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts aggregate =
                new ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts()
                .setP0A0Ts(testValue);

        // persist via active record pattern
        aggregate.persist();

        // check that the property retrieved from revenj (persist will mutate the aggregate)
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableArrayOfNullableEquals(
                testValue,
                aggregate.getP0A0Ts().getP0A0Ts());

        final ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts aggregateFound =
                ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts.find(aggregate.getURI());

        final ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts aggregateFound =
                ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts.find(aggregate.getURI());

        // check the property retrieved from the database
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableArrayOfNullableEquals(
                testValue,
                aggregateFound.getP0A0Ts());

        // aggregates are compared via URI equality - both URIs have be initialized at this point
        org.junit.Assert.assertEquals(aggregate, aggregateFound);

        // hashCodes are generated from the URI
        org.junit.Assert.assertEquals(aggregate.hashCode(), aggregateFound.hashCode());
    }

    /* Testing the "p0A0Ts" NonDefault3 aggregate property JSON serialization */
    @org.junit.Test
    public void testP0A0TsNonDefault3PropertyInAggregateJsonSerialization() throws java.io.IOException {
        final org.joda.time.DateTime[] testValue = new org.joda.time.DateTime[] { new org.joda.time.DateTime(Integer.MAX_VALUE * 1001L) };
        final ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts aggregate =
                new ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts()
                .setP0A0Ts(testValue);

        // check that the property was properly assigned
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableArrayOfNullableEquals(
                testValue,
                aggregate.getP0A0Ts());

        final String serialized = com.dslplatform.client.JsonSerialization.serialize(aggregate);
        final ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts aggregateDeserialized = jsonSerialization.deserialize(
                com.dslplatform.client.JsonSerialization.buildType(ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts.class),
                serialized);

        // check that the property was properly deserialized
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableArrayOfNullableEquals(
                testValue,
                aggregateDeserialized.getP0A0Ts());
    }

    /* Testing the "p0A0Ts" NonDefault3 property value after active record persist */
    @org.junit.Test
    public void testP0A0TsNonDefault3PropertyValueInAggregateAfterActiveRecordPersist() throws java.io.IOException {
        final org.joda.time.DateTime[] testValue = new org.joda.time.DateTime[] { new org.joda.time.DateTime(Integer.MAX_VALUE * 1001L) };
        final ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts aggregate =
                new ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts()
                .setP0A0Ts(testValue);

        // persist via active record pattern
        aggregate.persist();

        // check that the property retrieved from revenj (persist will mutate the aggregate)
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableArrayOfNullableEquals(
                testValue,
                aggregate.getP0A0Ts().getP0A0Ts());

        final ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts aggregateFound =
                ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts.find(aggregate.getURI());

        final ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts aggregateFound =
                ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts.find(aggregate.getURI());

        // check the property retrieved from the database
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableArrayOfNullableEquals(
                testValue,
                aggregateFound.getP0A0Ts());

        // aggregates are compared via URI equality - both URIs have be initialized at this point
        org.junit.Assert.assertEquals(aggregate, aggregateFound);

        // hashCodes are generated from the URI
        org.junit.Assert.assertEquals(aggregate.hashCode(), aggregateFound.hashCode());
    }

    /* Testing the "p0A0Ts" NonDefault4 aggregate property JSON serialization */
    @org.junit.Test
    public void testP0A0TsNonDefault4PropertyInAggregateJsonSerialization() throws java.io.IOException {
        final org.joda.time.DateTime[] testValue = new org.joda.time.DateTime[] { org.joda.time.DateTime.now(), new org.joda.time.DateTime(0), new org.joda.time.DateTime(1, 1, 1, 0, 0), new org.joda.time.DateTime(Integer.MAX_VALUE * 1001L) };
        final ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts aggregate =
                new ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts()
                .setP0A0Ts(testValue);

        // check that the property was properly assigned
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableArrayOfNullableEquals(
                testValue,
                aggregate.getP0A0Ts());

        final String serialized = com.dslplatform.client.JsonSerialization.serialize(aggregate);
        final ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts aggregateDeserialized = jsonSerialization.deserialize(
                com.dslplatform.client.JsonSerialization.buildType(ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts.class),
                serialized);

        // check that the property was properly deserialized
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableArrayOfNullableEquals(
                testValue,
                aggregateDeserialized.getP0A0Ts());
    }

    /* Testing the "p0A0Ts" NonDefault4 property value after active record persist */
    @org.junit.Test
    public void testP0A0TsNonDefault4PropertyValueInAggregateAfterActiveRecordPersist() throws java.io.IOException {
        final org.joda.time.DateTime[] testValue = new org.joda.time.DateTime[] { org.joda.time.DateTime.now(), new org.joda.time.DateTime(0), new org.joda.time.DateTime(1, 1, 1, 0, 0), new org.joda.time.DateTime(Integer.MAX_VALUE * 1001L) };
        final ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts aggregate =
                new ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts()
                .setP0A0Ts(testValue);

        // persist via active record pattern
        aggregate.persist();

        // check that the property retrieved from revenj (persist will mutate the aggregate)
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableArrayOfNullableEquals(
                testValue,
                aggregate.getP0A0Ts().getP0A0Ts());

        final ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts aggregateFound =
                ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts.find(aggregate.getURI());

        final ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts aggregateFound =
                ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts.find(aggregate.getURI());

        // check the property retrieved from the database
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableArrayOfNullableEquals(
                testValue,
                aggregateFound.getP0A0Ts());

        // aggregates are compared via URI equality - both URIs have be initialized at this point
        org.junit.Assert.assertEquals(aggregate, aggregateFound);

        // hashCodes are generated from the URI
        org.junit.Assert.assertEquals(aggregate.hashCode(), aggregateFound.hashCode());
    }

    /* Testing the "p0A0Ts" NonDefault5 aggregate property JSON serialization */
    @org.junit.Test
    public void testP0A0TsNonDefault5PropertyInAggregateJsonSerialization() throws java.io.IOException {
        final org.joda.time.DateTime[] testValue = new org.joda.time.DateTime[] { null, org.joda.time.DateTime.now(), new org.joda.time.DateTime(0), new org.joda.time.DateTime(1, 1, 1, 0, 0), new org.joda.time.DateTime(Integer.MAX_VALUE * 1001L) };
        final ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts aggregate =
                new ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts()
                .setP0A0Ts(testValue);

        // check that the property was properly assigned
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableArrayOfNullableEquals(
                testValue,
                aggregate.getP0A0Ts());

        final String serialized = com.dslplatform.client.JsonSerialization.serialize(aggregate);
        final ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts aggregateDeserialized = jsonSerialization.deserialize(
                com.dslplatform.client.JsonSerialization.buildType(ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts.class),
                serialized);

        // check that the property was properly deserialized
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableArrayOfNullableEquals(
                testValue,
                aggregateDeserialized.getP0A0Ts());
    }

    /* Testing the "p0A0Ts" NonDefault5 property value after active record persist */
    @org.junit.Test
    public void testP0A0TsNonDefault5PropertyValueInAggregateAfterActiveRecordPersist() throws java.io.IOException {
        final org.joda.time.DateTime[] testValue = new org.joda.time.DateTime[] { null, org.joda.time.DateTime.now(), new org.joda.time.DateTime(0), new org.joda.time.DateTime(1, 1, 1, 0, 0), new org.joda.time.DateTime(Integer.MAX_VALUE * 1001L) };
        final ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts aggregate =
                new ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts()
                .setP0A0Ts(testValue);

        // persist via active record pattern
        aggregate.persist();

        // check that the property retrieved from revenj (persist will mutate the aggregate)
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableArrayOfNullableEquals(
                testValue,
                aggregate.getP0A0Ts().getP0A0Ts());

        final ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts aggregateFound =
                ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts.find(aggregate.getURI());

        final ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts aggregateFound =
                ocd.AggregateSurrogateTimestamp.Aggregate0A0Ts.find(aggregate.getURI());

        // check the property retrieved from the database
        com.dslplatform.ocd.javaasserts.TimestampAsserts.assertNullableArrayOfNullableEquals(
                testValue,
                aggregateFound.getP0A0Ts());

        // aggregates are compared via URI equality - both URIs have be initialized at this point
        org.junit.Assert.assertEquals(aggregate, aggregateFound);

        // hashCodes are generated from the URI
        org.junit.Assert.assertEquals(aggregate.hashCode(), aggregateFound.hashCode());
    }
}