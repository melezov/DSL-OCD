package com.dslplatform.ocd.aggregates.PrimaryKeyPropertyInAggregateSetup;

import com.dslplatform.patterns.*;
import com.dslplatform.client.*;
import com.fasterxml.jackson.annotation.*;

public class OneArrayOfOneTimestamps_2 implements java.io.Serializable,
        AggregateRoot {
    public OneArrayOfOneTimestamps_2() {
        _serviceLocator = Bootstrap.getLocator();
        _domainProxy = _serviceLocator.resolve(DomainProxy.class);
        _crudProxy = _serviceLocator.resolve(CrudProxy.class);
        this.oneArrayOfOneTimestamps = new org.joda.time.DateTime[] {};
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
        final OneArrayOfOneTimestamps_2 other = (OneArrayOfOneTimestamps_2) obj;

        return URI != null && URI.equals(other.URI);
    }

    @Override
    public String toString() {
        return URI != null
                ? "OneArrayOfOneTimestamps_2(" + URI + ')'
                : "new OneArrayOfOneTimestamps_2(" + super.hashCode() + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    public OneArrayOfOneTimestamps_2(
            final org.joda.time.DateTime[] oneArrayOfOneTimestamps) {
        _serviceLocator = Bootstrap.getLocator();
        _domainProxy = _serviceLocator.resolve(DomainProxy.class);
        _crudProxy = _serviceLocator.resolve(CrudProxy.class);
        setOneArrayOfOneTimestamps(oneArrayOfOneTimestamps);
    }

    @JsonCreator
    private OneArrayOfOneTimestamps_2(
            @JacksonInject("_serviceLocator") final ServiceLocator _serviceLocator,
            @JsonProperty("URI") final String URI,
            @JsonProperty("oneArrayOfOneTimestamps") final org.joda.time.DateTime[] oneArrayOfOneTimestamps) {
        this._serviceLocator = _serviceLocator;
        this._domainProxy = _serviceLocator.resolve(DomainProxy.class);
        this._crudProxy = _serviceLocator.resolve(CrudProxy.class);
        this.URI = URI;
        this.oneArrayOfOneTimestamps = oneArrayOfOneTimestamps == null
                ? new org.joda.time.DateTime[] {}
                : oneArrayOfOneTimestamps;
    }

    public static OneArrayOfOneTimestamps_2 find(final String uri)
            throws java.io.IOException {
        return find(uri, Bootstrap.getLocator());
    }

    public static OneArrayOfOneTimestamps_2 find(
            final String uri,
            final ServiceLocator locator) throws java.io.IOException {
        try {
            return (locator != null ? locator : Bootstrap.getLocator())
                    .resolve(CrudProxy.class)
                    .read(OneArrayOfOneTimestamps_2.class, uri).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<OneArrayOfOneTimestamps_2> find(
            final Iterable<String> uris) throws java.io.IOException {
        return find(uris, Bootstrap.getLocator());
    }

    public static java.util.List<OneArrayOfOneTimestamps_2> find(
            final Iterable<String> uris,
            final ServiceLocator locator) throws java.io.IOException {
        try {
            return (locator != null ? locator : Bootstrap.getLocator())
                    .resolve(DomainProxy.class)
                    .find(OneArrayOfOneTimestamps_2.class, uris).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<OneArrayOfOneTimestamps_2> findAll()
            throws java.io.IOException {
        return findAll(null, null, Bootstrap.getLocator());
    }

    public static java.util.List<OneArrayOfOneTimestamps_2> findAll(
            final ServiceLocator locator) throws java.io.IOException {
        return findAll(null, null, locator);
    }

    public static java.util.List<OneArrayOfOneTimestamps_2> findAll(
            final Integer limit,
            final Integer offset) throws java.io.IOException {
        return findAll(limit, offset, Bootstrap.getLocator());
    }

    public static java.util.List<OneArrayOfOneTimestamps_2> findAll(
            final Integer limit,
            final Integer offset,
            final ServiceLocator locator) throws java.io.IOException {
        try {
            return (locator != null ? locator : Bootstrap.getLocator())
                    .resolve(DomainProxy.class)
                    .findAll(OneArrayOfOneTimestamps_2.class, limit, offset,
                            null).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<OneArrayOfOneTimestamps_2> search(
            final Specification<OneArrayOfOneTimestamps_2> specification)
            throws java.io.IOException {
        return search(specification, null, null, Bootstrap.getLocator());
    }

    public static java.util.List<OneArrayOfOneTimestamps_2> search(
            final Specification<OneArrayOfOneTimestamps_2> specification,
            final ServiceLocator locator) throws java.io.IOException {
        return search(specification, null, null, locator);
    }

    public static java.util.List<OneArrayOfOneTimestamps_2> search(
            final Specification<OneArrayOfOneTimestamps_2> specification,
            final Integer limit,
            final Integer offset) throws java.io.IOException {
        return search(specification, limit, offset, Bootstrap.getLocator());
    }

    public static java.util.List<OneArrayOfOneTimestamps_2> search(
            final Specification<OneArrayOfOneTimestamps_2> specification,
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
                    .count(OneArrayOfOneTimestamps_2.class).get().longValue();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static long count(
            final Specification<OneArrayOfOneTimestamps_2> specification)
            throws java.io.IOException {
        return count(specification, Bootstrap.getLocator());
    }

    public static long count(
            final Specification<OneArrayOfOneTimestamps_2> specification,
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
            final com.dslplatform.ocd.aggregates.PrimaryKeyPropertyInAggregateSetup.OneArrayOfOneTimestamps_2 result) {
        this.URI = result.URI;

        this.oneArrayOfOneTimestamps = result.oneArrayOfOneTimestamps;
    }

    public OneArrayOfOneTimestamps_2 persist() throws java.io.IOException {
        final OneArrayOfOneTimestamps_2 result;
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

    public OneArrayOfOneTimestamps_2 delete() throws java.io.IOException {
        try {
            return _crudProxy.delete(OneArrayOfOneTimestamps_2.class, URI)
                    .get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    private org.joda.time.DateTime[] oneArrayOfOneTimestamps;

    @JsonProperty("oneArrayOfOneTimestamps")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public org.joda.time.DateTime[] getOneArrayOfOneTimestamps() {
        return oneArrayOfOneTimestamps;
    }

    public OneArrayOfOneTimestamps_2 setOneArrayOfOneTimestamps(
            final org.joda.time.DateTime[] value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"oneArrayOfOneTimestamps\" cannot be null!");
        com.dslplatform.ocd.aggregates.Guards.checkNulls(value);
        this.oneArrayOfOneTimestamps = value;

        return this;
    }
}