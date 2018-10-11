package lesson15.userRepository;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User save(User user) {
        int i = 0;
        if (findUser(user)!=null){
            return null;
        }
        for (User el : users) {
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
        return users[index];
    }

    public User update(User user) {
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

    public void delete(long id) {
        int i = 0;
        for (User el : users) {
            if (el != null && el.getId() == id) {
                users[i] = null;
            }
            i++;
        }
    }

    public User findUser(User user){
        int index = 0;
        for (User el : users){
            if (el!=null && el.equals(user)){
                return el;
            }
            index++;
        }
        return null;
    }

    public User[] getUsers() {
        return users;
    }
}
