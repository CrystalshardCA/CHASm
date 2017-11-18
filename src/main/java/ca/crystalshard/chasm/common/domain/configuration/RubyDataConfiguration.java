package ca.crystalshard.chasm.common.domain.configuration;

import ca.crystalshard.chasm.common.domain.DatabaseTypeEnum;

public interface RubyDataConfiguration {
    String getUrl();

    String getUsername();

    String getPassword();

    String getServerName();

    String getMigrationLocation();

    DatabaseTypeEnum getDatabaseType();

    String getDatabaseName();
}
