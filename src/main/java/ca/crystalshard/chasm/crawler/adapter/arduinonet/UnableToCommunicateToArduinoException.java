package ca.crystalshard.chasm.crawler.adapter.arduinonet;

public class UnableToCommunicateToArduinoException extends RuntimeException {
    public UnableToCommunicateToArduinoException(Exception e) {
        super(e.getMessage(), e);
    }
}
