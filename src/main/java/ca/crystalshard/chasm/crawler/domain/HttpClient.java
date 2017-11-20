package ca.crystalshard.chasm.crawler.domain;

import ca.crystalshard.chasm.crawler.adapter.httpclient.HttpResponse;

import java.net.URL;

public interface HttpClient {
    <T> HttpResponse<T> getContent(URL url, Class<T> classOfT);

    HttpResponse<String> getRawContent(URL url);
}
