package ca.crystalshard.chasm.common.domain.identifier;

public class BuildStepId extends IntegerId {

    public static BuildStepId of(String id) {
        return new BuildStepId(Integer.parseInt(id));
    }

    public static BuildStepId of(int id) {
        return new BuildStepId(id);
    }

    private BuildStepId(Integer id) {
        super(id);
    }

    @Override
    protected boolean validate(Integer id) {
        return id > 0;
    }
}
