package gromcode.main.lesson25.homework;

public class User {
    private String name;
    private int age;
    private String login;

    public User(String name, int age, String login) {
        this.name = name;
        this.age = age;
        this.login = login;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", login='" + login + '\'' +
                '}';
    }
}
