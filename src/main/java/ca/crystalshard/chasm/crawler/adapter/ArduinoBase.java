package ca.crystalshard.chasm.crawler.adapter;

import ca.crystalshard.chasm.crawler.adapter.arduinonet.ArduinoNetGateway;

public abstract class ArduinoBase {

    protected ArduinoNetGateway gateway;

    public ArduinoBase(ArduinoNetGateway gateway) {
        this.gateway = gateway;
    }
}
