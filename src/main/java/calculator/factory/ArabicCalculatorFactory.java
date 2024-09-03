package calculator.factory;

import calculator.impl.ArabicCalculator;
import calculator.Calculator;

public class ArabicCalculatorFactory implements CalculatorFactory {

    @Override
    public Calculator createCalculator() {
        return new ArabicCalculator();
    }
}
