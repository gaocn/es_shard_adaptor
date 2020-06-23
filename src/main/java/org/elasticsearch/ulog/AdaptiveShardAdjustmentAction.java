package org.elasticsearch.ulog;

import org.elasticsearch.client.node.NodeClient;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.rest.BaseRestHandler;
import org.elasticsearch.rest.RestController;
import org.elasticsearch.rest.RestRequest;

import java.io.IOException;

public class AdaptiveShardAdjustmentAction extends BaseRestHandler {

    @Override
    public String getName() {
        return "es_shard_adaptor";
    }

    @Inject
    public AdaptiveShardAdjustmentAction(Settings settings, RestController controller) {
        super(settings);

        //注册 RESTFul API
        controller.registerHandler(RestRequest.Method.GET, "/_adaptive_shard", this);

    }

    @Override
    protected RestChannelConsumer prepareRequest(RestRequest restRequest, NodeClient nodeClient) throws IOException {
        return null;
    }
}
