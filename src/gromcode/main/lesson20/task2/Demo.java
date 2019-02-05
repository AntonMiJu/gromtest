package gromcode.main.lesson20.task2;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Transaction transaction1 = new Transaction(1,"Kiev",30,"grom", TransactionType.INCOME, new Date());
        Transaction transaction2 = new Transaction(2,"Kiev",110,"grom", TransactionType.INCOME, new Date());
        Transaction transaction3 = new Transaction(3,"Odessa",10,"grom", TransactionType.INCOME, new Date());
        Transaction transaction4 = new Transaction(4,"Lviv",50,"grom", TransactionType.INCOME, new Date());

        Controller controller = new Controller();
        TransactionDAO transactionDAO = new TransactionDAO();
//        try {
//            Sys.out.println(controller.save(transaction1));
//        } catch (Exception e){
//            Sys.out.println(e.getMessage());
//        }
        try {

            transactionDAO.validate(transaction3);
            System.out.println(transactionDAO.save(transaction3));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(Arrays.toString(transactionDAO.transactionList()));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
