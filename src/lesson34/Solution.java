package lesson34;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public static void copyFileContentExample(String fileFromPath, String fileToPath) throws Exception {
        validate(fileFromPath, fileToPath);
        writeToFile(fileToPath, readFromFile(fileFromPath));
    }

    public static void transferFileContent(String fileFromPath, String fileToPath) throws Exception {
        validate(fileFromPath, fileToPath);
        writeToFile(fileToPath, readFromFile(fileFromPath));
        deleteFromFile(fileFromPath);
    }

    public static void transferSentences(String fileFromPath, String fileToPath, String word) throws Exception{
        validate(fileFromPath, fileToPath);
        try(BufferedReader br = new BufferedReader(new FileReader(fileFromPath)); BufferedWriter bwFrom = new BufferedWriter(new FileWriter(fileFromPath,true));BufferedWriter bwTo = new BufferedWriter(new FileWriter(fileToPath, true))){
            String line;
            String[] sentences;
            StringBuffer res = new StringBuffer();
            while ((line = br.readLine()) != null){
                sentences = line.split("\\.");
                for (String sntns: sentences){
                    if (sntns.length()>10 && sntns.contains(word)){
                        bwTo.append(sntns.trim()+".");
                        bwTo.append("\n");
                    } else {
                        res.append(sntns.trim()+".");
                        res.append("\n");
                    }
                }
            }
            deleteFromFile(fileFromPath);
            bwFrom.append(res);
        } catch (IOException e) {
            System.err.println("Writing to file " + fileToPath + " failed");
        }
    }

    public static void copyFileContent(String fileFromPath, String fileToPath){
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);
    }

    private static StringBuffer readFromFile(String path) {
        StringBuffer res = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.append(line);
                res.append("\n");
            }
            res.replace(res.length() - 1, res.length(), "");
        } catch (FileNotFoundException e) {
            System.err.println("File " + path + " does not exist");
        } catch (IOException e) {
            System.out.println("Reading from file " + path + " failed");
        }
        return res;
    }

    private static void writeToFile(String path, StringBuffer contentToWrite) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.append(contentToWrite);
        } catch (IOException e) {
            System.err.println("Writing to file " + path + " failed");
        }
    }

    private static void deleteFromFile(String path){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write("");
        } catch (IOException e) {
            System.err.println("Deleting from file " + path + " failed");
        }
    }

    private static void validate(String fileFromPath, String fileToPath) throws Exception {
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);
        if (!fileFrom.exists()) {
            throw new FileNotFoundException("File " + fileFromPath + " does not exist");
        }
        if (!fileTo.exists()) {
            throw new FileNotFoundException("File " + fileToPath + " does not exist");
        }
        if (!fileFrom.canRead()) {
            throw new Exception("Reading from file " + fileFromPath + " failed");
        }
        if (!fileTo.canWrite()) {
            throw new Exception("Writing to file " + fileToPath + " failed");
        }
    }
}
