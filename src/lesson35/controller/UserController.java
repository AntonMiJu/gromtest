package lesson35.controller;

import lesson35.model.*;
import lesson35.service.UserService;

import java.util.ArrayList;

public class UserController {
    private UserService userService = new UserService();
    private HotelController hotelController = new HotelController();
    private RoomController roomController = new RoomController();
    private OrderController orderController = new OrderController();

    public User currentUser = null;


    public User registerUser(User user) {
        return userService.registerUser(user);
    }

    public Hotel findHotelByName(String name) throws Exception {
        if (currentUser == null)
            throw new Exception("You must be signed");
        return hotelController.findHotelByName(name);
    }

    public Hotel findHotelByCity(String city) throws Exception {
        if (currentUser == null)
            throw new Exception("You must be signed");
        return hotelController.findHotelByCity(city);
    }

    public Hotel findHotelById(long id) {
        return hotelController.findHotelById(id);
    }

    public ArrayList<Room> findRooms(Filter filter) throws Exception {
        if (currentUser == null)
            throw new Exception("You must be signed");
        return roomController.findRooms(filter);
    }

    public Room findRoomById(long id) {
        return roomController.findRoomById(id);
    }

    public User findUserById(long id) {
        return userService.findUserById(id);
    }

    public void bookRoom(long roomId, long userId, long hotelId) {
        orderController.bookRoom(roomId,userId,hotelId);
    }

    public void cancelReservation(long roomId, long userId) {
        orderController.cancelReservation(roomId, userId);
    }

    public void login(String userName, String password) throws Exception {
        userService.login(userName, password);
    }

    public void logout() {
        currentUser = null;
    }

    public void addHotel(Hotel hotel) throws Exception {
        if (currentUser != null && currentUser.getUserType().equals(UserType.valueOf("ADMIN"))) {
            hotelController.addHotel(hotel);
        } else {
            throw new Exception("You must have UserType = ADMIN");
        }
    }

    public void deleteHotel(long hotelId) throws Exception {
        if (currentUser != null && currentUser.getUserType().equals(UserType.valueOf("ADMIN"))) {
            hotelController.deleteHotel(hotelId);
        } else {
            throw new Exception("You must have UserType = ADMIN");
        }
    }

    public void addRoom(Room room) throws Exception {
        if (currentUser != null && currentUser.getUserType().equals("ADMIN")) {
            roomController.addRoom(room);
        } else {
            throw new Exception("You must have UserType = ADMIN");
        }
    }

    public void deleteRoom(long roomId) throws Exception {
        if (currentUser != null && currentUser.getUserType().equals(UserType.valueOf("ADMIN"))) {
            roomController.deleteRoom(roomId);
        } else {
            throw new Exception("You must have UserType = ADMIN");
        }
    }
}
