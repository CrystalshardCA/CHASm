package ca.crystalshard.chasm.crawler.adapter.httpclient;

public class UnableToCompleteHttpRequestException extends RuntimeException {
    public UnableToCompleteHttpRequestException(String message, Exception e) {
        super(message, e);
    }
}
