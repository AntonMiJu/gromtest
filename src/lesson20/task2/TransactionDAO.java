package lesson20.task2;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;
import lesson20.task2.exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {
    private Transaction[] transactions = new Transaction[10];
    private Utils utils = new Utils();

    public Transaction save(Transaction transaction) throws Exception {
        validate(transaction);
        int index = 0;
        for (Transaction tr : transactions) {
            if (tr == null) {
                transactions[index] = transaction;
                break;
            }
            index++;
        }
        return transactions[index];
    }

    private void validate(Transaction transaction) throws Exception {
        if (transaction.getAmount() > utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceed " + transaction.getId() + ". can't be saved");

        int sum = 0;
        int count = 0;
        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {
            sum += tr.getAmount();
            count++;
        }

        if (sum > utils.getLimitTransactionsPerDayAmount())
            throw new LimitExceeded("Transaction limit per day amount exceed " + transaction.getId() + ". can't be saved");

        if (count > utils.getLimitTransactionsPerDayCount())
            throw new LimitExceeded("Transaction limit per day count exceed " + transaction.getId() + ". can't be saved");

        count = 0;
        for (String el : utils.getCities()) {
            if (transaction.getCity().equals(el))
                count++;
        }
        if (count!=1)
            throw new BadRequestException("Bad city request for transaction with id: "+transaction.getId());

        for (Transaction tr : transactions){
            if (transaction.equals(tr))
                throw new BadRequestException("Transaction with id: "+ transaction.getId()+" already in list");
        }

        count = 0;
        for (Transaction tr : transactions) {
            if (tr.equals(null))
                count++;
        }

        if (count == 0)
            throw new InternalServerException("Not enough space for transaction with id: " + transaction.getId());
    }


    Transaction[] transactionList() {
        return transactions;
    }

    Transaction[] transactionList(String city) {
        int count = 0;
        for (Transaction tr : transactions) {
            for (String el : utils.getCities()) {
                if (tr.getCity().equals(el))
                    count++;
            }
        }
        int index = 0;
        Transaction[] result = new Transaction[count];
        for (Transaction tr : transactions) {
            for (String el : utils.getCities()) {
                if (tr.getCity().equals(el)) {
                    result[index] = tr;
                    index++;
                }
            }
        }
        return result;
    }

    Transaction[] transactionList(int amount) {
        int count = 0;
        for (Transaction tr : transactions) {
            if (tr.getAmount() == amount)
                count++;
        }
        int index = 0;
        Transaction[] result = new Transaction[count];
        for (Transaction tr : transactions) {
            if (tr.getAmount() == amount) {
                result[index] = tr;
                index++;
            }
        }
        return result;
    }

    private Transaction[] getTransactionsPerDay(Date dateOfCurTransaction) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfCurTransaction);

        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day)
                    count++;
            }
        }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day) {
                    result[index] = transaction;
                    index++;
                }
            }
        }
        return result;
    }
}
