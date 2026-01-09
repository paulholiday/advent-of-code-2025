package org.paulholiday;

import java.util.List;

public class BatteryBank {

    public String getJoltage(String battery) {

        int batteryLength = battery.length();

        int firstDigit = Integer.parseInt(battery.substring(0,1));
        int secondDigit = Integer.parseInt(battery.substring(1,2));

        if (secondDigit > firstDigit) {
            firstDigit = secondDigit;
            secondDigit = 0;
        }

        for (int i = 2; i < batteryLength; i++) {
            int digit = Integer.parseInt(battery.substring(i,i + 1));
            if (digit > firstDigit && i != batteryLength - 1) {
                firstDigit = digit;
                secondDigit = 0;
            }
            else if (digit > secondDigit) {
                secondDigit = digit;
            }
        }

        return Integer.toString(firstDigit) + secondDigit;
    }
}
