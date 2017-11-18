package ca.crystalshard.chasm.boot.guice;

import ca.crystalshard.chasm.common.adapter.configuration.OverridePropertyFileLocation;
import ca.crystalshard.chasm.common.adapter.configuration.PropertyFile;
import ca.crystalshard.chasm.common.adapter.configuration.PropertyFileClassLoader;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class PropertyFileProvider implements Provider<PropertyFile> {

    private OverridePropertyFileLocation overridePropertyFileLocation;

    @Inject
    public PropertyFileProvider(OverridePropertyFileLocation overridePropertyFileLocation) {
        this.overridePropertyFileLocation = overridePropertyFileLocation;
    }

    @Override
    public PropertyFile get() {

        if (overridePropertyFileLocation.getLocation() != null) {
            return new PropertyFileClassLoader("chasm.properties", overridePropertyFileLocation.getLocation());
        }
        else {
            return new PropertyFileClassLoader("chasm.properties");
        }

    }
}
