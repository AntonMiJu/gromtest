package lesson16.homework;

public class Solution2 {
    String maxWord(String input){
        int max = 0;
        int maxIndex = 0;
        int k = 0;
        String[] array = input.split(" ");
        String[] result = new String[array.length];
        for (int i = 0; i<array.length;i++){
            if (array[i]==null || array[i].isEmpty())
                continue;
            int counter = 0;
            char[] mid = array[i].toCharArray();
            for (char el1:mid){
                if (Character.isLetter(el1))
                    i++;
            }
            if (i==mid.length){
                result[k] = array[i];
                k++;
            }
        }
        for (int j = 0; j<result.length;j++){
            if (result[j]==null || result[j].isEmpty())
                continue;
            if (result[j].getBytes().length>max) {
                max = result[j].toCharArray().length;
                maxIndex = j;
            }
        }
        return result[maxIndex];
    }

    String minWord(String input){
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        int k = 0;
        String[] array = input.split(" ");
        String[] result = new String[array.length];
        for (int i = 0; i<array.length;i++){
            if (array[i]==null || array[i].isEmpty())
                continue;
            int counter = 0;
            char[] mid = array[i].toCharArray();
            for (char el1:mid){
                if (Character.isLetter(el1))
                    i++;
            }
            if (i==mid.length){
                result[k] = array[i];
                k++;
            }
        }
        for (int j = 0; j<result.length;j++){
            if (result[j]==null || result[j].isEmpty())
                continue;
            if (result[j].getBytes().length<min) {
                min = result[j].toCharArray().length;
                minIndex = j;
            }
        }
        return result[minIndex];
    }
}
