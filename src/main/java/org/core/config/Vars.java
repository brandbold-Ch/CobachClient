package org.core.config;

enum Vars {
    MATRICULA("enrollment"),
    CLAVE_IN("claveIn"),
    CLAVEMAT("claveMat"),
    PARCIAL_1("partial1"),
    FALTAS_1("faults1"),
    PARCIAL_2("partial2"),
    FALTAS_2("faults2"),
    PARCIAL_3("partial3"),
    FALTAS_3("faults3"),
    PROMEDIO("average"),
    OBSERVA("observation"),
    PALABRA("word");

    private final String nameField;

    Vars(String nameField) {
        this.nameField = nameField;
    }

    public String getNameField() {
        return nameField;
    }
}
