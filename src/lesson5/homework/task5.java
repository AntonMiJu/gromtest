package homework;

import java.util.Arrays;

public class task5 {

    static int[] sortAscending(int[] array){
        for (int indexTop = (array.length-1);indexTop>=0;indexTop--){
            for (int indexDown = 0; indexDown<indexTop;indexDown++){
                if (array[indexDown]>array[indexDown+1]){
                    int tmp = array[indexDown];
                    array[indexDown] = array[indexDown+1];
                    array[indexDown+1] = tmp;
                }
            }
        }
        return array;
    }

    static int[] sortDescending(int[] array){
        for (int indexTop = (array.length-1);indexTop>=0;indexTop--){
            for (int indexDown = 0; indexDown<indexTop;indexDown++){
                if (array[indexDown]<array[indexDown+1]){
                    int tmp = array[indexDown];
                    array[indexDown] = array[indexDown+1];
                    array[indexDown+1] = tmp;
                }
            }
        }
        return array;
    }
}
