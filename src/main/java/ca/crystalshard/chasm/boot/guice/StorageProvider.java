package ca.crystalshard.chasm.boot.guice;

import ca.crystalshard.chasm.common.adapter.persistance.Storage;
import ca.crystalshard.chasm.common.adapter.persistance.sql2o.Sql2oStorage;
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

