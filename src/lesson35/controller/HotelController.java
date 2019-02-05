package lesson35.controller;

import lesson35.model.Hotel;
import lesson35.service.HotelService;

public class HotelController {
    private HotelService hotelService = new HotelService();

    public void addHotel(Hotel hotel){
        hotelService.addHotel(hotel);
    }

    public Hotel findHotelByName(String name){
        return hotelService.findHotelByName(name);
    }

    public Hotel findHotelByCity(String city){
        return hotelService.findHotelByCity(city);
    }

    public Hotel findHotelById(long id){
        return hotelService.findHotelById(id);
    }

    public void deleteHotel(long id){
        hotelService.deleteHotel(id);
    }
}
