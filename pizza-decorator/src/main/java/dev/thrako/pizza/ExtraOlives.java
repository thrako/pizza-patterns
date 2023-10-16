package dev.thrako.pizza;

import java.math.BigDecimal;

public class ExtraOlives extends PizzaDecorator {

    public static final BigDecimal PRICE = BigDecimal.valueOf(1.70);

    public ExtraOlives(Pizza pizza) {

        super(pizza);
        super.price = PRICE;
    }

    @Override
    public String getDescription() {

        return super.getDescription() + " with olives";
    }
}
