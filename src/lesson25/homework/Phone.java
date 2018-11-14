package lesson25.homework;

public class Phone {
    private int price;
    private int garanty;

    public Phone(int price, int garanty) {
        this.price = price;
        this.garanty = garanty;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "price=" + price +
                ", garanty=" + garanty +
                '}';
    }
}
