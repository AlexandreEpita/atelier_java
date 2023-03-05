package fr.epita.assistants.observer;

import java.util.stream.Collector;

public class Person implements Observable.Observer<Swimmer>{

    public String name;
    public Person(String name) {
        this.name = name;
    }
    @Override
    public void onEvent(Swimmer event) {
        if (event.currentStatus == SwimmerStatus.WAVING)
            System.out.println(this.name + ": Waves at " + event.getName() + ".");
    }
}
