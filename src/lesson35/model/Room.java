package lesson35.model;

import lesson35.service.GeneralService;

import java.util.Date;

public class Room extends GeneralClass{
    private long id;
    private int numberOfGuests;
    private double price;
    private boolean breakfastIncluded;
    private boolean petsAllowed;
    private Date dateAvailableFrom;
    private Hotel hotel;
    private GeneralService<Hotel> generalService = new GeneralService<>();

    public Room(long id, int numberOfGuests, double price, boolean breakfastIncluded, boolean petsAllowed, Date dateAvailableFrom, Hotel hotel) {
        this.id = id;
        this.numberOfGuests = numberOfGuests;
        this.price = price;
        this.breakfastIncluded = breakfastIncluded;
        this.petsAllowed = petsAllowed;
        this.dateAvailableFrom = dateAvailableFrom;
        this.hotel = hotel;
    }

    public Room() {
    }

    public void setDateAvailableFrom(Date dateAvailableFrom) {
        this.dateAvailableFrom = dateAvailableFrom;
    }

    public long getId() {
        return id;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public double getPrice() {
        return price;
    }

    public boolean isBreakfastIncluded() {
        return breakfastIncluded;
    }

    public boolean isPetsAllowed() {
        return petsAllowed;
    }

    public Date getDateAvailableFrom() {
        return dateAvailableFrom;
    }

    public Hotel getHotel() {
        return hotel;
    }

    @Override
    public String toString() {
        return id + "," + numberOfGuests + "," + price + "," + breakfastIncluded + "," + petsAllowed + "," + dateAvailableFrom + "," + hotel.getId();
    }

    @Override
    public Room fromStringToObject(String[] array) {
        return new Room(Long.parseLong(array[0].trim()), Integer.parseInt(array[1].trim()),Double.parseDouble(array[2].trim()),Boolean.parseBoolean(array[3].trim()),Boolean.parseBoolean(array[4].trim()), java.sql.Date.valueOf(array[5].trim()),generalService.findObjectById(Long.parseLong(array[6].trim())));
    }
}