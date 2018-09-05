package lesson8.homework1;

public class Arithmetic {
    boolean check(int[] array){
        for (int indexTop = (array.length-1);indexTop>=0;indexTop--){
            for (int indexDown = 0; indexDown<indexTop;indexDown++){
                if (array[indexDown]>array[indexDown+1]){
                    int tmp = array[indexDown];
                    array[indexDown] = array[indexDown+1];
                    array[indexDown+1] = tmp;
                }
            }
        }
        return (array[0]+array[array.length-1])>100;
    }
}
