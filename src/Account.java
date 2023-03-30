package com.mycompany.atm;

/**
 *
 * @author Abdulrahman Alkhateeb
 */
class Account {

    private static String nextGeneratedAccountNumber = "0";
    private final String accountNumber;
    private double accountBalance;
    private String PIN;
    private final TransactionHistory transactionHistory;

    public Account(String accountNumber, double accountBalance, String PIN) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.PIN = PIN;
        this.transactionHistory = new TransactionHistory();
    }

    public static String generateAccountNumber() {
        String generatedAccountNumber = nextGeneratedAccountNumber;
        nextGeneratedAccountNumber = Integer.toString(Integer.parseInt(nextGeneratedAccountNumber) + 1);
        return generatedAccountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public String getPIN() {
        return PIN;
    }

    public TransactionHistory getTransactionHistory() {
        return transactionHistory;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public void deposit(double amount) {
        Transaction transaction = new Transaction(amount, Transaction.types.DEPOSIT);
        accountBalance += (amount - transaction.getFee());
        transactionHistory.appendTransaction(transaction);
    }

    public void withdraw(double amount) throws Exception {
        Transaction transaction = new Transaction(amount, Transaction.types.WITHDRAW);

        if ((amount + transaction.getFee()) <= accountBalance) {
            accountBalance -= (amount + transaction.getFee());
        } else {
            throw new Exception("Non-sufficient funds.");
        }

        transactionHistory.appendTransaction(transaction);
    }

    public void transfer(double amount, Account recipient) throws Exception {
        Transaction sendTransaction = new Transaction(amount, Transaction.types.TRANSFER_SEND);
        Transaction receiveTransaction = new Transaction(amount, Transaction.types.TRANSFER_RECEIVE);

        if ((amount + sendTransaction.getFee()) <= accountBalance) {
            accountBalance -= (amount + sendTransaction.getFee());
            recipient.accountBalance += amount;
        } else {
            throw new Exception("Non-sufficient funds.");
        }

        transactionHistory.appendTransaction(sendTransaction);
        recipient.transactionHistory.appendTransaction(receiveTransaction);
    }
}
