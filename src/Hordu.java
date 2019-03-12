public class Hordu {
    private static double a = 3;
    private static double b = 4;
    private static double eps = 0.0001;

    public static void main(String[] args) {
        if (f(a) * f(b) < 0)
            proc();
        else
            System.out.println("Коренів немає");
    }

    public static void proc() {
        double c;
        c = (f(b) * a - f(a) * b) / (f(b) - f(a));
        while (Math.abs(f(c)) >= eps) {
            c = (f(b) * a - f(a) * b) / (f(b) - f(a));
            if (f(a) * f(c) > 0)
                a = c;
            else
                b = c;
        }
        System.out.println("x=" + c);
    }

    public static double f(double x) {
        return Math.pow(x, 3) - 3 * Math.pow(x, 2) - 3.5;
    }
}