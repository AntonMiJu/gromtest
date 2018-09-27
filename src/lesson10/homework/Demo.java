package lesson10.homework;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Customer customer = new Customer("Test", "Lviv", "Женский");

        ElectronicsOrder electronicsOrder = new ElectronicsOrder("iPhone", new Date(), "Киев", "Днепр", 1000, customer, 12);
        ElectronicsOrder testElectronicsCalculate = new ElectronicsOrder("iPhone", new Date(), "Киев", "Днепр", 900, customer, 12);
        ElectronicsOrder testElectronicsCity = new ElectronicsOrder("iPhone", new Date(), "Львов", "Днепр", 500, customer, 12);
        ElectronicsOrder testElectronicsPrice = new ElectronicsOrder("iPhone", new Date(), "Киев", "Днепр", 90, customer, 12);

        FurnitureOrder furnitureOrder = new FurnitureOrder("SofaBed", new Date(), "Киев", "Днепр", 6000, customer, "12312");
        FurnitureOrder testFurnitureCalculate = new FurnitureOrder("SofaBed", new Date(), "Киев", "Днепр", 4000, customer, "12312");
        FurnitureOrder testFurnitureCity = new FurnitureOrder("SofaBed", new Date(), "Днепр", "Днепр", 6000, customer, "12312");
        FurnitureOrder testFurniturePrice = new FurnitureOrder("SofaBed", new Date(), "Киев", "Днепр", 400, customer, "12312");

        //electronicsOrder

        //validate
        electronicsOrder.validateOrder();
        System.out.println(electronicsOrder.getDateConfirmed());
        testElectronicsCity.validateOrder();
        System.out.println(testElectronicsCity.getDateConfirmed());
        testElectronicsPrice.validateOrder();
        System.out.println(testElectronicsPrice.getDateConfirmed());
        System.out.println();

        //confirmShipping
        electronicsOrder.confirmShipping();
        System.out.println(electronicsOrder.getDateShipped());
        testElectronicsCity.validateOrder();
        System.out.println(testElectronicsCity.getDateShipped());
        testElectronicsPrice.validateOrder();
        System.out.println(testElectronicsPrice.getDateShipped());
        System.out.println();

        //calculatePrice
        electronicsOrder.calculatePrice();
        System.out.println(electronicsOrder.getTotalPrice());
        testElectronicsCity.calculatePrice();
        System.out.println(testElectronicsCity.getTotalPrice());

        testElectronicsCalculate.validateOrder();
        testElectronicsCalculate.confirmShipping();
        testElectronicsCalculate.calculatePrice();
        System.out.println(testElectronicsCalculate.getTotalPrice());
        System.out.println();


        //furnitureOrder

        //validate
        furnitureOrder.validateOrder();
        System.out.println(furnitureOrder.getDateConfirmed());
        testFurnitureCity.validateOrder();
        System.out.println(testFurnitureCity.getDateConfirmed());
        testFurniturePrice.validateOrder();
        System.out.println(testFurniturePrice.getDateConfirmed());
        System.out.println();

        //confirmShipping
        furnitureOrder.confirmShipping();
        System.out.println(furnitureOrder.getDateShipped());
        testFurnitureCity.confirmShipping();
        System.out.println(testFurnitureCity.getDateShipped());
        testFurniturePrice.confirmShipping();
        System.out.println(testFurniturePrice.getDateShipped());
        System.out.println();

        //calculatePrice
        furnitureOrder.calculatePrice();
        System.out.println(furnitureOrder.getTotalPrice());
        testFurnitureCity.calculatePrice();
        System.out.println(testFurnitureCity.getTotalPrice());

        testFurnitureCalculate.validateOrder();
        testFurnitureCalculate.confirmShipping();
        testFurnitureCalculate.calculatePrice();
        System.out.println(testFurnitureCalculate.getTotalPrice());
        System.out.println();
    }
}
