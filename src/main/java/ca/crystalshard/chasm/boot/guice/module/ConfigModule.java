package ca.crystalshard.chasm.boot.guice.module;

import ca.crystalshard.chasm.boot.guice.DatabaseConfigurationProvider;
import ca.crystalshard.chasm.boot.guice.PropertyFileProvider;
import ca.crystalshard.chasm.boot.guice.WebConfigurationProvider;
import ca.crystalshard.chasm.common.adapter.configuration.OverridePropertyFileLocation;
import ca.crystalshard.chasm.common.adapter.configuration.PropertyFile;
import ca.crystalshard.chasm.common.domain.configuration.RubyDataConfiguration;
import ca.crystalshard.chasm.common.domain.configuration.RubyWebConfiguration;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class ConfigModule extends AbstractModule {

    private OverridePropertyFileLocation overridePropertyFileLocation;

    public ConfigModule(OverridePropertyFileLocation overridePropertyFileLocation) {
        this.overridePropertyFileLocation = overridePropertyFileLocation;
    }

    protected void configure() {
        bind(OverridePropertyFileLocation.class).toInstance(overridePropertyFileLocation);
        bind(PropertyFile.class).toProvider(PropertyFileProvider.class).in(Singleton.class);
        bind(RubyWebConfiguration.class).toProvider(WebConfigurationProvider.class).in(Singleton.class);
        bind(RubyDataConfiguration.class).toProvider(DatabaseConfigurationProvider.class).in(Singleton.class);
    }
}
