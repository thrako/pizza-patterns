package dev.thrako.pizza;

import java.math.BigDecimal;

public class Margherita implements Pizza {

    public static final BigDecimal PRICE = BigDecimal.valueOf(5.70);

    @Override
    public String getDescription() {

        return "Pizza Margherita";
    }

    @Override
    public BigDecimal getPrice() {

        return PRICE;
    }

    @Override
    public String toString() {

        return this.getDescription();
    }
}
