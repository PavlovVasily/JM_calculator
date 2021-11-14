package ru.pavlov.jmcalculator;

import java.util.ArrayList;
import java.util.Arrays;

public class InputHandler {
    private Boolean inputValid = false, modeRome = false;

    public Boolean isInputValid() {
        return inputValid;
    }

    public Boolean getModeRome() {
        return modeRome;
    }

    ArrayList<Integer> operands = new ArrayList<>();

    String input;

    MathOperations mathOperation;

    public InputHandler(String input) throws CalculatorException {
        this.input = input;
        this.inputControl();
    }

    private void inputControl() throws CalculatorException{
        ArrayList<String> listOperators = new ArrayList<>(Arrays.asList(input.split(" ")));

        //Проверка на исключения
        if (listOperators.size() < 3)
            throw new CalculatorException.MathematicalOperationNotValid();
        else if(listOperators.size() > 3) {
            throw new CalculatorException.FormatNotValid();
        }

        //Проверка на ключ математической операции
        if (!listOperators.get(1).equals("+") && !listOperators.get(1).equals("-") &&
            !listOperators.get(1).equals("*") && !listOperators.get(1).equals("/"))
            throw new CalculatorException.MathematicalOperationNotValid();

        //промежуточная запись операндов
        String operand1 = listOperators.get(0);
        String operand2 = listOperators.get(2);
        String operation = listOperators.get(1);

        int num1 = castToInt(operand1);
        int num2 = castToInt(operand2);

        if (num1 < 1 || num1 > 10)
            throw new CalculatorException.NumNotInRange(num1);

        if (num2 < 1 || num2 > 10)
            throw new CalculatorException.NumNotInRange(num2);

        //Проверка на режим работы с римскими цифрами и их обработка
        boolean modeRomeOperand1 = this.checkedOperandForRomeDigits(operand1);
        boolean modeRomeOperand2 = this.checkedOperandForRomeDigits(operand2);

        if (modeRomeOperand1 != modeRomeOperand2)
            throw new CalculatorException.UsedArabAndRomeDigitsTogether();
        else if (modeRomeOperand1 && modeRomeOperand2)
            this.modeRome = true;


        //Заполнение листа операндов
        try {
            this.operands.add(num1);
        }
        catch (NumberFormatException e){
            throw new CalculatorException.OperandNotValid(operand1);
        }

        try {
            this.operands.add(num2);
        }
        catch (NumberFormatException e){
            throw new CalculatorException.OperandNotValid(operand2);
        }

        //Проверка и определение математической операции
        this.mathOperation = determineMathOperation(operation);

        //если дошли до сюда и не вылетели, значит ввод данных верен
        this.inputValid = true;

    }

    private Boolean checkedOperandForRomeDigits(String operand){
        String s = operand.toUpperCase();
        char[] characters = s.toCharArray();
        try{
            for (int i = 0; i < characters.length; i++){
                RomanNumeral.valueOf(String.valueOf(characters[i]));
            }
        }
        catch (IllegalArgumentException e){
            return false;
        }
        return true;
    }

    private MathOperations determineMathOperation(String operation) throws CalculatorException{
        MathOperations[] arr = MathOperations.values();
        for (MathOperations mathOperations : arr) {
            if (mathOperations.getValue().equals(operation))
            return mathOperations;
        }
        throw new CalculatorException.MathematicalOperationNotValid();
    }

    private int castToInt(String operand) throws CalculatorException{
        try {
            return Integer.parseInt(operand);
        }
        catch (NumberFormatException e){
            return ConverterArabicRoman.romanToArabic(operand);
        }
    }


}
