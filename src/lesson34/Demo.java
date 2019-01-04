package lesson34;

import java.io.File;

public class Demo {
    public static void main(String[] args) throws Exception{
//        Solution.copyFileContentExample("/home/anton/test.txt","/home/anton/test1.txt");
//        Solution.transferFileContent("/home/anton/test.txt","/home/anton/test1.txt");
        Solution.transferSentences("/home/anton/test.txt","/home/anton/test1.txt", "word");
    }
}
