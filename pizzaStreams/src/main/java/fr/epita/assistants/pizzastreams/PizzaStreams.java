package fr.epita.assistants.pizzastreams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import fr.epita.assistants.pizzastreams.Topping.*;

public class PizzaStreams {
    /**
     * @return The sum of the prices of all the pizzas in the stream
     */
    public static Integer getTotalPrice(Stream<Pizza> pizzaStream) {

        return pizzaStream.mapToInt(i -> i.getPrice()).sum();
    }

    /**
     * @return The average price of the pizzas in the stream, or the
     * double NaN if the stream is empty
     */
    public static Double getAveragePrice(Stream<Pizza> pizzaStream) {
        /* FIXME */
        return pizzaStream.mapToDouble(i -> i.getPrice()).average().orElse(Double.NaN);
    }

    /**
     * @return Names of the pizzas, sorted by price in ascending order
     */
    public static List<String> sortByPrice(Stream<Pizza> pizzaStream) {
        /* FIXME */
        return pizzaStream.sorted(Comparator.comparing(Pizza::getPrice)).map(i -> new String(i.getName())).toList();
    }

    /**
     * @return The Pizza object that has the lowest price, or null by default
     */
    public static Pizza getCheapest(Stream<Pizza> pizzaStream) {
        /* FIXME */
        return pizzaStream.min(Comparator.comparing(Pizza::getPrice)).orElse(null);
    }

    /**
     * @return Names of the pizzas with meat (Protein)
     */
    public static List<String> getCarnivorous(Stream<Pizza> pizzaStream) {
        /* FIXME */
        return pizzaStream.filter(i -> i.getTopping().getProtein().isPresent()).map(i -> new String(i.getName())).toList();
    }

    /**
     * @return Names of the pizzas with at least one Vegetable and no Proteins
     */
    public static List<String> getVeggies(Stream<Pizza> pizzaStream) {
        /* FIXME */
        return pizzaStream.filter(i -> !i.getTopping().getVegetableList().isEmpty() && i.getTopping().getProtein().isEmpty()).map(i -> new String(i.getName())).toList();
    }

    /**
     * @return true if all the pizzas with a nature dough are based with tomato
     * and mozzarella (italian pizza criteria), false otherwise
     */
    public static boolean areAllNatureItalians(Stream<Pizza> pizzaStream) {
        /* FIXME */
        return pizzaStream.allMatch(i -> i.getDough() != Dough.NATURE || (i.getDough() == Dough.NATURE && i.getTopping().getCheese() == Cheese.MOZZARELLA && i.getTopping().getSauce() == Sauce.TOMATO));
    }
}
