package com.mycompany.atm;

/**
 *
 * @author Abdulrahman Alkhateeb
 */
import java.util.Date;

class Transaction {

    private static int numberGenerated = 0;
    private final int number;
    private final double amount;
    private final double fee;
    private final Date date;
    private final types type;

    public static enum types {
        DEPOSIT,
        WITHDRAW,
        TRANSFER_SEND,
        TRANSFER_RECEIVE
    }

    public Transaction(double amount, types type) {
        this.number = numberGenerated++;
        this.amount = amount;
        this.fee = amount * switch (type) {
            case DEPOSIT ->
                0.01;
            case WITHDRAW ->
                0.05;
            case TRANSFER_SEND ->
                0.025;
            case TRANSFER_RECEIVE ->
                0;
        };
        this.date = new Date();
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public double getFee() {
        return fee;
    }

    public Date getDate() {
        return date;
    }

    public types getType() {
        return type;
    }

    @Override
    public String toString() {
        return "{ Transaction number: " + number + ", amount: " + String.format("%.2f", amount) + ", fee: " + String.format("%.2f", fee) + ", date: " + date.toString() + ", type: " + type + " }";
    }
}
