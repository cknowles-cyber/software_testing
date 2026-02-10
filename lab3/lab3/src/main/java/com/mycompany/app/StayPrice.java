package com.mycompany.app;

public class StayPrice {
    int inRange(int nights, int guestAge, boolean isArkansasResident, boolean hasVeteranDiscount) {
        int total = 0;

        if (guestAge < 0) {
            return 0;
        }
        if (nights < 1) {
            return 0;
        }
        if (nights > 14) {
            return 0;
        }

        total = nights * 50;

        if (guestAge <= 12) {
            total = total / 2;
        }
        else if (guestAge >= 65) {
            total = total * 4 / 5;
        }

        if (isArkansasResident && hasVeteranDiscount) {
            total = total - 10;
            total = total * 9 / 10;
        }
        else if (isArkansasResident) {
            total = total - 10;
        }
        else if (hasVeteranDiscount) {
            total = total * 9 / 10;
        }
        return total;
    }
}
