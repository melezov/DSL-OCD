package com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup;

import com.dslplatform.patterns.*;
import com.dslplatform.client.*;
import com.fasterxml.jackson.annotation.*;

public class NullableArrayOfNullableDecimalsWithScaleOf9_3 implements
        java.io.Serializable, AggregateRoot {
    public NullableArrayOfNullableDecimalsWithScaleOf9_3() {
        _serviceLocator = Bootstrap.getLocator();
        _domainProxy = _serviceLocator.resolve(DomainProxy.class);
        _crudProxy = _serviceLocator.resolve(CrudProxy.class);
        this.ID = 0;
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
        final NullableArrayOfNullableDecimalsWithScaleOf9_3 other = (NullableArrayOfNullableDecimalsWithScaleOf9_3) obj;

        return URI != null && URI.equals(other.URI);
    }

    @Override
    public String toString() {
        return URI != null
                ? "NullableArrayOfNullableDecimalsWithScaleOf9_3(" + URI + ')'
                : "new NullableArrayOfNullableDecimalsWithScaleOf9_3("
                        + super.hashCode() + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    public NullableArrayOfNullableDecimalsWithScaleOf9_3(
            final java.math.BigDecimal[] nullableArrayOfNullableDecimalsWithScaleOf9) {
        _serviceLocator = Bootstrap.getLocator();
        _domainProxy = _serviceLocator.resolve(DomainProxy.class);
        _crudProxy = _serviceLocator.resolve(CrudProxy.class);
        setNullableArrayOfNullableDecimalsWithScaleOf9(nullableArrayOfNullableDecimalsWithScaleOf9);
    }

    @JsonCreator
    private NullableArrayOfNullableDecimalsWithScaleOf9_3(
            @JacksonInject("_serviceLocator") final ServiceLocator _serviceLocator,
            @JsonProperty("URI") final String URI,
            @JsonProperty("ID") final int ID,
            @JsonProperty("nullableArrayOfNullableDecimalsWithScaleOf9") final java.math.BigDecimal[] nullableArrayOfNullableDecimalsWithScaleOf9,
            @JsonProperty("calculatedNullableArrayOfNullableDecimalsWithScaleOf9") final java.math.BigDecimal[] calculatedNullableArrayOfNullableDecimalsWithScaleOf9,
            @JsonProperty("persistedNullableArrayOfNullableDecimalsWithScaleOf9") final java.math.BigDecimal[] persistedNullableArrayOfNullableDecimalsWithScaleOf9) {
        this._serviceLocator = _serviceLocator;
        this._domainProxy = _serviceLocator.resolve(DomainProxy.class);
        this._crudProxy = _serviceLocator.resolve(CrudProxy.class);
        this.URI = URI;
        this.ID = ID;
        this.nullableArrayOfNullableDecimalsWithScaleOf9 = nullableArrayOfNullableDecimalsWithScaleOf9;
        this.calculatedNullableArrayOfNullableDecimalsWithScaleOf9 = calculatedNullableArrayOfNullableDecimalsWithScaleOf9 == null
                ? new java.math.BigDecimal[] {}
                : calculatedNullableArrayOfNullableDecimalsWithScaleOf9;
        this.persistedNullableArrayOfNullableDecimalsWithScaleOf9 = persistedNullableArrayOfNullableDecimalsWithScaleOf9 == null
                ? new java.math.BigDecimal[] {}
                : persistedNullableArrayOfNullableDecimalsWithScaleOf9;
    }

    private int ID;

    @JsonProperty("ID")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public int getID() {
        return ID;
    }

    private NullableArrayOfNullableDecimalsWithScaleOf9_3 setID(final int value) {
        this.ID = value;

        return this;
    }

    public static NullableArrayOfNullableDecimalsWithScaleOf9_3 find(
            final String uri) throws java.io.IOException {
        return find(uri, Bootstrap.getLocator());
    }

    public static NullableArrayOfNullableDecimalsWithScaleOf9_3 find(
            final String uri,
            final ServiceLocator locator) throws java.io.IOException {
        try {
            return (locator != null ? locator : Bootstrap.getLocator())
                    .resolve(CrudProxy.class)
                    .read(NullableArrayOfNullableDecimalsWithScaleOf9_3.class,
                            uri).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<NullableArrayOfNullableDecimalsWithScaleOf9_3> find(
            final Iterable<String> uris) throws java.io.IOException {
        return find(uris, Bootstrap.getLocator());
    }

    public static java.util.List<NullableArrayOfNullableDecimalsWithScaleOf9_3> find(
            final Iterable<String> uris,
            final ServiceLocator locator) throws java.io.IOException {
        try {
            return (locator != null ? locator : Bootstrap.getLocator())
                    .resolve(DomainProxy.class)
                    .find(NullableArrayOfNullableDecimalsWithScaleOf9_3.class,
                            uris).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<NullableArrayOfNullableDecimalsWithScaleOf9_3> findAll()
            throws java.io.IOException {
        return findAll(null, null, Bootstrap.getLocator());
    }

    public static java.util.List<NullableArrayOfNullableDecimalsWithScaleOf9_3> findAll(
            final ServiceLocator locator) throws java.io.IOException {
        return findAll(null, null, locator);
    }

    public static java.util.List<NullableArrayOfNullableDecimalsWithScaleOf9_3> findAll(
            final Integer limit,
            final Integer offset) throws java.io.IOException {
        return findAll(limit, offset, Bootstrap.getLocator());
    }

    public static java.util.List<NullableArrayOfNullableDecimalsWithScaleOf9_3> findAll(
            final Integer limit,
            final Integer offset,
            final ServiceLocator locator) throws java.io.IOException {
        try {
            return (locator != null ? locator : Bootstrap.getLocator())
                    .resolve(DomainProxy.class)
                    .findAll(
                            NullableArrayOfNullableDecimalsWithScaleOf9_3.class,
                            limit, offset, null).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<NullableArrayOfNullableDecimalsWithScaleOf9_3> search(
            final Specification<NullableArrayOfNullableDecimalsWithScaleOf9_3> specification)
            throws java.io.IOException {
        return search(specification, null, null, Bootstrap.getLocator());
    }

    public static java.util.List<NullableArrayOfNullableDecimalsWithScaleOf9_3> search(
            final Specification<NullableArrayOfNullableDecimalsWithScaleOf9_3> specification,
            final ServiceLocator locator) throws java.io.IOException {
        return search(specification, null, null, locator);
    }

    public static java.util.List<NullableArrayOfNullableDecimalsWithScaleOf9_3> search(
            final Specification<NullableArrayOfNullableDecimalsWithScaleOf9_3> specification,
            final Integer limit,
            final Integer offset) throws java.io.IOException {
        return search(specification, limit, offset, Bootstrap.getLocator());
    }

    public static java.util.List<NullableArrayOfNullableDecimalsWithScaleOf9_3> search(
            final Specification<NullableArrayOfNullableDecimalsWithScaleOf9_3> specification,
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
                    .count(NullableArrayOfNullableDecimalsWithScaleOf9_3.class)
                    .get().longValue();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static long count(
            final Specification<NullableArrayOfNullableDecimalsWithScaleOf9_3> specification)
            throws java.io.IOException {
        return count(specification, Bootstrap.getLocator());
    }

    public static long count(
            final Specification<NullableArrayOfNullableDecimalsWithScaleOf9_3> specification,
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
            final com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.NullableArrayOfNullableDecimalsWithScaleOf9_3 result) {
        this.URI = result.URI;

        this.nullableArrayOfNullableDecimalsWithScaleOf9 = result.nullableArrayOfNullableDecimalsWithScaleOf9;
        this.calculatedNullableArrayOfNullableDecimalsWithScaleOf9 = result.calculatedNullableArrayOfNullableDecimalsWithScaleOf9;
        this.persistedNullableArrayOfNullableDecimalsWithScaleOf9 = result.persistedNullableArrayOfNullableDecimalsWithScaleOf9;
        this.ID = result.ID;
    }

    public NullableArrayOfNullableDecimalsWithScaleOf9_3 persist()
            throws java.io.IOException {
        final NullableArrayOfNullableDecimalsWithScaleOf9_3 result;
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

    public NullableArrayOfNullableDecimalsWithScaleOf9_3 delete()
            throws java.io.IOException {
        try {
            return _crudProxy.delete(
                    NullableArrayOfNullableDecimalsWithScaleOf9_3.class, URI)
                    .get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    private java.math.BigDecimal[] nullableArrayOfNullableDecimalsWithScaleOf9;

    @JsonProperty("nullableArrayOfNullableDecimalsWithScaleOf9")
    public java.math.BigDecimal[] getNullableArrayOfNullableDecimalsWithScaleOf9() {
        return nullableArrayOfNullableDecimalsWithScaleOf9;
    }

    public NullableArrayOfNullableDecimalsWithScaleOf9_3 setNullableArrayOfNullableDecimalsWithScaleOf9(
            final java.math.BigDecimal[] value) {
        if (value != null)
            com.dslplatform.ocd.calculation.Guards.checkScale(value, 9);
        this.nullableArrayOfNullableDecimalsWithScaleOf9 = value;

        return this;
    }

    private java.math.BigDecimal[] calculatedNullableArrayOfNullableDecimalsWithScaleOf9;

    @JsonProperty("calculatedNullableArrayOfNullableDecimalsWithScaleOf9")
    public java.math.BigDecimal[] getCalculatedNullableArrayOfNullableDecimalsWithScaleOf9() {
        return this.calculatedNullableArrayOfNullableDecimalsWithScaleOf9;
    }

    private java.math.BigDecimal[] persistedNullableArrayOfNullableDecimalsWithScaleOf9;

    @JsonProperty("persistedNullableArrayOfNullableDecimalsWithScaleOf9")
    public java.math.BigDecimal[] getPersistedNullableArrayOfNullableDecimalsWithScaleOf9() {
        return this.persistedNullableArrayOfNullableDecimalsWithScaleOf9;
    }
}
