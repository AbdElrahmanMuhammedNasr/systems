package org.example.cdn;

public class Main {
    public static void main(String[] args) {
        CDNManager cdnManager = new CDNManager();
        for (int i = 0; i <2; i++) {
            cdnManager.getContent();
        }
    }
}
