package ca.crystalshard.chasm.common.domain.identifier;

import java.util.regex.Pattern;

public abstract class StringId extends Id<String> {

    private static Pattern isAlphaNumericPattern = Pattern.compile("^[a-z0-9]*$", Pattern.CASE_INSENSITIVE);

    protected StringId(String id) {
        super(id);
    }

    @Override
    protected boolean validate(String id) {
        return isAlphaNumericPattern.matcher(id).find();
    }

    @Override
    public int compareTo(Id<String> o) {
        return this.getId().compareTo(o.getId());
    }
}
