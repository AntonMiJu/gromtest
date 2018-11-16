package lesson19.homework;

public class Storage {
    private long id;
    private File[] files;
    private String[] formatsSupported;
    private String storageCountry;
    private long storageSize;

    public Storage(long id, File[] files, String[] formatsSupported, String storageCountry, long storageSize) throws Exception {
        this.id = id;
        this.files = files;
//        for (File el : files) {
//            if (!fileInArray(formatsSupported, el))
//                throw new Exception("not that format");
//        }
        this.formatsSupported = formatsSupported;
        this.storageCountry = storageCountry;
        int i = 0;
//        for (File el : files) {
//            if (el != null)
//                i += el.getSize();
//        }
//        if (i > storageSize)
//            throw new Exception("size is too large");
        this.storageSize = storageSize;
    }

    public long getId() {
        return id;
    }

    public File[] getFiles() {
        return files;
    }

    public void setFiles(File[] files) {
        this.files = files;
    }

    public void addFile(int i, File file) {
        files[i] = file;
    }

    private static boolean fileInArray(String[] formats, File file) {
        if (formats == null)
            return false;
        for (int i = 0; i < formats.length; i++) {
            if (formats[i] != null && formats[i].equals(file.getFormat()))
                return true;
        }
        return false;
    }

//    private static void validateBySize(File[] files, long storageSize) throws Exception {
//        int i = 0;
//        for (File el : files) {
//            if (el != null)
//                i += el.getSize();
//        }
//        if (i > storageSize)
//            throw new Exception("size is too large");
//    }
}
