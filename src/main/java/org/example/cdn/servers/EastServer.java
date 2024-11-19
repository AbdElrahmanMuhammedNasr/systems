package org.example.cdn.servers;

import org.example.cdn.domain.MultimediaContent;

import java.util.HashMap;
import java.util.Map;

public class EastServer implements Server {
    private String serverId;
    private Map<String, MultimediaContent> contentStore;

    public EastServer() {
        this.serverId = "EastServer-002";
        this.contentStore = new HashMap<>();
    }
    @Override
    public String getServerId() {
        return this.serverId;
    }

    @Override
    public MultimediaContent getContent(String key) {
        if (contentStore.containsKey(key)) {
            return contentStore.get(key);
        } else {
            return null; // Content not found
        }
    }

    @Override
    public void storeContent(MultimediaContent content) {
        contentStore.put(content.getContentId(), content);

    }

    @Override
    public void removeContent(String key) {
        contentStore.remove(key);
    }
}
