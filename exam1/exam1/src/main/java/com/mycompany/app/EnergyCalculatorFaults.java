package com.mycompany.app;

public class EnergyCalculatorFaults {
    public double calculateRebate(double kwh, boolean hasSmartDevice, boolean peakOptOut) {
        if (kwh <= 0) {
            throw new IllegalArgumentException("Usage must be positive.");
        }

        double rebatePercent = 0.0;

        if (kwh >= 500 && kwh <= 1500) { // Fault for BVA, 500 gets caught
            if (hasSmartDevice && peakOptOut) {
                rebatePercent = 0.30; // Fault for EQ, should be 0.15
            } else if (hasSmartDevice || peakOptOut) {
                rebatePercent = 0.00; // Fault for decision table, should be 0.10
            }
        } else if (kwh > 1500) {
            if (!hasSmartDevice && !peakOptOut) {
                rebatePercent = 0.07; // Fault caught by Branch Coverage due to logic flaw
            }
            if (hasSmartDevice && peakOptOut) {
                rebatePercent = 0.20;
            } else {
                rebatePercent = 0.05;
            }
        }

        if (kwh > 2500) { // Fault caught by Code Coverage, should not be tested
            rebatePercent = .75;
        }

        return rebatePercent;
    }
}