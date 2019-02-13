package lesson35.controller;

import lesson35.model.*;
import lesson35.service.UserService;

public class UserController {
    private UserService userService = new UserService();

    public User currentUser = null;


    public User registerUser(User user) {
        return userService.registerUser(user);
    }

    public User findUserById(long id) {
        return userService.findUserById(id);
    }

    public void login(String userName, String password) throws Exception {
        userService.login(userName, password);
    }

    public void logout() {
        currentUser = null;
    }

    public void validateLogin() throws Exception{
        if (currentUser == null)
            throw new Exception("You must be signed");
    }

    public void validateLoginAdmin() throws Exception{
        if (currentUser == null || !currentUser.getUserType().equals(UserType.valueOf("ADMIN")))
            throw new Exception("You must have UserType = ADMIN");
    }
}
