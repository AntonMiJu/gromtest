package lesson27.homework1;

import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        useList();
    }

    public static LinkedList<Order> useList(){
        LinkedList<Order> linkedList = new LinkedList<>();
        Order order1 = new Order(1,3500,"USD","Mac","sdf");
        Order order2 = new Order(2,4500,"UAH","Macbook","sdfwd");
        Order order3 = new Order(3,500,"USD","Mac mini","sdsadf");
        Order order4 = new Order(4,1500,"EUR","Mac pro ","sdasfcf");
        Order order5 = new Order(5,5500,"USD","Mac","sdfdshdsfv4");

        linkedList.add(order1);//1
        linkedList.add(0,order2);//2
        linkedList.remove(1);//3
        linkedList.remove(order2);//4
        linkedList.add(order1);
        linkedList.add(1,order3);
        linkedList.add(order4);
        linkedList.add(order3);
        linkedList.set(2,order2);//5
        linkedList.add(order5);
        linkedList.add(order2);
        Object[] objects = new Order[linkedList.size()];
        objects = linkedList.toArray();//6
        linkedList.contains(order1);//7
        LinkedList<Order> linkedList1 = new LinkedList<>();
        linkedList1.addAll(linkedList.subList(1,3));//8
        linkedList1.addAll(linkedList);//9
        linkedList.clear();//10

        LinkedList<Order> result = new LinkedList<>();
        result.add(order1);
        result.add(order4);
        result.add(order3);
        result.add(order5);
        result.add(order2);
        System.out.println(result.toString());
        return result;
    }
}
