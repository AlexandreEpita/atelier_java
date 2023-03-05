package fr.epita.assistants.observer;

import java.util.Set;

public class Lifeguard implements Observable.Observer<Swimmer> {

    public String name;
    public Lifeguard(String name) {
        this.name = name;
        System.out.println(this.name + " begins to keep an eye on the swimmers.");
    }
    @Override
    public void onEvent(Swimmer event) {
        if (event.currentStatus == SwimmerStatus.DROWNING)
            System.out.println(this.name + ": I will save you " + event.getName() + "!");
        else if (event.currentStatus == SwimmerStatus.TOO_FAR)
            System.out.println(this.name + ": " + event.getName() + "! You are too far, come back!");
    }
}
