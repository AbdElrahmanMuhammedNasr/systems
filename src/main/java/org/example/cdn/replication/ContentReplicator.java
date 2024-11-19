package org.example.cdn.replication;

import org.example.cdn.domain.MultimediaContent;
import org.example.cdn.servers.Server;

import java.util.List;

public class ContentReplicator {

    private List<Server> servers;

    public ContentReplicator(List<Server> servers) {
        this.servers = servers;
    }

    public void replicateContent(MultimediaContent content) {
        for (Server server : servers) {
            server.storeContent(content);
        }
    }
}
