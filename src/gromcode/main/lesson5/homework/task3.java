package gromcode.main.lesson5.homework;

public class task3 {
    static int uniqueCount(int[] array) {
        for (int indexTop = (array.length - 1); indexTop >= 0; indexTop--) {
            for (int indexDown = 0; indexDown < indexTop; indexDown++) {
                if (array[indexDown] > array[indexDown + 1]) {
                    int tmp = array[indexDown];
                    array[indexDown] = array[indexDown + 1];
                    array[indexDown + 1] = tmp;
                }
            }
        }
        int count = 0;
        for (int index = 0; index < array.length - 1; index++) {
            if (array[index] != array[index + 1])
                count++;

        }
        count++;
        return count;
    }
}
