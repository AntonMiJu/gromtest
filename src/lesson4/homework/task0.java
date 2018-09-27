package lesson4.homework;

public class task0 {
    public static void main(String[] args) {
        short a = 1;
        short b = 10;
        System.out.println(findDivCount(a, b, 3));
    }

    public static int findDivCount(short a, short b, int n) {
        int count = 0;
        for (int i = a; i <= b; i++) {
            if (i % n == 0)
                count++;
        }
        return count;
    }
}
