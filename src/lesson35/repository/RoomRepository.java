package lesson35.repository;

import lesson35.model.Hotel;
import lesson35.model.Room;
import lesson35.service.GeneralService;

import java.util.ArrayList;

public class RoomRepository extends GeneralRepository<Room>{
    private String path = "/home/anton/RoomDB.txt";

    private GeneralService<Hotel> generalServiceHotel = new GeneralService<>();

    public ArrayList<Room> readFile() {
        return readFromFile();
    }

    public void addRoom(Room room) {
        addObject(room);
    }

    public void deleteRoom(long id) {
        deleteObject(id);
    }

    @Override
    public Room map(String str) {
        String[] array = str.split(".");
        return new Room(Long.parseLong(array[0].trim()), Integer.parseInt(array[1].trim()),Double.parseDouble(array[2].trim()),Boolean.parseBoolean(array[3].trim()),Boolean.parseBoolean(array[4].trim()), java.sql.Date.valueOf(array[5].trim()),generalServiceHotel.findObjectById(Long.parseLong(array[6].trim())));
    }

    public RoomRepository() {
        setPath(path);
    }
}
