package dev.thrako;

import dev.thrako.pizza.*;

public class Main {

    public static void main(String[] args) {

        final Margherita margherita = new Margherita();
        final PizzaDecorator margheritaWithExtraOlives = new ExtraOlives(margherita);
        final PizzaDecorator takeAwayPizza = new PizzaBox(margheritaWithExtraOlives);

        System.out.println("Description: " + takeAwayPizza.getDescription());
        System.out.printf("Total price: EUR %.2f%n", takeAwayPizza.getPrice());
    }
}