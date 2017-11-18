package ca.crystalshard.chasm.boot.guice;

import ca.crystalshard.chasm.common.adapter.spark.JsonResponseTransformer;
import com.google.inject.Provider;
import spark.ResponseTransformer;

public class ResponseTransformerProvider implements Provider<ResponseTransformer> {

    @Override
    public ResponseTransformer get() {
        return new JsonResponseTransformer();
    }
}


