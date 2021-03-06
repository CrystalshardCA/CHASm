package ca.crystalshard.boot.guice;

import ca.crystalshard.adapter.persistance.sql2o.Sql2oStorage;
import ca.crystalshard.adapter.persistance.Storage;
import com.google.inject.Inject;
import com.google.inject.Provider;

import javax.sql.DataSource;

public class StorageProvider implements Provider<Storage> {
    private DataSource dataSource;

    @Inject
    public StorageProvider(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Storage get() {
        return new Sql2oStorage(dataSource);
    }
}

