package lesson35.repository;

import lesson35.model.Hotel;
import lesson35.service.HotelService;

import java.io.*;
import java.util.ArrayList;

public class HotelRepository {
    private String path = "/home/anton/HotelDB.txt";
    private HotelService hotelService = new HotelService();

    //read data - read file
    //work with data - mapping data
    public ArrayList<Hotel> readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            ArrayList<Hotel> hotels = new ArrayList<>();
            String[] array;
            String line;
            Hotel hotel = null;
            while ((line = br.readLine()) != null) {
                array = line.split(",");
                hotels.add((Hotel) hotel.fromStringToObject(array));
            }
            return hotels;
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
        } catch (IOException e) {
            System.out.println("Reading from file " + path + " failed");
        }
        return null;
    }

    public void addHotel(Hotel hotel) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.append("\n");
            bufferedWriter.append(hotel.toString());
        } catch (IOException e) {
            System.err.println("Can't write to file" + path);
        }
    }

    public void deleteHotel(long id) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.append(deleteHotelFromString(id));
        } catch (IOException e) {
            System.err.println("Writing to file " + path + " failed");
        }
    }

    private StringBuffer deleteHotelFromString(long id) {
        StringBuffer res = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.equals(hotelService.findHotelById(id).toString())){
                    res.append(line);
                    res.append("\n");
                }
            }
            res.replace(res.length() - 1, res.length(), "");
        } catch (IOException e) {
            System.out.println("Reading from file " + path + " failed");
        }
        return res;
    }
}
