package lesson8.homework1;

public class Demo {
    public static void main(String[] args) {
        Adder adder = new Adder();
        int[] array = {5,3,2,8,1,9,5,99};
        int a = 5;
        int b = 2;
        adder.check(array);
        adder.add(a ,b);
    }
}
