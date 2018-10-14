package lesson16.homework;

public class Solution {
    public static int countWords(String input){
        //65-122
        String[] array = input.split(" ");
        int counter = 0;
        int i = 0;
        for (String el:array){
            char[] mid = el.toCharArray();
            for (char el1:mid){
                if (Character.isLetter(el1))
                    i++;
            }
            if (i==mid.length)
                counter++;
        }
        return counter;
    }
}
