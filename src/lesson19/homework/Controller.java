package lesson19.homework;

public class Controller {
    public static void put(Storage storage, File file) throws Exception {
        File[] storageFiles = storage.getFiles();
        if (fileInArray(storageFiles, file))
            throw new Exception("File " + file.getId() + " is already in BD " + storage.getId());
        int j = 0;
        for (int i = 0; i < storageFiles.length; i++) {
            if (storageFiles[i] == null) {
                storage.addFile(i,file);
                break;
            } else
                j++;
        }
        if (!fileInArray(storageFiles, file) || j == storageFiles.length)
            throw new Exception("BD " + storage.getId() + " can not put file " + file.getId());
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
        for (File el : storageT){
            if (el==null)
                arrayToLength++;
        }
        if (storageF.length>arrayToLength)
            throw new Exception("StorageTo  is smaller");
        for (int i = 0; i<storageF.length;i++){
            put(storageTo,storageF[i]);
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
}
