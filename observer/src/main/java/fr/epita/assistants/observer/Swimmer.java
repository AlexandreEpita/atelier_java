package fr.epita.assistants.observer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Swimmer implements Observable<Swimmer>{

    public Set<Observer<Swimmer>> observers;
    public String name;
    public SwimmerStatus currentStatus;

    public String getName() {
        return name;
    }
    public SwimmerStatus getStatus() {
        return currentStatus;
    }

    public void setStatus(SwimmerStatus currentStatus) {
        this.currentStatus = currentStatus;
        if (currentStatus == SwimmerStatus.DROWNING)
            System.out.println(this.name + ": I'm drowning, help!!");
        this.fire(this);
    }

    public Swimmer(String name)
    {
        this.name = name;
        this.currentStatus = SwimmerStatus.OK;
        this.observers = new HashSet<>();
        System.out.println(this.name + " goes into the sea.");
    }
    @Override
    public Set<Observer<Swimmer>> getObservers() {
        return observers;
    }

    @Override
    public void register(Observer<Swimmer>... observers) {
        this.observers.addAll(Arrays.asList(observers));
    }

    @Override
    public void unregister(Observer<Swimmer> observer) {
        this.observers.remove(observer);
    }

    @Override
    public void fire(Swimmer event) {
        event.getObservers().forEach(swimmerObserver -> swimmerObserver.onEvent(event));
    }
}
