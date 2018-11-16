package lesson19.homework;

public class Controller {
    public static void put(Storage storage, File file) throws Exception {
        File[] storageFiles = storage.getFiles();
        validate(storage, file);
        for (int i = 0; i < storageFiles.length; i++) {
            if (storageFiles[i] == null) {
                storage.addFile(i, file);
                break;
            }
        }
    }

    public static void delete(Storage storage, File file) throws Exception {
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
        File[] storageF = storageFrom.getFiles();
        File[] storageT = storageTo.getFiles();
        int arrayToLength = 0;
        for (File el : storageT) {
            if (el == null)
                arrayToLength++;
        }
        if (storageF.length > arrayToLength)
            throw new Exception("StorageTo  is smaller");
        for (File el : storageF) {
            validate(storageTo, el);
        }
        for (int i = 0; i < storageF.length; i++) {
            put(storageTo, storageF[i]);
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
        for (int i = 0; i < files.length; i++) {
            if (files[i] != null && files[i].equals(file))
                return true;
        }
        return false;
    }

    private static boolean fileCorrectFormat(String[] formats, File file) {
        if (formats == null)
            return false;
        for (int i = 0; i < formats.length; i++) {
            if (formats[i] != null && formats[i].equals(file.getFormat()))
                return true;
        }
        return false;
    }

    private static void validate(Storage storage, File file) throws Exception {
        File[] storageFiles = storage.getFiles();
        if (fileInArray(storageFiles, file))
            throw new Exception("File " + file.getId() + " is already in BD " + storage.getId());
        int index = 0;
        for (File storageFile : storageFiles) {
            if (storageFile != null)
                index++;
        }
        if (!fileInArray(storageFiles, file) || index == storageFiles.length)
            throw new Exception("BD " + storage.getId() + " can not put file " + file.getId());

        if (!fileCorrectFormat(storage.getFormatsSupported(), file))
            throw new Exception("not that format");

        int sizeSum = 0;
        for (File el : storage.getFiles()) {
            if (el != null)
                sizeSum += el.getSize();
        }
        if (sizeSum > storage.getStorageSize())
            throw new Exception("Haven't enough memory for save file");
    }
}
