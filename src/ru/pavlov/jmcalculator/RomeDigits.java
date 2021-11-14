package ru.pavlov.jmcalculator;

public enum RomeDigits {
    I (1),
    II (2),
    III (3),
    IV (4),
    V (5),
    VI (6),
    VII (7),
    VIII (8) ,
    IX (9),
    X (10),
    L (50),
    C (100);

    private int value;

    RomeDigits(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
