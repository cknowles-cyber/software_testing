package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class StayPriceTest {
    @ParameterizedTest
    @CsvFileSource(resources= "TestCasesInRange.csv", numLinesToSkip=1)
    public void test_in_range(double testCase, int nights, int guestAge, boolean isArkansasResident,
                              boolean hasVeteranDiscount, int expected) {
        StayPrice stayPrice = new StayPrice();
        assertEquals(expected,
                stayPrice.inRange(nights, guestAge, isArkansasResident, hasVeteranDiscount),
                "Test Case " + testCase + " Failed.");
    }
}
