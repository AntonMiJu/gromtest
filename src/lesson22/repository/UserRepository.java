package lesson22.repository;

public class UserRepository {
    private static User[] users = new User[10];

    public static User[] getUsers() {
        return users;
    }

    public static User findById(long id) {
        for (User us : users) {
            if (us!= null && us.getId()==id)
                return us;
        }
        return null;
    }

    public static User save(User user) {
        int i = 0;
        for (User el : users) {
            if (el == user)
                return null;
            if (el != null)
                i++;
        }
        if (users == null || i == users.length)
            return null;
        int index = 0;
        for (User el : users) {
            if (el == null)
                break;
            index++;
        }
        users[index] = user;
        return user;
    }

    public static User update(User user) {
        if (users == null || user == null)
            return null;
        int i = 0;
        for (User el : users) {
            if (el != null && el.getId() == user.getId()) {
                users[i] = user;
                return users[i];
            }
            i++;
        }
        return null;
    }

    public static void delete(long id) {
        int i = 0;
        for (User el : users) {
            if (el != null && el.getId() == id) {
                users[i] = null;
            }
            i++;
        }
    }
}
