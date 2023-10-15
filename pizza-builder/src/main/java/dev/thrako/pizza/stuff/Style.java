package dev.thrako.pizza.stuff;

public enum Style {

    NAPOLETANA("Traditional Neapolitan style pizza"),
    ROMANA("Traditional Roman style pizza"),
    SICILIANA("Traditional Sicilian style pizza"),
    CALZONE("Pizza Calzone");

    final String description;

    Style(String description) {

        this.description = description;
    }

    public String getDescription() {

        return description;
    }
}
