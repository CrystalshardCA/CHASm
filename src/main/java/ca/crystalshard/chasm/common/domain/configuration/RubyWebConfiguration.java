package ca.crystalshard.chasm.common.domain.configuration;

public interface RubyWebConfiguration {
    int getPort();

    String getStaticFileLocation();

    String getViewFolder();
}

