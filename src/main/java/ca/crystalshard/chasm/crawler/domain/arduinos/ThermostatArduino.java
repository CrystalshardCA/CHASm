package ca.crystalshard.chasm.crawler.domain.arduinos;

import ca.crystalshard.chasm.crawler.adapter.ArduinoBase;
import ca.crystalshard.chasm.crawler.adapter.arduinonet.ArduinoNetGateway;
import ca.crystalshard.chasm.crawler.domain.identifier.PinId;

public class ThermostatArduino extends ArduinoBase {

    public ThermostatArduino(ArduinoNetGateway gateway) {
        super(gateway);
    }

    public int getTemperatureSensorValue() {
        return gateway.getAnalogPin(PinId.of("A0"));
    }

    public void setFurnaceEnable(boolean enable) {
        gateway.setDigitalPin(PinId.of("3"), enable);
    }

}
