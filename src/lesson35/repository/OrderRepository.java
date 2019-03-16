package lesson35.repository;

import lesson35.model.Order;
import lesson35.model.Room;
import lesson35.model.User;
import lesson35.service.GeneralService;

import java.sql.Date;
import java.util.ArrayList;

public class OrderRepository extends GeneralRepository<Order> {
    private String path = "/home/anton/Order.txt";
    private GeneralService<User> userGeneralService = new GeneralService<>();
    private GeneralService<Room> roomGeneralService = new GeneralService<>();

    public ArrayList<Order> readFile() {
        return readFromFile();
    }

    public void writeFile(Order order) {
        addObject(order);
    }

    public void cancelReservation(long roomId, long userId) {
        deleteObject(roomId, userId);
    }

    @Override
    public Order map(String str) {
        String[] array = str.split(",");
        User user = userGeneralService.findObjectById(Long.parseLong(array[1].trim()));
        Room room = roomGeneralService.findObjectById(Long.parseLong(array[1].trim()));
        return new Order(Long.parseLong(array[0].trim()), user, room, Date.valueOf(array[3].trim()), Date.valueOf(array[4].trim()), Double.parseDouble(array[5].trim()));
    }

    public OrderRepository() {
        setPath(path);
    }
}
