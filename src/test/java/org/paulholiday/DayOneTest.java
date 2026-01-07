package org.paulholiday;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayOneTest {

    private SafeDoor safeDoor;
    private List<String> fileContents;

    @BeforeEach
    void setup() {
        Utils utils = new Utils();
        fileContents = utils.getFileContentsByLine("src/main/resources/DayOneInput.txt");
        safeDoor = new SafeDoor();
    }

    @Test
    public void testSafeDoorDialMovements() {

        int currentDialPosition = 50;
        currentDialPosition = safeDoor.turnDial(currentDialPosition, "L68");
//        System.out.println("Current dialPosition: " + currentDialPosition);
//        currentDialPosition = safeDoor.turnDial(50, "L168");
//        System.out.println("Current dialPosition: " + currentDialPosition);
//        currentDialPosition = safeDoor.turnDial(50, "L268");
//        System.out.println("Current dialPosition: " + currentDialPosition);

        currentDialPosition = safeDoor.turnDial(currentDialPosition, "L30");
        currentDialPosition = safeDoor.turnDial(currentDialPosition, "R48");
        currentDialPosition = safeDoor.turnDial(currentDialPosition, "L5");
        currentDialPosition = safeDoor.turnDial(currentDialPosition, "R60");
        currentDialPosition = safeDoor.turnDial(currentDialPosition, "L55");
        currentDialPosition = safeDoor.turnDial(currentDialPosition, "L1");
        currentDialPosition = safeDoor.turnDial(currentDialPosition, "L99");
        currentDialPosition = safeDoor.turnDial(currentDialPosition, "R14");
        currentDialPosition = safeDoor.turnDial(currentDialPosition, "L82");
        System.out.println("Current dialPosition: " + currentDialPosition);
        assertEquals(32, currentDialPosition);
    }

    @Test
    public void dayOneTest() {
        int currentDialPosition = 50;
        int zeroPositionCount = 0;
        for (String dialMovement : fileContents) {
            currentDialPosition = safeDoor.turnDial(currentDialPosition, dialMovement);
            if (currentDialPosition == 0) {
                zeroPositionCount++;
            }
        }

        System.out.println("zeroPositionCount: " + zeroPositionCount);

    }
}
