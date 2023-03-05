package fr.epita.assistants.throwback;

public abstract class StringException extends Exception{
    protected String name;
    public StringException(String s) {
        super("StringException: " + s);
    }
}
  