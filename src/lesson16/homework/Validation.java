package lesson16.homework;

public class Validation {
    public static void main(String[] args) {
        System.out.println(validate(""));
        System.out.println(validate(null));
        System.out.println(validate("     "));
        System.out.println(validate("http://sdfsdfs.com"));
        System.out.println(validate("https://sdfs112dfs.org"));
        System.out.println(validate("https://sdfsd&**fs.org"));

    }

    private static boolean validate(String input){
        if (input == "" || input == null)
            return false;
        String[] http = input.split("//");
        if (http.length!=2)
            return false;
        if (!(http[0].equals("http:") || http[0].equals("https:")))
            return false;
        String[] com = http[1].split(".");
        if (com.length!=2)
            return false;
        if (!(com[1].equals("com") || com[1].equals("org") || com[1].equals("net")))
            return false;
        int i = 0;
        char[] array = com[0].toCharArray();
        for (char el:array){
            if (Character.isLetterOrDigit(el))
                i++;
        }
        if (i!=array.length)
            return false;
        return true;
    }
}
