package com.mycompany.app;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnergyCalculatorTest {
    @ParameterizedTest
    @CsvFileSource(resources= "testCases.csv", numLinesToSkip=1)
    public void test_in_range(double testCase, double kwh, boolean hasSmartDevice, boolean peakOptOut,
                              double expected) {
        EnergyCalculator energyCalculator = new EnergyCalculator();
        assertEquals(expected,
                energyCalculator.calculateRebate(kwh, hasSmartDevice, peakOptOut), 0.00001,
                "Test Case " + testCase + " Failed.");
    }
}
