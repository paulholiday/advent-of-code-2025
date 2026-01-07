package org.paulholiday;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DialContext {
    private int currentDialPosition;
    private int numberOfZeroTraversals;
}
