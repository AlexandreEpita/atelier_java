package fr.epita.assistants;

import fr.epita.assistants.throwback.*;

/**
 * A very simple test
 */
public class Main {
    public static void main(String[] args) throws NegativeIntegerException, ShortStringException,
            PositiveIntegerException, UnknownException, LongStringException {
        /*
          Replace this String to try other exceptions.
          Hint: this one should trigger an UnknownException.
         */

        String exception = null;

        try {
            Pitcher.throwException(exception);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
