package fr.epita.assistants.throwback;

public class Pitcher {
    public static void throwException(String message) throws
            LongStringException, ShortStringException,
            PositiveIntegerException, NegativeIntegerException,
            UnknownException {

        if (message.matches("^[0-9-]+$"))
        {
            if (message.length() > 1 && !message.substring(1).matches("^[0-9]+$"))
            {
                throw new UnknownException(message);
            }
            if (message.length() == 1 && !message.matches("^[0-9]+$"))
                throw new UnknownException(message);

            if (message.charAt(0) != '-')
                throw new PositiveIntegerException(message);
            else
                throw new NegativeIntegerException(message);
        }
        else if (message.matches("^[a-zA-Z, .']+$")) {
            if (message.length() >= 100)
                throw new LongStringException(message);
            else
                throw new ShortStringException(message);
        }
        else
            throw new UnknownException(message);
    }
}