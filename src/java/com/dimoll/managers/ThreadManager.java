package com.dimoll.managers;

import java.util.Timer;
import java.util.TimerTask;

public class ThreadManager {

    public ThreadManager(){
    }

    public static void start(int minute) {
        new Timer(true).schedule(new TimerTask() {
            @Override
            public void run() {
                ShutDownManager.shutDownSystem();
                System.out.println("*************************************************************");
                System.out.println("YOUR SYSTEM WILL BE TURN OFF NOW");
                System.out.println("*************************************************************");
                ShutDownManager.shutDownSystem();
            }
        }, minute * 60 * 1000);
    }

    public static void timer(int minute){
        Thread timerThread = new Thread(() -> {
            long start = System.currentTimeMillis();
            for (int count = 0; count <= minute; count++) {

                System.out.println("COMPUTER WILL TURN OFF AFTER " + "*" + (minute - count) + "*" + " minutes");
                try {
                    long finish = System.currentTimeMillis();
                    Thread.sleep((60 * 1000) - (start - finish));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                start = System.currentTimeMillis();
            }
        });
        timerThread.start();
    }
}
