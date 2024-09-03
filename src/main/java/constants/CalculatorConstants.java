package constants;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CalculatorConstants {

    public static final Map<String, Integer> ROMANS;

    static {
        ROMANS = new LinkedHashMap<>();
        ROMANS.put("C", 100);
        ROMANS.put("XC", 90);
        ROMANS.put("L", 50);
        ROMANS.put("XL", 40);
        ROMANS.put("X", 10);
        ROMANS.put("IX", 9);
        ROMANS.put("V", 5);
        ROMANS.put("IV", 4);
        ROMANS.put("I", 1);
    }

    public static final List<String> OPERATORS = List.of("+", "-", "/", "*");
}
