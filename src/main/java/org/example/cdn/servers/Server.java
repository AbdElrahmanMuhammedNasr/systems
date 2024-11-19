package org.example.cdn.servers;

import org.example.cdn.domain.MultimediaContent;

public interface Server {
    String getServerId();
    MultimediaContent getContent(String key);

    void storeContent(MultimediaContent content);

    void  removeContent(String key);
}
