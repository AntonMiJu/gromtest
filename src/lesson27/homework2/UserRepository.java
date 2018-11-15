package lesson27.homework2;

import java.util.ArrayList;

public class UserRepository {
    private ArrayList<User> users;

    public UserRepository(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public User save(User user) {
        for (User el : users) {
            if (el != null && el.equals(user))
                return null;
        }
        int index = 0;
        for (User el : users) {
            if (el == null) {
                users.set(index, user);
                return users.get(index);
            }
            index++;
        }
        if (index == users.size()) {
            users.add(user);
            return users.get(users.size()-1);
        }
        return null;
    }

    public User update(User user) {
        int index = 0;
        for (User el : users) {
            if (el != null && el.equals(user)){
                users.set(index,user);
                return users.get(index);
            }
            index++;
        }
        return null;
    }

    public void delete(long id) {
        for (User el : users) {
            if (el.getId() == id)
                users.remove(el);
        }
    }

    public User findById(long id) {
        for (User el : users) {
            if (el.getId() == id)
                return el;
        }
        return null;
    }
}
