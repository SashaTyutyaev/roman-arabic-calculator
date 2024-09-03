package calculator;

import checkers.Checkers;
import converter.Converter;

public class Calculator {

    public String calculate(String input, Boolean isArabic) {
        Checkers.checkNumbersAreInteger(input);

        String[] elem = input.split(" ");

        String firstNumber = elem[0];
        String operator = elem[1];
        String secondNumber = elem[2];

        Checkers.checkOperatorsAvailability(operator);
        Checkers.checkOperationFormatAvailability(elem);

        String result;

        if (isArabic) {
            result = calculateArabic(firstNumber, operator, secondNumber);
        } else {
            result = calculateRoman(firstNumber, operator, secondNumber);
        }

        return result;
    }

    public String calculateRoman(String firstNumber, String operator, String secondNumber) {
        int firstArabic = Converter.romanToArabic(firstNumber);
        int secondArabic = Converter.romanToArabic(secondNumber);

        Checkers.checkNumberAvailability(firstArabic, secondArabic);

        int result = getResult(operator, firstArabic, secondArabic);

        Checkers.checkResultPositiveForRoman(result);

        return Converter.arabicToRoman(result);
    }

    public String calculateArabic(String firstNumber, String operator, String secondNumber) {
        try {
            int firstArabic = Integer.parseInt(firstNumber);
            int secondArabic = Integer.parseInt(secondNumber);

            Checkers.checkNumberAvailability(firstArabic, secondArabic);

            return String.valueOf(getResult(operator, firstArabic, secondArabic));
        } catch (NumberFormatException e) {
            throw new RuntimeException("Numbers must be arabic");
        }
    }

    private static int getResult(String operand, int firstArabic, int secondArabic) {
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
