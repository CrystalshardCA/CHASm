package ca.crystalshard.chasm.crawler.adapter.httpclient.okhttp3;

import ca.crystalshard.chasm.crawler.adapter.httpclient.UnableToCompleteHttpRequestException;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;
import java.net.URL;

public class OkHttp3Wrapper {

    private OkHttpClient client;

    public OkHttp3Wrapper(OkHttpClient client) {
        this.client = client;
    }

    OkHttp3ResponseWrapper getResponse(URL url) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try {
            return new OkHttp3ResponseWrapper(client.newCall(request).execute());
        } catch (IOException e) {
            throw new UnableToCompleteHttpRequestException(String.format("There was an error making a request to %s", url), e);
        }
    }
}
