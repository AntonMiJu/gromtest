package lesson11.homework;

public class Controller {
    private API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }

    public Room[] requstRooms(int price, int persons, String city, String hotel) {

        return null;
    }

    public Room[] check(API api1, API api2) {
        if (api1.getAll() == null || api2.getAll() == null)
            return null;
        Room[] api1Array = new Room[api1.getAll().length];
        Room[] api2Array = new Room[api2.getAll().length];
        int i = 0;
        for (Room el1 : api1Array) {
            for (Room el2 : api2Array) {
                if (el1 != null && el2 != null && el1.getHotelName() == el2.getHotelName() && el1.getCityName() == el2.getCityName() && el1.getPersons()==el2.getPersons() && el1.getPrice()==el2.getPrice()){
                    i++;
                }
            }
        }
        Room[] result = new Room[i];
        int index = 0;
        for (Room el1 : api1Array) {
            for (Room el2 : api2Array) {
                if (el1 != null && el2 != null && el1.getHotelName() == el2.getHotelName() && el1.getCityName() == el2.getCityName() && el1.getPersons()==el2.getPersons() && el1.getPrice()==el2.getPrice()){
                    result[index]=el1;
                    index++;
                }
            }
        }
        return result;
    }
}
