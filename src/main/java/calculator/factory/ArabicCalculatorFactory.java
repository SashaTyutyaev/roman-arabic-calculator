package calculator.factory;

import calculator.Calculator;
import calculator.impl.ArabicCalculator;

public class ArabicCalculatorFactory implements CalculatorFactory {

    @Override
    public Calculator createCalculator() {
        return new ArabicCalculator();
    }
}
