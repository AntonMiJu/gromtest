package lesson16.homework;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(countWords("      sdsdsd      "));
        System.out.println(countWords(null));
        System.out.println(countWords("      sdsdsd      dsgsds"));

        System.out.println(maxWord("anton mi mi 342fdefse 23rfdc asfsdfdsfsdfsd"));
        System.out.println(maxWord("           "));
        System.out.println(maxWord(null));
        System.out.println(maxWord("     sdfsdfsd    dsfsdfsdf"));

        System.out.println(minWord("anton mi mi 342fdefse 23rfdc asfsdfdsfsdfsd"));
        System.out.println(minWord("           "));
        System.out.println(minWord(null));
        System.out.println(minWord("     sdfsdfsd    dsfsdfsdf"));

        System.out.println(mostCountedWord("      "));
        System.out.println(mostCountedWord(null));
        System.out.println(mostCountedWord("asdasd mi s432ed s432ed mi"));
        System.out.println(mostCountedWord("     asdasd      mi s432ed s432ed mi    asdasd asdasd"));
    }

    public static int countWords(String input) {
        if (input==null)
            return 0;
        String[] array = input.trim().split(" ");
        int counter = 0;
        for (String el : array) {
            if (el.equals(""))
                continue;
            if (checkLetter(el))
                counter++;
        }
        return counter;
    }

    public static String maxWord(String input){
        if (input==null)
            return null;
        int max = 0;
        String str = "";
        String[] array = filtrate(input);
        for (String el : array){
            if (el.length()>max){
                str = el;
                max = el.length();
            }
        }
        if (str.isEmpty())
            return null;
        return str;
    }

    public static String minWord(String input){
        if (input==null)
            return null;
        int min = Integer.MAX_VALUE;
        String str = "";
        String[] array = filtrate(input);
        for (String el : array){
            if (!(el.equals("")) && el.toCharArray().length<min){
                str = el;
                min = el.length();
            }
        }
        if (str.isEmpty())
            return null;
        return str;
    }

    private static String mostCountedWord(String input){
        if (input==null)
            return null;
        String[] array = filtrate(input);
        String result = null;
        int max = 1;
        for (String el : array){
            int counter = 1;
            for (int j = 1; j<array.length;j++){
                if (!(el.equals("")) && el.equals(array[j]))
                    counter++;
            }
            if (counter>max){
                max = counter;
                result = el;
            }
        }
        if (max == 1)
            return null;
        return result;
    }

    private static String[] filtrate(String input){
        int k = 0;
        String[] array = input.trim().split(" ");
        for (String el:array){
            if (checkLetter(el)){
                k++;
            }
        }
        String[] result = new String[k];
        k = 0;
        for (String el:array){
            if (checkLetter(el)){
                result[k] = el;
                k++;
            }
        }
        return result;
    }

    private static boolean checkLetter(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isLetter(c))
                return false;
        }
        return true;
    }
}
