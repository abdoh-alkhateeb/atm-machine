package com.mycompany.atm;

/**
 *
 * @author Abdulrahman Alkhateeb
 */
import java.util.ArrayList;

class TransactionHistory {

    private final ArrayList<Transaction> transactionHistory;

    TransactionHistory() {
        this.transactionHistory = new ArrayList<>();
    }

    public void appendTransaction(Transaction transaction) {
        transactionHistory.add(transaction);
    }

    public ArrayList<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    @Override
    public String toString() {
        return "Transaction history: " + transactionHistory.toString();
    }
}
