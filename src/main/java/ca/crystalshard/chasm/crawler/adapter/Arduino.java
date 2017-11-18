package ca.crystalshard.chasm.crawler.adapter;

import ca.crystalshard.chasm.crawler.domain.PinSource;
import ca.crystalshard.chasm.crawler.domain.identifier.PinId;

public class Arduino implements PinSource {


    @Override
    public int getAnalogPin(PinId pinId) {
        return 0;
    }

    @Override
    public boolean getDigitalPin(PinId pinId) {
        return false;
    }
}
