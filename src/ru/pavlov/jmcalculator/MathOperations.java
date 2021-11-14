package ru.pavlov.jmcalculator;

public enum MathOperations {
    PLUS ("+"),
    MINUS ("-"),
    MULT ("*"),
    DIV ("/");

    public String getValue() {
        return value;
    }

    private String value;

    MathOperations(String operation) {
        this.value = operation;
    }



}
