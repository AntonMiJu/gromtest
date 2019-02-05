package lesson35.controller;

import lesson35.model.Filter;
import lesson35.model.Room;
import lesson35.service.RoomService;

import java.util.ArrayList;

public class RoomController {
    private RoomService roomService = new RoomService();

    public void addRoom(Room room){
        roomService.addRoom(room);
    }

    public Room findRoomById(long id){
        return roomService.findRoomById(id);
    }

    public void deleteRoom(long id){
        roomService.deleteRoom(id);
    }

    public ArrayList<Room> findRooms(Filter filter){
        return roomService.findRooms(filter);
    }
}
