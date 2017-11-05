package ca.crystalshard.ruby.boot.guice.module;

import ca.crystalshard.ruby.boot.guice.ResponseTransformerProvider;
import ca.crystalshard.ruby.boot.guice.TemplateEngineProvider;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import spark.ResponseTransformer;
import spark.TemplateEngine;

public class AppModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(TemplateEngine.class).toProvider(TemplateEngineProvider.class).in(Singleton.class);
        bind(ResponseTransformer.class).toProvider(ResponseTransformerProvider.class).in(Singleton.class);
    }

}

