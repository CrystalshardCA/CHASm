package ca.crystalshard.chasm.boot.guice.module;

import ca.crystalshard.chasm.common.adapter.persistance.repositories.mysql.MySqlBuildStepRepository;
import ca.crystalshard.chasm.common.adapter.persistance.repositories.mysql.MySqlJobRepository;
import ca.crystalshard.chasm.common.domain.persistance.repositories.BuildStepRepository;
import ca.crystalshard.chasm.common.domain.persistance.repositories.JobRepository;
import com.google.inject.Singleton;

public class MySqlDatabaseModule extends AbstractDatabaseModule {

    @Override
    protected void configure() {
        super.configure();

        bind(JobRepository.class).to(MySqlJobRepository.class).in(Singleton.class);
        bind(BuildStepRepository.class).to(MySqlBuildStepRepository.class).in(Singleton.class);
    }
}

