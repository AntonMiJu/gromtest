package lesson31.homework;

import java.util.HashMap;

public class MapMethods {

    public static HashMap<String, Integer> countSymbols(String text){
        if (text == null)
            return null;
        char[] chars = text.toCharArray();
        HashMap<String,Integer> result = new HashMap<>();
        for (char ch : chars){
            if ((ch != ' ') && Character.isLetter(ch) && !(result.containsKey(ch)))
                result.put(Character.toString(ch),countSymbolsByChar(ch,chars));
        }
        return result;
    }

    public static HashMap<String,Integer> words(String text){
        if (text == null)
            return null;
        String[] strings = text.split(" ");
        HashMap<String,Integer> result = new HashMap<>();
        for (String str : strings){
            if ((str != null) && !validate(str) && !(result.containsKey(str)))
                result.put(str,countWordsByString(str,strings));
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

    private static int countWordsByString(String word, String[] strings){
        int i = 0;
        for (String str : strings){
            if (word.equals(str))
                i++;
        }
        return i;
    }

    private static int countSymbolsByChar(char ch, char[] chars){
        int i = 0;
        for (char chs : chars){
            if (ch==chs)
                i++;
        }
        return i;
    }
}
