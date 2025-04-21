package org.example;

public class NumberParser {
    public int parse(String input) {
        return Integer.parseInt(input); // ⚠️ Could throw NullPointerException or NumberFormatException
    }

    //Possible Alternate Code
//    public int parse(String input) {
//        if (input == null) {
//            throw new NullPointerException("Input cannot be null");
//        }
//
//        if (input.isEmpty()) {
//            throw new NumberFormatException("Input cannot be an empty string");
//        }
//
//        try {
//            return Integer.parseInt(input);
//        } catch (NumberFormatException e) {
//            throw new NumberFormatException("Invalid input string for parsing to an integer: " + input);
//        }
//    }
}