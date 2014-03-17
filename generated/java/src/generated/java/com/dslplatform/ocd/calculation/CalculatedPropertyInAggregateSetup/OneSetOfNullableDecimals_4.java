package com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup;

import com.dslplatform.patterns.*;
import com.dslplatform.client.*;
import com.fasterxml.jackson.annotation.*;

public class OneSetOfNullableDecimals_4 implements java.io.Serializable,
        AggregateRoot {
    public OneSetOfNullableDecimals_4() {
        _serviceLocator = Bootstrap.getLocator();
        _domainProxy = _serviceLocator.resolve(DomainProxy.class);
        _crudProxy = _serviceLocator.resolve(CrudProxy.class);
        this.ID = 0;
        this.oneSetOfNullableDecimals = new java.util.HashSet<java.math.BigDecimal>();
        this.calculatedOneSetOfNullableDecimals = new java.util.HashSet<java.math.BigDecimal>();
        this.persistedOneSetOfNullableDecimals = new java.util.HashSet<java.math.BigDecimal>();
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
        final OneSetOfNullableDecimals_4 other = (OneSetOfNullableDecimals_4) obj;

        return URI != null && URI.equals(other.URI);
    }

    @Override
    public String toString() {
        return URI != null
                ? "OneSetOfNullableDecimals_4(" + URI + ')'
                : "new OneSetOfNullableDecimals_4(" + super.hashCode() + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    public OneSetOfNullableDecimals_4(
            final java.util.Set<java.math.BigDecimal> oneSetOfNullableDecimals) {
        _serviceLocator = Bootstrap.getLocator();
        _domainProxy = _serviceLocator.resolve(DomainProxy.class);
        _crudProxy = _serviceLocator.resolve(CrudProxy.class);
        setOneSetOfNullableDecimals(oneSetOfNullableDecimals);
    }

    @JsonCreator
    private OneSetOfNullableDecimals_4(
            @JacksonInject("_serviceLocator") final ServiceLocator _serviceLocator,
            @JsonProperty("URI") final String URI,
            @JsonProperty("ID") final int ID,
            @JsonProperty("oneSetOfNullableDecimals") final java.util.Set<java.math.BigDecimal> oneSetOfNullableDecimals,
            @JsonProperty("calculatedOneSetOfNullableDecimals") final java.util.Set<java.math.BigDecimal> calculatedOneSetOfNullableDecimals,
            @JsonProperty("persistedOneSetOfNullableDecimals") final java.util.Set<java.math.BigDecimal> persistedOneSetOfNullableDecimals) {
        this._serviceLocator = _serviceLocator;
        this._domainProxy = _serviceLocator.resolve(DomainProxy.class);
        this._crudProxy = _serviceLocator.resolve(CrudProxy.class);
        this.URI = URI;
        this.ID = ID;
        this.oneSetOfNullableDecimals = oneSetOfNullableDecimals == null
                ? new java.util.HashSet<java.math.BigDecimal>()
                : oneSetOfNullableDecimals;
        this.calculatedOneSetOfNullableDecimals = calculatedOneSetOfNullableDecimals;
        this.persistedOneSetOfNullableDecimals = persistedOneSetOfNullableDecimals;
    }

    private int ID;

    @JsonProperty("ID")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public int getID() {
        return ID;
    }

    private OneSetOfNullableDecimals_4 setID(final int value) {
        this.ID = value;

        return this;
    }

    public static OneSetOfNullableDecimals_4 find(final String uri)
            throws java.io.IOException {
        return find(uri, Bootstrap.getLocator());
    }

    public static OneSetOfNullableDecimals_4 find(
            final String uri,
            final ServiceLocator locator) throws java.io.IOException {
        try {
            return (locator != null ? locator : Bootstrap.getLocator())
                    .resolve(CrudProxy.class)
                    .read(OneSetOfNullableDecimals_4.class, uri).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<OneSetOfNullableDecimals_4> find(
            final Iterable<String> uris) throws java.io.IOException {
        return find(uris, Bootstrap.getLocator());
    }

    public static java.util.List<OneSetOfNullableDecimals_4> find(
            final Iterable<String> uris,
            final ServiceLocator locator) throws java.io.IOException {
        try {
            return (locator != null ? locator : Bootstrap.getLocator())
                    .resolve(DomainProxy.class)
                    .find(OneSetOfNullableDecimals_4.class, uris).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<OneSetOfNullableDecimals_4> findAll()
            throws java.io.IOException {
        return findAll(null, null, Bootstrap.getLocator());
    }

    public static java.util.List<OneSetOfNullableDecimals_4> findAll(
            final ServiceLocator locator) throws java.io.IOException {
        return findAll(null, null, locator);
    }

    public static java.util.List<OneSetOfNullableDecimals_4> findAll(
            final Integer limit,
            final Integer offset) throws java.io.IOException {
        return findAll(limit, offset, Bootstrap.getLocator());
    }

    public static java.util.List<OneSetOfNullableDecimals_4> findAll(
            final Integer limit,
            final Integer offset,
            final ServiceLocator locator) throws java.io.IOException {
        try {
            return (locator != null ? locator : Bootstrap.getLocator())
                    .resolve(DomainProxy.class)
                    .findAll(OneSetOfNullableDecimals_4.class, limit, offset,
                            null).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<OneSetOfNullableDecimals_4> search(
            final Specification<OneSetOfNullableDecimals_4> specification)
            throws java.io.IOException {
        return search(specification, null, null, Bootstrap.getLocator());
    }

    public static java.util.List<OneSetOfNullableDecimals_4> search(
            final Specification<OneSetOfNullableDecimals_4> specification,
            final ServiceLocator locator) throws java.io.IOException {
        return search(specification, null, null, locator);
    }

    public static java.util.List<OneSetOfNullableDecimals_4> search(
            final Specification<OneSetOfNullableDecimals_4> specification,
            final Integer limit,
            final Integer offset) throws java.io.IOException {
        return search(specification, limit, offset, Bootstrap.getLocator());
    }

    public static java.util.List<OneSetOfNullableDecimals_4> search(
            final Specification<OneSetOfNullableDecimals_4> specification,
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
                    .count(OneSetOfNullableDecimals_4.class).get().longValue();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static long count(
            final Specification<OneSetOfNullableDecimals_4> specification)
            throws java.io.IOException {
        return count(specification, Bootstrap.getLocator());
    }

    public static long count(
            final Specification<OneSetOfNullableDecimals_4> specification,
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
            final com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.OneSetOfNullableDecimals_4 result) {
        this.URI = result.URI;

        this.oneSetOfNullableDecimals = result.oneSetOfNullableDecimals;
        this.calculatedOneSetOfNullableDecimals = result.calculatedOneSetOfNullableDecimals;
        this.persistedOneSetOfNullableDecimals = result.persistedOneSetOfNullableDecimals;
        this.ID = result.ID;
    }

    public OneSetOfNullableDecimals_4 persist() throws java.io.IOException {
        final OneSetOfNullableDecimals_4 result;
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

    public OneSetOfNullableDecimals_4 delete() throws java.io.IOException {
        try {
            return _crudProxy.delete(OneSetOfNullableDecimals_4.class, URI)
                    .get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    private java.util.Set<java.math.BigDecimal> oneSetOfNullableDecimals;

    @JsonProperty("oneSetOfNullableDecimals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.util.Set<java.math.BigDecimal> getOneSetOfNullableDecimals() {
        return oneSetOfNullableDecimals;
    }

    public OneSetOfNullableDecimals_4 setOneSetOfNullableDecimals(
            final java.util.Set<java.math.BigDecimal> value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"oneSetOfNullableDecimals\" cannot be null!");
        this.oneSetOfNullableDecimals = value;

        return this;
    }

    private java.util.Set<java.math.BigDecimal> calculatedOneSetOfNullableDecimals;

    @JsonProperty("calculatedOneSetOfNullableDecimals")
    public java.util.Set<java.math.BigDecimal> getCalculatedOneSetOfNullableDecimals() {
        return this.calculatedOneSetOfNullableDecimals;
    }

    private java.util.Set<java.math.BigDecimal> persistedOneSetOfNullableDecimals;

    @JsonProperty("persistedOneSetOfNullableDecimals")
    public java.util.Set<java.math.BigDecimal> getPersistedOneSetOfNullableDecimals() {
        return this.persistedOneSetOfNullableDecimals;
    }
}