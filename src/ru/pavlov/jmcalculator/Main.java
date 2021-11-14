package ru.pavlov.jmcalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException, CalculatorException {
        //Ввод математического уравнения из двух операндов и одной матиматической операции
        System.out.println("Калькулятор.\nМожет работать с арабскими и римскими числами.");
        System.out.println("Введите математическое выражение в формате: операнд1 оператор операнд2;");
        System.out.println("Операнды должен быть целыми числами из диапазона [1..10];");
        System.out.println("Оператор может представлять одну из математических операций:\n" +
                "+ сложение\n" +
                "- вычитание\n" +
                "* умножение\n" +
                "/ деление без остатка\n");

        String input = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            input = reader.readLine();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        //Контроль ввода
        InputHandler inputHandler = new InputHandler(input);
        if (!inputHandler.isInputValid()) {
            return;
        }

        //Вычисление
        Calculation calculation = new Calculation(inputHandler.operands, inputHandler.mathOperation);
        int result = calculation.calculate();

        //Контроль вывода
        OutputHandler outputHandler = new OutputHandler(inputHandler.getModeRome(), result);
        if (!outputHandler.isOutputValid()) {
            return;
        }

        //Результат
        System.out.println("Результат: " + outputHandler.getResult());

    }

}
