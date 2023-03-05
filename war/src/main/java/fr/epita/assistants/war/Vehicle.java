package fr.epita.assistants.war;

public class Vehicle extends Combatant{
    public Vehicle(String name, int defense) {
        this.name = name;
        this.defense = defense;
    }
    protected String name;
    protected int defense;

    @Override
    void printState() {
        System.out.println("I have " + this.defense + " defense points.");
    }

    @Override
    void attack(Soldier s) {
        s.kill();
    }

    @Override
    void attack(Vehicle v) {
        v.defense /= 2;
    }

    @Override
    void scream() {
        System.out.println("I'm " + this.name + "!");
    }
}
