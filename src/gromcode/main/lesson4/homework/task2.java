package gromcode.main.lesson4.homework;

public class task2 {
    public static void main(String[] args) {
        System.out.println(compareSums(5, 6, 3, 4));
        System.out.println(Integer.MAX_VALUE + 1);
    }

    public static long sum(int from, int to) {
        long s = 0;
        for (long i = from; i <= to; i++) {
            s += i;
        }
        return s;
    }

    public static boolean compareSums(int a, int b, int c, int d) {
        return sum(a, b) > sum(c, d);
    }
}
