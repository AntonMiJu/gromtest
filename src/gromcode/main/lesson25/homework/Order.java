package gromcode.main.lesson25.homework;

public class Order {
    private String name;
    private int price;

    public Order(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
