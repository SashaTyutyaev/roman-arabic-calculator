package converter;

import checkers.ValidatorService;
import constants.CalculatorConstants;

import java.util.Map;

public class Converter {

    public static Integer romanToArabic(String input) {
        String roman = input.toUpperCase();
        int result = 0;

        if (roman.length() >= 2 && roman.startsWith("I")
                && roman.chars().filter(ch -> ch == 'I').count() == 1) {
            ValidatorService.checkRomanAvailability(roman);
            result = CalculatorConstants.ROMANS.get(roman);
        } else {
            int i = 0;
            while (i < roman.length()) {
                ValidatorService.checkRomanAvailability(String.valueOf(roman.charAt(i)));
                result += CalculatorConstants.ROMANS.get(String.valueOf(roman.charAt(i)));
                i++;
            }
        }
        return result;
    }

    public static String arabicToRoman(Integer number) {
        ValidatorService.checkIfPositive(number);
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, Integer> entry : CalculatorConstants.ROMANS.entrySet()) {
            String roman = entry.getKey();
            Integer arabic = entry.getValue();

            if (number >= arabic) {
                sb.append(roman);
                number -= arabic;
            }
        }
        return sb.toString();
    }
}
