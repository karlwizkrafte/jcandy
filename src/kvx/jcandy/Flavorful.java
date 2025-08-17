/**
 * MIT License
 * Copyright (c) 2025 karlwizkrafte
 *
 * JCandy is a lightweight Java library that simplifies console output 
 * with easy printing, formatting, and colorful text styling, helping students and developers 
 * reduce boilerplate in terminal apps. 
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

        public static String rgba(int r, int g, int b, int a) {
            if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255 || a < 0 || a > 255) {
            throw new IllegalArgumentException("RGBA values must be between 0 and 255");
            }
            
            // Note: ANSI doesn't support alpha, add alpha for convenience, but ignore it.
            return String.format("\u001B[38;2;%d;%d;%dm", r, g, b);
        }

        // Attempt 2: hex implementation with 8 character support
        // Note to self use long for both since 8-character hex exceeds 32-bit :)
        public static String hex(String code) {
            String clean = code.replace("#", "");
            if (clean.length() == 6) {
                long value = Long.parseLong(clean, 16);
                long r = (int)((value >> 16) & 0xFF);
                long g = (int)((value >> 8) & 0xFF);
                long b = (int)(value & 0xFF);
                return String.format("\u001B[38;2;%d;%d;%dm", r, g, b);
            } else if (clean.length() == 8) {
                long value = Long.parseLong(clean, 16);
                int r = (int)((value >> 24) & 0xFF);
                int g = (int)((value >> 16) & 0xFF);
                int b = (int)((value >> 8) & 0xFF);
                
                return String.format("\u001B[38;2;%d;%d;%dm", r, g, b);
            } else {
                throw new IllegalArgumentException("Hex color must be 6 or 8 characters");
            }
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

        // Same logic with the foreground just copied
        public static String rgba(int r, int g, int b, int a) {
            if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255 || a < 0 || a > 255) {
            throw new IllegalArgumentException("RGBA values must be between 0 and 255");
            }
            return String.format("\u001B[48;2;%d;%d;%dm", r, g, b);
        }

        // Same logic with the foreground just copied
        public static String hex(String code) {
            String clean = code.replace("#", "");
            if (clean.length() == 6) {
                long value = Long.parseLong(clean, 16);
                long r = (int)((value >> 16) & 0xFF);
                long g = (int)((value >> 8) & 0xFF);
                long b = (int)(value & 0xFF);
                return String.format("\u001B[48;2;%d;%d;%dm", r, g, b);
            } else if (clean.length() == 8) {
                long value = Long.parseLong(clean, 16);
                int r = (int)((value >> 24) & 0xFF);
                int g = (int)((value >> 16) & 0xFF);
                int b = (int)((value >> 8) & 0xFF);
                
                return String.format("\u001B[48;2;%d;%d;%dm", r, g, b);
            } else {
                throw new IllegalArgumentException("Hex color must be 6 or 8 characters");
            }
        }

    }
   
    public enum Style {
    reset("\u001B[0m"),
    bold("\u001B[1m"),
    italic("\u001B[3m"),
    underline("\u001B[4m"),
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
            } else if (arg instanceof String && ((String) arg).matches("\\u001B\\[[0-9;]*m")) {
                styling.append((String) arg);
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
    
    
    public static String reverse(String text) {
        return flavor(text, Style.reverse);
    }
    
    public static String strikethrough(String text) {
        return flavor(text, Style.strikethrough);
    }
}