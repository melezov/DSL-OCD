package com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup;

import com.dslplatform.patterns.*;
import com.dslplatform.client.*;
import com.fasterxml.jackson.annotation.*;

public class NullableSetOfNullableDates_3 implements java.io.Serializable,
        AggregateRoot {
    public NullableSetOfNullableDates_3() {
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
        final NullableSetOfNullableDates_3 other = (NullableSetOfNullableDates_3) obj;

        return URI != null && URI.equals(other.URI);
    }

    @Override
    public String toString() {
        return URI != null
                ? "NullableSetOfNullableDates_3(" + URI + ')'
                : "new NullableSetOfNullableDates_3(" + super.hashCode() + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    public NullableSetOfNullableDates_3(
            final java.util.Set<org.joda.time.LocalDate> nullableSetOfNullableDates) {
        _serviceLocator = Bootstrap.getLocator();
        _domainProxy = _serviceLocator.resolve(DomainProxy.class);
        _crudProxy = _serviceLocator.resolve(CrudProxy.class);
        setNullableSetOfNullableDates(nullableSetOfNullableDates);
    }

    @JsonCreator
    private NullableSetOfNullableDates_3(
            @JacksonInject("_serviceLocator") final ServiceLocator _serviceLocator,
            @JsonProperty("URI") final String URI,
            @JsonProperty("ID") final int ID,
            @JsonProperty("nullableSetOfNullableDates") final java.util.Set<org.joda.time.LocalDate> nullableSetOfNullableDates,
            @JsonProperty("calculatedNullableSetOfNullableDates") final java.util.Set<org.joda.time.LocalDate> calculatedNullableSetOfNullableDates,
            @JsonProperty("persistedNullableSetOfNullableDates") final java.util.Set<org.joda.time.LocalDate> persistedNullableSetOfNullableDates) {
        this._serviceLocator = _serviceLocator;
        this._domainProxy = _serviceLocator.resolve(DomainProxy.class);
        this._crudProxy = _serviceLocator.resolve(CrudProxy.class);
        this.URI = URI;
        this.ID = ID;
        this.nullableSetOfNullableDates = nullableSetOfNullableDates;
        this.calculatedNullableSetOfNullableDates = calculatedNullableSetOfNullableDates == null
                ? new java.util.HashSet<org.joda.time.LocalDate>()
                : calculatedNullableSetOfNullableDates;
        this.persistedNullableSetOfNullableDates = persistedNullableSetOfNullableDates == null
                ? new java.util.HashSet<org.joda.time.LocalDate>()
                : persistedNullableSetOfNullableDates;
    }

    private int ID;

    @JsonProperty("ID")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public int getID() {
        return ID;
    }

    private NullableSetOfNullableDates_3 setID(final int value) {
        this.ID = value;

        return this;
    }

    public static NullableSetOfNullableDates_3 find(final String uri)
            throws java.io.IOException {
        return find(uri, Bootstrap.getLocator());
    }

    public static NullableSetOfNullableDates_3 find(
            final String uri,
            final ServiceLocator locator) throws java.io.IOException {
        try {
            return (locator != null ? locator : Bootstrap.getLocator())
                    .resolve(CrudProxy.class)
                    .read(NullableSetOfNullableDates_3.class, uri).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<NullableSetOfNullableDates_3> find(
            final Iterable<String> uris) throws java.io.IOException {
        return find(uris, Bootstrap.getLocator());
    }

    public static java.util.List<NullableSetOfNullableDates_3> find(
            final Iterable<String> uris,
            final ServiceLocator locator) throws java.io.IOException {
        try {
            return (locator != null ? locator : Bootstrap.getLocator())
                    .resolve(DomainProxy.class)
                    .find(NullableSetOfNullableDates_3.class, uris).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<NullableSetOfNullableDates_3> findAll()
            throws java.io.IOException {
        return findAll(null, null, Bootstrap.getLocator());
    }

    public static java.util.List<NullableSetOfNullableDates_3> findAll(
            final ServiceLocator locator) throws java.io.IOException {
        return findAll(null, null, locator);
    }

    public static java.util.List<NullableSetOfNullableDates_3> findAll(
            final Integer limit,
            final Integer offset) throws java.io.IOException {
        return findAll(limit, offset, Bootstrap.getLocator());
    }

    public static java.util.List<NullableSetOfNullableDates_3> findAll(
            final Integer limit,
            final Integer offset,
            final ServiceLocator locator) throws java.io.IOException {
        try {
            return (locator != null ? locator : Bootstrap.getLocator())
                    .resolve(DomainProxy.class)
                    .findAll(NullableSetOfNullableDates_3.class, limit, offset,
                            null).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<NullableSetOfNullableDates_3> search(
            final Specification<NullableSetOfNullableDates_3> specification)
            throws java.io.IOException {
        return search(specification, null, null, Bootstrap.getLocator());
    }

    public static java.util.List<NullableSetOfNullableDates_3> search(
            final Specification<NullableSetOfNullableDates_3> specification,
            final ServiceLocator locator) throws java.io.IOException {
        return search(specification, null, null, locator);
    }

    public static java.util.List<NullableSetOfNullableDates_3> search(
            final Specification<NullableSetOfNullableDates_3> specification,
            final Integer limit,
            final Integer offset) throws java.io.IOException {
        return search(specification, limit, offset, Bootstrap.getLocator());
    }

    public static java.util.List<NullableSetOfNullableDates_3> search(
            final Specification<NullableSetOfNullableDates_3> specification,
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
                    .count(NullableSetOfNullableDates_3.class).get()
                    .longValue();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static long count(
            final Specification<NullableSetOfNullableDates_3> specification)
            throws java.io.IOException {
        return count(specification, Bootstrap.getLocator());
    }

    public static long count(
            final Specification<NullableSetOfNullableDates_3> specification,
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
            final com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.NullableSetOfNullableDates_3 result) {
        this.URI = result.URI;

        this.nullableSetOfNullableDates = result.nullableSetOfNullableDates;
        this.calculatedNullableSetOfNullableDates = result.calculatedNullableSetOfNullableDates;
        this.persistedNullableSetOfNullableDates = result.persistedNullableSetOfNullableDates;
        this.ID = result.ID;
    }

    public NullableSetOfNullableDates_3 persist() throws java.io.IOException {
        final NullableSetOfNullableDates_3 result;
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

    public NullableSetOfNullableDates_3 delete() throws java.io.IOException {
        try {
            return _crudProxy.delete(NullableSetOfNullableDates_3.class, URI)
                    .get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    private java.util.Set<org.joda.time.LocalDate> nullableSetOfNullableDates;

    @JsonProperty("nullableSetOfNullableDates")
    public java.util.Set<org.joda.time.LocalDate> getNullableSetOfNullableDates() {
        return nullableSetOfNullableDates;
    }

    public NullableSetOfNullableDates_3 setNullableSetOfNullableDates(
            final java.util.Set<org.joda.time.LocalDate> value) {
        this.nullableSetOfNullableDates = value;

        return this;
    }

    private java.util.Set<org.joda.time.LocalDate> calculatedNullableSetOfNullableDates;

    @JsonProperty("calculatedNullableSetOfNullableDates")
    public java.util.Set<org.joda.time.LocalDate> getCalculatedNullableSetOfNullableDates() {
        return this.calculatedNullableSetOfNullableDates;
    }

    private java.util.Set<org.joda.time.LocalDate> persistedNullableSetOfNullableDates;

    @JsonProperty("persistedNullableSetOfNullableDates")
    public java.util.Set<org.joda.time.LocalDate> getPersistedNullableSetOfNullableDates() {
        return this.persistedNullableSetOfNullableDates;
    }
}