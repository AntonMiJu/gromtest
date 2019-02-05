package gromcode.main.lesson16.homework;

public class CountWords {
    public static void main(String[] args) {
        System.out.println(mostCountedWord("anyon f434 f434 mi"));
        System.out.println(mostCountedWord("           "));
    }

    private static String mostCountedWord(String input){
        if (input == null || input.isEmpty())
            return null;
        String[] array = validate(input);
        int max = 1;
        String result = null;
        for (int i = 0; i<array.length;i++){
            if (array[i] == null || array[i].isEmpty())
                continue;
            int counter = 1;
            for (int j = i+1; j<array.length;j++){
                if (array[i].equals(array[j])){
                    counter++;
                }
            }
            if (counter>=max){
                max = counter;
                result = array[i];
            }
        }
        return result;
    }

    private static String[] validate(String input){
        if (input == null || input.isEmpty())
            return null;
        int k = 0;
        String[] array = input.split(" ");
        for (String el : array) {
            if (el == null || el.isEmpty())
                continue;
            char[] mid = el.toCharArray();
            int counter = 0;
            for (char el1 : mid) {
                if (Character.isLetter(el1))
                    counter++;
            }
            if (counter == mid.length) {
                k++;
            }
        }
        String[] result = new String[k];
        k = 0;
        for (String el : array) {
            if (el == null || el.isEmpty())
                continue;
            char[] mid = el.toCharArray();
            int counter = 0;
            for (char el1 : mid) {
                if (Character.isLetter(el1))
                    counter++;
            }
            if (counter == mid.length) {
                result[k] = el;
                k++;
            }
        }
        return result;
    }
}
