package dev.thrako.pizza;

import java.math.BigDecimal;

public abstract class PizzaDecorator implements Pizza {

    private final Pizza pizza;
    protected BigDecimal price;

    public PizzaDecorator(Pizza pizza) {

        this.pizza = pizza;
    }

    @Override
    public String getDescription() {

        return pizza.getDescription();
    }

    public BigDecimal getPrice() {

        return this.pizza.getPrice().add(this.price);
    }

    public Pizza unwrap() {
        return this.pizza;
    }

    @Override
    public String toString() {

        return this.getDescription();
    }
}
