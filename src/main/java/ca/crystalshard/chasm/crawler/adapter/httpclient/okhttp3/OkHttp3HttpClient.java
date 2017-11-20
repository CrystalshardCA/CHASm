package ca.crystalshard.chasm.crawler.adapter.httpclient.okhttp3;

import ca.crystalshard.chasm.crawler.adapter.httpclient.HttpResponse;
import ca.crystalshard.chasm.crawler.domain.HttpClient;
import com.google.gson.Gson;

import java.net.URL;

public class OkHttp3HttpClient implements HttpClient {

    private OkHttp3Wrapper okHttp3Wrapper;
    private Gson gson;

    public OkHttp3HttpClient(OkHttp3Wrapper okHttp3Wrapper, Gson gson) {
        this.okHttp3Wrapper = okHttp3Wrapper;
        this.gson = gson;
    }

    @Override
    public <T> HttpResponse<T> getContent(URL url, Class<T> classOfT) {
        OkHttp3ResponseWrapper response = okHttp3Wrapper.getResponse(url);

        return new HttpResponse<>(gson.fromJson(response.getBody(), classOfT), response.getCode());
    }

    @Override
    public HttpResponse<String> getRawContent(URL url) {
        OkHttp3ResponseWrapper response = okHttp3Wrapper.getResponse(url);

        return new HttpResponse<>(response.getBody(), response.getCode());
    }

}

