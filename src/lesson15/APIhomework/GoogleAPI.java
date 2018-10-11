package lesson15.APIhomework;

public class GoogleAPI implements API {
    private Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    public Room[] getRooms() {
        return rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        Room man = new Room(0,price,persons,null,hotel,city);
        if (rooms == null)
            return null;
        int i = 0;
        for (Room el : rooms) {
            if (el != null && el.equals(man))
                i++;
        }
        Room[] foundedRooms = new Room[i];
        int index = 0;
        for (Room el : rooms) {
            if (el != null && el.equals(man)) {
                foundedRooms[index] = el;
                index++;
            }
        }
        return foundedRooms;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }
}
