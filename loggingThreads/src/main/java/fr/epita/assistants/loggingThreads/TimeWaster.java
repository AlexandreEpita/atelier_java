package fr.epita.assistants.loggingThreads;

import java.math.*;

public class TimeWaster {
    // FIXME: Logger

    public TimeWaster() {
        // FIXME: Initialize logger with level TRACE
    }

    /**
     * @param n Last natural number to sum
     * @return The sum of integers from 0 to n
     */
    public BigInteger sumUpTo(int n) {
        // FIXME: Add logging

        BigInteger sum = BigInteger.ZERO;
        for (int i = 1; i <= n; i++) {
            sum = sum.add(BigInteger.valueOf(i));
        }

        return sum;
    }

    public void doImportantThing() {
        // FIXME: Wait for 2s, logging an error in case of interruption
    }
}
