package org.paulholiday;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DayTwoTest {

    private GiftShop giftShop;
    private String[] idsArray;

    @BeforeEach
    void setup() {
        Utils utils = new Utils();
        List<String> fileContents = utils.getFileContentsByLine("src/main/resources/DayTwoInput.txt");
        idsArray = fileContents.get(0).split(",");
        giftShop = new GiftShop();
    }

    @Test
    void testInvalidIDs() {
        long invalidIDs = giftShop.getInvalidIDsTotal("11-22");
        assertEquals(2, invalidIDs);
        invalidIDs = giftShop.getInvalidIDsTotal("95-115");
        assertEquals(2, invalidIDs);
        invalidIDs = giftShop.getInvalidIDsTotal("998-1012");
        assertEquals(2, invalidIDs);
        invalidIDs = giftShop.getInvalidIDsTotal("1188511880-1188511890");
        assertEquals(1, invalidIDs);
        invalidIDs = giftShop.getInvalidIDsTotal("222220-222224");
        assertEquals(1, invalidIDs);
        invalidIDs = giftShop.getInvalidIDsTotal("1698522-1698528");
        assertEquals(0, invalidIDs);
        invalidIDs = giftShop.getInvalidIDsTotal("446443-446449");
        assertEquals(1, invalidIDs);
        invalidIDs = giftShop.getInvalidIDsTotal("38593856-38593862");
        assertEquals(1, invalidIDs);
        invalidIDs = giftShop.getInvalidIDsTotal("565653-565659");
        assertEquals(1, invalidIDs);
        invalidIDs = giftShop.getInvalidIDsTotal("824824821-824824827");
        assertEquals(1, invalidIDs);
        invalidIDs = giftShop.getInvalidIDsTotal("2121212118-2121212124");
        assertEquals(1, invalidIDs);
    }

    @Test
    void dayTwoTest() {

        long invalidIDsSum = 0;

        System.out.println("Number of id ranges: " + idsArray.length);

        for (String id : idsArray) {
            invalidIDsSum += giftShop.getInvalidIDsTotal(id);
        }

        System.out.println("DayTwoTest: invalidIDs: " + invalidIDsSum);
        assertEquals(30323879646L, invalidIDsSum);

    }

    @Test
    void dayTwoTestPart2() {

        long invalidIDsSum = 0;

        System.out.println("Number of id ranges: " + idsArray.length);

        for (String id : idsArray) {
            invalidIDsSum += giftShop.getInvalidIDsTotal(id);
        }

        System.out.println("DayTwoTest: invalidIDs: " + invalidIDsSum);
        assertTrue(invalidIDsSum > 43867719113L);
    }
}
