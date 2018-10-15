package com.dimoll;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    volatile static boolean flag=true;
    public static void main(String args[]) throws InterruptedException {
        System.out.println("START PROGRAM");
        System.out.println();
        int minute = 0;

        while (minute <= 0) {
            try {
                System.out.println("How many minutes you need to turn off your computer?");
                minute = Integer.parseInt(new Scanner(System.in).nextLine());
            } catch (NumberFormatException e) {
                System.out.println("You need enter the INTEGER value");
            }
        }

        start(minute);

        int minuteCount = 0;


        while (flag){
            System.out.println("COMPUTER WILL TURN OFF AFTER " + "*" + (minute - (minuteCount++)) + "*" + " minutes");
            System.out.println(minuteCount);
            Thread.sleep((long) (59.9 *1000));
        }


    }

    private static void start(int minute) {
        new Timer(true).schedule(new TimerTask() {
            @Override
            public void run() {
                ShutDownManager.shutDownSystem();
                System.out.println("*************************************************************");
                System.out.println("YOUR SYSTEM WILL BE TURN OFF NOW");
                System.out.println("*************************************************************");
                flag=false;
            }
        }, minute * 60 * 1000);
    }
}
