package com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup;

import com.dslplatform.patterns.*;
import com.dslplatform.client.*;
import com.fasterxml.jackson.annotation.*;

public class NullableArrayOfNullableDecimals_3 implements java.io.Serializable,
        AggregateRoot {
    public NullableArrayOfNullableDecimals_3() {
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
        final NullableArrayOfNullableDecimals_3 other = (NullableArrayOfNullableDecimals_3) obj;

        return URI != null && URI.equals(other.URI);
    }

    @Override
    public String toString() {
        return URI != null
                ? "NullableArrayOfNullableDecimals_3(" + URI + ')'
                : "new NullableArrayOfNullableDecimals_3(" + super.hashCode()
                        + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    public NullableArrayOfNullableDecimals_3(
            final java.math.BigDecimal[] nullableArrayOfNullableDecimals) {
        _serviceLocator = Bootstrap.getLocator();
        _domainProxy = _serviceLocator.resolve(DomainProxy.class);
        _crudProxy = _serviceLocator.resolve(CrudProxy.class);
        setNullableArrayOfNullableDecimals(nullableArrayOfNullableDecimals);
    }

    @JsonCreator
    private NullableArrayOfNullableDecimals_3(
            @JacksonInject("_serviceLocator") final ServiceLocator _serviceLocator,
            @JsonProperty("URI") final String URI,
            @JsonProperty("ID") final int ID,
            @JsonProperty("nullableArrayOfNullableDecimals") final java.math.BigDecimal[] nullableArrayOfNullableDecimals,
            @JsonProperty("calculatedNullableArrayOfNullableDecimals") final java.math.BigDecimal[] calculatedNullableArrayOfNullableDecimals,
            @JsonProperty("persistedNullableArrayOfNullableDecimals") final java.math.BigDecimal[] persistedNullableArrayOfNullableDecimals) {
        this._serviceLocator = _serviceLocator;
        this._domainProxy = _serviceLocator.resolve(DomainProxy.class);
        this._crudProxy = _serviceLocator.resolve(CrudProxy.class);
        this.URI = URI;
        this.ID = ID;
        this.nullableArrayOfNullableDecimals = nullableArrayOfNullableDecimals;
        this.calculatedNullableArrayOfNullableDecimals = calculatedNullableArrayOfNullableDecimals == null
                ? new java.math.BigDecimal[] {}
                : calculatedNullableArrayOfNullableDecimals;
        this.persistedNullableArrayOfNullableDecimals = persistedNullableArrayOfNullableDecimals == null
                ? new java.math.BigDecimal[] {}
                : persistedNullableArrayOfNullableDecimals;
    }

    private int ID;

    @JsonProperty("ID")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public int getID() {
        return ID;
    }

    private NullableArrayOfNullableDecimals_3 setID(final int value) {
        this.ID = value;

        return this;
    }

    public static NullableArrayOfNullableDecimals_3 find(final String uri)
            throws java.io.IOException {
        return find(uri, Bootstrap.getLocator());
    }

    public static NullableArrayOfNullableDecimals_3 find(
            final String uri,
            final ServiceLocator locator) throws java.io.IOException {
        try {
            return (locator != null ? locator : Bootstrap.getLocator())
                    .resolve(CrudProxy.class)
                    .read(NullableArrayOfNullableDecimals_3.class, uri).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<NullableArrayOfNullableDecimals_3> find(
            final Iterable<String> uris) throws java.io.IOException {
        return find(uris, Bootstrap.getLocator());
    }

    public static java.util.List<NullableArrayOfNullableDecimals_3> find(
            final Iterable<String> uris,
            final ServiceLocator locator) throws java.io.IOException {
        try {
            return (locator != null ? locator : Bootstrap.getLocator())
                    .resolve(DomainProxy.class)
                    .find(NullableArrayOfNullableDecimals_3.class, uris).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<NullableArrayOfNullableDecimals_3> findAll()
            throws java.io.IOException {
        return findAll(null, null, Bootstrap.getLocator());
    }

    public static java.util.List<NullableArrayOfNullableDecimals_3> findAll(
            final ServiceLocator locator) throws java.io.IOException {
        return findAll(null, null, locator);
    }

    public static java.util.List<NullableArrayOfNullableDecimals_3> findAll(
            final Integer limit,
            final Integer offset) throws java.io.IOException {
        return findAll(limit, offset, Bootstrap.getLocator());
    }

    public static java.util.List<NullableArrayOfNullableDecimals_3> findAll(
            final Integer limit,
            final Integer offset,
            final ServiceLocator locator) throws java.io.IOException {
        try {
            return (locator != null ? locator : Bootstrap.getLocator())
                    .resolve(DomainProxy.class)
                    .findAll(NullableArrayOfNullableDecimals_3.class, limit,
                            offset, null).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<NullableArrayOfNullableDecimals_3> search(
            final Specification<NullableArrayOfNullableDecimals_3> specification)
            throws java.io.IOException {
        return search(specification, null, null, Bootstrap.getLocator());
    }

    public static java.util.List<NullableArrayOfNullableDecimals_3> search(
            final Specification<NullableArrayOfNullableDecimals_3> specification,
            final ServiceLocator locator) throws java.io.IOException {
        return search(specification, null, null, locator);
    }

    public static java.util.List<NullableArrayOfNullableDecimals_3> search(
            final Specification<NullableArrayOfNullableDecimals_3> specification,
            final Integer limit,
            final Integer offset) throws java.io.IOException {
        return search(specification, limit, offset, Bootstrap.getLocator());
    }

    public static java.util.List<NullableArrayOfNullableDecimals_3> search(
            final Specification<NullableArrayOfNullableDecimals_3> specification,
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
                    .count(NullableArrayOfNullableDecimals_3.class).get()
                    .longValue();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static long count(
            final Specification<NullableArrayOfNullableDecimals_3> specification)
            throws java.io.IOException {
        return count(specification, Bootstrap.getLocator());
    }

    public static long count(
            final Specification<NullableArrayOfNullableDecimals_3> specification,
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
            final com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.NullableArrayOfNullableDecimals_3 result) {
        this.URI = result.URI;

        this.nullableArrayOfNullableDecimals = result.nullableArrayOfNullableDecimals;
        this.calculatedNullableArrayOfNullableDecimals = result.calculatedNullableArrayOfNullableDecimals;
        this.persistedNullableArrayOfNullableDecimals = result.persistedNullableArrayOfNullableDecimals;
        this.ID = result.ID;
    }

    public NullableArrayOfNullableDecimals_3 persist()
            throws java.io.IOException {
        final NullableArrayOfNullableDecimals_3 result;
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

    public NullableArrayOfNullableDecimals_3 delete()
            throws java.io.IOException {
        try {
            return _crudProxy.delete(NullableArrayOfNullableDecimals_3.class,
                    URI).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    private java.math.BigDecimal[] nullableArrayOfNullableDecimals;

    @JsonProperty("nullableArrayOfNullableDecimals")
    public java.math.BigDecimal[] getNullableArrayOfNullableDecimals() {
        return nullableArrayOfNullableDecimals;
    }

    public NullableArrayOfNullableDecimals_3 setNullableArrayOfNullableDecimals(
            final java.math.BigDecimal[] value) {
        this.nullableArrayOfNullableDecimals = value;

        return this;
    }

    private java.math.BigDecimal[] calculatedNullableArrayOfNullableDecimals;

    @JsonProperty("calculatedNullableArrayOfNullableDecimals")
    public java.math.BigDecimal[] getCalculatedNullableArrayOfNullableDecimals() {
        return this.calculatedNullableArrayOfNullableDecimals;
    }

    private java.math.BigDecimal[] persistedNullableArrayOfNullableDecimals;

    @JsonProperty("persistedNullableArrayOfNullableDecimals")
    public java.math.BigDecimal[] getPersistedNullableArrayOfNullableDecimals() {
        return this.persistedNullableArrayOfNullableDecimals;
    }
}