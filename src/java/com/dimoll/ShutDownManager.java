package com.dimoll;

import java.io.IOException;

public class ShutDownManager {

    public static void shutDownSystem() {
        String property = System.getProperty("os.name");
        System.out.println(property);

        if (property.toLowerCase().contains("win")) {
            String[] commands = new String[]{"shutdown", "-s"};

            shutDownComputer(commands);
        } else if (property.toLowerCase().contains("nux")) {
            String[] commands = new String[]{"shutdown", "-p", "now"};

            shutDownComputer(commands);
        }
    }

    private static void shutDownComputer(String [] commands) {
        System.out.println("start process");
        try {
            Runtime.getRuntime().exec(commands);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
