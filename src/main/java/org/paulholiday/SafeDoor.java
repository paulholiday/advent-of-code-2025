package org.paulholiday;



public class SafeDoor {

    public DialContext turnDial(DialContext currentDialContext, String dialMovement) {
        DialDirection direction = DialDirection.RIGHT;
        if (dialMovement.startsWith("L")) {
            direction = DialDirection.LEFT;
        }

        int numberOfClicks = Integer.parseInt(dialMovement.substring(1));
        int newDialPosition = currentDialContext.getCurrentDialPosition();
        int numberOfZeroTraversals = currentDialContext.getNumberOfZeroTraversals();

        if (numberOfClicks > 100) {
            int difference = numberOfClicks - 100;
            numberOfZeroTraversals++;
            if (difference > 100) {
                while (difference > 100) {
                    difference = difference - 100;
                    numberOfZeroTraversals++;
                }
            }

            numberOfClicks = difference;
        }

        if (direction == DialDirection.LEFT) {
            newDialPosition = currentDialContext.getCurrentDialPosition() - numberOfClicks;
            if (newDialPosition < 0) {
                // plussing a minus
                newDialPosition = 100 + newDialPosition;
                if (currentDialContext.getCurrentDialPosition() != 0) {
                    numberOfZeroTraversals++;
                }
            }
        } else if (direction == DialDirection.RIGHT) {
            newDialPosition = currentDialContext.getCurrentDialPosition() + numberOfClicks;
            if (newDialPosition > 100) {
                newDialPosition = newDialPosition - 100;
                numberOfZeroTraversals++;
            } else if (newDialPosition == 100) {
                newDialPosition = 0;
                // no zero traversals
            }
        }
        else {
            System.out.println("Invalid dial direction");
        }

        return DialContext.builder().currentDialPosition(newDialPosition).numberOfZeroTraversals(numberOfZeroTraversals).build();
    }

}
