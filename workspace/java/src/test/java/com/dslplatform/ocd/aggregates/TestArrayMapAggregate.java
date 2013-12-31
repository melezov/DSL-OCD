package com.dslplatform.ocd.aggregates;

import com.dslplatform.client.Bootstrap;
import com.dslplatform.ocd.aggregates.ArrayMapInAggregate.ArrayMapAggregate;
import com.dslplatform.ocd.aggregates.ArrayMapInAggregate.repositories.ArrayMapAggregateRepository;
import com.dslplatform.patterns.ServiceLocator;
import java.io.IOException;
import java.lang.reflect.*;
import java.util.*;
import java.util.concurrent.ExecutionException;
import org.junit.*;
import static org.junit.Assert.*;

public class TestArrayMapAggregate {
    private static ServiceLocator locator;

        private static ArrayMapAggregateRepository repository;

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "TRACE");
        locator = Bootstrap.init(TestArrayMapAggregate.class.getResourceAsStream("dsl-project.ini"));

        repository = locator.resolve(ArrayMapAggregateRepository.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        repository = null;
        locator.resolve(java.util.concurrent.ExecutorService.class).shutdown();
        locator = null;
    }

    @Before
    public void setUp() throws Exception {
        if (repository.countAll().get() > 0) {
          repository.delete(repository.findAll().get()).get();

          final long remaining = repository.countAll().get();
          assertEquals(0L, remaining);
        }
    }

    @After
    public void tearDown() throws Exception {
    }

    /* Testing the property field type via reflection (no instantiation) */
    @Test
    public void testPropertyFieldType() throws NoSuchFieldException {
        assertEquals(
                new Object() {
                    @SuppressWarnings("unused")
                    private final Map<String, String>[] etalon = null;
                }.getClass().getDeclaredField("etalon").getGenericType(),
                ArrayMapAggregate.class.getDeclaredField("arrayMap").getGenericType());
    }

    /* Testing the property getter method type via reflection (no instantiation) */
    @Test
    public void testPropertyGetterType() throws NoSuchMethodException {
        assertEquals(
                new Object() {
                    @SuppressWarnings("unused")
                    public Map<String, String>[] getEtalon() { return null; }
                }.getClass().getMethod("getEtalon").getGenericReturnType(),
                ArrayMapAggregate.class.getMethod("getArrayMap").getGenericReturnType());
    }

    /* Testing the property setter method type via reflection (no instantiation) */
    @Test
    public void testPropertySetterType() throws NoSuchMethodException {
        final Method method = ArrayMapAggregate.class.getMethod("setArrayMap", Map[].class);

        assertEquals(
                new Object() {
                    @SuppressWarnings("unused")
                    public ArrayMapAggregate setEtalon(final Map<String, String>[] etalon) { return null; }
                }.getClass().getMethod("setEtalon", Map[].class).getGenericParameterTypes()[0],
                method.getGenericParameterTypes()[0]);

        assertEquals(
                ArrayMapAggregate.class,
                method.getGenericReturnType());
    }

    /* Testing the default property value */
    @Test
    public void testPropertyDefaultValue() {
        assertArrayEquals(
                new HashMap[0],
                new ArrayMapAggregate().getArrayMap());
    }

    /* Setting a non-nullable property to null should trigger an exception */
    @Test(expected = IllegalArgumentException.class)
    public void testSetterNullGuard() {
        try {
            new ArrayMapAggregate().setArrayMap(null);
        }
        catch (final IllegalArgumentException e) {
            assertEquals(
                    "Property \"arrayMap\" cannot be null!",
                    e.getMessage());
            throw e;
        }
    }

    /* Testing the default property value after persist */
    @Test
    public void testPropertyDefaultValueAfterPersist()
            throws IOException, InterruptedException, ExecutionException {
        final ArrayMapAggregate aggregate = new ArrayMapAggregate();

        // Will not mutate the original aggregate
        final String uri = repository.insert(aggregate).get();
        final ArrayMapAggregate persisted = repository.find(uri).get();

        assertArrayEquals(
                new HashMap[0],
                persisted.getArrayMap());

        assertArrayEquals(
                aggregate.getArrayMap(),
                persisted.getArrayMap());
    }
}
