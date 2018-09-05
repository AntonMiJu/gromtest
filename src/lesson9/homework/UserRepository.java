package lesson9.homework;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    public String[] getUserNames() {
        if (users == null)
            return null;
        int length = 0;
        for (User el : users) {
            if (el != null)
                length++;
        }
        String[] names = new String[length];
        int i = 0;
        for (User el : users) {
            if (el == null)
                continue;
            names[i] = el.getName();
            i++;
        }
        return names;
    }

    public long[] getUserIds() {
        if (users == null)
            return null;
        int length = 0;
        for (User el : users) {
            if (el != null)
                length++;
        }
        long[] ids = new long[length];
        int i = 0;
        for (User el : users) {
            if (el != null) {
                ids[i] = el.getId();
                i++;
            }
        }
        return ids;
    }

    public String getUserNameById(long id) {
        if (users == null)
            return null;
        for (User el : users) {
            if (el == null)
                continue;
            if (el.getId() == id)
                return el.getName();
        }
        return null;
    }

    public User getUserByName(String name) {
        String[] names = getUserNames();
        int i = 0;
        for (String el : names) {
            if (el == name)
                return users[i];
            i++;
        }
        return null;
    }

    private User findById(long id) {
        long[] ids = getUserIds();
        int i = 0;
        for (long el : ids) {
            if (el == id)
                return users[i];
            i++;
        }
        return null;
    }

    public User getUserBySessionId(String sessionId) {
        if (users == null)
            return null;
        int length = 0;
        for (User el : users) {
            if (el != null)
                length++;
        }
        String[] sessionIds = new String[length];
        int i = 0;
        for (User el : users) {
            if (el != null) {
                sessionIds[i] = el.getSessionId();
                i++;
            }
        }
        int k = 0;
        for (String el : sessionIds) {
            if (el == sessionId)
                return users[k];
            k++;
        }
        return null;
    }

    public User save(User user) {
        if (users == null)
            return null;
        for (User el : users) {
            if (el == user || users[users.length - 1] != null)
                return null;
        }
        int i = 0;
        for (User el : users) {
            if (el==null)
                break;
            i++;
        }
        users[i] = user;
        return user;
    }

    public User update(User user){
        if (users == null || user == null)
            return null;
        int i = 0;
        for (User el: users){
            if (el==null)
                continue;
            if (el.getId()==user.getId()){
                users[i] = user;
                return users[i];
            }
            i++;
        }
        return null;
    }

    public void delete(long id){
        int i = 0;
        for (User el: users){
            if (el==null)
                continue;
            if (el.getId()==id){
                users[i] = null;
            }
            i++;
        }
    }
}
