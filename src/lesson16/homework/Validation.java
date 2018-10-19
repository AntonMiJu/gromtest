package lesson16.homework;

public class Validation {
    public static void main(String[] args) {
        System.out.println(validate(""));
        System.out.println(validate(null));
        System.out.println(validate("     "));
        System.out.println(validate("http://sdfsdfs.com"));
        System.out.println(validate("https://www.sdfs112dfs.net"));
        System.out.println(validate("http://www.sdfsd&**fs.org"));

    }

    private static boolean validate(String address){
        String[] array = address.split("//");
        if (array.length!=2 || !array[0].equals("http:") && !array[0].equals("https:"))
            return false;
        String[] com = array[1].split("\\.");
        if (com.length==2 && (com[1].equals("com") || com[1].equals("org") || com[1].equals("net"))){
            int i = 0;
            char[] mid = com[0].toCharArray();
            for (char el: mid){
                if (Character.isLetterOrDigit(el))
                    i++;
            }
            if (i==mid.length)
                return true;
        }
        if (com.length==3 && (com[2].equals("com") || com[2].equals("org") || com[2].equals("net")) && com[0].equals("www")){
            int i = 0;
            char[] mid = com[1].toCharArray();
            for (char el: mid){
                if (Character.isLetterOrDigit(el))
                    i++;
            }
            if (i==mid.length)
                return true;
        }
        return false;
    }
}
