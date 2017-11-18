package ca.crystalshard.chasm.crawler.domain;

import ca.crystalshard.chasm.crawler.adapter.httpclient.HttpResponse;

public interface HttpClient {
    <T> HttpResponse<T> getContent(String url, Class<T> classOfT);

    HttpResponse<String> getRawContent(String url);
}
