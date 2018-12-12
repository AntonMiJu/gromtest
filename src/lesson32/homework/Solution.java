package lesson32.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static int readNumbers(){
        int n = 3;
        int sum = 0;
        while (n>0) {
            try {
                InputStreamReader reader = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(reader);

                String[] strings = br.readLine().split(" ");
                Set<Integer> set = new HashSet<>();

                for (String str : strings) {
                    set.add(Integer.parseInt(str));
                }
                if (set.size()!= 10){
                    System.out.println("Your numbers are wrong. You have "+n+" attempts to try again");
                    n--;
                    continue;
                }
                for (int number : set){
                    if (!(number>=100)){
                        sum+=number;
                    } else {
                        System.out.println("Your numbers are wrong. You have "+n+" attempts to try again");
                        n--;
                        continue;
                    }
                }
                return sum;
            } catch (Exception e){
                System.out.println("Your numbers are wrong. You have "+n+" attempts to try again");
                n--;
                continue;
            }
        }
        if (n==0){
            System.out.println("Your numbers are wrong. Number of attempts exceeded");
        }
        return sum;
    }
}
