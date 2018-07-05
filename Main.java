package com.zeytin;


public class Main {


    public static void main(String[] args) {


        String cyperText = encryptString("This is some \"really\" great. (Text)!?", 2, 3);
        System.out.println(cyperText);
        System.out.println("********************************");
        String plainText = decryptString(cyperText, 2);
        System.out.println();
        System.out.println(plainText);

    }

    public static String normalizeText(String message) {
        //Removes all the spaces from your text
        message = message.replace(" ", "");

        //Remove any punctuation (. , : ; ? ? ! ? ( ) ),Turn all lower-case letters into upper-case letters
        message = message.replaceAll("[^a-zA-Z ]", "").toUpperCase();
        System.out.println(message);
        return message;
    }

    private static String caesarify(String encryption, int shiftValueOf) {
        /*
         * Convert @encryption to @encryptionArray
         * */
        char[] encryptionArray = encryption.toCharArray();

        String result;
        /*
         * Shift the letters*/
        if (shiftValueOf < 0) {
            for (int i = 0; i < encryption.length(); i++) {
                encryptionArray[i] += shiftValueOf;
                if (encryptionArray[i] < 'A') {
                    encryptionArray[i] = (char) ('Z' + 1 - ('A' - encryptionArray[i]));
                }
                System.out.print(encryptionArray[i]);
            }
            result = new String(encryptionArray);
            return result;
        } else {
            for (int i = 0; i < encryption.length(); i++) {
                encryptionArray[i] += shiftValueOf;
                if (encryptionArray[i] > 'Z') {
                    encryptionArray[i] = (char) ('A' - 1 + (encryptionArray[i] - 'Z'));
                }
                System.out.print(encryptionArray[i]);
            }
            System.out.println();
            result = new String(encryptionArray);
            return result;
        }
    }

    private static String groupify(String breakGroups, int numberOfLetters) {
        //find number of remaining letters
        int remaining = breakGroups.length() % numberOfLetters;
        //Add 'x' after remaining letter(s) to complete group
        if (remaining != 0) {
            for (int i = 0; i < (numberOfLetters - remaining); i++) {
                breakGroups += "x";
            }
        }
        String result = "";
        //Split desired groups

        for (int j = 0; j < breakGroups.length(); ) {
            result += breakGroups.substring(j, j + numberOfLetters) + " ";
            j += numberOfLetters;
        }
        return result;
    }

    public static String ungroupify(String removeSpace) {
        removeSpace = removeSpace.replaceAll(" ", "");
        removeSpace = removeSpace.replaceAll("x", "");
        return removeSpace;
    }

    private static String encryptString(String encrypted, int shiftValue, int groupSize) {
        String normalize = normalizeText(encrypted);
        String breakGroup = caesarify(normalize, shiftValue);
        return groupify(breakGroup, groupSize);

    }

    private static String decryptString(String decrypted, int shiftValue) {
        shiftValue *= -1;
        String text = ungroupify(decrypted);
        System.out.println(text);
        return caesarify(text, shiftValue);

    }


}
