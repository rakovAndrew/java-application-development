package com.acme.dbo.txlog;

public class Facade {

    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String REFERENCE_PREFIX = "reference: ";

    public static void log(int message) {
        consoleLog(decorateMessage(message));
    }

    public static void log(byte message) {
        consoleLog(decorateMessage(message));
    }

    public static void log(char message) {
        consoleLog(decorateMessage(message));
    }

    public static void log(String message) {
        consoleLog(decorateMessage(message));
    }

    public static void log(boolean message) {
        consoleLog(decorateMessage(message));
    }

    public static void log(Object message) {
        consoleLog(decorateMessage(message));
    }

    private static void consoleLog(String message) {
        System.out.println(message);
    }

    private static String decorateMessage(int message) {
        return PRIMITIVE_PREFIX + message;
    }

    private static String decorateMessage(char message) {
        return CHAR_PREFIX + message;
    }

    private static String decorateMessage(String message) {
        return STRING_PREFIX + message;
    }

    private static String decorateMessage(boolean message) {
        return PRIMITIVE_PREFIX + message;
    }

    private static String decorateMessage(Object message) {
        return REFERENCE_PREFIX + message;
    }
}
