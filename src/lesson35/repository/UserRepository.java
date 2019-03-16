package lesson35.repository;

import lesson35.model.User;
import lesson35.model.UserType;

import java.util.ArrayList;

public class UserRepository extends GeneralRepository<User> {
    private String path = "/home/anton/UserDB.txt";

    public ArrayList<User> readFile() {
        return readFromFile();
    }

    public User registerUser(User user) {
        return addObject(user);
    }

    @Override
    public User map(String str) {
        String[] array = str.split(".");
        return new User(Long.parseLong(array[0].trim()),array[1].trim(),array[2].trim(),array[3].trim(),UserType.valueOf(array[4].trim()));
    }

    public UserRepository() {
        setPath(path);
    }
}
