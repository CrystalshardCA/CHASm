package ca.crystalshard.chasm.crawler.adapter.arduinonet;

import ca.crystalshard.chasm.crawler.adapter.httpclient.HttpResponse;
import ca.crystalshard.chasm.crawler.domain.ChasmFirmwareVersion;
import ca.crystalshard.chasm.crawler.domain.DeviceNetGateway;
import ca.crystalshard.chasm.crawler.domain.HttpClient;
import ca.crystalshard.chasm.crawler.domain.identifier.PinId;
import org.apache.commons.lang.NotImplementedException;

import java.net.MalformedURLException;
import java.net.URL;

public class ArduinoNetGateway implements DeviceNetGateway {
    private HttpClient httpClient;
    private URL arduinoUrl;


    public ArduinoNetGateway(HttpClient httpClient, URL arduinoUrl) {
        this.httpClient = httpClient;
        this.arduinoUrl = arduinoUrl;
    }

    @Override
    public void setDigitalPin(PinId pinId, boolean value) {
        setPin(pinId, value ? "HIGH" : "LOW");
    }

    @Override
    public void setAnalogPin(PinId pinId, int value) {
        setPin(pinId, String.valueOf(value));
    }

    private void setPin(PinId pinId, String value) {
        URL requestUrl = appendPath(arduinoUrl, String.format("/%s/%s", pinId, value));
        httpClient.getRawContent(requestUrl);
    }

    @Override
    public boolean getDigitalPin(PinId pinId) {
        return getPin(pinId).equalsIgnoreCase("HIGH");
    }

    @Override
    public int getAnalogPin(PinId pinId) {
        return Integer.parseInt(getPin(pinId));
    }

    @Override
    public ChasmFirmwareVersion getVersion() {
        throw new NotImplementedException();
        //HttpResponse<String> response = httpClient.getRawContent(arduinoUrl);
    }

    private String getPin(PinId pinId) {
        URL requestUrl = appendPath(arduinoUrl, String.format("/%s", pinId));

        HttpResponse<PinValueDto> response = httpClient.getContent(requestUrl, PinValueDto.class);

        return response.getBody().value;
    }

    private URL appendPath(URL base, String path) {
        try {
            return new URL(base, path);
        } catch (MalformedURLException e) {
            throw new UnableToCommunicateToArduinoException(e);
        }
    }

    private class PinValueDto {
        public String value;
    }
}
