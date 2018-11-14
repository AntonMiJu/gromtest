package lesson25.homework;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws Exception{
        GeneralDAO<Order> orderGeneralDAO = new GeneralDAO<>();
        Order order1 = new Order("AirPods",4500);

        orderGeneralDAO.save(order1);

        orderGeneralDAO.save(order1);
        orderGeneralDAO.save(null);
        System.out.println(Arrays.deepToString(orderGeneralDAO.getAll()));


        GeneralDAO<User> userGeneralDAO = new GeneralDAO<>();
        User user1 = new User("Anton",24,"...");

        userGeneralDAO.save(user1);
        
        userGeneralDAO.save(user1);
        userGeneralDAO.save(null);
        System.out.println(Arrays.deepToString(userGeneralDAO.getAll()));


        GeneralDAO<Phone> phoneGeneralDAO = new GeneralDAO<>();
        Phone phone1 = new Phone(14000, 12);

        phoneGeneralDAO.save(phone1);

        phoneGeneralDAO.save(phone1);
        phoneGeneralDAO.save(null);
        System.out.println(Arrays.deepToString(phoneGeneralDAO.getAll()));
    }
}
