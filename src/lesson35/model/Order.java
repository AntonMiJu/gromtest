package lesson35.model;

import java.util.Date;

public class Order extends GeneralClass{
    private long id;
    private User user;
    private Room room;
    private Date dateFrom;
    private Date dateTo;
    private double moneyPaid;

    public Order(long id, User user, Room room, Date dateFrom, Date dateTo, double moneyPaid) {
        this.id = id;
        this.user = user;
        this.room = room;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.moneyPaid = moneyPaid;
    }

    public Order() {
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Room getRoom() {
        return room;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public double getMoneyPaid() {
        return moneyPaid;
    }

    @Override
    public String toString() {
        return id + "," + user.getId() + "," + room.getId() + "," + dateFrom + "," + dateTo + "," + moneyPaid;
    }

    @Override
    public Order fromStringToObject(String[] array) {
        return new Order(Long.parseLong(array[0].trim()), user, room, java.sql.Date.valueOf(array[3].trim()), java.sql.Date.valueOf(array[4].trim()), Double.parseDouble(array[5].trim()));
    }
}
