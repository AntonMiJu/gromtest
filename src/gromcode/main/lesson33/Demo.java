package gromcode.main.lesson33;

public class Demo {
    public static void main(String[] args) {
        ReadWriteFile.readFile("/home/anton/test.txt");
        ReadWriteFile.writeFile("/home/anton/test.txt");

        System.out.println();
        ReadWriteFile.readFile("/home/anton/test.txt");
    }
}
