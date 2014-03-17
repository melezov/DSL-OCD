package com.dslplatform.ocd.aggregates.PrimaryKeyPropertyInAggregateSetup.repositories;

import com.dslplatform.patterns.*;
import com.dslplatform.client.*;

public class OneImage_2Repository
        extends
        ClientPersistableRepository<com.dslplatform.ocd.aggregates.PrimaryKeyPropertyInAggregateSetup.OneImage_2> {
    public OneImage_2Repository(
            final ServiceLocator locator) {
        super(
                com.dslplatform.ocd.aggregates.PrimaryKeyPropertyInAggregateSetup.OneImage_2.class,
                locator);
    }
}