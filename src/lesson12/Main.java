package lesson12;

public class Main {
    public static void main(String[] args) {
        Bank euBank = new EUBank(1222, "Sweden", Currency.EUR, 100, 1400, 4, 444343434);
        Bank esBank = new USBank(1222, "Sweden", Currency.EUR, 100, 1400, 4, 444343434);
        Bank chinaBank = new ChinaBank(1222, "Sweden", Currency.EUR, 100, 1400, 4, 444343434);
        User user = new User(1001, "Denis", 1200, 40, "GMD", 1500, euBank);
        User user1 = new User(1002, "Andrey", 12200, 40, "GMD", 2500, euBank);
        User user2 = new User(1003, "Anton", 10000, 40, "GMD", 1500, esBank);
        User user3 = new User(1004, "Dima", 222202, 40, "GMD", 500, esBank);
        User user4 = new User(1005, "Jack", 102200, 40, "GMD", 3500, chinaBank);
        User user5 = new User(1006, "John", 120200, 40, "GMD", 1500, chinaBank);

        BankSystem bankSystem = new UkrainianBankSystem();
        bankSystem.withdraw(user, 150);
        bankSystem.fund(user, 200);
        bankSystem.transferMoney(user, user1, 200);

        System.out.println(user1.getBalance());
    }
}
