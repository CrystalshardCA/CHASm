package ca.crystalshard.chasm.crawler.domain;

import ca.crystalshard.chasm.crawler.adapter.arduinonet.ArduinoNetGateway;
import ca.crystalshard.chasm.crawler.adapter.arduinonet.UnableToCommunicateToArduinoException;
import ca.crystalshard.chasm.crawler.domain.arduinos.ThermostatArduino;

import java.net.MalformedURLException;
import java.net.URL;

public class ArduinoBuilder {

    private HttpClient httpClient;
    private URL url;

    public ArduinoBuilder httpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
        return this;
    }

    public ArduinoBuilder url(String url) {
        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            throw new UnableToCommunicateToArduinoException(e);
        }
        return this;
    }

    public ThermostatArduino buildThermostat() {
        return new ThermostatArduino(new ArduinoNetGateway(httpClient, url));
    }

}
