/**
 * MIT License
 * Copyright (c) 2025 karlwizkrafte
 * 
 * This library provides standard CLI utilities for Java-related laboratory tasks to reduce boilerplate.
 */

package kvx.jcandy;

import java.io.IOException;

public class Std {

    // output
    public static void printf(String message){System.out.print(message);}
    public static void printf(String format, Object... args) {System.out.printf(format, args);}

    public static void print(String message) {System.out.print(message);}

    public static void println(String message) {System.out.println(message);}
    public static void println(String format, Object... args) {System.out.printf((format) + "%n", args);}

    public static void printError(String message, Object... args) {System.err.printf((message) + "%n", args);}

    // utilities
    public static void newl() {System.out.println();}
    public static void newl(int range) {
        for (int i = 1; i <= range; i++) {System.out.println();}
    }

    public static void delay(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void clear() {

        String _os = System.getProperty("os.name");

        try {
            if (_os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("[WARN] If you see this the terminal clear operation may not be supported on this platform.");
            newl(50); // Fallback: if clear command is not supported :(
        }
    }

}