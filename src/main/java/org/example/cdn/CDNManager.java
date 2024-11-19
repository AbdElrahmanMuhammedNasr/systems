package org.example.cdn;

import org.example.cdn.domain.MultimediaContent;
import org.example.cdn.load.LoadBalancer;
import org.example.cdn.replication.ContentReplicator;
import org.example.cdn.servers.EastServer;
import org.example.cdn.servers.Server;
import org.example.cdn.servers.WestServer;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class CDNManager {
    Server eastServer = new EastServer();
    Server westServer = new WestServer();
    List<Server> serverList = Arrays.asList(eastServer, westServer);

    public  void getContent() {
        System.out.println("==================================== Start =========================================");
        ContentReplicator contentReplicator = new ContentReplicator(serverList);
        LoadBalancer loadBalancer = new LoadBalancer(serverList);

        Server server = loadBalancer.getServer();
        System.out.println("CDN Server id is "+server.getServerId());
        MultimediaContent content = server.getContent("123");

        if(Objects.isNull(content)){
            System.out.println("content not exist in CDN Server call master server and get data");
            content = new MultimediaContent();
            content.setContentId("123");
            content.setResponse(UUID.randomUUID().toString());
            contentReplicator.replicateContent(content);

        }else {
            System.out.println("content  exist in CDN Server"+server.getServerId()+" and return data");
        }
        System.out.println("==================================== End =========================================");
    }
}
