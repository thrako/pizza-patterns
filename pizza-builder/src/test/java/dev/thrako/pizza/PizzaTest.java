package dev.thrako.pizza;

import dev.thrako.pizza.stuff.Base;
import dev.thrako.pizza.stuff.Style;
import dev.thrako.pizza.stuff.Topping;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PizzaTest {

    private Pizza pizzaMargherita;
    private Pizza pizzaCapricciosa;
    private Pizza pizzaBiancaNeve;


    @BeforeEach
    void setUp() {

        this.pizzaMargherita = Pizza.of(Style.NAPOLETANA, Base.ROSSA)
                                    .with(Topping.MOZZARELLA)
                                    .with(Topping.BASILICO)
                                    .build();

        this.pizzaCapricciosa = Pizza.of(Style.ROMANA, Base.ROSSA)
                                    .with(List.of(Topping.MOZZARELLA,
                                                  Topping.PORTOBELLO,
                                                  Topping.PROSCIUTTO_COTTO,
                                                  Topping.CARCIOFI,
                                                  Topping.OLIVE))
                                    .build();

        this.pizzaBiancaNeve = Pizza.of(Style.SICILIANA, Base.BIANCA)
                                    .with(Topping.OLIO)
                                    .with(Topping.ORIGANO)
                                    .build();
    }

    @Test
    void fieldsOfPizzaCreatedWithBuilderAreProperlySet() {

        assertEquals(Style.NAPOLETANA, pizzaMargherita.getStyle());
        assertEquals(Style.ROMANA, pizzaCapricciosa.getStyle());
        assertEquals(Style.SICILIANA, pizzaBiancaNeve.getStyle());

        assertEquals(Base.ROSSA, pizzaMargherita.getBase());
        assertEquals(Base.ROSSA, pizzaCapricciosa.getBase());
        assertEquals(Base.BIANCA, pizzaBiancaNeve.getBase());

        assertTrue(pizzaMargherita.getToppings().containsAll(List.of(Topping.MOZZARELLA,
                                                                     Topping.BASILICO)));

        assertTrue(pizzaCapricciosa.getToppings().containsAll(List.of(Topping.MOZZARELLA,
                                                                      Topping.PORTOBELLO,
                                                                      Topping.PROSCIUTTO_COTTO,
                                                                      Topping.CARCIOFI,
                                                                      Topping.OLIVE)));

        assertTrue(pizzaBiancaNeve.getToppings().containsAll(List.of(Topping.OLIO,
                                                                     Topping.ORIGANO)));
    }

    @Test
    void testToString() {

        final Pizza biancaNoToppings = Pizza.of(Style.ROMANA, Base.BIANCA).build();
        final Pizza rossaNoToppings = Pizza.of(Style.ROMANA, Base.ROSSA).build();
        final Pizza biancaOneTopping = Pizza.of(Style.NAPOLETANA, Base.BIANCA)
                .with(Topping.MOZZARELLA).build();
        final Pizza rossaOneTopping = Pizza.of(Style.NAPOLETANA, Base.ROSSA)
                .with(Topping.MOZZARELLA).build();
        final Pizza biancaTwoToppings = Pizza.of(Style.SICILIANA, Base.BIANCA)
                .with(Topping.MOZZARELLA).with(Topping.ORIGANO).build();
        final Pizza rossaTwoToppings = Pizza.of(Style.SICILIANA, Base.ROSSA)
                .with(Topping.MOZZARELLA).with(Topping.BASILICO).build();

        assertEquals("Traditional Roman style pizza.",
                     biancaNoToppings.toString());
        assertEquals("Traditional Roman style pizza with tomato sauce base.",
                     rossaNoToppings.toString());
        assertEquals("Traditional Neapolitan style pizza with mozzarella.",
                     biancaOneTopping.toString());
        assertEquals("Traditional Neapolitan style pizza with tomato sauce base and mozzarella.",
                     rossaOneTopping.toString());
        assertEquals("Traditional Sicilian style pizza with mozzarella and oregano.",
                     biancaTwoToppings.toString());
        assertEquals("Traditional Sicilian style pizza with tomato sauce base, mozzarella and fresh basil leaves.",
                     rossaTwoToppings.toString());
    }

}