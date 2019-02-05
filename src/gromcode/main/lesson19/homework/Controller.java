package gromcode.main.lesson19.homework;

public class Controller {
    public static void put(Storage storage, File file) throws Exception {
        validate(storage, file);
        int index = 0;
        for (File el : storage.getFiles()) {
            if (el == null) {
                storage.addFile(index, file);
                break;
            }
            index++;
        }
    }

    public static void delete(Storage storage, File file) throws Exception {
        if (!fileInArray(storage.getFiles(), file))
            throw new Exception("File " + file.getId() + " is not in BD " + storage.getId());
        int index = 0;
        for (File el : storage.getFiles()) {
            if (el != null && el.equals(file))
                storage.addFile(index, null);
            index++;
        }
    }

    public static void transferAll(Storage storageFrom, Storage storageTo) throws Exception {
        int arrayToLength = 0;
        for (File el : storageTo.getFiles()) {
            if (el == null)
                arrayToLength++;
        }
        if (storageFrom.getFiles().length > arrayToLength)
            throw new Exception("StorageTo "+storageTo.getId()+" is smaller than StorageFrom: "+ storageFrom.getId());
        for (File el : storageFrom.getFiles()) {
            validate(storageTo, el);
        }
        for (File el : storageFrom.getFiles()) {
            put(storageTo, el);
        }
    }

    public static void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {
        File[] storageFiles = storageFrom.getFiles();
        int j = 0;
        for (File el : storageFiles) {
            if (el.getId() == id) {
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
        for (File file1 : files) {
            if (file1 != null && file1.equals(file))
                return true;
        }
        return false;
    }

    private static boolean fileCorrectFormat(String[] formats, File file) {
        if (formats == null)
            return false;
        for (String format : formats) {
            if (format != null && format.equals(file.getFormat()))
                return true;
        }
        return false;
    }

    private static void validate(Storage storage, File file) throws Exception {
        if (storage == null)
            throw new Exception("Null storage" + storage.getId()+ " cant put file: "+ file.getId());
        File[] storageFiles = storage.getFiles();
        if (fileInArray(storageFiles, file))
            throw new Exception("File " + file.getId() + " is already in BD " + storage.getId());
        int index = 0;
        for (File storageFile : storageFiles) {
            if (storageFile != null)
                index++;
        }
        if (index == storageFiles.length)
            throw new Exception("BD " + storage.getId() + " can not put file " + file.getId());

        if (!fileCorrectFormat(storage.getFormatsSupported(), file))
            throw new Exception("Not that format in file: " + file.getId()+ " for storage : "+ storage.getId());

        int sizeSum = 0;
        for (File el : storage.getFiles()) {
            if (el != null)
                sizeSum += el.getSize();
        }
        if (sizeSum > storage.getStorageSize())
            throw new Exception("Haven't enough memory in storage: "+storage.getId()+" for save file: " + file.getId());
    }
}
