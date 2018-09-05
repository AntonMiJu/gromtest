package homework;

public class task4 {
    public static void main(String[] args) {
        String[] names = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"};
        int[] balances = {100, 500, 8432, -99, 12000, -54, 0};
        System.out.println(withdraw(names,balances,"Nikolay",30));
    }

    static int withdraw(String[] clients, int[] balances, String client, int amount){
        int clientIndex = 0;
        for (String cl : clients){
            if (cl == client){
                break;
            }
            clientIndex++;
        }
        if (balances[clientIndex]<amount)
            return -1;
        else
            return (balances[clientIndex]-amount);
    }
}
