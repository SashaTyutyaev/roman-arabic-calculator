package calculator.impl;

import calculator.Calculator;
import validators.CalculatorValidatorService;

import static calculator.CalculatorService.getResult;

public class ArabicCalculator implements Calculator {
    @Override
    public String calculate(String firstNumber, String operator, String secondNumber) {
        try {
            int firstArabic = Integer.parseInt(firstNumber);
            int secondArabic = Integer.parseInt(secondNumber);

            CalculatorValidatorService.arabicValidator(firstArabic, secondArabic);

            return String.valueOf(getResult(operator, firstArabic, secondArabic));
        } catch (NumberFormatException e) {
            throw new RuntimeException("Numbers must be arabic");
        }
    }
}
