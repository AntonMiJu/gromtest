package lesson9.homework;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        User user1 = new User(13, "Anton", "13");
        User user2 = new User(11, "Ann", "11");
        User test = new User(1001,"Test","test");
        User[] users = {user1,user2};

        UserRepository userRepository = new UserRepository(users);

        //getuserbysession

        //getting + null + not in array
        System.out.println(userRepository.getUserBySessionId("13"));
        System.out.println(userRepository.getUserBySessionId(null));
        System.out.println(userRepository.getUserBySessionId("1311"));
        System.out.println();

        //findbyid

        //finding + not in array
        System.out.println(userRepository.findById(13));
        System.out.println(userRepository.findById(1311));
        System.out.println();

        //save

        //full array
        System.out.println(userRepository.save(test));

        //save user
        userRepository.delete(13);
        userRepository.delete(11);
        System.out.println(userRepository.save(test));
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        //save the same user
        System.out.println(userRepository.save(test));
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        System.out.println();

        //delete

        //not in the array
        userRepository.delete(12);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        System.out.println();

        //update

        //updating
        User user = new User(1001,"Ann","eretertert");
        System.out.println(userRepository.update(user));
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        //null
        System.out.println(userRepository.update(null));
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        //not in the array
        User not = new User(9999,"Ann","eretertert");
        System.out.println(userRepository.update(not));
        System.out.println(Arrays.deepToString(userRepository.getUsers()));
    }
}
