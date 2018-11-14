package lesson26.homework;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        useList();
    }

    public static ArrayList<Order> useList(){
        ArrayList<Order> arrayList = new ArrayList<>();
        Order order1 = new Order(1,3500,"USD","Mac","sdf");
        Order order2 = new Order(2,4500,"UAH","Macbook","sdfwd");
        Order order3 = new Order(3,500,"USD","Mac mini","sdsadf");
        Order order4 = new Order(4,1500,"EUR","Mac pro ","sdasfcf");
        Order order5 = new Order(5,5500,"USD","Mac","sdfdshdsfv4");

        arrayList.add(order1);//1
        arrayList.add(0,order2);//2
        arrayList.remove(1);//3
        arrayList.remove(order2);//4
        arrayList.add(order1);
        arrayList.add(1,order3);
        arrayList.add(order4);
        arrayList.add(order3);
        arrayList.set(2,order2);//5
        arrayList.add(order5);
        arrayList.add(order2);
        arrayList.toArray();//6
        arrayList.contains(order1);//7
        ArrayList<Order> arrayList1 = new ArrayList<>();
        arrayList.subList(1,3);//8
        arrayList1.addAll(arrayList);//9
        arrayList.clear();//10

        ArrayList<Order> result = new ArrayList<>();
        result.add(order1);
        result.add(order4);
        result.add(order3);
        result.add(order5);
        result.add(order2);
        System.out.println(result.toString());
        return result;
    }
}
