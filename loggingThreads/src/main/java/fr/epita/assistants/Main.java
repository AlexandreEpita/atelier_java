package fr.epita.assistants;

import fr.epita.assistants.loggingThreads.*;

public class Main {
    // FIXME: Add static logger

    public static void main(String[] args) throws InterruptedException {
        // FIXME: Add startup logging here

        TimeWaster waster = new TimeWaster();

        Thread sum = new Thread(() -> waster.sumUpTo(123456789));
        Thread importantThing = new Thread(waster::doImportantThing);

        sum.start();
        importantThing.start();

        // FIXME: Manually interrupt importantThing to test your output

        sum.join();
        importantThing.join();

        // FIXME: Add clean exit logging
    }
}