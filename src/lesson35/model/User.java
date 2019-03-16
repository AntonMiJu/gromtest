package lesson35.model;

public class User extends GeneralClass{
    private long id;
    private String userName;
    private String password;
    private String country;
    private UserType userType;

    public User(long id, String userName, String password, String country, UserType userType) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.country = country;
        this.userType = userType;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getCountry() {
        return country;
    }

    public UserType getUserType() {
        return userType;
    }

    @Override
    public String toString() {
        return id + "," + userName + "," + password + "," + country + "," + userType;
    }

    @Override
    public User fromStringToObject(String[] array) {
        return new User(Long.parseLong(array[0].trim()),array[1].trim(),array[2].trim(),array[3].trim(),UserType.valueOf(array[4].trim()));
    }
}
