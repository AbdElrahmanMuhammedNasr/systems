package org.example.cdn.load;

import org.example.cdn.servers.Server;

import java.util.List;

public class LoadBalancer {

    private List<Server> servers;

    public LoadBalancer(List<Server> servers) {
        this.servers = servers;
    }

    public Server getServer() {
        int currentIndex = 0;
        return servers.get(currentIndex);
    }
}
