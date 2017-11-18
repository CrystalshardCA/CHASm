package ca.crystalshard.chasm.crawler.adapter;

import ca.crystalshard.chasm.crawler.adapter.providers.HttpClientProvider;
import ca.crystalshard.chasm.crawler.domain.HttpClient;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class CrawlerModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(HttpClient.class).toProvider(HttpClientProvider.class).in(Singleton.class);
    }
}
