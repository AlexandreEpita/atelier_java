package fr.epita.assistants.singleton;

import fr.epita.assistants.logger.Logger;

public class StaticSingletonLogger implements Logger {

    private static class InstanceHolder
    {
        private static StaticSingletonLogger _INSTANCE = new StaticSingletonLogger();
    }
    public static StaticSingletonLogger getInstance() {
        return InstanceHolder._INSTANCE;
    }

    static private int infoCount = 0;
    static private int warnCount = 0;
    static private int errorCount = 0;

    private StaticSingletonLogger() {
    }

    @Override
    public void log(Level level, String message) {
        String output = Logger.getFormattedLog(level, message);
        System.err.println(output);
        if (level == Level.INFO)
            infoCount++;
        else if (level == Level.WARN)
            warnCount++;
        else
            errorCount++;
    }

    @Override
    public int getInfoCounter() {
        return infoCount;
    }

    @Override
    public int getWarnCounter() {
        return warnCount;
    }

    @Override
    public int getErrorCounter() {
        return errorCount;
    }

    @Override
    public void reset() {
        infoCount = 0;
        warnCount = 0;
        errorCount = 0;
    }
}
