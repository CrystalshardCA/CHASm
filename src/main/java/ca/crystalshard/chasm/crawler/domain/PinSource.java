package ca.crystalshard.chasm.crawler.domain;

import ca.crystalshard.chasm.crawler.domain.identifier.PinId;

public interface PinSource {

    int getAnalogPin(PinId pinId);

    boolean getDigitalPin(PinId pinId);

}