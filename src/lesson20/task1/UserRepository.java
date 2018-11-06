package lesson20.task1;

import lesson20.task1.exception.BadRequestException;
import lesson20.task1.exception.InternalServerException;
import lesson20.task1.exception.UserNotFoundException;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    public User findById(long id) throws UserNotFoundException{
        for (User el: users){
            if (el!=null && id == el.getId())
                return el;
        }
        throw new UserNotFoundException("User with id: "+id+" not found");
    }

    public User save(User user) throws Exception{
        if (user == null)
            throw new BadRequestException("Can't save null user");

        try {
            findById(user.getId());
            throw new BadRequestException("User with id: "+user.getId()+" already exist");
        } catch (UserNotFoundException e){
            System.out.println("User with id: "+user.getId()+" not found, will be saved");
        }

        int index = 0;
        for (User us : users){
            if (us==null){
                users[index] = user;
                return user;
            }
            index++;
        }
        throw new InternalServerException("Not enough space to save user with id: " + user.getId());
    }

    public User update(User user) throws Exception{
        if (user == null)
            throw new BadRequestException("Can't update null user");
        findById(user.getId());
        int index = 0;
        for (User el : users) {
            if (el != null && el.getId() == user.getId()) {
                users[index] = user;
                return users[index];
            }
            index++;
        }
        throw new InternalServerException("Unexpected error");
    }

    public void delete(long id) throws Exception{
        findById(id);
        int index = 0;
        for (User el : users) {
            if (el.getId() == id) {
                users[index] = null;
                break;
            }
            index++;
        }
    }
}
