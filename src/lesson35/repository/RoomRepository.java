package lesson35.repository;

import lesson35.controller.UserController;
import lesson35.model.Room;
import lesson35.service.RoomService;

import java.io.*;
import java.sql.Date;
import java.util.ArrayList;

public class RoomRepository {
    private String path = "/home/anton/RoomDB.txt";
    private UserController userController = new UserController();
    private RoomService roomService = new RoomService();

    //read data - read file
    //work with data - mapping data

    public ArrayList<Room> readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            ArrayList<Room> rooms = new ArrayList<>();
            String[] array;
            String line;
            while ((line = br.readLine()) != null) {
                array = line.split(",");
                long s = Long.parseLong(array[6].trim());
                rooms.add(new Room(Long.parseLong(array[0].trim()), Integer.parseInt(array[1].trim()),Double.parseDouble(array[2].trim()),Boolean.parseBoolean(array[3].trim()),Boolean.parseBoolean(array[4].trim()), Date.valueOf(array[5].trim()),userController.findHotelById(s)));
            }
            return rooms;
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
        } catch (IOException e) {
            System.out.println("Reading from file " + path + " failed");
        }
        return null;
    }

    public void addRoom(Room room) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.append("\n");
            bufferedWriter.append((transferRoomToString(room)));
        } catch (IOException e) {
            System.err.println("Can't write to file" + path);
        }
    }

    public void deleteRoom(long id) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.append(deleteRoomFromString(id));
        } catch (IOException e) {
            System.err.println("Deleting from file " + path + " failed");
        }
    }

    private StringBuffer deleteRoomFromString(long id) {
        StringBuffer res = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.equals(transferRoomToString(roomService.findRoomById(id)))){
                    res.append(line);
                    res.append("\n");
                }
            }
            res.replace(res.length() - 1, res.length(), "");
        } catch (IOException e) {
            System.out.println("Deleting from file " + path + " failed");
        }
        return res;
    }

    private String transferRoomToString(Room room){
        return room.getId()+","+room.getNumberOfGuests()+","+room.getPrice()+","+room.isBreakfastIncluded()+","+room.isPetsAllowed()+","+room.getDateAvailableFrom()+","+room.getHotel().getId();
    }
}
