package com.dslplatform.ocd.aggregates.SurrogatePrimaryKeyWithOnePropertyInAggregate.repositories;

import com.dslplatform.patterns.*;
import com.dslplatform.client.*;

public class NullableListOfNullableLocations_2Repository
        extends
        ClientPersistableRepository<com.dslplatform.ocd.aggregates.SurrogatePrimaryKeyWithOnePropertyInAggregate.NullableListOfNullableLocations_2> {
    public NullableListOfNullableLocations_2Repository(
            final ServiceLocator locator) {
        super(
                com.dslplatform.ocd.aggregates.SurrogatePrimaryKeyWithOnePropertyInAggregate.NullableListOfNullableLocations_2.class,
                locator);
    }
}