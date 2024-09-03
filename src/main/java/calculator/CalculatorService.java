package calculator;

import calculator.factory.ArabicCalculatorFactory;
import calculator.factory.CalculatorFactory;
import calculator.factory.RomanCalculatorFactory;
import checkers.ValidatorService;

public class CalculatorService {

    public String calculate(String input, Boolean isArabic) {
        String[] elem = input.split(" ");

        String firstNumber = elem[0];
        String operator = elem[1];
        String secondNumber = elem[2];

        ValidatorService.inputValidator(elem);

        CalculatorFactory calculatorFactory;

        if (isArabic) {
            calculatorFactory = new ArabicCalculatorFactory();
        } else {
            calculatorFactory = new RomanCalculatorFactory();
        }

        return calculatorFactory.createCalculator().calculate(firstNumber, operator, secondNumber);
    }

    public static int getResult(String operand, int firstArabic, int secondArabic) {
        int result = 0;

        switch (operand) {
            case "+":
                result = firstArabic + secondArabic;
                break;
            case "-":
                result = firstArabic - secondArabic;
                break;
            case "*":
                result = firstArabic * secondArabic;
                break;
            case "/":
                result = firstArabic / secondArabic;
        }

        return result;
    }

}
