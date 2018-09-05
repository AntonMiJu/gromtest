package lesson2.Homework;

public class SumAndDivision {
    public static void main(String[] args) {
        int a = 1;
        int s = 0;

        while (a <= 1000) {
            s += a;
            a++;
        }

        int d = s / 1234;
        int m = s % 1234;

        System.out.println(m > d);
    }
}
