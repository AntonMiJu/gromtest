//package gromcode.main.lesson33;
//
//import org.apache.commons.io.IOUtils;
//
//import java.io.*;
//
//public class ReadWriteFile {
//    public static void readFile(String path) {
//        FileReader reader;
//        try {
//            reader = new FileReader(path);
//        } catch (FileNotFoundException e){
//            System.err.println("File does not exist");
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
//            System.out.println("Reading from file "+path+" failed");
//        } finally {
//            IOUtils.closeQuietly(reader);
//            IOUtils.closeQuietly(br);
//        }
//    }
//
//    public static void writeFile(String path){
//        FileWriter writer = null;
//        BufferedWriter bufferedWriter = null;
//        try {
//            writer = new FileWriter(path, true);
//            bufferedWriter = new BufferedWriter(writer);
//
//            bufferedWriter.append("\n");
//            bufferedWriter.append("PPPPPPPP");
//        } catch (IOException e){
//            System.err.println("Can't write to file");
//            return;
//        } finally {
//            IOUtils.closeQuietly(writer);
//            IOUtils.closeQuietly(bufferedWriter);
//        }
//    }
//}
