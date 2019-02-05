package gromcode.main.lesson23;

public class Demo {
    public static void main(String[] args) {
        Validator validator1 = new Validator("user");
        System.out.println(validator1.getCheckCount());

        Validator validator2 = new Validator("comp");
        System.out.println(validator2.getCheckCount());
    }
}
