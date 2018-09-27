package lesson7;

import lesson6.homework.Order;

import java.util.Date;

public class DemoHomeWork {
    Order createOrder() {
        Date tmp = new Date();
        Order order = new Order(100, tmp, false, null, "Dnepr", "Ukraine", "Buy");
        return order;
    }

    Order createOrderAndCallMethods() {
        Date tmp = new Date();
        Order order = new Order(100, tmp, false, null, "Kiev", "Ukraine", "SomeValue");
        order.confirmOrder();
        order.isValidType();
        order.checkPrice();
        return order;
    }

}
