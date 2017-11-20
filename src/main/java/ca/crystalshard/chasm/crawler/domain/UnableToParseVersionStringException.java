package ca.crystalshard.chasm.crawler.domain;

class UnableToParseVersionStringException extends RuntimeException {
    UnableToParseVersionStringException(String message) {
        super(message);
    }
}
