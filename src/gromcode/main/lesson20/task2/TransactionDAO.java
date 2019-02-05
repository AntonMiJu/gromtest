package gromcode.main.lesson20.task2;

import gromcode.main.lesson20.task2.exception.BadRequestException;
import gromcode.main.lesson20.task2.exception.InternalServerException;
import gromcode.main.lesson20.task2.exception.LimitExceeded;

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

    public void validate(Transaction transaction) throws Exception {
        if (transaction.getAmount() > utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceed " + transaction.getId() + ". can't be saved");

        int sum = transaction.getAmount();
        int count = 1;
        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {
            sum += tr.getAmount();
            count++;
        }

        if (sum > utils.getLimitTransactionsPerDayAmount())
            throw new LimitExceeded("Transaction limit per day amount exceed " + transaction.getId() + ". can't be saved");

        if (count > utils.getLimitTransactionsPerDayCount())
            throw new LimitExceeded("Transaction limit per day count exceed " + transaction.getId() + ". can't be saved");

        if (!validateByCity(transaction))
            throw new BadRequestException("Bad city request for transaction with id: " + transaction.getId());

        for (Transaction tr : transactions) {
            if (transaction.equals(tr))
                throw new BadRequestException("Transaction with id: " + transaction.getId() + " already in list");
        }

        count = 0;
        for (Transaction tr : transactions) {
            if (tr == null)
                count++;
        }

        if (count == 0)
            throw new InternalServerException("Not enough space for transaction with id: " + transaction.getId());
    }


    Transaction[] transactionList() {
        int count = 0;
        for (Transaction tr : transactions) {
            if (tr != null)
                count++;
        }
        int index = 0;
        Transaction[] result = new Transaction[count];
        for (Transaction tr : transactions) {
            if (tr != null) {
                result[index] = tr;
                index++;
            }
        }
        return result;
    }

    Transaction[] transactionList(String city) {
        int count = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getCity().equals(city))
                count++;
        }
        int index = 0;
        Transaction[] result = new Transaction[count];
        for (Transaction tr : transactions) {
            if (tr != null && tr.getCity().equals(city)) {
                result[index] = tr;
                index++;
            }
        }
        return result;
    }

    Transaction[] transactionList(int amount) {
        int count = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getAmount() == amount)
                count++;
        }
        int index = 0;
        Transaction[] result = new Transaction[count];
        for (Transaction tr : transactions) {
            if (tr != null && tr.getAmount() == amount) {
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

//    private void validateByTransactionList(int count) throws InternalServerException {
//        if (count == 0)
//            throw new InternalServerException("Haven't transactions");
//    }

    private boolean validateByCity(Transaction transaction) {
        for (String el : utils.getCities()) {
            if (transaction.getCity().equals(el))
                return true;
        }
        return false;
    }
}
