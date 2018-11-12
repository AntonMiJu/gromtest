package lesson22.arrays;

public class ArrayUtils {

    public static int maxElement(int[] array) {
        int max = array[0];

        for (int el : array) {
            if (el > max)
                max = el;
        }
        return max;
    }

    public static int nCount(int[] array, int n) {
        int count = 0;

        for (int el : array) {
            if (el == n)
                count++;
        }
        return count;
    }

    public static int[] sortAscending(int[] array) {
        for (int indexTop = (array.length - 1); indexTop >= 0; indexTop--) {
            for (int indexDown = 0; indexDown < indexTop; indexDown++) {
                if (array[indexDown] > array[indexDown + 1]) {
                    int tmp = array[indexDown];
                    array[indexDown] = array[indexDown + 1];
                    array[indexDown + 1] = tmp;
                }
            }
        }
        return array;
    }

    public static int[] sortDescending(int[] array) {
        for (int indexTop = (array.length - 1); indexTop >= 0; indexTop--) {
            for (int indexDown = 0; indexDown < indexTop; indexDown++) {
                if (array[indexDown] < array[indexDown + 1]) {
                    int tmp = array[indexDown];
                    array[indexDown] = array[indexDown + 1];
                    array[indexDown + 1] = tmp;
                }
            }
        }
        return array;
    }
}
