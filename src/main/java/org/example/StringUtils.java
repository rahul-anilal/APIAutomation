package org.example;

public class StringUtils {
    public int countWords(String input) {
        return input.trim().split("\\s+").length; // ⚠️ Could throw NullPointerException
    }
}