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
        DialContext dialContext = DialContext.builder().currentDialPosition(currentDialPosition).numberOfZeroTraversals(0).build();
//        dialContext = safeDoor.turnDial(dialContext, "R1000");
        dialContext = safeDoor.turnDial(dialContext, "L68");
//        System.out.println("Current dialPosition: " + dialContext.getCurrentDialPosition());
//        dialContext = safeDoor.turnDial(dialContext, "L168");
//        System.out.println("Current dialPosition: " + dialContext.getCurrentDialPosition());
//        dialContext = safeDoor.turnDial(dialContext, "L268");
//        System.out.println("Current dialPosition: " + dialContext.getCurrentDialPosition());


        dialContext = safeDoor.turnDial(dialContext, "L30");
        dialContext = safeDoor.turnDial(dialContext, "R48");
        dialContext = safeDoor.turnDial(dialContext, "L5");
        dialContext = safeDoor.turnDial(dialContext, "R60");
        dialContext = safeDoor.turnDial(dialContext, "L55");
        dialContext = safeDoor.turnDial(dialContext, "L1");
        dialContext = safeDoor.turnDial(dialContext, "L99");
        dialContext = safeDoor.turnDial(dialContext, "R14");
        dialContext = safeDoor.turnDial(dialContext, "L82");

        assertEquals(32, dialContext.getCurrentDialPosition());
    }

    @Test
    public void dayOneTest() {
        int currentDialPosition = 50;
        int zeroPositionCount = 0;
        DialContext dialContext = DialContext.builder().currentDialPosition(currentDialPosition).numberOfZeroTraversals(0).build();
        for (String dialMovement : fileContents) {
            dialContext = safeDoor.turnDial(dialContext, dialMovement);
            if (dialContext.getCurrentDialPosition() == 0) {
                zeroPositionCount++;
            }
        }

        System.out.println("zeroPositionCount: " + zeroPositionCount);
        System.out.println("numberOfZeroTraversals: " + dialContext.getNumberOfZeroTraversals());
        assertEquals(1150, zeroPositionCount);
        assertEquals(6738, dialContext.getNumberOfZeroTraversals() + zeroPositionCount);
    }
}
