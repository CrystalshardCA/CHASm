package ca.crystalshard.chasm.crawler.adapter.httpclient;

public class HttpResponse<T> {

    private T body;
    private int code;

    public HttpResponse(T body, int code) {
        this.body = body;
        this.code = code;
    }

    public T getBody() {
        return body;
    }

    public int getCode() {
        return code;
    }
}
