package lesson35.service;

import lesson35.controller.RoomController;
import lesson35.controller.UserController;
import lesson35.model.Order;
import lesson35.model.Room;
import lesson35.repository.OrderRepository;
import lesson35.repository.RoomRepository;

import java.util.Calendar;
import java.util.Date;

public class OrderService {
    private OrderRepository orderRepository = new OrderRepository();
    private RoomController roomController = new RoomController();
    private RoomRepository roomRepository = new RoomRepository();
    private UserController userController = new UserController();

    public void cancelReservation(long roomId, long userId) {
        Date availableFrom = null;
        Room chRoom;
        for (Order el : orderRepository.readFile()){
            if (el.getRoom().getId() == roomId && el.getUser().getId()==userId)
                availableFrom = el.getDateFrom();
        }
        chRoom = roomController.findRoomById(roomId);
        chRoom.setDateAvailableFrom(availableFrom);
        roomRepository.deleteRoom(roomId);
        roomRepository.addRoom(chRoom);
        orderRepository.cancelReservation(roomId, userId);
    }

    public void bookRoom(long roomId, long userId, long hotelId){
        Room chRoom;
        Calendar cal = Calendar.getInstance();
        cal.setTime(roomController.findRoomById(roomId).getDateAvailableFrom());
        cal.add(Calendar.DATE, 3);
        chRoom = roomController.findRoomById(roomId);
        chRoom.setDateAvailableFrom(cal.getTime());
        roomRepository.deleteRoom(roomId);
        roomRepository.addRoom(chRoom);
        orderRepository.writeFile(new Order(roomController.findRoomById(roomId).hashCode(),userController.findUserById(userId),roomController.findRoomById(roomId),roomController.findRoomById(roomId).getDateAvailableFrom(),cal.getTime(),roomController.findRoomById(roomId).getPrice()));
    }
}
