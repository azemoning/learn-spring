package com.company;

public class Task2 {
    public String reverseText(String text) {
        char[] split = text.toCharArray();
        String reverseText = "";

        for (int i = split.length - 1; i >= 0; i--) {
            reverseText += split[i];
        }

        return reverseText;
    }
}
