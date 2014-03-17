package com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup;

import com.dslplatform.patterns.*;
import com.dslplatform.client.*;
import com.fasterxml.jackson.annotation.*;

public class OneArrayOfNullableDecimalsWithScaleOf9_4 implements
        java.io.Serializable, AggregateRoot {
    public OneArrayOfNullableDecimalsWithScaleOf9_4() {
        _serviceLocator = Bootstrap.getLocator();
        _domainProxy = _serviceLocator.resolve(DomainProxy.class);
        _crudProxy = _serviceLocator.resolve(CrudProxy.class);
        this.ID = 0;
        this.oneArrayOfNullableDecimalsWithScaleOf9 = new java.math.BigDecimal[] {};
        this.calculatedOneArrayOfNullableDecimalsWithScaleOf9 = new java.math.BigDecimal[] {};
        this.persistedOneArrayOfNullableDecimalsWithScaleOf9 = new java.math.BigDecimal[] {};
    }

    private transient final ServiceLocator _serviceLocator;
    private transient final DomainProxy _domainProxy;
    private transient final CrudProxy _crudProxy;

    private String URI;

    @JsonProperty("URI")
    public String getURI() {
        return this.URI;
    }

    @Override
    public int hashCode() {
        return URI != null ? URI.hashCode() : super.hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (getClass() != obj.getClass()) return false;
        final OneArrayOfNullableDecimalsWithScaleOf9_4 other = (OneArrayOfNullableDecimalsWithScaleOf9_4) obj;

        return URI != null && URI.equals(other.URI);
    }

    @Override
    public String toString() {
        return URI != null ? "OneArrayOfNullableDecimalsWithScaleOf9_4(" + URI
                + ')' : "new OneArrayOfNullableDecimalsWithScaleOf9_4("
                + super.hashCode() + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    public OneArrayOfNullableDecimalsWithScaleOf9_4(
            final java.math.BigDecimal[] oneArrayOfNullableDecimalsWithScaleOf9) {
        _serviceLocator = Bootstrap.getLocator();
        _domainProxy = _serviceLocator.resolve(DomainProxy.class);
        _crudProxy = _serviceLocator.resolve(CrudProxy.class);
        setOneArrayOfNullableDecimalsWithScaleOf9(oneArrayOfNullableDecimalsWithScaleOf9);
    }

    @JsonCreator
    private OneArrayOfNullableDecimalsWithScaleOf9_4(
            @JacksonInject("_serviceLocator") final ServiceLocator _serviceLocator,
            @JsonProperty("URI") final String URI,
            @JsonProperty("ID") final int ID,
            @JsonProperty("oneArrayOfNullableDecimalsWithScaleOf9") final java.math.BigDecimal[] oneArrayOfNullableDecimalsWithScaleOf9,
            @JsonProperty("calculatedOneArrayOfNullableDecimalsWithScaleOf9") final java.math.BigDecimal[] calculatedOneArrayOfNullableDecimalsWithScaleOf9,
            @JsonProperty("persistedOneArrayOfNullableDecimalsWithScaleOf9") final java.math.BigDecimal[] persistedOneArrayOfNullableDecimalsWithScaleOf9) {
        this._serviceLocator = _serviceLocator;
        this._domainProxy = _serviceLocator.resolve(DomainProxy.class);
        this._crudProxy = _serviceLocator.resolve(CrudProxy.class);
        this.URI = URI;
        this.ID = ID;
        this.oneArrayOfNullableDecimalsWithScaleOf9 = oneArrayOfNullableDecimalsWithScaleOf9 == null
                ? new java.math.BigDecimal[] {}
                : oneArrayOfNullableDecimalsWithScaleOf9;
        this.calculatedOneArrayOfNullableDecimalsWithScaleOf9 = calculatedOneArrayOfNullableDecimalsWithScaleOf9;
        this.persistedOneArrayOfNullableDecimalsWithScaleOf9 = persistedOneArrayOfNullableDecimalsWithScaleOf9;
    }

    private int ID;

    @JsonProperty("ID")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public int getID() {
        return ID;
    }

    private OneArrayOfNullableDecimalsWithScaleOf9_4 setID(final int value) {
        this.ID = value;

        return this;
    }

    public static OneArrayOfNullableDecimalsWithScaleOf9_4 find(final String uri)
            throws java.io.IOException {
        return find(uri, Bootstrap.getLocator());
    }

    public static OneArrayOfNullableDecimalsWithScaleOf9_4 find(
            final String uri,
            final ServiceLocator locator) throws java.io.IOException {
        try {
            return (locator != null ? locator : Bootstrap.getLocator())
                    .resolve(CrudProxy.class)
                    .read(OneArrayOfNullableDecimalsWithScaleOf9_4.class, uri)
                    .get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<OneArrayOfNullableDecimalsWithScaleOf9_4> find(
            final Iterable<String> uris) throws java.io.IOException {
        return find(uris, Bootstrap.getLocator());
    }

    public static java.util.List<OneArrayOfNullableDecimalsWithScaleOf9_4> find(
            final Iterable<String> uris,
            final ServiceLocator locator) throws java.io.IOException {
        try {
            return (locator != null ? locator : Bootstrap.getLocator())
                    .resolve(DomainProxy.class)
                    .find(OneArrayOfNullableDecimalsWithScaleOf9_4.class, uris)
                    .get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<OneArrayOfNullableDecimalsWithScaleOf9_4> findAll()
            throws java.io.IOException {
        return findAll(null, null, Bootstrap.getLocator());
    }

    public static java.util.List<OneArrayOfNullableDecimalsWithScaleOf9_4> findAll(
            final ServiceLocator locator) throws java.io.IOException {
        return findAll(null, null, locator);
    }

    public static java.util.List<OneArrayOfNullableDecimalsWithScaleOf9_4> findAll(
            final Integer limit,
            final Integer offset) throws java.io.IOException {
        return findAll(limit, offset, Bootstrap.getLocator());
    }

    public static java.util.List<OneArrayOfNullableDecimalsWithScaleOf9_4> findAll(
            final Integer limit,
            final Integer offset,
            final ServiceLocator locator) throws java.io.IOException {
        try {
            return (locator != null ? locator : Bootstrap.getLocator())
                    .resolve(DomainProxy.class)
                    .findAll(OneArrayOfNullableDecimalsWithScaleOf9_4.class,
                            limit, offset, null).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<OneArrayOfNullableDecimalsWithScaleOf9_4> search(
            final Specification<OneArrayOfNullableDecimalsWithScaleOf9_4> specification)
            throws java.io.IOException {
        return search(specification, null, null, Bootstrap.getLocator());
    }

    public static java.util.List<OneArrayOfNullableDecimalsWithScaleOf9_4> search(
            final Specification<OneArrayOfNullableDecimalsWithScaleOf9_4> specification,
            final ServiceLocator locator) throws java.io.IOException {
        return search(specification, null, null, locator);
    }

    public static java.util.List<OneArrayOfNullableDecimalsWithScaleOf9_4> search(
            final Specification<OneArrayOfNullableDecimalsWithScaleOf9_4> specification,
            final Integer limit,
            final Integer offset) throws java.io.IOException {
        return search(specification, limit, offset, Bootstrap.getLocator());
    }

    public static java.util.List<OneArrayOfNullableDecimalsWithScaleOf9_4> search(
            final Specification<OneArrayOfNullableDecimalsWithScaleOf9_4> specification,
            final Integer limit,
            final Integer offset,
            final ServiceLocator locator) throws java.io.IOException {
        try {
            return (locator != null ? locator : Bootstrap.getLocator())
                    .resolve(DomainProxy.class)
                    .search(specification, limit, offset, null).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static long count() throws java.io.IOException {
        return count(Bootstrap.getLocator());
    }

    public static long count(final ServiceLocator locator)
            throws java.io.IOException {
        try {
            return (locator != null ? locator : Bootstrap.getLocator())
                    .resolve(DomainProxy.class)
                    .count(OneArrayOfNullableDecimalsWithScaleOf9_4.class)
                    .get().longValue();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static long count(
            final Specification<OneArrayOfNullableDecimalsWithScaleOf9_4> specification)
            throws java.io.IOException {
        return count(specification, Bootstrap.getLocator());
    }

    public static long count(
            final Specification<OneArrayOfNullableDecimalsWithScaleOf9_4> specification,
            final ServiceLocator locator) throws java.io.IOException {
        try {
            return (locator != null ? locator : Bootstrap.getLocator())
                    .resolve(DomainProxy.class).count(specification).get()
                    .longValue();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    private void updateWithAnother(
            final com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.OneArrayOfNullableDecimalsWithScaleOf9_4 result) {
        this.URI = result.URI;

        this.oneArrayOfNullableDecimalsWithScaleOf9 = result.oneArrayOfNullableDecimalsWithScaleOf9;
        this.calculatedOneArrayOfNullableDecimalsWithScaleOf9 = result.calculatedOneArrayOfNullableDecimalsWithScaleOf9;
        this.persistedOneArrayOfNullableDecimalsWithScaleOf9 = result.persistedOneArrayOfNullableDecimalsWithScaleOf9;
        this.ID = result.ID;
    }

    public OneArrayOfNullableDecimalsWithScaleOf9_4 persist()
            throws java.io.IOException {
        final OneArrayOfNullableDecimalsWithScaleOf9_4 result;
        try {
            result = this.URI == null
                    ? _crudProxy.create(this).get()
                    : _crudProxy.update(this).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
        this.updateWithAnother(result);
        return this;
    }

    public OneArrayOfNullableDecimalsWithScaleOf9_4 delete()
            throws java.io.IOException {
        try {
            return _crudProxy.delete(
                    OneArrayOfNullableDecimalsWithScaleOf9_4.class, URI).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    private java.math.BigDecimal[] oneArrayOfNullableDecimalsWithScaleOf9;

    @JsonProperty("oneArrayOfNullableDecimalsWithScaleOf9")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.math.BigDecimal[] getOneArrayOfNullableDecimalsWithScaleOf9() {
        return oneArrayOfNullableDecimalsWithScaleOf9;
    }

    public OneArrayOfNullableDecimalsWithScaleOf9_4 setOneArrayOfNullableDecimalsWithScaleOf9(
            final java.math.BigDecimal[] value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"oneArrayOfNullableDecimalsWithScaleOf9\" cannot be null!");
        com.dslplatform.ocd.calculation.Guards.checkScale(value, 9);
        this.oneArrayOfNullableDecimalsWithScaleOf9 = value;

        return this;
    }

    private java.math.BigDecimal[] calculatedOneArrayOfNullableDecimalsWithScaleOf9;

    @JsonProperty("calculatedOneArrayOfNullableDecimalsWithScaleOf9")
    public java.math.BigDecimal[] getCalculatedOneArrayOfNullableDecimalsWithScaleOf9() {
        return this.calculatedOneArrayOfNullableDecimalsWithScaleOf9;
    }

    private java.math.BigDecimal[] persistedOneArrayOfNullableDecimalsWithScaleOf9;

    @JsonProperty("persistedOneArrayOfNullableDecimalsWithScaleOf9")
    public java.math.BigDecimal[] getPersistedOneArrayOfNullableDecimalsWithScaleOf9() {
        return this.persistedOneArrayOfNullableDecimalsWithScaleOf9;
    }
}