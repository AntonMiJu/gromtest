package gromcode.main.lesson18.homework;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findNumbers("123 s2d 12234 sdf 324")));
        System.out.println(Arrays.toString(findNumbers("      ")));
        System.out.println(Arrays.toString(findNumbers("   123 s2d 12234 sdf 324   ")));
        System.out.println(Arrays.toString(findNumbers("123 s2d 12234 sdf 324")));
    }

    private static int[] findNumbers(String text){
        String[] input = text.split(" ");
        int i = 0;
        for (String el: input) {
            if (isItNumber(el)){
                i++;
            }
        }
        int[] res = new int[i];
        i = 0;
        for (String el: input){
            if (isItNumber(el)){
                res[i] = Integer.parseInt(el);
                i++;
            } else
                System.out.println("not a number");
        }
        return res;
    }

    private static boolean isItNumber(String input){
        if (input.isEmpty())
            return false;
        for (char c : input.toCharArray()){
            if (!(Character.isDigit(c)))
                return false;
        }
        return true;
    }
}
