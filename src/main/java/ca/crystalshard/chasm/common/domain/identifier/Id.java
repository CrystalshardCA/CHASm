package ca.crystalshard.chasm.common.domain.identifier;

public abstract class Id<T> implements Comparable<Id<T>> {

    private final T id;

    protected Id(T id) {
        if (validate(id)) {
            this.id = id;
        }
        else {
            throw new InvalidIdValueException(String.format("Attempted to create an Id with the value of: %s", id));
        }
    }

    public T getId() {
        return id;
    }

    protected abstract boolean validate(T id);

    @Override
    public String toString() {
        return id.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Id id1 = (Id) o;
        return id != null ? id.equals(id1.id) : id1.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
