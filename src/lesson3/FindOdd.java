package lesson3;

public class FindOdd {
    public static void main(String[] args) {
        int s = 0;
        for (int i = 0; i<=1000; i++){
            if (i%2==1){
                System.out.println("Found");
                s+=i;
            }
        }
        if (s*5>5000)
            System.out.println("Bigger");
        else
            System.out.println("Smaller or equal");
    }
}
