package ca.crystalshard.chasm.crawler.domain.identifier;

import ca.crystalshard.chasm.common.domain.identifier.Id;

import java.util.regex.Pattern;

public abstract class StringId extends Id<String> {

    private Pattern isAlphaNumericPattern = Pattern.compile("^[a-zA-Z0-9]*$");

    StringId(String id) {
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
