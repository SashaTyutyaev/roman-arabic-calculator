package converter;

import checkers.Checkers;
import repository.ConstantsRepository;

import java.util.Map;

public class Converter {

    public static Integer romanToArabic(String input) {
        String roman = input.toUpperCase();
        int result = 0;

        if (roman.length() >= 2 && roman.startsWith("I")
                && roman.chars().filter(ch -> ch == 'I').count() == 1) {
            Checkers.checkRomanAvailability(roman);
            result = ConstantsRepository.ROMANS.get(roman);
        } else {
            int i = 0;
            while (i < roman.length()) {
                Checkers.checkRomanAvailability(String.valueOf(roman.charAt(i)));
                result += ConstantsRepository.ROMANS.get(String.valueOf(roman.charAt(i)));
                i++;
            }
        }
        return result;
    }

    public static String arabicToRoman(Integer number) {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, Integer> entry : ConstantsRepository.ROMANS.entrySet()) {
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
