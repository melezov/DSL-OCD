package com.dslplatform.ocd.aggregates;

import java.io.IOException;

public class AggregateTypeWithSurrogateKeyAndNullableArrayOfOneIntegersPropertyTest {

    private static com.dslplatform.client.JsonSerialization jsonSerialization;
    private static com.dslplatform.patterns.PersistableRepository<ocd.AggregateSurrogateInteger.Aggregate0A1In> aggregate0A1InRepository;

    @org.junit.BeforeClass
    public static void initialize() throws IOException {
        final com.dslplatform.patterns.ServiceLocator locator = com.dslplatform.client.Bootstrap.init(AggregateTypeWithSurrogateKeyAndNullableArrayOfOneIntegersPropertyTest.class.getResourceAsStream("/dsl-project.ini"));
        jsonSerialization = locator.resolve(com.dslplatform.client.JsonSerialization.class);
        aggregate0A1InRepository = locator.resolve(ocd.AggregateSurrogateInteger.repositories.Aggregate0A1InRepository.class);
    }

    /* Testing the "p0A1In" Default aggregate property JSON serialization */
    @org.junit.Test
    public void testP0A1InDefaultPropertyInAggregateJsonSerialization() throws java.io.IOException {
        final ocd.AggregateSurrogateInteger.Aggregate0A1In aggregate =
                new ocd.AggregateSurrogateInteger.Aggregate0A1In();
        final int[] testValue = aggregate.getP0A1In();

        // check that the property was properly assigned
        com.dslplatform.ocd.javaasserts.IntegerAsserts.assertNullableArrayOfOneEquals(
                testValue,
                aggregate.getP0A1In());

        final String serialized = com.dslplatform.client.JsonSerialization.serialize(aggregate);
        final ocd.AggregateSurrogateInteger.Aggregate0A1In aggregateDeserialized = jsonSerialization.deserialize(
                com.dslplatform.client.JsonSerialization.buildType(ocd.AggregateSurrogateInteger.Aggregate0A1In.class),
                serialized);

        // check that the property was properly deserialized
        com.dslplatform.ocd.javaasserts.IntegerAsserts.assertNullableArrayOfOneEquals(
                testValue,
                aggregateDeserialized.getP0A1In());
    }

    /* Testing the "p0A1In" Default property value after active record persist */
    @org.junit.Test
    public void testP0A1InDefaultPropertyValueInAggregateAfterActiveRecordPersist() throws java.io.IOException {
        final ocd.AggregateSurrogateInteger.Aggregate0A1In aggregate =
                new ocd.AggregateSurrogateInteger.Aggregate0A1In();
        final int[] testValue = aggregate.getP0A1In();

        // persist via active record pattern
        aggregate.persist();

        // check that the property retrieved from revenj (persist will mutate the aggregate)
        com.dslplatform.ocd.javaasserts.IntegerAsserts.assertNullableArrayOfOneEquals(
                testValue,
                aggregate.getP0A1In().getP0A1In());

        final ocd.AggregateSurrogateInteger.Aggregate0A1In aggregateFound =
                ocd.AggregateSurrogateInteger.Aggregate0A1In.find(aggregate.getURI());

        final ocd.AggregateSurrogateInteger.Aggregate0A1In aggregateFound =
                ocd.AggregateSurrogateInteger.Aggregate0A1In.find(aggregate.getURI());

        // check the property retrieved from the database
        com.dslplatform.ocd.javaasserts.IntegerAsserts.assertNullableArrayOfOneEquals(
                testValue,
                aggregateFound.getP0A1In());

        // aggregates are compared via URI equality - both URIs have be initialized at this point
        org.junit.Assert.assertEquals(aggregate, aggregateFound);

        // hashCodes are generated from the URI
        org.junit.Assert.assertEquals(aggregate.hashCode(), aggregateFound.hashCode());
    }

    /* Testing the "p0A1In" NonDefault1 aggregate property JSON serialization */
    @org.junit.Test
    public void testP0A1InNonDefault1PropertyInAggregateJsonSerialization() throws java.io.IOException {
        final int[] testValue = new int[] { 0 };
        final ocd.AggregateSurrogateInteger.Aggregate0A1In aggregate =
                new ocd.AggregateSurrogateInteger.Aggregate0A1In()
                .setP0A1In(testValue);

        // check that the property was properly assigned
        com.dslplatform.ocd.javaasserts.IntegerAsserts.assertNullableArrayOfOneEquals(
                testValue,
                aggregate.getP0A1In());

        final String serialized = com.dslplatform.client.JsonSerialization.serialize(aggregate);
        final ocd.AggregateSurrogateInteger.Aggregate0A1In aggregateDeserialized = jsonSerialization.deserialize(
                com.dslplatform.client.JsonSerialization.buildType(ocd.AggregateSurrogateInteger.Aggregate0A1In.class),
                serialized);

        // check that the property was properly deserialized
        com.dslplatform.ocd.javaasserts.IntegerAsserts.assertNullableArrayOfOneEquals(
                testValue,
                aggregateDeserialized.getP0A1In());
    }

    /* Testing the "p0A1In" NonDefault1 property value after active record persist */
    @org.junit.Test
    public void testP0A1InNonDefault1PropertyValueInAggregateAfterActiveRecordPersist() throws java.io.IOException {
        final int[] testValue = new int[] { 0 };
        final ocd.AggregateSurrogateInteger.Aggregate0A1In aggregate =
                new ocd.AggregateSurrogateInteger.Aggregate0A1In()
                .setP0A1In(testValue);

        // persist via active record pattern
        aggregate.persist();

        // check that the property retrieved from revenj (persist will mutate the aggregate)
        com.dslplatform.ocd.javaasserts.IntegerAsserts.assertNullableArrayOfOneEquals(
                testValue,
                aggregate.getP0A1In().getP0A1In());

        final ocd.AggregateSurrogateInteger.Aggregate0A1In aggregateFound =
                ocd.AggregateSurrogateInteger.Aggregate0A1In.find(aggregate.getURI());

        final ocd.AggregateSurrogateInteger.Aggregate0A1In aggregateFound =
                ocd.AggregateSurrogateInteger.Aggregate0A1In.find(aggregate.getURI());

        // check the property retrieved from the database
        com.dslplatform.ocd.javaasserts.IntegerAsserts.assertNullableArrayOfOneEquals(
                testValue,
                aggregateFound.getP0A1In());

        // aggregates are compared via URI equality - both URIs have be initialized at this point
        org.junit.Assert.assertEquals(aggregate, aggregateFound);

        // hashCodes are generated from the URI
        org.junit.Assert.assertEquals(aggregate.hashCode(), aggregateFound.hashCode());
    }

    /* Testing the "p0A1In" NonDefault2 aggregate property JSON serialization */
    @org.junit.Test
    public void testP0A1InNonDefault2PropertyInAggregateJsonSerialization() throws java.io.IOException {
        final int[] testValue = new int[] { 1000000000 };
        final ocd.AggregateSurrogateInteger.Aggregate0A1In aggregate =
                new ocd.AggregateSurrogateInteger.Aggregate0A1In()
                .setP0A1In(testValue);

        // check that the property was properly assigned
        com.dslplatform.ocd.javaasserts.IntegerAsserts.assertNullableArrayOfOneEquals(
                testValue,
                aggregate.getP0A1In());

        final String serialized = com.dslplatform.client.JsonSerialization.serialize(aggregate);
        final ocd.AggregateSurrogateInteger.Aggregate0A1In aggregateDeserialized = jsonSerialization.deserialize(
                com.dslplatform.client.JsonSerialization.buildType(ocd.AggregateSurrogateInteger.Aggregate0A1In.class),
                serialized);

        // check that the property was properly deserialized
        com.dslplatform.ocd.javaasserts.IntegerAsserts.assertNullableArrayOfOneEquals(
                testValue,
                aggregateDeserialized.getP0A1In());
    }

    /* Testing the "p0A1In" NonDefault2 property value after active record persist */
    @org.junit.Test
    public void testP0A1InNonDefault2PropertyValueInAggregateAfterActiveRecordPersist() throws java.io.IOException {
        final int[] testValue = new int[] { 1000000000 };
        final ocd.AggregateSurrogateInteger.Aggregate0A1In aggregate =
                new ocd.AggregateSurrogateInteger.Aggregate0A1In()
                .setP0A1In(testValue);

        // persist via active record pattern
        aggregate.persist();

        // check that the property retrieved from revenj (persist will mutate the aggregate)
        com.dslplatform.ocd.javaasserts.IntegerAsserts.assertNullableArrayOfOneEquals(
                testValue,
                aggregate.getP0A1In().getP0A1In());

        final ocd.AggregateSurrogateInteger.Aggregate0A1In aggregateFound =
                ocd.AggregateSurrogateInteger.Aggregate0A1In.find(aggregate.getURI());

        final ocd.AggregateSurrogateInteger.Aggregate0A1In aggregateFound =
                ocd.AggregateSurrogateInteger.Aggregate0A1In.find(aggregate.getURI());

        // check the property retrieved from the database
        com.dslplatform.ocd.javaasserts.IntegerAsserts.assertNullableArrayOfOneEquals(
                testValue,
                aggregateFound.getP0A1In());

        // aggregates are compared via URI equality - both URIs have be initialized at this point
        org.junit.Assert.assertEquals(aggregate, aggregateFound);

        // hashCodes are generated from the URI
        org.junit.Assert.assertEquals(aggregate.hashCode(), aggregateFound.hashCode());
    }

    /* Testing the "p0A1In" NonDefault3 aggregate property JSON serialization */
    @org.junit.Test
    public void testP0A1InNonDefault3PropertyInAggregateJsonSerialization() throws java.io.IOException {
        final int[] testValue = new int[] { 0, Integer.MIN_VALUE, Integer.MAX_VALUE, -1000000000, 1000000000 };
        final ocd.AggregateSurrogateInteger.Aggregate0A1In aggregate =
                new ocd.AggregateSurrogateInteger.Aggregate0A1In()
                .setP0A1In(testValue);

        // check that the property was properly assigned
        com.dslplatform.ocd.javaasserts.IntegerAsserts.assertNullableArrayOfOneEquals(
                testValue,
                aggregate.getP0A1In());

        final String serialized = com.dslplatform.client.JsonSerialization.serialize(aggregate);
        final ocd.AggregateSurrogateInteger.Aggregate0A1In aggregateDeserialized = jsonSerialization.deserialize(
                com.dslplatform.client.JsonSerialization.buildType(ocd.AggregateSurrogateInteger.Aggregate0A1In.class),
                serialized);

        // check that the property was properly deserialized
        com.dslplatform.ocd.javaasserts.IntegerAsserts.assertNullableArrayOfOneEquals(
                testValue,
                aggregateDeserialized.getP0A1In());
    }

    /* Testing the "p0A1In" NonDefault3 property value after active record persist */
    @org.junit.Test
    public void testP0A1InNonDefault3PropertyValueInAggregateAfterActiveRecordPersist() throws java.io.IOException {
        final int[] testValue = new int[] { 0, Integer.MIN_VALUE, Integer.MAX_VALUE, -1000000000, 1000000000 };
        final ocd.AggregateSurrogateInteger.Aggregate0A1In aggregate =
                new ocd.AggregateSurrogateInteger.Aggregate0A1In()
                .setP0A1In(testValue);

        // persist via active record pattern
        aggregate.persist();

        // check that the property retrieved from revenj (persist will mutate the aggregate)
        com.dslplatform.ocd.javaasserts.IntegerAsserts.assertNullableArrayOfOneEquals(
                testValue,
                aggregate.getP0A1In().getP0A1In());

        final ocd.AggregateSurrogateInteger.Aggregate0A1In aggregateFound =
                ocd.AggregateSurrogateInteger.Aggregate0A1In.find(aggregate.getURI());

        final ocd.AggregateSurrogateInteger.Aggregate0A1In aggregateFound =
                ocd.AggregateSurrogateInteger.Aggregate0A1In.find(aggregate.getURI());

        // check the property retrieved from the database
        com.dslplatform.ocd.javaasserts.IntegerAsserts.assertNullableArrayOfOneEquals(
                testValue,
                aggregateFound.getP0A1In());

        // aggregates are compared via URI equality - both URIs have be initialized at this point
        org.junit.Assert.assertEquals(aggregate, aggregateFound);

        // hashCodes are generated from the URI
        org.junit.Assert.assertEquals(aggregate.hashCode(), aggregateFound.hashCode());
    }
}