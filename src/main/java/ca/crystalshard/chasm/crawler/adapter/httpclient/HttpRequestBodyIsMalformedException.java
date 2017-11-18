package ca.crystalshard.chasm.crawler.adapter.httpclient;

public class HttpRequestBodyIsMalformedException extends RuntimeException {
    public HttpRequestBodyIsMalformedException(Exception e) {
        super(e.getMessage(), e);
    }
}
