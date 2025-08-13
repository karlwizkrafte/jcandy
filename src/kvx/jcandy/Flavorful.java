/**
 * MIT License
 * Copyright (c) 2025 karlwizkrafte
 *
 * This library provides standard CLI utilities for Java-related laboratory tasks to reduce boilerplate.
 */

package kvx.jcandy;

public class Flavorful {
    public enum Color {
        red("\u001B[31m"),
        green("\u001B[32m"),
        yellow("\u001B[33m"),
        blue("\u001B[34m"),
        purple("\u001B[35m"),
        cyan("\u001B[36m"),
        white("\u001B[37m"),
        bright_red("\u001B[91m"),
        bright_green("\u001B[92m"),
        bright_yellow("\u001B[93m"),
        bright_blue("\u001B[94m"),
        bright_purple("\u001B[95m"),
        bright_cyan("\u001B[96m"),
        bright_white("\u001B[97m"),
        black("\u001B[30m"),
        bright_black("\u001B[90m");
       
        private final String code;
       
        Color(String code) {
            this.code = code;
        }
       
        @Override
        public String toString() {
            return code;
        }
    }
   
    public enum BGColor {
        red("\u001B[41m"),
        green("\u001B[42m"),
        yellow("\u001B[43m"),
        blue("\u001B[44m"),
        purple("\u001B[45m"),
        cyan("\u001B[46m"),
        white("\u001B[47m"),
        black("\u001B[40m"),
        bright_red("\u001B[101m"),
        bright_green("\u001B[102m"),
        bright_yellow("\u001B[103m"),
        bright_blue("\u001B[104m"),
        bright_purple("\u001B[105m"),
        bright_cyan("\u001B[106m"),
        bright_white("\u001B[107m"),
        bright_black("\u001B[100m");
       
        private final String code;
       
        BGColor(String code) {
            this.code = code;
        }
       
        @Override
        public String toString() {
            return code;
        }
    }
   
    public enum Style {
        reset("\u001B[0m"),
        bold("\u001B[1m"),
        dim("\u001B[2m"),
        italic("\u001B[3m"),
        underline("\u001B[4m"),
        blink("\u001B[5m"),
        reverse("\u001B[7m"),
        strikethrough("\u001B[9m");
       
        private final String code;
       
        Style(String code) {
            this.code = code;
        }
       
        @Override
        public String toString() {
            return code;
        }
    }
   
    public static String flavor(Object... args) {
        StringBuilder text = new StringBuilder();
        StringBuilder styling = new StringBuilder();
        
        for (Object arg : args) {
            if (arg instanceof Color) {
                styling.append(((Color) arg).toString());
            } else if (arg instanceof BGColor) {
                styling.append(((BGColor) arg).toString());
            } else if (arg instanceof Style) {
                styling.append(((Style) arg).toString());
            } else {
                // Everything else is treated as text content
                text.append(arg.toString());
            }
        }
        
        return styling.toString() + text.toString() + Style.reset.toString();
    }
    
    // Added for convenience
    public static String bold(String text) {
        return flavor(text, Style.bold);
    }
   
    public static String underline(String text) {
        return flavor(text, Style.underline);
    }
   
    public static String italic(String text) {
        return flavor(text, Style.italic);
    }
    
    public static String dim(String text) {
        return flavor(text, Style.dim);
    }
    
    public static String blink(String text) {
        return flavor(text, Style.blink);
    }
    
    public static String reverse(String text) {
        return flavor(text, Style.reverse);
    }
    
    public static String strikethrough(String text) {
        return flavor(text, Style.strikethrough);
    }
}