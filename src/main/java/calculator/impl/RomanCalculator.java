package calculator.impl;

import calculator.Calculator;
import validators.CalculatorValidatorService;
import converter.Converter;

import static calculator.CalculatorService.getResult;

public class RomanCalculator implements Calculator {

    @Override
    public String calculate(String firstNumber, String operator, String secondNumber) {
        int firstArabic = Converter.romanToArabic(firstNumber);
        int secondArabic = Converter.romanToArabic(secondNumber);

        CalculatorValidatorService.romanValidator(firstArabic, secondArabic);

        int result = getResult(operator, firstArabic, secondArabic);

        return Converter.arabicToRoman(result);
    }
}
