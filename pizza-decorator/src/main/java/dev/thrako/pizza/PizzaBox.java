package dev.thrako.pizza;

import java.math.BigDecimal;

public class PizzaBox extends PizzaDecorator {

    public static final BigDecimal PRICE = BigDecimal.valueOf(0.80);

    public PizzaBox(Pizza pizza) {

        super(pizza);
        super.price = PRICE;
    }

    @Override
    public String getDescription() {

        return super.getDescription() + " in a box";
    }
}
