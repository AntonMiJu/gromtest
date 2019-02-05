package lesson35.service;

import lesson35.model.Filter;
import lesson35.model.Room;
import lesson35.repository.RoomRepository;

import java.util.ArrayList;

public class RoomService {
    private RoomRepository roomRepository = new RoomRepository();

    public void addRoom(Room room){
        roomRepository.addRoom(room);
    }

    public void deleteRoom(long id){
        roomRepository.deleteRoom(id);
    }

    public Room findRoomById(long id) {
        Room[] rooms = (Room[]) roomRepository.readFile().toArray();
        for (Room el : rooms){
            if (el.getId() == id)
                return el;
        }
        return null;
    }

    public ArrayList<Room> findRooms(Filter filter){
        ArrayList<Room> res = new ArrayList<>();
        Room[] rooms = (Room[]) roomRepository.readFile().toArray();
        for (Room el : rooms){
            if (el.getNumberOfGuests() == filter.getNumberOfGuests() && el.getPrice() == filter.getPrice() && el.isBreakfastIncluded() == filter.isBreakfastIncluded() && el.isPetsAllowed() == filter.isPetsAllowed() && el.getDateAvailableFrom().equals(filter.getDateAvailableFrom()) && el.getHotel().getCountry().equals(filter.getCountry()) && el.getHotel().getCity().equals(filter.getCity()))
                res.add(el);
        }
        return res;
    }
}
