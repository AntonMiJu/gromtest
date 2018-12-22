package lesson33.homework;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class WriteFromConsole {
    public static void writeToFileFromConsole(String path) {
        FileReader reader = null;
        try {
            reader = new FileReader(path);
        } catch (FileNotFoundException e) {
            System.err.println("File with path " + path + " not found");
            return;
        } finally {
            IOUtils.closeQuietly(reader);
        }
        InputStreamReader readerStr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(readerStr);
        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;

        System.out.println("Enter file content to write in the file:");

        try {
            writer = new FileWriter(path, true);
            bufferedWriter = new BufferedWriter(writer);

            String line;
            while (!((line = br.readLine()).equals("wr"))) {
                bufferedWriter.append(line);
                bufferedWriter.append("\n");
            }
        } catch (IOException e) {
            System.err.println("Can't write to file with path " + path);
        } finally {
            IOUtils.closeQuietly(writer);
            IOUtils.closeQuietly(bufferedWriter);
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(readerStr);
        }
    }
}
