package lesson19.homework;

public class Demo {
    public static void main(String[] args) {
        File file1 = new File(1,"123","txt", 128);
        File file2 = new File(2,"sadasd","jpg",256);
        File file3 = new File(3,"saffght","doc",512);
        File file4 = new File(4,"d33fvx","xlsx",1024);
        File file5 = new File(5,"safdafadfafafaasf","ppt",2048);

        File[] arrayPutWithoutProblem = {file1,null,file2,file4};
        File[] arrayPutFull = {file1,file5,file2,file4};
        File[] arrayPutFileExist = {file1,file5,file2,file4,file3};

        Storage storagePutWithoutProblem = new Storage(1,arrayPutWithoutProblem,null,"Ukraine",128);
        Storage storagePutFull = new Storage(2,arrayPutFull,null,"Ukraine",128);
        Storage storagePutFileExist = new Storage(3,arrayPutFileExist,null,"Ukraine",128);

        try {
            Controller.put(storagePutWithoutProblem,file3);
            Controller.put(storagePutFull,file3);
            Controller.put(storagePutFileExist,file3);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}
