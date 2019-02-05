package gromcode.main.lesson22.homework;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Transaction transaction1 = new Transaction(1,"Kiev",30,"grom", TransactionType.INCOME, new Date());
        Transaction transaction2 = new Transaction(2,"Kiev",110,"grom", TransactionType.INCOME, new Date());
        Transaction transaction3 = new Transaction(3,"Odessa",10,"grom", TransactionType.INCOME, new Date());
        Transaction transaction4 = new Transaction(4,"Lviv",50,"grom", TransactionType.INCOME, new Date());

        try {
            System.out.println(Controller.save(transaction1));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
//        try {
//
//            transactionDAO.validate(transaction3);
//            Sys.out.println(transactionDAO.save(transaction3));
//        } catch (Exception e){
//            Sys.out.println(e.getMessage());
//        }
        try {
            System.out.println(Arrays.toString(TransactionDAO.transactionList()));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
