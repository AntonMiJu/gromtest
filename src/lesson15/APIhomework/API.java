package lesson15.APIhomework;

public interface API {
    Room[] findRooms(int price, int persons, String city, String hotel);

    Room[] getAll();
}
