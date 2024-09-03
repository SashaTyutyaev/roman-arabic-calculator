package checkers;

import repository.ConstantsRepository;

public class Checkers {

    public static void checkNumberAvailability(int firstNumber, int secondNumber) {
        if (firstNumber > 10 || firstNumber < 1 || secondNumber > 10 || secondNumber < 1) {
            throw new RuntimeException("Numbers must be from 1 to 10");
        }
    }

    public static void checkResultPositiveForRoman(int result) {
        if (result < 1) {
            throw new RuntimeException("Romans must be positive");
        }
    }

    public static void checkOperationFormatAvailability(String[] elem) {
        if (elem.length != 3) {
            throw new RuntimeException("Operation must be: a + b");
        }
    }

    public static void checkNumbersAreInteger(String input) {
        if (input.contains(".")) {
            throw new RuntimeException("Numbers must be integer");
        }
    }

    public static void checkOperatorsAvailability(String operator) {
        if (!ConstantsRepository.OPERATORS.contains(operator)) {
            throw new RuntimeException("Illegal operator");
        }
    }

    public static void checkRomanAvailability(String roman) {
        if (!ConstantsRepository.ROMANS.containsKey(roman)) {
            throw new RuntimeException("There is no such number in roman");
        }
    }
}
