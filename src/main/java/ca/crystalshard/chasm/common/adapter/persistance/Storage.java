package ca.crystalshard.chasm.common.adapter.persistance;

public interface Storage {
    StorageConnection beginTransaction();

    StorageConnection open();
}
