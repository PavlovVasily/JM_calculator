package ru.pavlov.jmcalculator;

public class CalculatorException extends Exception{
    public CalculatorException(String message){
        super(message);
    }

    static class OperandNotValid extends CalculatorException {
        OperandNotValid(String operand){
            super("операнд " + operand + " не валиден");
        }
    }

    static class RomeSystemHasNoNegativeDigits extends CalculatorException {
        RomeSystemHasNoNegativeDigits(){
            super("В римской системе только положительные числа");
        }
    }

    static class UsedArabAndRomeDigitsTogether extends CalculatorException {
        UsedArabAndRomeDigitsTogether(){
            super("Используются одновременно разные системы счисления");
        }
    }

    static class FormatNotValid extends CalculatorException {
        FormatNotValid(){
            super("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
    }

    static class InputNotMathematicalOperation extends CalculatorException {
        InputNotMathematicalOperation(){
            super("Cтрока не является математической операцией");
        }
    }

    static class MathematicalOperationNotValid extends CalculatorException {
        MathematicalOperationNotValid(){
            super("Математическая операция не удоволетворяет условию");
        }
    }

    static class NumNotInRange extends CalculatorException {
        NumNotInRange(int num){
            super(num + " вне диапазона [1, 10]");
        }
    }

}

