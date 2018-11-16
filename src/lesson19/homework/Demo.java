package lesson19.homework;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws Exception {

        File file1 = new File(1, "123", "txt", 50);
        File file2 = new File(2, "sadasd", "jpg", 3);
        File file3 = new File(3, "saffght", "doc", 20);
        File file4 = new File(4, "d33fvx", "txt", 2048);
        File file5 = new File(5, "safdafa", "ppt", 2048);

        File[] arrayPutWithoutProblem = {file1, null, file2, file4};
        File[] arrayPutFull = {file1, file5, file2, file4};
        File[] arrayPutFileExist = {file1, file5, file2, file4, file3};

        Storage storagePutWithoutProblem = new Storage(1, arrayPutWithoutProblem, new String[]{"doc", "jpg", "txt"}, "Ukraine", 128);
        Storage storagePutFull = new Storage(2, arrayPutFull, null, "Ukraine", 128);
        Storage storagePutFileExist = new Storage(3, arrayPutFileExist, null, "Ukraine", 128);


        Controller.put(storagePutWithoutProblem, file3);
        System.out.println(Arrays.toString(storagePutWithoutProblem.getFiles()));

        Controller.put(storagePutFull, file3);
        System.out.println(Arrays.toString(storagePutFull.getFiles()));

        Controller.put(storagePutFileExist, file3);
        System.out.println(Arrays.toString(storagePutFileExist.getFiles()));

    }
}
