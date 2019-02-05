package lesson35.service;

import lesson35.controller.UserController;
import lesson35.model.User;
import lesson35.repository.UserRepository;

import java.util.ArrayList;

public class UserService {
    private UserRepository userRepository = new UserRepository();
    private UserController userController = new UserController();

    public User registerUser(User user){
        //check business logic

        //if logic is ok
        return userRepository.registerUser(user);
    }

    public void login(String userName, String password) throws Exception{
        if (userController.currentUser!=null){
            throw new Exception("User with id "+userController.currentUser.getId()+" already signed");
        }
        User[] users = (User[]) userRepository.readFile().toArray();
        for (User el : users){
            if (el.getUserName().equals(userName) && el.getPassword().equals(password))
                userController.currentUser = el;
        }
    }

    public User findUserById(long id) {
        User[] users = (User[]) userRepository.readFile().toArray();
        for (User el : users){
            if (el.getId() == id)
                return el;
        }
        return null;
    }
}
