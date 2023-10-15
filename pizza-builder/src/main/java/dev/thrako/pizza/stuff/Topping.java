package dev.thrako.pizza.stuff;

public enum Topping {

    MOZZARELLA("mozzarella"),
    PROVOLONE("provolone"),
    PARMIGIANO("parmesan"),
    CHEDDAR("cheddar"),
    OLIO("oil"),
    ORIGANO("oregano"),
    PORTOBELLO("portobello mushrooms"),
    OLIVE("delicious black olives"),
    CARCIOFI("artichokes"),
    PROSCIUTTO_CRUDO("prosciutto crudo"),
    PROSCIUTTO_COTTO("prosciutto cotto"),
    SALAME_PICCANTE("spicy salami"),
    BASILICO("fresh basil leaves"),
    PESTO("basil pesto");

    final String description;

    Topping(String description) {

        this.description = description;
    }

    public String getDescription() {

        return description;
    }
}
