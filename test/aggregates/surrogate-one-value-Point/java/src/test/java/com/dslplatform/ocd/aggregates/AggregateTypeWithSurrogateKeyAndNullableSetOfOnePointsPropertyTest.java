package com.dslplatform.ocd.aggregates;

import java.io.IOException;

public class AggregateTypeWithSurrogateKeyAndNullableSetOfOnePointsPropertyTest {

    private static com.dslplatform.client.JsonSerialization jsonSerialization;
    private static com.dslplatform.patterns.PersistableRepository<ocd.AggregateSurrogatePoint.Aggregate0S1Po> aggregate0S1PoRepository;

    @org.junit.BeforeClass
    public static void initialize() throws IOException {
        final com.dslplatform.patterns.ServiceLocator locator = com.dslplatform.client.Bootstrap.init(AggregateTypeWithSurrogateKeyAndNullableSetOfOnePointsPropertyTest.class.getResourceAsStream("/dsl-project.ini"));
        jsonSerialization = locator.resolve(com.dslplatform.client.JsonSerialization.class);
        aggregate0S1PoRepository = locator.resolve(ocd.AggregateSurrogatePoint.repositories.Aggregate0S1PoRepository.class);
    }

    /* Testing the "p0S1Po" Default aggregate property JSON serialization */
    @org.junit.Test
    public void testP0S1PoDefaultPropertyInAggregateJsonSerialization() throws java.io.IOException {
        final ocd.AggregateSurrogatePoint.Aggregate0S1Po aggregate =
                new ocd.AggregateSurrogatePoint.Aggregate0S1Po();
        final java.util.Set<java.awt.Point> testValue = aggregate.getP0S1Po();

        // check that the property was properly assigned
        com.dslplatform.ocd.javaasserts.PointAsserts.assertNullableSetOfOneEquals(
                testValue,
                aggregate.getP0S1Po());

        final String serialized = com.dslplatform.client.JsonSerialization.serialize(aggregate);
        final ocd.AggregateSurrogatePoint.Aggregate0S1Po aggregateDeserialized = jsonSerialization.deserialize(
                com.dslplatform.client.JsonSerialization.buildType(ocd.AggregateSurrogatePoint.Aggregate0S1Po.class),
                serialized);

        // check that the property was properly deserialized
        com.dslplatform.ocd.javaasserts.PointAsserts.assertNullableSetOfOneEquals(
                testValue,
                aggregateDeserialized.getP0S1Po());
    }

    /* Testing the "p0S1Po" Default property value after active record persist */
    @org.junit.Test
    public void testP0S1PoDefaultPropertyValueInAggregateAfterActiveRecordPersist() throws java.io.IOException {
        final ocd.AggregateSurrogatePoint.Aggregate0S1Po aggregate =
                new ocd.AggregateSurrogatePoint.Aggregate0S1Po();
        final java.util.Set<java.awt.Point> testValue = aggregate.getP0S1Po();

        // persist via active record pattern
        aggregate.persist();

        // check that the property retrieved from revenj (persist will mutate the aggregate)
        com.dslplatform.ocd.javaasserts.PointAsserts.assertNullableSetOfOneEquals(
                testValue,
                aggregate.getP0S1Po().getP0S1Po());

        final ocd.AggregateSurrogatePoint.Aggregate0S1Po aggregateFound =
                ocd.AggregateSurrogatePoint.Aggregate0S1Po.find(aggregate.getURI());

        final ocd.AggregateSurrogatePoint.Aggregate0S1Po aggregateFound =
                ocd.AggregateSurrogatePoint.Aggregate0S1Po.find(aggregate.getURI());

        // check the property retrieved from the database
        com.dslplatform.ocd.javaasserts.PointAsserts.assertNullableSetOfOneEquals(
                testValue,
                aggregateFound.getP0S1Po());

        // aggregates are compared via URI equality - both URIs have be initialized at this point
        org.junit.Assert.assertEquals(aggregate, aggregateFound);

        // hashCodes are generated from the URI
        org.junit.Assert.assertEquals(aggregate.hashCode(), aggregateFound.hashCode());
    }

    /* Testing the "p0S1Po" NonDefault1 aggregate property JSON serialization */
    @org.junit.Test
    public void testP0S1PoNonDefault1PropertyInAggregateJsonSerialization() throws java.io.IOException {
        final java.util.Set<java.awt.Point> testValue = new java.util.HashSet<java.awt.Point>() {{ add(new java.awt.Point()); }};
        final ocd.AggregateSurrogatePoint.Aggregate0S1Po aggregate =
                new ocd.AggregateSurrogatePoint.Aggregate0S1Po()
                .setP0S1Po(testValue);

        // check that the property was properly assigned
        com.dslplatform.ocd.javaasserts.PointAsserts.assertNullableSetOfOneEquals(
                testValue,
                aggregate.getP0S1Po());

        final String serialized = com.dslplatform.client.JsonSerialization.serialize(aggregate);
        final ocd.AggregateSurrogatePoint.Aggregate0S1Po aggregateDeserialized = jsonSerialization.deserialize(
                com.dslplatform.client.JsonSerialization.buildType(ocd.AggregateSurrogatePoint.Aggregate0S1Po.class),
                serialized);

        // check that the property was properly deserialized
        com.dslplatform.ocd.javaasserts.PointAsserts.assertNullableSetOfOneEquals(
                testValue,
                aggregateDeserialized.getP0S1Po());
    }

    /* Testing the "p0S1Po" NonDefault1 property value after active record persist */
    @org.junit.Test
    public void testP0S1PoNonDefault1PropertyValueInAggregateAfterActiveRecordPersist() throws java.io.IOException {
        final java.util.Set<java.awt.Point> testValue = new java.util.HashSet<java.awt.Point>() {{ add(new java.awt.Point()); }};
        final ocd.AggregateSurrogatePoint.Aggregate0S1Po aggregate =
                new ocd.AggregateSurrogatePoint.Aggregate0S1Po()
                .setP0S1Po(testValue);

        // persist via active record pattern
        aggregate.persist();

        // check that the property retrieved from revenj (persist will mutate the aggregate)
        com.dslplatform.ocd.javaasserts.PointAsserts.assertNullableSetOfOneEquals(
                testValue,
                aggregate.getP0S1Po().getP0S1Po());

        final ocd.AggregateSurrogatePoint.Aggregate0S1Po aggregateFound =
                ocd.AggregateSurrogatePoint.Aggregate0S1Po.find(aggregate.getURI());

        final ocd.AggregateSurrogatePoint.Aggregate0S1Po aggregateFound =
                ocd.AggregateSurrogatePoint.Aggregate0S1Po.find(aggregate.getURI());

        // check the property retrieved from the database
        com.dslplatform.ocd.javaasserts.PointAsserts.assertNullableSetOfOneEquals(
                testValue,
                aggregateFound.getP0S1Po());

        // aggregates are compared via URI equality - both URIs have be initialized at this point
        org.junit.Assert.assertEquals(aggregate, aggregateFound);

        // hashCodes are generated from the URI
        org.junit.Assert.assertEquals(aggregate.hashCode(), aggregateFound.hashCode());
    }

    /* Testing the "p0S1Po" NonDefault2 aggregate property JSON serialization */
    @org.junit.Test
    public void testP0S1PoNonDefault2PropertyInAggregateJsonSerialization() throws java.io.IOException {
        final java.util.Set<java.awt.Point> testValue = new java.util.HashSet<java.awt.Point>() {{ add(new java.awt.Point(0, 1000000000)); }};
        final ocd.AggregateSurrogatePoint.Aggregate0S1Po aggregate =
                new ocd.AggregateSurrogatePoint.Aggregate0S1Po()
                .setP0S1Po(testValue);

        // check that the property was properly assigned
        com.dslplatform.ocd.javaasserts.PointAsserts.assertNullableSetOfOneEquals(
                testValue,
                aggregate.getP0S1Po());

        final String serialized = com.dslplatform.client.JsonSerialization.serialize(aggregate);
        final ocd.AggregateSurrogatePoint.Aggregate0S1Po aggregateDeserialized = jsonSerialization.deserialize(
                com.dslplatform.client.JsonSerialization.buildType(ocd.AggregateSurrogatePoint.Aggregate0S1Po.class),
                serialized);

        // check that the property was properly deserialized
        com.dslplatform.ocd.javaasserts.PointAsserts.assertNullableSetOfOneEquals(
                testValue,
                aggregateDeserialized.getP0S1Po());
    }

    /* Testing the "p0S1Po" NonDefault2 property value after active record persist */
    @org.junit.Test
    public void testP0S1PoNonDefault2PropertyValueInAggregateAfterActiveRecordPersist() throws java.io.IOException {
        final java.util.Set<java.awt.Point> testValue = new java.util.HashSet<java.awt.Point>() {{ add(new java.awt.Point(0, 1000000000)); }};
        final ocd.AggregateSurrogatePoint.Aggregate0S1Po aggregate =
                new ocd.AggregateSurrogatePoint.Aggregate0S1Po()
                .setP0S1Po(testValue);

        // persist via active record pattern
        aggregate.persist();

        // check that the property retrieved from revenj (persist will mutate the aggregate)
        com.dslplatform.ocd.javaasserts.PointAsserts.assertNullableSetOfOneEquals(
                testValue,
                aggregate.getP0S1Po().getP0S1Po());

        final ocd.AggregateSurrogatePoint.Aggregate0S1Po aggregateFound =
                ocd.AggregateSurrogatePoint.Aggregate0S1Po.find(aggregate.getURI());

        final ocd.AggregateSurrogatePoint.Aggregate0S1Po aggregateFound =
                ocd.AggregateSurrogatePoint.Aggregate0S1Po.find(aggregate.getURI());

        // check the property retrieved from the database
        com.dslplatform.ocd.javaasserts.PointAsserts.assertNullableSetOfOneEquals(
                testValue,
                aggregateFound.getP0S1Po());

        // aggregates are compared via URI equality - both URIs have be initialized at this point
        org.junit.Assert.assertEquals(aggregate, aggregateFound);

        // hashCodes are generated from the URI
        org.junit.Assert.assertEquals(aggregate.hashCode(), aggregateFound.hashCode());
    }

    /* Testing the "p0S1Po" NonDefault3 aggregate property JSON serialization */
    @org.junit.Test
    public void testP0S1PoNonDefault3PropertyInAggregateJsonSerialization() throws java.io.IOException {
        final java.util.Set<java.awt.Point> testValue = new java.util.HashSet<java.awt.Point>() {{ add(new java.awt.Point()); add(new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)); add(new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)); add(new java.awt.Point(0, -1000000000)); add(new java.awt.Point(0, 1000000000)); }};
        final ocd.AggregateSurrogatePoint.Aggregate0S1Po aggregate =
                new ocd.AggregateSurrogatePoint.Aggregate0S1Po()
                .setP0S1Po(testValue);

        // check that the property was properly assigned
        com.dslplatform.ocd.javaasserts.PointAsserts.assertNullableSetOfOneEquals(
                testValue,
                aggregate.getP0S1Po());

        final String serialized = com.dslplatform.client.JsonSerialization.serialize(aggregate);
        final ocd.AggregateSurrogatePoint.Aggregate0S1Po aggregateDeserialized = jsonSerialization.deserialize(
                com.dslplatform.client.JsonSerialization.buildType(ocd.AggregateSurrogatePoint.Aggregate0S1Po.class),
                serialized);

        // check that the property was properly deserialized
        com.dslplatform.ocd.javaasserts.PointAsserts.assertNullableSetOfOneEquals(
                testValue,
                aggregateDeserialized.getP0S1Po());
    }

    /* Testing the "p0S1Po" NonDefault3 property value after active record persist */
    @org.junit.Test
    public void testP0S1PoNonDefault3PropertyValueInAggregateAfterActiveRecordPersist() throws java.io.IOException {
        final java.util.Set<java.awt.Point> testValue = new java.util.HashSet<java.awt.Point>() {{ add(new java.awt.Point()); add(new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)); add(new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)); add(new java.awt.Point(0, -1000000000)); add(new java.awt.Point(0, 1000000000)); }};
        final ocd.AggregateSurrogatePoint.Aggregate0S1Po aggregate =
                new ocd.AggregateSurrogatePoint.Aggregate0S1Po()
                .setP0S1Po(testValue);

        // persist via active record pattern
        aggregate.persist();

        // check that the property retrieved from revenj (persist will mutate the aggregate)
        com.dslplatform.ocd.javaasserts.PointAsserts.assertNullableSetOfOneEquals(
                testValue,
                aggregate.getP0S1Po().getP0S1Po());

        final ocd.AggregateSurrogatePoint.Aggregate0S1Po aggregateFound =
                ocd.AggregateSurrogatePoint.Aggregate0S1Po.find(aggregate.getURI());

        final ocd.AggregateSurrogatePoint.Aggregate0S1Po aggregateFound =
                ocd.AggregateSurrogatePoint.Aggregate0S1Po.find(aggregate.getURI());

        // check the property retrieved from the database
        com.dslplatform.ocd.javaasserts.PointAsserts.assertNullableSetOfOneEquals(
                testValue,
                aggregateFound.getP0S1Po());

        // aggregates are compared via URI equality - both URIs have be initialized at this point
        org.junit.Assert.assertEquals(aggregate, aggregateFound);

        // hashCodes are generated from the URI
        org.junit.Assert.assertEquals(aggregate.hashCode(), aggregateFound.hashCode());
    }
}