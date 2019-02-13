package lesson35.repository;

import lesson35.controller.RoomController;
import lesson35.controller.UserController;
import lesson35.model.Order;
import lesson35.model.Room;
import lesson35.model.User;

import java.io.*;
import java.sql.Date;
import java.util.ArrayList;

public class OrderRepository {
    private String path = "/home/anton/Order.txt";
    private UserController userController = new UserController();
    private RoomController roomController = new RoomController();

    //read data - read file
    //work with data - mapping data

    public ArrayList<Order> readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            ArrayList<Order> orders = new ArrayList<>();
            String[] array;
            String line;
            while ((line = br.readLine()) != null) {
                array = line.split(",");
                User user = userController.findUserById(Long.parseLong(array[1].trim()));
                Room room = roomController.findRoomById(Long.parseLong(array[1].trim()));
                orders.add(new Order(Long.parseLong(array[0].trim()), user, room, Date.valueOf(array[3].trim()), Date.valueOf(array[4].trim()), Double.parseDouble(array[5].trim())));
            }
            return orders;
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
        } catch (IOException e) {
            System.out.println("Reading from file " + path + " failed");
        }
        return null;
    }

    public void writeFile(Order order) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.append("\n");
            bufferedWriter.append(order.getId() + "," + order.getUser().getId() + "," + order.getRoom().getId() + "," + order.getDateFrom() + "," + order.getDateTo() + "," + order.getMoneyPaid());
        } catch (IOException e) {
            System.err.println("Can't write to file" + path);
        }
    }

    public void cancelReservation(long roomId, long userId) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.append(deleteReservationFromString(roomId, userId));
        } catch (IOException e) {
            System.err.println("Deleting from file " + path + " failed");
        }
    }

    private StringBuffer deleteReservationFromString(long roomId, long userId) {
        StringBuffer res = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            String[] array;
            while ((line = br.readLine()) != null) {
                array = line.split(",");
                if (Long.parseLong(array[1]) != userId || Long.parseLong(array[2]) != roomId) {
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
}
