package ca.crystalshard.chasm.crawler.domain.identifier;

import ca.crystalshard.chasm.common.domain.identifier.StringId;

import java.util.regex.Pattern;

public class PinId extends StringId {

    private static Pattern isValidPinString = Pattern.compile("^A?[0-9]{1,2}$");

    public static PinId of(String id) {
        return new PinId(id);
    }

    private PinId(String id) {
        super(id);
    }

    @Override
    protected boolean validate(String id) {
        return super.validate(id) && isValidPinString.matcher(id).find();
    }
}
