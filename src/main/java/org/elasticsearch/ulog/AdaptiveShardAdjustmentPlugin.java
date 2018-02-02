package org.elasticsearch.ulog;

import org.elasticsearch.cluster.metadata.IndexNameExpressionResolver;
import org.elasticsearch.cluster.node.DiscoveryNodes;
import org.elasticsearch.common.settings.ClusterSettings;
import org.elasticsearch.common.settings.IndexScopedSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.settings.SettingsFilter;
import org.elasticsearch.plugins.ActionPlugin;
import org.elasticsearch.plugins.Plugin;
import org.elasticsearch.rest.RestController;
import org.elasticsearch.rest.RestHandler;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class AdaptiveShardAdjustmentPlugin extends Plugin implements ActionPlugin{

    public AdaptiveShardAdjustmentPlugin() {
    }

    public String name() {
        return "es_shard_adaptor";
    }

    public String describe() {
        return "Used to adjust indices shard number adaptively.";
    }


    @Override
    public List<RestHandler> getRestHandlers(Settings settings, RestController restController, ClusterSettings clusterSettings, IndexScopedSettings indexScopedSettings, SettingsFilter settingsFilter, IndexNameExpressionResolver indexNameExpressionResolver, Supplier<DiscoveryNodes> nodesInCluster) {
        return Collections.singletonList(new AdaptiveShardAdjustmentAction(settings, restController));
    }
}
