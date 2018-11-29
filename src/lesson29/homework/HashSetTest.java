package lesson29.homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        System.out.println(useHashSet());
    }

    public static Set<Order> useHashSet(){
        Set<Order> set = new HashSet<>();
        Order order1 = new Order(1,25,"usd","ball","safa23");
        Order order2 = new Order(2,2556,"uah","ball","cvtr7");
        Order order3 = new Order(3,125,"usd","ball","dsf3");
        Order order4 = new Order(4,225,"eur","ball","dfdw4");
        Order order5 = new Order(2,2556,"uah","ball","cvtr7");
        Order order6 = new Order(5,256,"uah","ball","cvtr7");
        ArrayList<Order> arrayList = new ArrayList<>();
        arrayList.add(order5);
        arrayList.add(order6);

        set.add(order1);
        set.add(order2);
        set.remove(order2);
        System.out.println(set);

        set.add(order2);
        System.out.println(set);
        set.retainAll(arrayList);
        System.out.println(set);
        set.add(order1);
        set.add(order3);
        set.add(order4);
        set.add(order6);

        Order[] orders = new Order[set.size()];
        //orders = (Order[]) set.toArray();

        return set;
    }
}
