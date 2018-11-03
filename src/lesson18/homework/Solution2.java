package lesson18.homework;

import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findNumbers("123 s2d 12234 sdf 324")));
        System.out.println(Arrays.toString(findNumbers("      ")));
        System.out.println(Arrays.toString(findNumbers("   123 s2d 12234 sdf 324   ")));
        System.out.println(Arrays.toString(findNumbers("123 s2d 12234 sdf 324")));
    }

    private static int[] findNumbers(String text){
        String[] input = text.split(" ");
        int i = 0;
        for (String el : input){
            try {
                Integer.parseInt(el);
                i++;
            } catch (Exception e){

            }
        }
        int[] res = new int[i];
        i = 0;
        for (String el : input){
            try {
                res[i] = Integer.parseInt(el);
                i++;
            } catch (Exception e){
                System.out.println("not a number");
            }
        }
        return res;
    }
}
