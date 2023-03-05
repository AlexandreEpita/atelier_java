package fr.epita.assistants.staticpen;

public class Pen {

    // FIXME: Add attributes here.
    public enum Color {
        RED,
        BLUE
    }

    static int red_pens;
    static int blue_pens;
    static int totals;

    public Color my_color;

    public Pen(final Color color) {
        this.my_color = color;
        if (color == Color.RED)
            red_pens++;
        else
            blue_pens++;
        totals++;
    }

    public static int getRedPenCounter() {
        return red_pens;
    }

    public static int getPenCounter() {
        return totals;
    }

    public static int getBluePenCounter() {
        return blue_pens;
    }

    public void changeColor(final Color color) {
        if (color == Color.BLUE && this.my_color == Color.RED)
        {
            blue_pens++;
            red_pens--;
        }
        if (color == Color.RED && this.my_color == Color.BLUE)
        {
            blue_pens--;
            red_pens++;
        }
        this.my_color = color;
    }

    public static void resetCounts() {
        blue_pens = 0;
        red_pens = 0;
        totals = 0;
    }

    public void print() {
        System.out.println("I'm a " + this.my_color.toString() + " pen.");
    }
}
