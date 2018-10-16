package com.dimoll.managers;

import java.io.IOException;

class ShutDownManager {

    static void shutDownSystem() {
        String property = System.getProperty("os.name");
        System.out.println(property);

        if (property.toLowerCase().contains("win")) {
            startCommand(new String[]{"shutdown", "-s"});
        } else if (property.toLowerCase().contains("nux")) {
            startCommand(new String[]{"shutdown", "-p", "now"});
        }
    }

    private static void startCommand(String [] commands) {
        System.out.println("start process");
        try {
            Runtime.getRuntime().exec(commands);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
