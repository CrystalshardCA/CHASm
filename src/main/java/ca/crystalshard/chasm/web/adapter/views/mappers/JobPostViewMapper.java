package ca.crystalshard.chasm.web.adapter.views.mappers;

import ca.crystalshard.chasm.common.domain.Job;
import ca.crystalshard.chasm.web.adapter.views.JobPostView;

public class JobPostViewMapper {
    public Job toDomain(JobPostView view) {
        return new Job(view.name);
    }
}
