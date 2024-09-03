package calculator.factory;

import calculator.Calculator;
import calculator.impl.RomanCalculator;

public class RomanCalculatorFactory implements CalculatorFactory {

    @Override
    public Calculator createCalculator() {
        return new RomanCalculator();
    }
}
