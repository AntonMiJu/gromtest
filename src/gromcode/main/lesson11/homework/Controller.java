package gromcode.main.lesson11.homework;

public class  Controller {
    private API[] apis;
    private Room[] rooms;

    public Controller(API[] apis) {
        this.apis = apis;
    }

//    public Room[] requestRooms(int price, int persons, String city, String hotel) {
//        BookingComAPI bookingComAPI = new BookingComAPI(rooms);
//        TripAdvisorAPI tripAdvisorAPI = new TripAdvisorAPI(rooms);
//        GoogleAPI googleAPI = new GoogleAPI(rooms);
//        Room[] booking = bookingComAPI.findRooms(price, persons, city, hotel);
//        Room[] tripAdvisor = tripAdvisorAPI.findRooms(price, persons, city, hotel);
//        Room[] google = googleAPI.findRooms(price, persons, city, hotel);
//        Room[] avarege = new Room[booking.length + tripAdvisor.length + google.length];
//        int index = 0;
//        for (Room el : booking) {
//            avarege[index] = el;
//            index++;
//        }
//        for (Room el : tripAdvisor) {
//            avarege[index] = el;
//            index++;
//        }
//        for (Room el : google) {
//            avarege[index] = el;
//            index++;
//        }
//        int i = 0;
//        int k = 0;
//        for (Room el1 : avarege) {
//            for (Room el2 : avarege) {
//                if (el1 != null && el2 != null && el1.getHotelName() == el2.getHotelName() && el1.getCityName() == el2.getCityName() && el1.getPersons() == el2.getPersons() && el1.getPrice() == el2.getPrice()) {
//                    i++;
//                }
//            }
//        }
//        Room[] result = new Room[booking.length + tripAdvisor.length + google.length - i - avarege.length];
//        for (Room el : avarege) {
//            for (Room el1 : result) {
//                if (el != null && el1 != null && el.getPrice() == el1.getPrice()&&el.getPersons()==el1.getPersons()&&el.getCityName()==el1.getCityName()&&el.getHotelName()==el1.getHotelName()){
//                    continue;
//                } else {
//                    result[k] = el;
//                    k++;
//                }
//            }
//        }
//        return result;
//    }

    public Room[] requestRooms(int price, int persons, String city, String hotel) {
        int lengthArray = 0;
        int index = 0;
        for (API el : apis) {
            if (el != null && el.findRooms(price, persons, city, hotel) != null)
                lengthArray += el.findRooms(price, persons, city, hotel).length;
        }
        Room[] result = new Room[lengthArray];
        for (API el : apis) {
            if (el != null) {
                Room[] average = el.findRooms(price, persons, city, hotel);
                for (Room el1 : average) {
                    result[index] = el1;
                    index++;
                }
            }
        }
        return result;
    }

    public Room[] check(API api1, API api2) {
        if (api1.getAll() == null || api2.getAll() == null)
            return null;
        Room[] api1Array = api1.getAll();
        Room[] api2Array = api2.getAll();
        int i = 0;
        for (Room el : api1Array) {
            for (Room el1 : api2Array) {
                if (el != null && el1 != null && el.getHotelName() == el1.getHotelName() && el.getCityName() == el1.getCityName() && el.getPersons() == el1.getPersons() && el.getPrice() == el1.getPrice()) {
                    i++;
                }
            }
        }
        int index = 0;
        Room[] result = new Room[i];
        for (Room el : api1Array) {
            for (Room el1 : api2Array) {
                if (el != null && el1 != null && el.getHotelName() == el1.getHotelName() && el.getCityName() == el1.getCityName() && el.getPersons() == el1.getPersons() && el.getPrice() == el1.getPrice()) {
                    result[index] = el;
                    index++;
                }
            }
        }
        return result;
    }
}
