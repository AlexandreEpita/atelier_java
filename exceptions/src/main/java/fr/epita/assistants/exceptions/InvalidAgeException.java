package fr.epita.assistants.exceptions;

public class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super("InvalidAgeException: " + message);
    }
}
