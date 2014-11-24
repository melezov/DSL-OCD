package com.dslplatform.ocd.aggregates;

import java.io.IOException;

public class AggregateTypeWithSurrogateKeyAndNullableListOfNullableIpsPropertyTest {

    private static com.dslplatform.client.JsonSerialization jsonSerialization;
    private static com.dslplatform.patterns.PersistableRepository<ocd.AggregateSurrogateIp.Aggregate0L0Ip> aggregate0L0IpRepository;

    @org.junit.BeforeClass
    public static void initialize() throws IOException {
        final com.dslplatform.patterns.ServiceLocator locator = com.dslplatform.client.Bootstrap.init(AggregateTypeWithSurrogateKeyAndNullableListOfNullableIpsPropertyTest.class.getResourceAsStream("/dsl-project.ini"));
        jsonSerialization = locator.resolve(com.dslplatform.client.JsonSerialization.class);
        aggregate0L0IpRepository = locator.resolve(ocd.AggregateSurrogateIp.repositories.Aggregate0L0IpRepository.class);
    }

    /* Testing the "p0L0Ip" Default aggregate property JSON serialization */
    @org.junit.Test
    public void testP0L0IpDefaultPropertyInAggregateJsonSerialization() throws java.io.IOException {
        final ocd.AggregateSurrogateIp.Aggregate0L0Ip aggregate =
                new ocd.AggregateSurrogateIp.Aggregate0L0Ip();
        final java.util.List<java.net.InetAddress> testValue = aggregate.getP0L0Ip();

        // check that the property was properly assigned
        com.dslplatform.ocd.javaasserts.IpAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregate.getP0L0Ip());

        final String serialized = com.dslplatform.client.JsonSerialization.serialize(aggregate);
        final ocd.AggregateSurrogateIp.Aggregate0L0Ip aggregateDeserialized = jsonSerialization.deserialize(
                com.dslplatform.client.JsonSerialization.buildType(ocd.AggregateSurrogateIp.Aggregate0L0Ip.class),
                serialized);

        // check that the property was properly deserialized
        com.dslplatform.ocd.javaasserts.IpAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregateDeserialized.getP0L0Ip());
    }

    /* Testing the "p0L0Ip" Default property value after active record persist */
    @org.junit.Test
    public void testP0L0IpDefaultPropertyValueInAggregateAfterActiveRecordPersist() throws java.io.IOException {
        final ocd.AggregateSurrogateIp.Aggregate0L0Ip aggregate =
                new ocd.AggregateSurrogateIp.Aggregate0L0Ip();
        final java.util.List<java.net.InetAddress> testValue = aggregate.getP0L0Ip();

        // persist via active record pattern
        aggregate.persist();

        // check that the property retrieved from revenj (persist will mutate the aggregate)
        com.dslplatform.ocd.javaasserts.IpAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregate.getP0L0Ip().getP0L0Ip());

        final ocd.AggregateSurrogateIp.Aggregate0L0Ip aggregateFound =
                ocd.AggregateSurrogateIp.Aggregate0L0Ip.find(aggregate.getURI());

        final ocd.AggregateSurrogateIp.Aggregate0L0Ip aggregateFound =
                ocd.AggregateSurrogateIp.Aggregate0L0Ip.find(aggregate.getURI());

        // check the property retrieved from the database
        com.dslplatform.ocd.javaasserts.IpAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregateFound.getP0L0Ip());

        // aggregates are compared via URI equality - both URIs have be initialized at this point
        org.junit.Assert.assertEquals(aggregate, aggregateFound);

        // hashCodes are generated from the URI
        org.junit.Assert.assertEquals(aggregate.hashCode(), aggregateFound.hashCode());
    }

    /* Testing the "p0L0Ip" NonDefault1 aggregate property JSON serialization */
    @org.junit.Test
    public void testP0L0IpNonDefault1PropertyInAggregateJsonSerialization() throws java.io.IOException {
        final java.util.List<java.net.InetAddress> testValue = new java.util.ArrayList<java.net.InetAddress>() {{ add(null); }};
        final ocd.AggregateSurrogateIp.Aggregate0L0Ip aggregate =
                new ocd.AggregateSurrogateIp.Aggregate0L0Ip()
                .setP0L0Ip(testValue);

        // check that the property was properly assigned
        com.dslplatform.ocd.javaasserts.IpAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregate.getP0L0Ip());

        final String serialized = com.dslplatform.client.JsonSerialization.serialize(aggregate);
        final ocd.AggregateSurrogateIp.Aggregate0L0Ip aggregateDeserialized = jsonSerialization.deserialize(
                com.dslplatform.client.JsonSerialization.buildType(ocd.AggregateSurrogateIp.Aggregate0L0Ip.class),
                serialized);

        // check that the property was properly deserialized
        com.dslplatform.ocd.javaasserts.IpAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregateDeserialized.getP0L0Ip());
    }

    /* Testing the "p0L0Ip" NonDefault1 property value after active record persist */
    @org.junit.Test
    public void testP0L0IpNonDefault1PropertyValueInAggregateAfterActiveRecordPersist() throws java.io.IOException {
        final java.util.List<java.net.InetAddress> testValue = new java.util.ArrayList<java.net.InetAddress>() {{ add(null); }};
        final ocd.AggregateSurrogateIp.Aggregate0L0Ip aggregate =
                new ocd.AggregateSurrogateIp.Aggregate0L0Ip()
                .setP0L0Ip(testValue);

        // persist via active record pattern
        aggregate.persist();

        // check that the property retrieved from revenj (persist will mutate the aggregate)
        com.dslplatform.ocd.javaasserts.IpAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregate.getP0L0Ip().getP0L0Ip());

        final ocd.AggregateSurrogateIp.Aggregate0L0Ip aggregateFound =
                ocd.AggregateSurrogateIp.Aggregate0L0Ip.find(aggregate.getURI());

        final ocd.AggregateSurrogateIp.Aggregate0L0Ip aggregateFound =
                ocd.AggregateSurrogateIp.Aggregate0L0Ip.find(aggregate.getURI());

        // check the property retrieved from the database
        com.dslplatform.ocd.javaasserts.IpAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregateFound.getP0L0Ip());

        // aggregates are compared via URI equality - both URIs have be initialized at this point
        org.junit.Assert.assertEquals(aggregate, aggregateFound);

        // hashCodes are generated from the URI
        org.junit.Assert.assertEquals(aggregate.hashCode(), aggregateFound.hashCode());
    }

    /* Testing the "p0L0Ip" NonDefault2 aggregate property JSON serialization */
    @org.junit.Test
    public void testP0L0IpNonDefault2PropertyInAggregateJsonSerialization() throws java.io.IOException {
        final java.util.List<java.net.InetAddress> testValue = new java.util.ArrayList<java.net.InetAddress>() {{ add(com.dslplatform.ocd.test.TypeFactory.buildIP("ffff::ffff")); }};
        final ocd.AggregateSurrogateIp.Aggregate0L0Ip aggregate =
                new ocd.AggregateSurrogateIp.Aggregate0L0Ip()
                .setP0L0Ip(testValue);

        // check that the property was properly assigned
        com.dslplatform.ocd.javaasserts.IpAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregate.getP0L0Ip());

        final String serialized = com.dslplatform.client.JsonSerialization.serialize(aggregate);
        final ocd.AggregateSurrogateIp.Aggregate0L0Ip aggregateDeserialized = jsonSerialization.deserialize(
                com.dslplatform.client.JsonSerialization.buildType(ocd.AggregateSurrogateIp.Aggregate0L0Ip.class),
                serialized);

        // check that the property was properly deserialized
        com.dslplatform.ocd.javaasserts.IpAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregateDeserialized.getP0L0Ip());
    }

    /* Testing the "p0L0Ip" NonDefault2 property value after active record persist */
    @org.junit.Test
    public void testP0L0IpNonDefault2PropertyValueInAggregateAfterActiveRecordPersist() throws java.io.IOException {
        final java.util.List<java.net.InetAddress> testValue = new java.util.ArrayList<java.net.InetAddress>() {{ add(com.dslplatform.ocd.test.TypeFactory.buildIP("ffff::ffff")); }};
        final ocd.AggregateSurrogateIp.Aggregate0L0Ip aggregate =
                new ocd.AggregateSurrogateIp.Aggregate0L0Ip()
                .setP0L0Ip(testValue);

        // persist via active record pattern
        aggregate.persist();

        // check that the property retrieved from revenj (persist will mutate the aggregate)
        com.dslplatform.ocd.javaasserts.IpAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregate.getP0L0Ip().getP0L0Ip());

        final ocd.AggregateSurrogateIp.Aggregate0L0Ip aggregateFound =
                ocd.AggregateSurrogateIp.Aggregate0L0Ip.find(aggregate.getURI());

        final ocd.AggregateSurrogateIp.Aggregate0L0Ip aggregateFound =
                ocd.AggregateSurrogateIp.Aggregate0L0Ip.find(aggregate.getURI());

        // check the property retrieved from the database
        com.dslplatform.ocd.javaasserts.IpAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregateFound.getP0L0Ip());

        // aggregates are compared via URI equality - both URIs have be initialized at this point
        org.junit.Assert.assertEquals(aggregate, aggregateFound);

        // hashCodes are generated from the URI
        org.junit.Assert.assertEquals(aggregate.hashCode(), aggregateFound.hashCode());
    }

    /* Testing the "p0L0Ip" NonDefault3 aggregate property JSON serialization */
    @org.junit.Test
    public void testP0L0IpNonDefault3PropertyInAggregateJsonSerialization() throws java.io.IOException {
        final java.util.List<java.net.InetAddress> testValue = new java.util.ArrayList<java.net.InetAddress>() {{ add(com.dslplatform.ocd.test.TypeFactory.buildIP("127.0.0.1")); add(com.dslplatform.ocd.test.TypeFactory.buildIP("0")); add(com.dslplatform.ocd.test.TypeFactory.buildIP("255.255.255.255")); add(com.dslplatform.ocd.test.TypeFactory.buildIP("::1")); add(com.dslplatform.ocd.test.TypeFactory.buildIP("ffff::ffff")); }};
        final ocd.AggregateSurrogateIp.Aggregate0L0Ip aggregate =
                new ocd.AggregateSurrogateIp.Aggregate0L0Ip()
                .setP0L0Ip(testValue);

        // check that the property was properly assigned
        com.dslplatform.ocd.javaasserts.IpAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregate.getP0L0Ip());

        final String serialized = com.dslplatform.client.JsonSerialization.serialize(aggregate);
        final ocd.AggregateSurrogateIp.Aggregate0L0Ip aggregateDeserialized = jsonSerialization.deserialize(
                com.dslplatform.client.JsonSerialization.buildType(ocd.AggregateSurrogateIp.Aggregate0L0Ip.class),
                serialized);

        // check that the property was properly deserialized
        com.dslplatform.ocd.javaasserts.IpAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregateDeserialized.getP0L0Ip());
    }

    /* Testing the "p0L0Ip" NonDefault3 property value after active record persist */
    @org.junit.Test
    public void testP0L0IpNonDefault3PropertyValueInAggregateAfterActiveRecordPersist() throws java.io.IOException {
        final java.util.List<java.net.InetAddress> testValue = new java.util.ArrayList<java.net.InetAddress>() {{ add(com.dslplatform.ocd.test.TypeFactory.buildIP("127.0.0.1")); add(com.dslplatform.ocd.test.TypeFactory.buildIP("0")); add(com.dslplatform.ocd.test.TypeFactory.buildIP("255.255.255.255")); add(com.dslplatform.ocd.test.TypeFactory.buildIP("::1")); add(com.dslplatform.ocd.test.TypeFactory.buildIP("ffff::ffff")); }};
        final ocd.AggregateSurrogateIp.Aggregate0L0Ip aggregate =
                new ocd.AggregateSurrogateIp.Aggregate0L0Ip()
                .setP0L0Ip(testValue);

        // persist via active record pattern
        aggregate.persist();

        // check that the property retrieved from revenj (persist will mutate the aggregate)
        com.dslplatform.ocd.javaasserts.IpAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregate.getP0L0Ip().getP0L0Ip());

        final ocd.AggregateSurrogateIp.Aggregate0L0Ip aggregateFound =
                ocd.AggregateSurrogateIp.Aggregate0L0Ip.find(aggregate.getURI());

        final ocd.AggregateSurrogateIp.Aggregate0L0Ip aggregateFound =
                ocd.AggregateSurrogateIp.Aggregate0L0Ip.find(aggregate.getURI());

        // check the property retrieved from the database
        com.dslplatform.ocd.javaasserts.IpAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregateFound.getP0L0Ip());

        // aggregates are compared via URI equality - both URIs have be initialized at this point
        org.junit.Assert.assertEquals(aggregate, aggregateFound);

        // hashCodes are generated from the URI
        org.junit.Assert.assertEquals(aggregate.hashCode(), aggregateFound.hashCode());
    }

    /* Testing the "p0L0Ip" NonDefault4 aggregate property JSON serialization */
    @org.junit.Test
    public void testP0L0IpNonDefault4PropertyInAggregateJsonSerialization() throws java.io.IOException {
        final java.util.List<java.net.InetAddress> testValue = new java.util.ArrayList<java.net.InetAddress>() {{ add(null); add(com.dslplatform.ocd.test.TypeFactory.buildIP("127.0.0.1")); add(com.dslplatform.ocd.test.TypeFactory.buildIP("0")); add(com.dslplatform.ocd.test.TypeFactory.buildIP("255.255.255.255")); add(com.dslplatform.ocd.test.TypeFactory.buildIP("::1")); add(com.dslplatform.ocd.test.TypeFactory.buildIP("ffff::ffff")); }};
        final ocd.AggregateSurrogateIp.Aggregate0L0Ip aggregate =
                new ocd.AggregateSurrogateIp.Aggregate0L0Ip()
                .setP0L0Ip(testValue);

        // check that the property was properly assigned
        com.dslplatform.ocd.javaasserts.IpAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregate.getP0L0Ip());

        final String serialized = com.dslplatform.client.JsonSerialization.serialize(aggregate);
        final ocd.AggregateSurrogateIp.Aggregate0L0Ip aggregateDeserialized = jsonSerialization.deserialize(
                com.dslplatform.client.JsonSerialization.buildType(ocd.AggregateSurrogateIp.Aggregate0L0Ip.class),
                serialized);

        // check that the property was properly deserialized
        com.dslplatform.ocd.javaasserts.IpAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregateDeserialized.getP0L0Ip());
    }

    /* Testing the "p0L0Ip" NonDefault4 property value after active record persist */
    @org.junit.Test
    public void testP0L0IpNonDefault4PropertyValueInAggregateAfterActiveRecordPersist() throws java.io.IOException {
        final java.util.List<java.net.InetAddress> testValue = new java.util.ArrayList<java.net.InetAddress>() {{ add(null); add(com.dslplatform.ocd.test.TypeFactory.buildIP("127.0.0.1")); add(com.dslplatform.ocd.test.TypeFactory.buildIP("0")); add(com.dslplatform.ocd.test.TypeFactory.buildIP("255.255.255.255")); add(com.dslplatform.ocd.test.TypeFactory.buildIP("::1")); add(com.dslplatform.ocd.test.TypeFactory.buildIP("ffff::ffff")); }};
        final ocd.AggregateSurrogateIp.Aggregate0L0Ip aggregate =
                new ocd.AggregateSurrogateIp.Aggregate0L0Ip()
                .setP0L0Ip(testValue);

        // persist via active record pattern
        aggregate.persist();

        // check that the property retrieved from revenj (persist will mutate the aggregate)
        com.dslplatform.ocd.javaasserts.IpAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregate.getP0L0Ip().getP0L0Ip());

        final ocd.AggregateSurrogateIp.Aggregate0L0Ip aggregateFound =
                ocd.AggregateSurrogateIp.Aggregate0L0Ip.find(aggregate.getURI());

        final ocd.AggregateSurrogateIp.Aggregate0L0Ip aggregateFound =
                ocd.AggregateSurrogateIp.Aggregate0L0Ip.find(aggregate.getURI());

        // check the property retrieved from the database
        com.dslplatform.ocd.javaasserts.IpAsserts.assertNullableListOfNullableEquals(
                testValue,
                aggregateFound.getP0L0Ip());

        // aggregates are compared via URI equality - both URIs have be initialized at this point
        org.junit.Assert.assertEquals(aggregate, aggregateFound);

        // hashCodes are generated from the URI
        org.junit.Assert.assertEquals(aggregate.hashCode(), aggregateFound.hashCode());
    }
}