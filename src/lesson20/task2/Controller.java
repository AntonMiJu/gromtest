package lesson20.task2;

import lesson20.task2.exception.InternalServerException;

public class Controller {
    private TransactionDAO transactionDAO = new TransactionDAO();

    Transaction save(Transaction transaction) throws  Exception{
        return transactionDAO.save(transaction);
    }

    Transaction[] transactionList() throws InternalServerException {
        return transactionDAO.transactionList();
    }

    Transaction[] transactionList(String city) throws InternalServerException {
        return transactionDAO.transactionList(city);
    }

    Transaction[] transactionList(int amount) throws InternalServerException {
        return transactionDAO.transactionList(amount);
    }
}
