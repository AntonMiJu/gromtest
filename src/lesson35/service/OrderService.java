package lesson35.service;

import lesson35.controller.UserController;
import lesson35.model.Order;
import lesson35.model.Room;
import lesson35.repository.OrderRepository;
import lesson35.repository.RoomRepository;

import java.util.Calendar;
import java.util.Date;

public class OrderService {
    private OrderRepository orderRepository = new OrderRepository();
    private UserController userController = new UserController();
    private RoomRepository roomRepository = new RoomRepository();

    public void cancelReservation(long roomId, long userId) {
        Order[] orders = (Order[]) orderRepository.readFile().toArray();
        Date availableFrom = null;
        Room chRoom;
        for (Order el : orders){
            if (el.getRoom().getId() == roomId && el.getUser().getId()==userId)
                availableFrom = el.getDateFrom();
        }
        chRoom = userController.findRoomById(roomId);
        chRoom.setDateAvailableFrom(availableFrom);
        roomRepository.deleteRoom(roomId);
        roomRepository.addRoom(chRoom);
        orderRepository.cancelReservation(roomId, userId);
    }

    public void bookRoom(long roomId, long userId, long hotelId){
        Order[] orders = (Order[]) orderRepository.readFile().toArray();
        Room chRoom;
        Calendar cal = Calendar.getInstance();
        cal.setTime(userController.findRoomById(roomId).getDateAvailableFrom());
        cal.add(Calendar.DATE, 3);
        chRoom = userController.findRoomById(roomId);
        chRoom.setDateAvailableFrom(cal.getTime());
        roomRepository.deleteRoom(roomId);
        roomRepository.addRoom(chRoom);
        orderRepository.writeFile(new Order(userController.findRoomById(roomId).hashCode(),userController.findUserById(userId),userController.findRoomById(roomId),userController.findRoomById(roomId).getDateAvailableFrom(),cal.getTime(),userController.findRoomById(roomId).getPrice()));
    }
}
