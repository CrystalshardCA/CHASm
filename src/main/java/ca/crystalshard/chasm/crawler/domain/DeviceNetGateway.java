package ca.crystalshard.chasm.crawler.domain;

import ca.crystalshard.chasm.crawler.domain.identifier.PinId;

public interface DeviceNetGateway {
    void setDigitalPin(PinId pinId, boolean value);

    void setAnalogPin(PinId pinId, int value);

    boolean getDigitalPin(PinId pinId);

    int getAnalogPin(PinId pinId);

    ChasmFirmwareVersion getVersion();
}
