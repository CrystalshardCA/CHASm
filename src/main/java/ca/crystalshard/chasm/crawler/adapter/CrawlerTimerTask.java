package ca.crystalshard.chasm.crawler.adapter;

import ca.crystalshard.chasm.crawler.domain.ArduinoBuilder;
import ca.crystalshard.chasm.crawler.domain.HttpClient;
import ca.crystalshard.chasm.crawler.domain.identifier.ArduinoId;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;

public class CrawlerTimerTask extends TimerTask {

    private Map<ArduinoId, ArduinoBase> arduinos;
    private HttpClient httpClient;
    private boolean initialized = false;

    @Inject
    public CrawlerTimerTask(HttpClient httpClient) {
        this.httpClient = httpClient;
        arduinos = new HashMap<>();
    }

    private void initialize() {
        arduinos.put(ArduinoId.HALLWAY_THERMOSTAT,
                new ArduinoBuilder().httpClient(httpClient).url("http://192.168.13.250/").buildThermostat());
    }

    @Override
    public void run() {
        if (!initialized) {
            initialize();
        }


    }
}

