package ca.crystalshard.chasm.boot.guice.module;

import ca.crystalshard.chasm.boot.guice.DataSourceProvider;
import ca.crystalshard.chasm.boot.guice.MigrationProvider;
import ca.crystalshard.chasm.boot.guice.StorageProvider;
import ca.crystalshard.chasm.common.adapter.persistance.Migration;
import ca.crystalshard.chasm.common.adapter.persistance.Storage;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

import javax.sql.DataSource;

public abstract class AbstractDatabaseModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(DataSource.class).toProvider(DataSourceProvider.class).in(Singleton.class);
        bind(Migration.class).toProvider(MigrationProvider.class).in(Singleton.class);
        bind(Storage.class).toProvider(StorageProvider.class).in(Singleton.class);
    }
}
