package lesson19.homework;

public class Demo {
    public static void main(String[] args) {
        File file1 = null;
        File file2 = null;
        File file3 = null;
        File file4 = null;
        File file5 = null;

        Storage storagePutWithoutProblem = null;
        Storage storagePutFull = null;
        Storage storagePutFileExist = null;

        try {
            file1 = new File(1, "123", "txt", 128);
            file2 = new File(2, "sadasd", "jpg", 256);
            file3 = new File(3, "saffght", "doc", 512);
            file4 = new File(4, "d33fvx", "xlsx", 1024);
            file5 = new File(5, "safdafadfafafaasf", "ppt", 2048);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        File[] arrayPutWithoutProblem = {file1, null, file2, file4};
        File[] arrayPutFull = {file1, file5, file2, file4};
        File[] arrayPutFileExist = {file1, file5, file2, file4, file3};

        try {
            storagePutWithoutProblem = new Storage(1, arrayPutWithoutProblem, null, "Ukraine", 128);
            storagePutFull = new Storage(2, arrayPutFull, null, "Ukraine", 128);
            storagePutFileExist = new Storage(3, arrayPutFileExist, null, "Ukraine", 128);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Controller.put(storagePutWithoutProblem, file3);
            Controller.put(storagePutFull, file3);
            Controller.put(storagePutFileExist, file3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
