package lesson35.model;

public class Hotel extends GeneralClass{
    private long id;
    private String name;
    private String country;
    private String city;
    private String street;

    public Hotel(long id, String name, String country, String city, String street) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public Hotel() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public String toString() {
        return id + "," + name+ "," + country + "," + city+ "," + street;
    }

    @Override
    public Hotel fromStringToObject(String[] array) {
        return new Hotel(Long.parseLong(array[0].trim()), array[1].trim(), array[2].trim(), array[3].trim(), array[4].trim());
    }


}
