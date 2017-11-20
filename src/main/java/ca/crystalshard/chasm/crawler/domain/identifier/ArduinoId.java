package ca.crystalshard.chasm.crawler.domain.identifier;

import ca.crystalshard.chasm.common.domain.identifier.UUIDId;

import java.util.UUID;

public class ArduinoId extends UUIDId {

    public static ArduinoId HALLWAY_THERMOSTAT =
            new ArduinoId(UUID.fromString("09b1e3b3-8b3f-4bb2-aab9-5b596bd41ba9"));

    private ArduinoId(UUID id) {
        super(id);
    }

    public static ArduinoId of(String id) {
        return new ArduinoId(UUID.fromString(id));
    }

    public static ArduinoId of(UUID id) {
        return new ArduinoId(id);
    }
}
