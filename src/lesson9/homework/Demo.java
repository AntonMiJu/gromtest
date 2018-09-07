package lesson9.homework;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        User user1 = new User(13, "Anton", "13");
        User user2 = new User(11, null, "11");
        User[] users = {user1, user2};
        User[] user = null;
        UserRepository userRepository = new UserRepository(users);


        System.out.println(Arrays.toString(userRepository.getUserNames()));
        System.out.println(Arrays.toString(userRepository.getUserIds()));
        System.out.println(userRepository.getUserNameById(11));

        UserRepository userRepository1 = new UserRepository(user);
        System.out.println(Arrays.toString(userRepository1.getUserNames()));
        System.out.println(Arrays.toString(userRepository1.getUserIds()));
        System.out.println(userRepository1.getUserNameById(13));
    }
}
