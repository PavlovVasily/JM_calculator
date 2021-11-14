package ru.pavlov.jmcalculator;

import java.util.ArrayList;

public class Calculation {
    private MathOperations mathOperation;
    private ArrayList<Integer> operands;
    private int result = 0;

    public Calculation(ArrayList<Integer> mathOperands, MathOperations mathOperation) {
        this.mathOperation = mathOperation;
        this.operands = mathOperands;
    }

    int calculate(){
        MathOperations allMathOperation;
        switch (this.mathOperation){
            case PLUS:
                result = operands.get(0) + operands.get(1);
                break;
            case MINUS:
                result = operands.get(0) - operands.get(1);
                break;
            case MULT:
                result = operands.get(0) * operands.get(1);
                break;
            case DIV:
                result = operands.get(0) / operands.get(1);
                break;
            default:
                result = 0;
        }
        return result;
    }
}
