package lesson16.homework;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(maxWord(null));
        System.out.println(minWord("rjhfdkfd sdfsd e3e33e3 dsf1 wdf4 sdfsdf"));
    }

    private static String maxWord(String input) {
        if (input==null || input=="")
            return null;
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        String[] result = validate(input);
        for (int j = 0; j < result.length; j++) {
            if (result[j] == null || result[j].isEmpty())
                continue;
            if (result[j].toCharArray().length > max) {
                max = result[j].length();
                maxIndex = j;
            }
        }
        return result[maxIndex];
    }

    private static String minWord(String input) {
        if (input==null || input=="")
            return null;
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        String[] result = validate(input);
        for (int j = 0; j < result.length; j++) {
            if (result[j] == null || result[j].isEmpty())
                continue;
            if (result[j].toCharArray().length < min) {
                min = result[j].length();
                minIndex = j;
            }
        }
        return result[minIndex];
    }

    private static String[] validate(String input){
        int k = 0;
        String[] array = input.trim().split(" ");
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null || array[i].isEmpty())
                continue;
            char[] mid = array[i].toCharArray();
            int counter = 0;
            for (char el1 : mid) {
                if (Character.isLetter(el1))
                    counter++;
            }
            if (counter == mid.length) {
                k++;
            }
        }
        k = 0;
        String[] result = new String[k];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null || array[i].isEmpty())
                continue;
            char[] mid = array[i].toCharArray();
            int counter = 0;
            for (char el1 : mid) {
                if (Character.isLetter(el1))
                    counter++;
            }
            if (counter == mid.length) {
                result[k] = array[i];
                k++;
            }
        }
        return result;
    }
}
