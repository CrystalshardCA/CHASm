package ca.crystalshard.chasm.boot.guice;

import ca.crystalshard.chasm.common.adapter.persistance.Migration;
import ca.crystalshard.chasm.common.adapter.persistance.flyway.FlywayMigration;
import ca.crystalshard.chasm.common.domain.configuration.RubyDataConfiguration;
import com.google.inject.Inject;
import com.google.inject.Provider;

import javax.sql.DataSource;

public class MigrationProvider implements Provider<Migration> {

    private DataSource dataSource;
    private RubyDataConfiguration dataConfiguration;

    @Inject
    public MigrationProvider(DataSource dataSource, RubyDataConfiguration dataConfiguration) {
        this.dataSource = dataSource;
        this.dataConfiguration = dataConfiguration;
    }

    @Override
    public Migration get() {
        String migrationLocation = String.format("%s/%s", dataConfiguration.getMigrationLocation(), dataConfiguration.getDatabaseType().toString());

        return new FlywayMigration(dataSource, migrationLocation);
    }
}

