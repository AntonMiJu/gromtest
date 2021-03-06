//package gromcode.main.lesson33.homework;
//
////import org.apache.commons.io.IOUtils;
//
//import java.io.*;
//
//public class ReadFromConsole {
//    public static void readFileByConsolePath(){
//        InputStreamReader reader = new InputStreamReader(System.in);
//        BufferedReader br = new BufferedReader(reader);
//
//        System.out.println("Please, enter file path to read:");
//
//        try {
//            String line;
//            if ((line = br.readLine()) != null)
//                readFile(line);
//        } catch (IOException e){
//            System.err.println();
//        } finally {
////            IOUtils.closeQuietly(reader);
////            IOUtils.closeQuietly(br);
//        }
//    }
//
//    private static void readFile(String path) {
//        FileReader reader;
//        try {
//            reader = new FileReader(path);
//        } catch (FileNotFoundException e){
//            System.err.println("File with path " + path + " not found");
//            return;
//        }
//        BufferedReader br = new BufferedReader(reader);
//
//        try {
//            String line;
//            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//            }
//        } catch (IOException e){
//            System.err.println("Can't read file by path " + path);
//        } finally {
//            IOUtils.closeQuietly(reader);
//            IOUtils.closeQuietly(br);
//        }
//    }
//}
