package com.house.server;

import com.thoughtworks.main.JettyLauncher;

public class AppServer {
    public static void main(String[] args) {
        JettyLauncher.start("src/main/webapp", "/sample");
    }
}
