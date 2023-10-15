package dev.thrako.pizza.stuff;

public enum Base {

    ROSSA("tomato sauce base"),
    BIANCA("");

    final String description;

    Base(String description) {

        this.description = description;
    }

    public String getDescription() {

        return description;
    }
}
