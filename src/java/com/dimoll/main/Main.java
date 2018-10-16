package com.dimoll.main;

import com.dimoll.managers.ThreadManager;

import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        System.out.println("START PROGRAM");
        System.out.println();

        int minute = inputMinute();
        ThreadManager.start(minute);
        ThreadManager.timer(minute);

    }

    private static int inputMinute(){
        int minute = 0;
        while (minute <= 0) {
            try {
                System.out.println("How many minutes you need to turn off your computer?");
                minute = Integer.parseInt(new Scanner(System.in).nextLine());
            } catch (NumberFormatException e) {
                System.out.println("You need enter the INTEGER value");
            }
        }
        return minute;
    }
}
