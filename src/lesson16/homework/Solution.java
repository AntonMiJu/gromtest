package lesson16.homework;

public class Solution {
    public static void main(String[] args) {
        System.out.println(countWords("a1sf anton mi cosi dfsdg!s"));
    }

    public static int countWords(String input){
        //65-122
        if (input==null)
            return 0;
        String[] array = input.split(" ");
        int counter = 0;
        int i = 0;
        for (String el:array){
            i = 0;
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
