package com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup;

import com.dslplatform.patterns.*;
import com.dslplatform.client.*;
import com.fasterxml.jackson.annotation.*;

public class NullableListOfNullableIntegers_3 implements java.io.Serializable,
        AggregateRoot {
    public NullableListOfNullableIntegers_3() {
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
        final NullableListOfNullableIntegers_3 other = (NullableListOfNullableIntegers_3) obj;

        return URI != null && URI.equals(other.URI);
    }

    @Override
    public String toString() {
        return URI != null
                ? "NullableListOfNullableIntegers_3(" + URI + ')'
                : "new NullableListOfNullableIntegers_3(" + super.hashCode()
                        + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    public NullableListOfNullableIntegers_3(
            final java.util.List<Integer> nullableListOfNullableIntegers) {
        _serviceLocator = Bootstrap.getLocator();
        _domainProxy = _serviceLocator.resolve(DomainProxy.class);
        _crudProxy = _serviceLocator.resolve(CrudProxy.class);
        setNullableListOfNullableIntegers(nullableListOfNullableIntegers);
    }

    @JsonCreator
    private NullableListOfNullableIntegers_3(
            @JacksonInject("_serviceLocator") final ServiceLocator _serviceLocator,
            @JsonProperty("URI") final String URI,
            @JsonProperty("ID") final int ID,
            @JsonProperty("nullableListOfNullableIntegers") final java.util.List<Integer> nullableListOfNullableIntegers,
            @JsonProperty("calculatedNullableListOfNullableIntegers") final java.util.List<Integer> calculatedNullableListOfNullableIntegers,
            @JsonProperty("persistedNullableListOfNullableIntegers") final java.util.List<Integer> persistedNullableListOfNullableIntegers) {
        this._serviceLocator = _serviceLocator;
        this._domainProxy = _serviceLocator.resolve(DomainProxy.class);
        this._crudProxy = _serviceLocator.resolve(CrudProxy.class);
        this.URI = URI;
        this.ID = ID;
        this.nullableListOfNullableIntegers = nullableListOfNullableIntegers;
        this.calculatedNullableListOfNullableIntegers = calculatedNullableListOfNullableIntegers == null
                ? new java.util.ArrayList<Integer>()
                : calculatedNullableListOfNullableIntegers;
        this.persistedNullableListOfNullableIntegers = persistedNullableListOfNullableIntegers == null
                ? new java.util.ArrayList<Integer>()
                : persistedNullableListOfNullableIntegers;
    }

    private int ID;

    @JsonProperty("ID")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public int getID() {
        return ID;
    }

    private NullableListOfNullableIntegers_3 setID(final int value) {
        this.ID = value;

        return this;
    }

    public static NullableListOfNullableIntegers_3 find(final String uri)
            throws java.io.IOException {
        return find(uri, Bootstrap.getLocator());
    }

    public static NullableListOfNullableIntegers_3 find(
            final String uri,
            final ServiceLocator locator) throws java.io.IOException {
        try {
            return (locator != null ? locator : Bootstrap.getLocator())
                    .resolve(CrudProxy.class)
                    .read(NullableListOfNullableIntegers_3.class, uri).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<NullableListOfNullableIntegers_3> find(
            final Iterable<String> uris) throws java.io.IOException {
        return find(uris, Bootstrap.getLocator());
    }

    public static java.util.List<NullableListOfNullableIntegers_3> find(
            final Iterable<String> uris,
            final ServiceLocator locator) throws java.io.IOException {
        try {
            return (locator != null ? locator : Bootstrap.getLocator())
                    .resolve(DomainProxy.class)
                    .find(NullableListOfNullableIntegers_3.class, uris).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<NullableListOfNullableIntegers_3> findAll()
            throws java.io.IOException {
        return findAll(null, null, Bootstrap.getLocator());
    }

    public static java.util.List<NullableListOfNullableIntegers_3> findAll(
            final ServiceLocator locator) throws java.io.IOException {
        return findAll(null, null, locator);
    }

    public static java.util.List<NullableListOfNullableIntegers_3> findAll(
            final Integer limit,
            final Integer offset) throws java.io.IOException {
        return findAll(limit, offset, Bootstrap.getLocator());
    }

    public static java.util.List<NullableListOfNullableIntegers_3> findAll(
            final Integer limit,
            final Integer offset,
            final ServiceLocator locator) throws java.io.IOException {
        try {
            return (locator != null ? locator : Bootstrap.getLocator())
                    .resolve(DomainProxy.class)
                    .findAll(NullableListOfNullableIntegers_3.class, limit,
                            offset, null).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<NullableListOfNullableIntegers_3> search(
            final Specification<NullableListOfNullableIntegers_3> specification)
            throws java.io.IOException {
        return search(specification, null, null, Bootstrap.getLocator());
    }

    public static java.util.List<NullableListOfNullableIntegers_3> search(
            final Specification<NullableListOfNullableIntegers_3> specification,
            final ServiceLocator locator) throws java.io.IOException {
        return search(specification, null, null, locator);
    }

    public static java.util.List<NullableListOfNullableIntegers_3> search(
            final Specification<NullableListOfNullableIntegers_3> specification,
            final Integer limit,
            final Integer offset) throws java.io.IOException {
        return search(specification, limit, offset, Bootstrap.getLocator());
    }

    public static java.util.List<NullableListOfNullableIntegers_3> search(
            final Specification<NullableListOfNullableIntegers_3> specification,
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
                    .count(NullableListOfNullableIntegers_3.class).get()
                    .longValue();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static long count(
            final Specification<NullableListOfNullableIntegers_3> specification)
            throws java.io.IOException {
        return count(specification, Bootstrap.getLocator());
    }

    public static long count(
            final Specification<NullableListOfNullableIntegers_3> specification,
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
            final com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.NullableListOfNullableIntegers_3 result) {
        this.URI = result.URI;

        this.nullableListOfNullableIntegers = result.nullableListOfNullableIntegers;
        this.calculatedNullableListOfNullableIntegers = result.calculatedNullableListOfNullableIntegers;
        this.persistedNullableListOfNullableIntegers = result.persistedNullableListOfNullableIntegers;
        this.ID = result.ID;
    }

    public NullableListOfNullableIntegers_3 persist()
            throws java.io.IOException {
        final NullableListOfNullableIntegers_3 result;
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

    public NullableListOfNullableIntegers_3 delete() throws java.io.IOException {
        try {
            return _crudProxy.delete(NullableListOfNullableIntegers_3.class,
                    URI).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    private java.util.List<Integer> nullableListOfNullableIntegers;

    @JsonProperty("nullableListOfNullableIntegers")
    public java.util.List<Integer> getNullableListOfNullableIntegers() {
        return nullableListOfNullableIntegers;
    }

    public NullableListOfNullableIntegers_3 setNullableListOfNullableIntegers(
            final java.util.List<Integer> value) {
        this.nullableListOfNullableIntegers = value;

        return this;
    }

    private java.util.List<Integer> calculatedNullableListOfNullableIntegers;

    @JsonProperty("calculatedNullableListOfNullableIntegers")
    public java.util.List<Integer> getCalculatedNullableListOfNullableIntegers() {
        return this.calculatedNullableListOfNullableIntegers;
    }

    private java.util.List<Integer> persistedNullableListOfNullableIntegers;

    @JsonProperty("persistedNullableListOfNullableIntegers")
    public java.util.List<Integer> getPersistedNullableListOfNullableIntegers() {
        return this.persistedNullableListOfNullableIntegers;
    }
}