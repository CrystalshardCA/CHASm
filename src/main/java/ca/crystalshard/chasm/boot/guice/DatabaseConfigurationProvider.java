package ca.crystalshard.chasm.boot.guice;

import ca.crystalshard.chasm.common.adapter.configuration.PropertyFile;
import ca.crystalshard.chasm.common.adapter.configuration.PropertyFileConfiguration;
import ca.crystalshard.chasm.common.domain.configuration.RubyDataConfiguration;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class DatabaseConfigurationProvider implements Provider<RubyDataConfiguration> {

    private PropertyFile propertyFile;

    @Inject
    public DatabaseConfigurationProvider(PropertyFile propertyFile) {

        this.propertyFile = propertyFile;
    }

    @Override
    public RubyDataConfiguration get() {
        return new PropertyFileConfiguration(propertyFile);
    }

}
