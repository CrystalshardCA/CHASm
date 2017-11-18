package ca.crystalshard.chasm.crawler.adapter.httpclient.okhttp3;

import ca.crystalshard.chasm.crawler.adapter.httpclient.HttpRequestBodyIsMalformedException;
import okhttp3.Response;

public class OkHttp3ResponseWrapper {

    private Response response;

    OkHttp3ResponseWrapper(Response response) {
        this.response = response;
    }

    public String getBody() {
        try {
            return response.body().string();
        }catch (Exception e) {
            throw new HttpRequestBodyIsMalformedException(e);
        }
    }

    public int getCode() {
        return response.code();
    }
}
