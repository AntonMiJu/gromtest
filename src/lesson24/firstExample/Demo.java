package lesson24.firstExample;

public class Demo <T> {

    public static void main(String[] args) {
        calculatePrice(new FirstOrder());
        calculatePrice(new SecondOrder());
    }

    private static void calculatePrice(AbstractOrder abstractOrder){
        System.out.println(abstractOrder.getPrice());
    }

    public void print(T t){
        System.out.println(t);
    }
}
