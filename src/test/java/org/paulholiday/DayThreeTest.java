package org.paulholiday;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayThreeTest {

    private BatteryBank batteryBank;
    private List<String> fileContents;

    @BeforeEach
    void setup() {
        Utils utils = new Utils();
        fileContents = utils.getFileContentsByLine("src/main/resources/DayThreeInput.txt");
        batteryBank = new BatteryBank();
    }

    @Test
    void testExampleInput() {

        assertEquals("98", batteryBank.getJoltage("987654321111111"));
        assertEquals("89", batteryBank.getJoltage("811111111111119"));
        assertEquals("78", batteryBank.getJoltage("234234234234278"));
        assertEquals("92", batteryBank.getJoltage("818181911112111"));
    }

    @Test
    void dayThreeTest() {

        int joltage = 0;

        for (String battery : fileContents) {
            joltage += Integer.parseInt(batteryBank.getJoltage(battery));
        }

        System.out.println("Joltage: " + joltage);
    }
}
