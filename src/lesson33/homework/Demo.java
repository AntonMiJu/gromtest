package lesson33.homework;

import lesson33.ReadWriteFile;

public class Demo {
    public static void main(String[] args) {
        WriteFromConsole.writeToFileFromConsole("/home/anton/Desktop/test.txt");
        ReadWriteFile.writeFile("/home/anton/Desktop/test.txt");
        //WriteFromConsole.writeToFileFromConsole("/home/anton/Desktop/test1.txt");
    }
}
