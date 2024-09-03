package checkers;

import repository.CalculatorConstants;

public class ValidatorService {

    public static void arabicValidator(int firstNumber, int secondNumber) {
        checkNumberAvailability(firstNumber, secondNumber);
    }

    public static void inputValidator(String[] elem) {
        checkOperatorsAvailability(elem[1]);
        checkOperationFormatAvailability(elem);
    }

    public static void romanValidator(int firstNumber, int secondNumber) {
        checkNumberAvailability(firstNumber, secondNumber);
    }

    private static void checkNumberAvailability(int firstNumber, int secondNumber) {
        if (firstNumber > 10 || firstNumber < 1 || secondNumber > 10 || secondNumber < 1) {
            throw new RuntimeException("Numbers must be from 1 to 10");
        }
    }

    public static void checkIfPositive(int result) {
        if (result < 1) {
            throw new RuntimeException("Romans must be positive");
        }
    }

    private static void checkOperationFormatAvailability(String[] elem) {
        if (elem.length != 3) {
            throw new RuntimeException("Operation must be: a + b");
        }
    }

    private static void checkOperatorsAvailability(String operator) {
        if (!CalculatorConstants.OPERATORS.contains(operator)) {
            throw new RuntimeException("Illegal operator");
        }
    }

    public static void checkRomanAvailability(String roman) {
        if (!CalculatorConstants.ROMANS.containsKey(roman)) {
            throw new RuntimeException("There is no such number in roman");
        }
    }
}
