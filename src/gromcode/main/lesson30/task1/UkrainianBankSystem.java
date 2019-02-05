package gromcode.main.lesson30.task1;

import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class UkrainianBankSystem implements BankSystem {
    private Set<Transaction> transactions = new TreeSet<>();

    @Override
    public void withdraw(User user, int amount) {
        if (!checkWithdraw(user, amount))
            return;
        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));

       createAndSaveTransaction(new Date(), TransactionType.WITHDRAWAL,amount,"dsfsd");
    }

    @Override
    public void fund(User user, int amount) {
        if (!checkFundLimits(user, amount, user.getBank().getLimitOfFunding()))
            return;
        user.setBalance(user.getBalance() + amount);

        createAndSaveTransaction(new Date(), TransactionType.FUNDING,amount,"dsfsd");
    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
        if (!checkWithdraw(fromUser, amount))
            return;
        if (!checkFundLimits(toUser, amount, toUser.getBank().getLimitOfFunding()))
            return;
        if (fromUser.getBank().getCurrency() != toUser.getBank().getCurrency())
            return;

        fromUser.setBalance(fromUser.getBalance() - amount - amount * fromUser.getBank().getCommission(amount));
        toUser.setBalance(toUser.getBalance() + amount);

        createAndSaveTransaction(new Date(), TransactionType.TRANSFER,amount,"dsfsd");
    }

    @Override
    public void paySalary(User user) {
        user.getBank().setTotalCapital(user.getBank().getTotalCapital() - user.getSalary());
        if (!checkFundLimits(user, user.getSalary(), user.getBank().getLimitOfFunding()))
            return;
        user.setBalance(user.getBalance() + user.getSalary());

        createAndSaveTransaction(new Date(), TransactionType.SALARY_INCOME,user.getSalary(),"dsfsd");
    }

    private boolean checkWithdraw(User user, int amount) {
        return (amount > 0 && checkWithdrawLimits(user, amount, user.getBank().getLimitOfWithdrawal()) && checkWithdrawLimits(user, amount, user.getBalance()));
    }

    private boolean checkWithdrawLimits(User user, int amount, double limit) {
        if (amount + user.getBank().getCommission(amount) > limit) {
            printWithdrawalErrorMsg(amount, user);
            return false;
        }
        return true;
    }

    private boolean checkFundLimits(User user, int amount, double limit) {
        if (amount > limit && amount > 0) {
            printFundErrorMsg(amount, user);
            return false;
        }
        return true;
    }

    private void printWithdrawalErrorMsg(int amount, User user) {
        System.err.println("Can't withdraw money" + amount + "from " + user.toString());
    }

    private void printFundErrorMsg(int amount, User user) {
        System.err.println("Can't fund money" + amount + "from " + user.toString());
    }

    private Transaction createAndSaveTransaction(Date dateCreated, TransactionType type, int amount, String description){
        Random random = new Random();
        Transaction tr = new Transaction(random.nextInt(), dateCreated, null, type, amount,description);
        transactions.add(tr);
        return tr;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }
}
