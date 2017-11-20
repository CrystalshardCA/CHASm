package ca.crystalshard.chasm.crawler.adapter.httpclient.okhttp3;

import okhttp3.Headers;

public class OkHttp3Headers {

    private Headers headers;

    OkHttp3Headers(Headers headers) {
        this.headers = headers;
    }

    public String getHeader(String name) {
        return headers.get(name);
    }
}
