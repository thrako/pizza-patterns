package dev.thrako.pizza;

import dev.thrako.pizza.stuff.Base;
import dev.thrako.pizza.stuff.Style;
import dev.thrako.pizza.stuff.Topping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Pizza {

    private final Style style;
    private final Base base;
    private final List<Topping> toppings;

    private Pizza(PizzaBuilder pizzaBuilder) {

        this.style = pizzaBuilder.style;
        this.base = pizzaBuilder.base;
        this.toppings = pizzaBuilder.toppings;
    }

    public Style getStyle() {

        return style;
    }

    public Base getBase() {

        return base;
    }

    public List<Topping> getToppings() {

        return Collections.unmodifiableList(toppings);
    }

    @Override
    public String toString() {

        final List<String> printList = new ArrayList<>();

        if (!this.base.getDescription().isEmpty()) {
            printList.add(this.base.getDescription());
        }

        printList.addAll(this.toppings.stream()
                .map(Topping::getDescription)
                .toList());

        final String lastTopping = (printList.isEmpty())
                                   ? null
                                   : printList.remove(printList.size() - 1);


        final String firstToppings = String.join(", ", printList);

        StringBuilder stringBuilder = new StringBuilder(this.style.getDescription());

        if (this.base == Base.BIANCA && this.toppings.isEmpty() && lastTopping == null) {
            stringBuilder.append(".");
            return stringBuilder.toString();
        }

        stringBuilder.append(" with ")
                .append((!firstToppings.isEmpty())
                        ? firstToppings + " and "
                        : "")
                .append((lastTopping != null)
                        ? lastTopping
                        : "")
                .append(".");

        return stringBuilder.toString();
    }

    public static PizzaBuilder of(Style style, Base base) {

        return new PizzaBuilder(style, base);
    }

    public static class PizzaBuilder {
        private final Style style;
        private final Base base;
        private final List<Topping> toppings;

        public PizzaBuilder(Style style, Base base) {

            this.style = style;
            this.base = base;
            this.toppings = new ArrayList<>();
        }

        public PizzaBuilder with(Topping topping) {

            this.toppings.add(topping);
            return this;
        }

        public PizzaBuilder with(Collection<Topping> toppings) {

            this.toppings.addAll(toppings);
            return this;
        }

        public Pizza build() {

            return new Pizza(this);
        }
    }
}
