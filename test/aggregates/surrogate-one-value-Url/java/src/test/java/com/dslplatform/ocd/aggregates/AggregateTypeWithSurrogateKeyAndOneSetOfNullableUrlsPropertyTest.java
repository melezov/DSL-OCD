package com.dslplatform.ocd.aggregates;

import java.io.IOException;

public class AggregateTypeWithSurrogateKeyAndOneSetOfNullableUrlsPropertyTest {

    private static com.dslplatform.client.JsonSerialization jsonSerialization;
    private static com.dslplatform.patterns.PersistableRepository<ocd.AggregateSurrogateUrl.Aggregate1S0Ur> aggregate1S0UrRepository;

    @org.junit.BeforeClass
    public static void initialize() throws IOException {
        final com.dslplatform.patterns.ServiceLocator locator = com.dslplatform.client.Bootstrap.init(AggregateTypeWithSurrogateKeyAndOneSetOfNullableUrlsPropertyTest.class.getResourceAsStream("/dsl-project.ini"));
        jsonSerialization = locator.resolve(com.dslplatform.client.JsonSerialization.class);
        aggregate1S0UrRepository = locator.resolve(ocd.AggregateSurrogateUrl.repositories.Aggregate1S0UrRepository.class);
    }

    /* Testing the "p1S0Ur" Default aggregate property JSON serialization */
    @org.junit.Test
    public void testP1S0UrDefaultPropertyInAggregateJsonSerialization() throws java.io.IOException {
        final ocd.AggregateSurrogateUrl.Aggregate1S0Ur aggregate =
                new ocd.AggregateSurrogateUrl.Aggregate1S0Ur();
        final java.util.Set<java.net.URI> testValue = aggregate.getP1S0Ur();

        // check that the property was properly assigned
        com.dslplatform.ocd.javaasserts.UrlAsserts.assertOneSetOfNullableEquals(
                testValue,
                aggregate.getP1S0Ur());

        final String serialized = com.dslplatform.client.JsonSerialization.serialize(aggregate);
        final ocd.AggregateSurrogateUrl.Aggregate1S0Ur aggregateDeserialized = jsonSerialization.deserialize(
                com.dslplatform.client.JsonSerialization.buildType(ocd.AggregateSurrogateUrl.Aggregate1S0Ur.class),
                serialized);

        // check that the property was properly deserialized
        com.dslplatform.ocd.javaasserts.UrlAsserts.assertOneSetOfNullableEquals(
                testValue,
                aggregateDeserialized.getP1S0Ur());
    }

    /* Testing the "p1S0Ur" Default property value after active record persist */
    @org.junit.Test
    public void testP1S0UrDefaultPropertyValueInAggregateAfterActiveRecordPersist() throws java.io.IOException {
        final ocd.AggregateSurrogateUrl.Aggregate1S0Ur aggregate =
                new ocd.AggregateSurrogateUrl.Aggregate1S0Ur();
        final java.util.Set<java.net.URI> testValue = aggregate.getP1S0Ur();

        // persist via active record pattern
        aggregate.persist();

        // check that the property retrieved from revenj (persist will mutate the aggregate)
        com.dslplatform.ocd.javaasserts.UrlAsserts.assertOneSetOfNullableEquals(
                testValue,
                aggregate.getP1S0Ur().getP1S0Ur());

        final ocd.AggregateSurrogateUrl.Aggregate1S0Ur aggregateFound =
                ocd.AggregateSurrogateUrl.Aggregate1S0Ur.find(aggregate.getURI());

        final ocd.AggregateSurrogateUrl.Aggregate1S0Ur aggregateFound =
                ocd.AggregateSurrogateUrl.Aggregate1S0Ur.find(aggregate.getURI());

        // check the property retrieved from the database
        com.dslplatform.ocd.javaasserts.UrlAsserts.assertOneSetOfNullableEquals(
                testValue,
                aggregateFound.getP1S0Ur());

        // aggregates are compared via URI equality - both URIs have be initialized at this point
        org.junit.Assert.assertEquals(aggregate, aggregateFound);

        // hashCodes are generated from the URI
        org.junit.Assert.assertEquals(aggregate.hashCode(), aggregateFound.hashCode());
    }

    /* Testing the "p1S0Ur" NonDefault1 aggregate property JSON serialization */
    @org.junit.Test
    public void testP1S0UrNonDefault1PropertyInAggregateJsonSerialization() throws java.io.IOException {
        final java.util.Set<java.net.URI> testValue = new java.util.HashSet<java.net.URI>() {{ add(null); }};
        final ocd.AggregateSurrogateUrl.Aggregate1S0Ur aggregate =
                new ocd.AggregateSurrogateUrl.Aggregate1S0Ur()
                .setP1S0Ur(testValue);

        // check that the property was properly assigned
        com.dslplatform.ocd.javaasserts.UrlAsserts.assertOneSetOfNullableEquals(
                testValue,
                aggregate.getP1S0Ur());

        final String serialized = com.dslplatform.client.JsonSerialization.serialize(aggregate);
        final ocd.AggregateSurrogateUrl.Aggregate1S0Ur aggregateDeserialized = jsonSerialization.deserialize(
                com.dslplatform.client.JsonSerialization.buildType(ocd.AggregateSurrogateUrl.Aggregate1S0Ur.class),
                serialized);

        // check that the property was properly deserialized
        com.dslplatform.ocd.javaasserts.UrlAsserts.assertOneSetOfNullableEquals(
                testValue,
                aggregateDeserialized.getP1S0Ur());
    }

    /* Testing the "p1S0Ur" NonDefault1 property value after active record persist */
    @org.junit.Test
    public void testP1S0UrNonDefault1PropertyValueInAggregateAfterActiveRecordPersist() throws java.io.IOException {
        final java.util.Set<java.net.URI> testValue = new java.util.HashSet<java.net.URI>() {{ add(null); }};
        final ocd.AggregateSurrogateUrl.Aggregate1S0Ur aggregate =
                new ocd.AggregateSurrogateUrl.Aggregate1S0Ur()
                .setP1S0Ur(testValue);

        // persist via active record pattern
        aggregate.persist();

        // check that the property retrieved from revenj (persist will mutate the aggregate)
        com.dslplatform.ocd.javaasserts.UrlAsserts.assertOneSetOfNullableEquals(
                testValue,
                aggregate.getP1S0Ur().getP1S0Ur());

        final ocd.AggregateSurrogateUrl.Aggregate1S0Ur aggregateFound =
                ocd.AggregateSurrogateUrl.Aggregate1S0Ur.find(aggregate.getURI());

        final ocd.AggregateSurrogateUrl.Aggregate1S0Ur aggregateFound =
                ocd.AggregateSurrogateUrl.Aggregate1S0Ur.find(aggregate.getURI());

        // check the property retrieved from the database
        com.dslplatform.ocd.javaasserts.UrlAsserts.assertOneSetOfNullableEquals(
                testValue,
                aggregateFound.getP1S0Ur());

        // aggregates are compared via URI equality - both URIs have be initialized at this point
        org.junit.Assert.assertEquals(aggregate, aggregateFound);

        // hashCodes are generated from the URI
        org.junit.Assert.assertEquals(aggregate.hashCode(), aggregateFound.hashCode());
    }

    /* Testing the "p1S0Ur" NonDefault2 aggregate property JSON serialization */
    @org.junit.Test
    public void testP1S0UrNonDefault2PropertyInAggregateJsonSerialization() throws java.io.IOException {
        final java.util.Set<java.net.URI> testValue = new java.util.HashSet<java.net.URI>() {{ add(com.dslplatform.ocd.test.TypeFactory.buildURI("failover:(tcp://localhost:8181,tcp://localhost:8080/)")); }};
        final ocd.AggregateSurrogateUrl.Aggregate1S0Ur aggregate =
                new ocd.AggregateSurrogateUrl.Aggregate1S0Ur()
                .setP1S0Ur(testValue);

        // check that the property was properly assigned
        com.dslplatform.ocd.javaasserts.UrlAsserts.assertOneSetOfNullableEquals(
                testValue,
                aggregate.getP1S0Ur());

        final String serialized = com.dslplatform.client.JsonSerialization.serialize(aggregate);
        final ocd.AggregateSurrogateUrl.Aggregate1S0Ur aggregateDeserialized = jsonSerialization.deserialize(
                com.dslplatform.client.JsonSerialization.buildType(ocd.AggregateSurrogateUrl.Aggregate1S0Ur.class),
                serialized);

        // check that the property was properly deserialized
        com.dslplatform.ocd.javaasserts.UrlAsserts.assertOneSetOfNullableEquals(
                testValue,
                aggregateDeserialized.getP1S0Ur());
    }

    /* Testing the "p1S0Ur" NonDefault2 property value after active record persist */
    @org.junit.Test
    public void testP1S0UrNonDefault2PropertyValueInAggregateAfterActiveRecordPersist() throws java.io.IOException {
        final java.util.Set<java.net.URI> testValue = new java.util.HashSet<java.net.URI>() {{ add(com.dslplatform.ocd.test.TypeFactory.buildURI("failover:(tcp://localhost:8181,tcp://localhost:8080/)")); }};
        final ocd.AggregateSurrogateUrl.Aggregate1S0Ur aggregate =
                new ocd.AggregateSurrogateUrl.Aggregate1S0Ur()
                .setP1S0Ur(testValue);

        // persist via active record pattern
        aggregate.persist();

        // check that the property retrieved from revenj (persist will mutate the aggregate)
        com.dslplatform.ocd.javaasserts.UrlAsserts.assertOneSetOfNullableEquals(
                testValue,
                aggregate.getP1S0Ur().getP1S0Ur());

        final ocd.AggregateSurrogateUrl.Aggregate1S0Ur aggregateFound =
                ocd.AggregateSurrogateUrl.Aggregate1S0Ur.find(aggregate.getURI());

        final ocd.AggregateSurrogateUrl.Aggregate1S0Ur aggregateFound =
                ocd.AggregateSurrogateUrl.Aggregate1S0Ur.find(aggregate.getURI());

        // check the property retrieved from the database
        com.dslplatform.ocd.javaasserts.UrlAsserts.assertOneSetOfNullableEquals(
                testValue,
                aggregateFound.getP1S0Ur());

        // aggregates are compared via URI equality - both URIs have be initialized at this point
        org.junit.Assert.assertEquals(aggregate, aggregateFound);

        // hashCodes are generated from the URI
        org.junit.Assert.assertEquals(aggregate.hashCode(), aggregateFound.hashCode());
    }

    /* Testing the "p1S0Ur" NonDefault3 aggregate property JSON serialization */
    @org.junit.Test
    public void testP1S0UrNonDefault3PropertyInAggregateJsonSerialization() throws java.io.IOException {
        final java.util.Set<java.net.URI> testValue = new java.util.HashSet<java.net.URI>() {{ add(com.dslplatform.ocd.test.TypeFactory.buildURI("http://127.0.0.1/")); add(com.dslplatform.ocd.test.TypeFactory.buildURI("http://www.xyz.com/")); add(com.dslplatform.ocd.test.TypeFactory.buildURI("https://www.abc.com/")); add(com.dslplatform.ocd.test.TypeFactory.buildURI("ftp://www.pqr.com/")); add(com.dslplatform.ocd.test.TypeFactory.buildURI("https://localhost:8080/")); add(com.dslplatform.ocd.test.TypeFactory.buildURI("mailto:snail@mail.hu")); add(com.dslplatform.ocd.test.TypeFactory.buildURI("file:///~/opt/somefile.md")); add(com.dslplatform.ocd.test.TypeFactory.buildURI("tcp://localhost:8181/")); add(com.dslplatform.ocd.test.TypeFactory.buildURI("failover:(tcp://localhost:8181,tcp://localhost:8080/)")); }};
        final ocd.AggregateSurrogateUrl.Aggregate1S0Ur aggregate =
                new ocd.AggregateSurrogateUrl.Aggregate1S0Ur()
                .setP1S0Ur(testValue);

        // check that the property was properly assigned
        com.dslplatform.ocd.javaasserts.UrlAsserts.assertOneSetOfNullableEquals(
                testValue,
                aggregate.getP1S0Ur());

        final String serialized = com.dslplatform.client.JsonSerialization.serialize(aggregate);
        final ocd.AggregateSurrogateUrl.Aggregate1S0Ur aggregateDeserialized = jsonSerialization.deserialize(
                com.dslplatform.client.JsonSerialization.buildType(ocd.AggregateSurrogateUrl.Aggregate1S0Ur.class),
                serialized);

        // check that the property was properly deserialized
        com.dslplatform.ocd.javaasserts.UrlAsserts.assertOneSetOfNullableEquals(
                testValue,
                aggregateDeserialized.getP1S0Ur());
    }

    /* Testing the "p1S0Ur" NonDefault3 property value after active record persist */
    @org.junit.Test
    public void testP1S0UrNonDefault3PropertyValueInAggregateAfterActiveRecordPersist() throws java.io.IOException {
        final java.util.Set<java.net.URI> testValue = new java.util.HashSet<java.net.URI>() {{ add(com.dslplatform.ocd.test.TypeFactory.buildURI("http://127.0.0.1/")); add(com.dslplatform.ocd.test.TypeFactory.buildURI("http://www.xyz.com/")); add(com.dslplatform.ocd.test.TypeFactory.buildURI("https://www.abc.com/")); add(com.dslplatform.ocd.test.TypeFactory.buildURI("ftp://www.pqr.com/")); add(com.dslplatform.ocd.test.TypeFactory.buildURI("https://localhost:8080/")); add(com.dslplatform.ocd.test.TypeFactory.buildURI("mailto:snail@mail.hu")); add(com.dslplatform.ocd.test.TypeFactory.buildURI("file:///~/opt/somefile.md")); add(com.dslplatform.ocd.test.TypeFactory.buildURI("tcp://localhost:8181/")); add(com.dslplatform.ocd.test.TypeFactory.buildURI("failover:(tcp://localhost:8181,tcp://localhost:8080/)")); }};
        final ocd.AggregateSurrogateUrl.Aggregate1S0Ur aggregate =
                new ocd.AggregateSurrogateUrl.Aggregate1S0Ur()
                .setP1S0Ur(testValue);

        // persist via active record pattern
        aggregate.persist();

        // check that the property retrieved from revenj (persist will mutate the aggregate)
        com.dslplatform.ocd.javaasserts.UrlAsserts.assertOneSetOfNullableEquals(
                testValue,
                aggregate.getP1S0Ur().getP1S0Ur());

        final ocd.AggregateSurrogateUrl.Aggregate1S0Ur aggregateFound =
                ocd.AggregateSurrogateUrl.Aggregate1S0Ur.find(aggregate.getURI());

        final ocd.AggregateSurrogateUrl.Aggregate1S0Ur aggregateFound =
                ocd.AggregateSurrogateUrl.Aggregate1S0Ur.find(aggregate.getURI());

        // check the property retrieved from the database
        com.dslplatform.ocd.javaasserts.UrlAsserts.assertOneSetOfNullableEquals(
                testValue,
                aggregateFound.getP1S0Ur());

        // aggregates are compared via URI equality - both URIs have be initialized at this point
        org.junit.Assert.assertEquals(aggregate, aggregateFound);

        // hashCodes are generated from the URI
        org.junit.Assert.assertEquals(aggregate.hashCode(), aggregateFound.hashCode());
    }

    /* Testing the "p1S0Ur" NonDefault4 aggregate property JSON serialization */
    @org.junit.Test
    public void testP1S0UrNonDefault4PropertyInAggregateJsonSerialization() throws java.io.IOException {
        final java.util.Set<java.net.URI> testValue = new java.util.HashSet<java.net.URI>() {{ add(null); add(com.dslplatform.ocd.test.TypeFactory.buildURI("http://127.0.0.1/")); add(com.dslplatform.ocd.test.TypeFactory.buildURI("http://www.xyz.com/")); add(com.dslplatform.ocd.test.TypeFactory.buildURI("https://www.abc.com/")); add(com.dslplatform.ocd.test.TypeFactory.buildURI("ftp://www.pqr.com/")); add(com.dslplatform.ocd.test.TypeFactory.buildURI("https://localhost:8080/")); add(com.dslplatform.ocd.test.TypeFactory.buildURI("mailto:snail@mail.hu")); add(com.dslplatform.ocd.test.TypeFactory.buildURI("file:///~/opt/somefile.md")); add(com.dslplatform.ocd.test.TypeFactory.buildURI("tcp://localhost:8181/")); add(com.dslplatform.ocd.test.TypeFactory.buildURI("failover:(tcp://localhost:8181,tcp://localhost:8080/)")); }};
        final ocd.AggregateSurrogateUrl.Aggregate1S0Ur aggregate =
                new ocd.AggregateSurrogateUrl.Aggregate1S0Ur()
                .setP1S0Ur(testValue);

        // check that the property was properly assigned
        com.dslplatform.ocd.javaasserts.UrlAsserts.assertOneSetOfNullableEquals(
                testValue,
                aggregate.getP1S0Ur());

        final String serialized = com.dslplatform.client.JsonSerialization.serialize(aggregate);
        final ocd.AggregateSurrogateUrl.Aggregate1S0Ur aggregateDeserialized = jsonSerialization.deserialize(
                com.dslplatform.client.JsonSerialization.buildType(ocd.AggregateSurrogateUrl.Aggregate1S0Ur.class),
                serialized);

        // check that the property was properly deserialized
        com.dslplatform.ocd.javaasserts.UrlAsserts.assertOneSetOfNullableEquals(
                testValue,
                aggregateDeserialized.getP1S0Ur());
    }

    /* Testing the "p1S0Ur" NonDefault4 property value after active record persist */
    @org.junit.Test
    public void testP1S0UrNonDefault4PropertyValueInAggregateAfterActiveRecordPersist() throws java.io.IOException {
        final java.util.Set<java.net.URI> testValue = new java.util.HashSet<java.net.URI>() {{ add(null); add(com.dslplatform.ocd.test.TypeFactory.buildURI("http://127.0.0.1/")); add(com.dslplatform.ocd.test.TypeFactory.buildURI("http://www.xyz.com/")); add(com.dslplatform.ocd.test.TypeFactory.buildURI("https://www.abc.com/")); add(com.dslplatform.ocd.test.TypeFactory.buildURI("ftp://www.pqr.com/")); add(com.dslplatform.ocd.test.TypeFactory.buildURI("https://localhost:8080/")); add(com.dslplatform.ocd.test.TypeFactory.buildURI("mailto:snail@mail.hu")); add(com.dslplatform.ocd.test.TypeFactory.buildURI("file:///~/opt/somefile.md")); add(com.dslplatform.ocd.test.TypeFactory.buildURI("tcp://localhost:8181/")); add(com.dslplatform.ocd.test.TypeFactory.buildURI("failover:(tcp://localhost:8181,tcp://localhost:8080/)")); }};
        final ocd.AggregateSurrogateUrl.Aggregate1S0Ur aggregate =
                new ocd.AggregateSurrogateUrl.Aggregate1S0Ur()
                .setP1S0Ur(testValue);

        // persist via active record pattern
        aggregate.persist();

        // check that the property retrieved from revenj (persist will mutate the aggregate)
        com.dslplatform.ocd.javaasserts.UrlAsserts.assertOneSetOfNullableEquals(
                testValue,
                aggregate.getP1S0Ur().getP1S0Ur());

        final ocd.AggregateSurrogateUrl.Aggregate1S0Ur aggregateFound =
                ocd.AggregateSurrogateUrl.Aggregate1S0Ur.find(aggregate.getURI());

        final ocd.AggregateSurrogateUrl.Aggregate1S0Ur aggregateFound =
                ocd.AggregateSurrogateUrl.Aggregate1S0Ur.find(aggregate.getURI());

        // check the property retrieved from the database
        com.dslplatform.ocd.javaasserts.UrlAsserts.assertOneSetOfNullableEquals(
                testValue,
                aggregateFound.getP1S0Ur());

        // aggregates are compared via URI equality - both URIs have be initialized at this point
        org.junit.Assert.assertEquals(aggregate, aggregateFound);

        // hashCodes are generated from the URI
        org.junit.Assert.assertEquals(aggregate.hashCode(), aggregateFound.hashCode());
    }
}