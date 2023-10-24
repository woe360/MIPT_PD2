package com.example.mipt_pd2;

public class TextCounter {
    public static int countSymbols(String phrase){
        return phrase.length();
    }
    public static int countWords (String text) {
        return text.split("[ \\.,]+").length;
    }
}
