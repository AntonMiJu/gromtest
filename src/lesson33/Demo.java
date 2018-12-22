package lesson33;

public class Demo {
    public static void main(String[] args) {
        ReadWriteFile readWriteFile = new ReadWriteFile();
        readWriteFile.readFile("/home/anton/Desktop/test.txt");
        readWriteFile.writeFile("/home/anton/Desktop/test1.txt");
    }
}
