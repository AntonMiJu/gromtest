package lesson35.controller;

import lesson35.model.Hotel;
import lesson35.service.HotelService;

public class HotelController {
    private UserController userController = new UserController();
    private HotelService hotelService = new HotelService();

    public void addHotel(Hotel hotel) throws Exception {
        userController.validateLoginAdmin();
        hotelService.addHotel(hotel);
    }

    public Hotel findHotelByName(String name) throws Exception {
        userController.validateLogin();
        return hotelService.findHotelByName(name);
    }

    public Hotel findHotelByCity(String city) throws Exception {
        userController.validateLogin();
        return hotelService.findHotelByCity(city);
    }

    public Hotel findHotelById(long id) {
        return hotelService.findHotelById(id);
    }

    public void deleteHotel(long id) throws Exception {
        userController.validateLoginAdmin();
        hotelService.deleteHotel(id);
    }
}
