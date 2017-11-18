package ca.crystalshard.chasm.boot.application.module;

import ca.crystalshard.chasm.common.domain.configuration.RubyWebConfiguration;
import ca.crystalshard.chasm.web.adapter.controllers.HomeController;
import ca.crystalshard.chasm.web.adapter.controllers.JobAdminController;
import ca.crystalshard.chasm.web.adapter.controllers.JobApiController;
import com.google.inject.Inject;

import static spark.Spark.port;
import static spark.Spark.staticFileLocation;

public class WebModule implements RubyModule {

    private RubyWebConfiguration webConfiguration;
    private HomeController homeController;
    private JobApiController jobApiController;
    private JobAdminController jobAdminController;

    @Inject
    public WebModule(RubyWebConfiguration webConfiguration,
                     HomeController homeController,
                     JobApiController jobApiController,
                     JobAdminController jobAdminController) {

        this.webConfiguration = webConfiguration;
        this.homeController = homeController;
        this.jobApiController = jobApiController;
        this.jobAdminController = jobAdminController;
    }

    @Override
    public void register() {
        port(webConfiguration.getPort());
        staticFileLocation(webConfiguration.getStaticFileLocation());
        homeController.register();
        jobApiController.register();
        jobAdminController.register();
    }
}

