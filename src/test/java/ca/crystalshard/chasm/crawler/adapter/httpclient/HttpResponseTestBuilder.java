package ca.crystalshard.chasm.crawler.adapter.httpclient;

public class HttpResponseTestBuilder<T> {

    private T body;
    private int code;

    public HttpResponse<T> build() {
        return new HttpResponse<>(body, code);
    }

    public HttpResponseTestBuilder body(T body) {
        this.body = body;
        return this;
    }

    public HttpResponseTestBuilder code(int code) {
        this.code = code;
        return this;
    }

}
