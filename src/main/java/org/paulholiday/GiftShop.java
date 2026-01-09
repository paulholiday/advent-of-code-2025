package org.paulholiday;

import java.util.HashSet;
import java.util.Set;

public class GiftShop {

    public long getInvalidIDsTotal(String idRange) {

        String[] ids = idRange.split("-");
        String lastId = ids[1];

        long sumOfInvalidIDs = 0;

        long currentId = Long.parseLong(ids[0]);
        long finalId = Long.parseLong(lastId);

        String idToValidate;

        while (currentId <= finalId) {
            idToValidate = Long.toString(currentId);

            boolean foundInvalidID = false;

            if (idToValidate.length() % 7 == 0 && matchingSections(idToValidate, 7)) {
                sumOfInvalidIDs += currentId;
                foundInvalidID = true;
            }

            //divide by 5 then check matching fifths
            if (!foundInvalidID && idToValidate.length() % 5 == 0 && matchingSections(idToValidate, 5)) {
                sumOfInvalidIDs += currentId;
                foundInvalidID = true;
            }

            if (!foundInvalidID && idToValidate.length() % 4 == 0 && matchingSections(idToValidate, 4)) {
                sumOfInvalidIDs += currentId;
                foundInvalidID = true;
            }

            // divide by 3 then check matching thirds
            if (!foundInvalidID && idToValidate.length() % 3 == 0 && matchingSections(idToValidate, 3)) {
                sumOfInvalidIDs += currentId;
                foundInvalidID = true;
            }

            if (!foundInvalidID && idToValidate.length() % 2 == 0 && (matchingSections(idToValidate, 2) || allDigitsMatch(idToValidate))) {
                sumOfInvalidIDs += currentId;
            }

            currentId++;
        }

        return sumOfInvalidIDs;
    }

    private boolean allDigitsMatch(String id) {

        boolean digitsMatch = false;
        char[] chars = id.toCharArray();
        for (int i = 0; i < id.length() - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                digitsMatch = true;
            }
            else {
                digitsMatch = false;
                break;
            }
        }

        return digitsMatch;
    }

    private boolean matchingHalves(String id) {

        String firstHalf = id.substring(0, id.length()/2);
        String secondHalf = id.substring(id.length()/2);

        return firstHalf.equals(secondHalf);
    }

    private boolean matchingSections(String id, int numberOfSections) {
        int sectionLength = id.length()/numberOfSections;

        Set<String> sections = new HashSet<>();

        for (int i = 0; i < numberOfSections * sectionLength; i+=sectionLength) {
            sections.add(id.substring(i, i + sectionLength));
        }

        return sections.size() == 1;
    }

    private boolean matchingFifths(String id) {
        int fifthLength = id.length()/5;

        Set<String> fifths = new HashSet<>();

        for (int i = 0; i < fifthLength; i++) {
            fifths.add(id.substring(i * 5, (i + 1) * 5));
        }

        return fifths.size() == 1;
    }
}
