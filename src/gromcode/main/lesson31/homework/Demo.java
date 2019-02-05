package gromcode.main.lesson31.homework;

public class Demo {
    public static void main(String[] args) {
        System.out.println(MapMethods.countSymbols("aas s s a a a a p"));
        System.out.println(MapMethods.countSymbols("    aas s s a a a a p    "));
        System.out.println(MapMethods.countSymbols("      "));
        System.out.println(MapMethods.countSymbols(null));

        System.out.println(MapMethods.words("sfsaf asfasf asfasf afs aasd afs afs sf afs"));
        System.out.println(MapMethods.words("   sfsaf  asfasf asfasf afs aasd afs afs sf afs    "));
        System.out.println(MapMethods.words("    "));
        System.out.println(MapMethods.words(null));
    }
}
