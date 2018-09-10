package lesson10.homework;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Customer customer = new Customer("Test","Lviv","Женский");
        ElectronicsOrder electronicsOrder = new ElectronicsOrder("iPhone",new Date(),"Киев","Днепр",1000,customer,12);
        FurnitureOrder furnitureOrder = new FurnitureOrder("SofaBed",new Date(),"Киев","Днепр",6000,customer,"12312");

        electronicsOrder.validateOrder();
        electronicsOrder.confirmShipping();
        electronicsOrder.calculatePrice();

        furnitureOrder.validateOrder();
        furnitureOrder.confirmShipping();
        furnitureOrder.calculatePrice();
    }
}
