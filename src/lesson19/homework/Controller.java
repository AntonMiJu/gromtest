package lesson19.homework;

import java.util.Arrays;

public class Controller {

    public static void put(Storage storage, File file) throws Exception {
        validate(file);
        File[] storageFiles = storage.getFiles();
        int j = 0;
        for (int i = 0; i < storageFiles.length; i++) {
            if (!fileInArray(storageFiles, file) && storageFiles[i] == null) {
                storageFiles[i] = file;
                break;
            } else
                j++;
        }
        if (j == storageFiles.length)
            throw new Exception("BD " + storage.getId() + " can not put file " + file.getId());
        storage.setFiles(storageFiles);
    }

    public static void delete(Storage storage, File file) throws Exception {
        validate(file);
        File[] storageFiles = storage.getFiles();
        if (!fileInArray(storageFiles, file))
            throw new Exception("File " + file.getId() + " is not in BD " + storage.getId());
        for (int i = 0; i < storageFiles.length; i++) {
            if (storageFiles[i].equals(file))
                storageFiles[i] = null;
        }
        storage.setFiles(storageFiles);
    }

    public static void transferAll(Storage storageFrom, Storage storageTo) throws Exception {
//       try {
//           storageTo.setFiles(storageFrom.getFiles());
//       } catch (Exception e){
//           System.out.println("Second BD "+storageTo.getId()+" is smaller than first "+storageFrom.getId());
//       }

        if (storageFrom.getFiles().length != storageTo.getFiles().length) {
            throw new Exception("Second BD " + storageTo.getId() + " is smaller than first " + storageFrom.getId());
        }
        File[] storageFiles = storageFrom.getFiles();
        File[] result = new File[storageFiles.length];
        for (int i = 0; i < storageFiles.length; i++) {
            validate(storageFiles[i]);
            result[i] = storageFiles[i];
        }
        storageTo.setFiles(result);
    }

    public static void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {
        File[] storageFiles = storageFrom.getFiles();
        int j = 0;
        for (File el : storageFiles) {
            if (el.getId() == id) {
                validate(el);
                put(storageTo, el);
            } else
                j++;
        }
        if (j == storageFiles.length)
            throw new Exception("File " + id + " is not in BD " + storageFrom.getId());
    }

    private static boolean fileInArray(File[] files, File file) {
        if (files == null)
            return false;
        for (int i = 0; i < files.length; i++) {
            if (files[i] != null && files[i].equals(file))
                return true;
        }
        return false;
    }

    private static void validate(File file) throws Exception {
        if (file.getName().length() > 10)
            throw new Exception("Name is too long");
    }
}
