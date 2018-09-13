package lesson11.homework;

public class Controller {
    private API[] apis;
    private Room[] rooms;

    public Controller(API[] apis) {
        this.apis = apis;
    }

    public Room[] requstRooms(int price, int persons, String city, String hotel) {
        BookingComAPI bookingComAPI = new BookingComAPI(rooms);
        TripAdvisorAPI tripAdvisorAPI = new TripAdvisorAPI(rooms);
        GoogleAPI googleAPI = new GoogleAPI(rooms);
        Room[] booking = new Room[bookingComAPI.findRooms(price, persons, city, hotel).length];
        Room[] tripAdvisor = new Room[tripAdvisorAPI.findRooms(price, persons, city, hotel).length];
        Room[] google = new Room[googleAPI.findRooms(price, persons, city, hotel).length];
        booking = bookingComAPI.findRooms(price, persons, city, hotel);
        tripAdvisor = tripAdvisorAPI.findRooms(price, persons, city, hotel);
        google = googleAPI.findRooms(price, persons, city, hotel);
        int i = 0;
        int index = 0;
        for (Room elBooking : booking) {
            for (Room elTrip : tripAdvisor) {
                for (Room elGoogle : google) {
                    if (elBooking != null && elTrip != null && elGoogle != null && (elBooking.getPrice() == elGoogle.getPrice() || elBooking.getPrice() == elTrip.getPrice() || elGoogle.getPrice() == elTrip.getPrice()) && (elBooking.getPersons() == elGoogle.getPersons() || elBooking.getPersons() == elTrip.getPersons() || elGoogle.getPersons() == elTrip.getPersons()) && (elBooking.getCityName() == elGoogle.getCityName() || elBooking.getCityName() == elTrip.getCityName() || elGoogle.getCityName() == elTrip.getCityName()) && (elBooking.getHotelName() == elGoogle.getHotelName() || elBooking.getHotelName() == elTrip.getHotelName() || elGoogle.getHotelName() == elTrip.getHotelName())){
                        i++;
                    }
                }
            }
        }
        Room[] result = new Room[i];
        for (Room elBooking : booking) {
            for (Room elTrip : tripAdvisor) {
                for (Room elGoogle : google) {
                    if (elBooking != null && elTrip != null && elGoogle != null && (elBooking.getPrice() == elGoogle.getPrice() || elBooking.getPrice() == elTrip.getPrice() || elGoogle.getPrice() == elTrip.getPrice()) && (elBooking.getPersons() == elGoogle.getPersons() || elBooking.getPersons() == elTrip.getPersons() || elGoogle.getPersons() == elTrip.getPersons()) && (elBooking.getCityName() == elGoogle.getCityName() || elBooking.getCityName() == elTrip.getCityName() || elGoogle.getCityName() == elTrip.getCityName()) && (elBooking.getHotelName() == elGoogle.getHotelName() || elBooking.getHotelName() == elTrip.getHotelName() || elGoogle.getHotelName() == elTrip.getHotelName())){
                        result[index] = elBooking;
                        index++;
                    }
                }
            }
        }
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
                if (el1 != null && el2 != null && el1.getHotelName() == el2.getHotelName() && el1.getCityName() == el2.getCityName() && el1.getPersons() == el2.getPersons() && el1.getPrice() == el2.getPrice()) {
                    i++;
                }
            }
        }
        Room[] result = new Room[i];
        int index = 0;
        for (Room el1 : api1Array) {
            for (Room el2 : api2Array) {
                if (el1 != null && el2 != null && el1.getHotelName() == el2.getHotelName() && el1.getCityName() == el2.getCityName() && el1.getPersons() == el2.getPersons() && el1.getPrice() == el2.getPrice()) {
                    result[index] = el1;
                    index++;
                }
            }
        }
        return result;
    }
}
