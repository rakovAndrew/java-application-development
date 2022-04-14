package com.acme.dbo.txlog;

import com.acme.dbo.txlog.decorator.Decorator;

import static com.acme.dbo.txlog.accumulator.Accumulator.*;
import static com.acme.dbo.txlog.decorator.Decorator.decorateMessage;
import static com.acme.dbo.txlog.saver.ConsoleSaver.save;

public class Facade {

    public static void log(int message) {
        flushString();

        setPrevInteger(true);
        accumulate(message);
    }

    public static void log(byte message) {
        save(decorateMessage(message));
    }

    public static void log(char message) {
        save(decorateMessage(message));
    }

    public static void log(String message) {
        flushInt();

        setPrevString(true);
        accumulate(message);
    }

    public static void log(boolean message) {
        save(decorateMessage(message));
    }

    public static void log(Object message) {
        save(decorateMessage(message));
    }

    public static void flush() {
        flushInt();
        flushString();
    }

    private static void flushInt() {
        if (isPrevInteger()) {
            save(decorateMessage(getSum()));
            setSum(0);
            setPrevInteger(false);
        }
    }

    private static void flushString() {
        if (isPrevString()) {
            if (getStringQuantity() == 1) {
                save(decorateMessage(getPrevMessage()));
            } else {
                save(decorateMessage(getPrevMessage() + " (x" + getStringQuantity() + ")"));
            }

            setStringQuantity(0);
            setPrevMessage(null);
            setPrevString(false);
        }
    }
}
