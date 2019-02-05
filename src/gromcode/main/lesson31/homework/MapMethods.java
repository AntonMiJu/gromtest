package gromcode.main.lesson31.homework;

import java.util.HashMap;

public class MapMethods {

    public static HashMap<Character, Integer> countSymbols(String text){
        HashMap<Character,Integer> result = new HashMap<>();
        for (char ch : text.toCharArray()){
            if (Character.isLetter(ch))
                result.put(ch, result.get(ch) == null ? 1 : result.get(ch) + 1);
        }
        return result;
    }

    public static HashMap<String,Integer> words(String text){
        HashMap<String,Integer> result = new HashMap<>();
        for (String str : text.split(" ")){
            if (!validate(str))
                result.put(str, result.get(str) == null ? 1 : result.get(str)+1);
        }
        return result;
    }

    private static boolean validate(String word){
        char[] chars = word.toCharArray();
        for (char ch : chars){
            if ((ch != ' ') && !Character.isLetter(ch))
                return true;
        }
        if (word.length()>2)
            return false;
        return true;
    }
}
