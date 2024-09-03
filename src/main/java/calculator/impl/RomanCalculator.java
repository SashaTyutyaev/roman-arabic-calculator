package calculator.impl;

import calculator.Calculator;
import checkers.ValidatorService;
import converter.Converter;

import static calculator.CalculatorService.getResult;

public class RomanCalculator implements Calculator {

    @Override
    public String calculate(String firstNumber, String operator, String secondNumber) {
        int firstArabic = Converter.romanToArabic(firstNumber);
        int secondArabic = Converter.romanToArabic(secondNumber);

        ValidatorService.romanValidator(firstArabic, secondArabic);

        int result = getResult(operator, firstArabic, secondArabic);

        return Converter.arabicToRoman(result);
    }
}
