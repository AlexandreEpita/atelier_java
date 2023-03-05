package fr.epita.assistants.travel;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Country fr = new Country("Australia", "Australia/Sydney", "src/main/resources/travel_times.csv");
        System.out.println(fr.travelTimes);
    }
}
