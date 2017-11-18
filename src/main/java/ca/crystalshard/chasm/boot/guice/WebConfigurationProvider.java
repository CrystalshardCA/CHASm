package ca.crystalshard.chasm.boot.guice;

import ca.crystalshard.chasm.common.adapter.configuration.PropertyFile;
import ca.crystalshard.chasm.common.adapter.configuration.PropertyFileConfiguration;
import ca.crystalshard.chasm.common.domain.configuration.RubyWebConfiguration;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class WebConfigurationProvider implements Provider<RubyWebConfiguration> {

    private PropertyFile propertyFile;

    @Inject
    public WebConfigurationProvider(PropertyFile propertyFile) {

        this.propertyFile = propertyFile;
    }

    @Override
    public RubyWebConfiguration get() {
        return new PropertyFileConfiguration(propertyFile);
    }

}

