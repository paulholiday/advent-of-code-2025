package org.paulholiday;



public class SafeDoor {


    public int turnDial(int currentDialPosition, String dialMovement) {
        DialDirection direction = DialDirection.RIGHT;
        if (dialMovement.startsWith("L")) {
            direction = DialDirection.LEFT;
        }

        int numberOfClicks = Integer.parseInt(dialMovement.substring(1));
        int newDialPosition = currentDialPosition;

        if (numberOfClicks > 100) {
            int difference = numberOfClicks - 100;
            if (difference > 100) {
                while (difference > 100) {
                    difference = difference - 100;
                }
            }

            numberOfClicks = difference;
        }

        if (direction == DialDirection.LEFT) {
            newDialPosition = currentDialPosition - numberOfClicks;
            if (newDialPosition < 0) {
                // plussing a minus
                newDialPosition = 100 + newDialPosition;
            }
        }  else if (direction == DialDirection.RIGHT) {
            newDialPosition = currentDialPosition + numberOfClicks;
            if (newDialPosition >= 100) {
                newDialPosition = newDialPosition - 100;
            }
        }
        else {
            System.out.println("Invalid dial direction");
        }

        return newDialPosition;
    }

}
