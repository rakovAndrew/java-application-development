package com.acme.dbo.txlog.accumulator;

import java.util.Objects;

public class Accumulator {
    private static int sum;
    private static int stringQuantity;
    private static String prevMessage;
    private static boolean isPrevInteger;
    private static boolean isPrevString;

    public static int getSum() {
        return sum;
    }

    public static void setSum(int sum) {
        Accumulator.sum = sum;
    }

    public static int getStringQuantity() {
        return stringQuantity;
    }

    public static void setStringQuantity(int stringQuantity) {
        Accumulator.stringQuantity = stringQuantity;
    }

    public static String getPrevMessage() {
        return prevMessage;
    }

    public static void setPrevMessage(String prevMessage) {
        Accumulator.prevMessage = prevMessage;
    }

    public static void setPrevInteger(boolean prevInteger) {
        isPrevInteger = prevInteger;
    }

    public static boolean isPrevInteger() {
        return isPrevInteger;
    }

    public static boolean isPrevString() {
        return isPrevString;
    }

    public static void setPrevString(boolean prevString) {
        isPrevString = prevString;
    }

    public static void accumulate(int message) {
        sum += message;
    }

    public static void accumulate(String message) {
        if (prevMessage == null) {
            prevMessage = message;
        }

        if (Objects.equals(prevMessage, message)) {
            stringQuantity++;
        }
    }
}
