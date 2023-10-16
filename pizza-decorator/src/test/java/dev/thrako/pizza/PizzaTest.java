package dev.thrako.pizza;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PizzaTest {

    private Pizza pizzaMargherita;

    @BeforeEach
    void setUp() {

        pizzaMargherita = new Margherita();
    }

    @Test
    void whenDecoratedPizza_thenThePriceIsAddedUp() {

        final Pizza margheritaWithExtraOlives = new ExtraOlives(pizzaMargherita);
        assertEquals(Margherita.PRICE.add(ExtraOlives.PRICE),
                     margheritaWithExtraOlives.getPrice());

        final Pizza takeAwayMargherita = new PizzaBox(pizzaMargherita);
        assertEquals(Margherita.PRICE.add(PizzaBox.PRICE),
                     takeAwayMargherita.getPrice());

        final Pizza takeAwayMargheritaWithExtraOlives = new PizzaBox(margheritaWithExtraOlives);
        assertEquals(Margherita.PRICE.add(ExtraOlives.PRICE).add(PizzaBox.PRICE),
                     takeAwayMargheritaWithExtraOlives.getPrice());

        final Pizza anotherTakeAwayMargheritaWithExtraOlives = new PizzaBox(new ExtraOlives(new Margherita()));
        assertEquals(Margherita.PRICE.add(ExtraOlives.PRICE).add(PizzaBox.PRICE),
                     anotherTakeAwayMargheritaWithExtraOlives.getPrice());
    }

    @Test
    void whenDecoratedPizza_thenTheDescriptionIsAddedUp() {

        final Pizza margheritaWithExtraOlives = new ExtraOlives(pizzaMargherita);
        assertEquals("Pizza Margherita with olives",
                     margheritaWithExtraOlives.getDescription());

        final Pizza takeAwayMargherita = new PizzaBox(pizzaMargherita);
        assertEquals("Pizza Margherita in a box",
                     takeAwayMargherita.getDescription());

        final Pizza takeAwayMargheritaWithExtraOlives = new PizzaBox(margheritaWithExtraOlives);
        assertEquals("Pizza Margherita with olives in a box",
                     takeAwayMargheritaWithExtraOlives.getDescription());

        final Pizza anotherTakeAwayMargheritaWithExtraOlives = new PizzaBox(new ExtraOlives(new Margherita()));
        assertEquals("Pizza Margherita with olives in a box",
                     anotherTakeAwayMargheritaWithExtraOlives.getDescription());
    }

    @Test
    void whenUnwrappedPizza_thenPizzaIsTheSame() {
        final PizzaDecorator takeAwayMargherita = new PizzaBox(pizzaMargherita);
        final Pizza unwrappedPizza = takeAwayMargherita.unwrap();

        assertEquals(unwrappedPizza, pizzaMargherita);
    }

}