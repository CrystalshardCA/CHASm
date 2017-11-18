package ca.crystalshard.chasm.crawler.adapter.providers;

import ca.crystalshard.chasm.crawler.adapter.httpclient.okhttp3.OkHttp3HttpClient;
import ca.crystalshard.chasm.crawler.adapter.httpclient.okhttp3.OkHttp3Wrapper;
import ca.crystalshard.chasm.crawler.domain.HttpClient;
import com.google.gson.Gson;
import com.google.inject.Provider;
import okhttp3.OkHttpClient;

public class HttpClientProvider implements Provider<HttpClient> {
    @Override
    public HttpClient get() {
        OkHttpClient client = new OkHttpClient();
        Gson gson = new Gson();
        OkHttp3Wrapper okHttp3Wrapper = new OkHttp3Wrapper(client);
        return new OkHttp3HttpClient(okHttp3Wrapper, gson);
    }
}
