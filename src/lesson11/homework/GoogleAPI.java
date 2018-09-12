package lesson11.homework;

public class GoogleAPI implements API {
    private Room rooms[];

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        if (rooms == null)
            return null;
        int i = 0;
        for (Room el:rooms){
            if (el != null && el.getPrice() == price && el.getPersons() == persons && el.getCityName() == city && el.getHotelName() == hotel)
                i++;
        }
        Room[] foundedRooms = new Room[i];
        int index = 0;
        for (Room el : rooms) {
            if (el != null && el.getPrice() == price && el.getPersons() == persons && el.getCityName() == city && el.getHotelName() == hotel){
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
