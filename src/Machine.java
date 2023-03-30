package com.mycompany.atm;

/**
 *
 * @author Abdulrahman Alkhateeb
 */
import java.util.Scanner;
import java.util.ArrayList;

public class Machine {

    private final ArrayList<User> userBase;
    private User currentUser;
    private final static Scanner read = new Scanner(System.in);

    public Machine(ArrayList<User> initUserBase) {
        this.userBase = initUserBase;
    }

    public void run() {
        System.out.print("Hey there! We are glad to see you here.");

        while (true) {
            try {
                logUserIn();
                provideServicesLoop();
            } catch (StringIndexOutOfBoundsException e) {
            } catch (Exception e) {
                System.out.println("Operation rejected! " + e.getMessage());
            }
        }
    }

    private void logUserIn() throws Exception {
        String accountNumber, PIN;

        System.out.print("\nEnter account number: ");
        accountNumber = read.nextLine();

        System.out.print("Enter PIN: ");
        PIN = read.nextLine();

        currentUser = searchUserBase(accountNumber);
        currentUser.authenticate(PIN);
    }

    private User searchUserBase(String accountNumber) throws Exception {
        for (User user : userBase) {
            if (user.getAccount().getAccountNumber().equals(accountNumber)) {
                return user;
            }
        }

        throw new Exception("Account not found!");
    }

    private void provideServicesLoop() throws Exception {
        char choice;

        while (true) {
            System.out.println("\n1. Account settings\n2. Balance inquiry\n3. Cash withdrawal\n4. Cash deposit\n5. Transfer\n6. Review transaction history\nAny other key to exit...");

            System.out.print("\nYour choice: ");
            choice = read.nextLine().charAt(0);

            switch (choice) {
                case '1' ->
                    handleAccountSettings();

                case '2' ->
                    printAccountBalance();

                case '3' ->
                    handleWithdraw();

                case '4' ->
                    handleDeposit();

                case '5' ->
                    handleTransfer();

                case '6' ->
                    printTransactionHistory();

                default -> {
                    return;
                }
            }
        }
    }

    private void handleAccountSettings() throws Exception {
        System.out.println("\n1. Review account details\n2. Change PIN");

        System.out.print("\nYour choice: ");
        char choice = read.nextLine().charAt(0);

        switch (choice) {
            case '1' ->
                printAccountDetails();

            case '2' ->
                handleChangePIN();

            default ->
                System.out.println("Invalid choice!");
        }
    }

    private void printAccountDetails() {
        System.out.println("\nName: " + currentUser.getName());
        System.out.println("Address: " + currentUser.getAddress());
        System.out.println("Phone number: " + currentUser.getPhoneNumber());
        System.out.println("Account number: " + currentUser.getAccount().getAccountNumber());
    }

    private void handleChangePIN() throws Exception {
        System.out.print("\nEnter old PIN: ");
        currentUser.authenticate(read.nextLine());
        System.out.print("Enter new PIN: ");
        String newPIN = read.nextLine();

        if (isValidPIN(newPIN)) {
            currentUser.getAccount().setPIN(newPIN);
            return;
        }

        throw new Exception("New PIN does not meet requirements.");
    }

    private boolean isValidPIN(String PIN) {
        try {
            Integer.parseInt(PIN);
            return PIN.length() == 4;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void printAccountBalance() {
        System.out.println("\nAvailable balance: " + String.format("%.2f", currentUser.getAccount().getAccountBalance()) + " $");
    }

    private void handleWithdraw() throws Exception {
        System.out.print("Enter amount: ");
        currentUser.getAccount().withdraw(Double.parseDouble(read.nextLine()));
    }

    private void handleDeposit() {
        System.out.print("Enter amount: ");
        currentUser.getAccount().deposit(Double.parseDouble(read.nextLine()));
    }

    private void handleTransfer() throws Exception {
        System.out.print("Enter amount: ");
        double amount = Double.parseDouble(read.nextLine());

        System.out.print("Enter recipient account number: ");
        User recipientUser = searchUserBase(read.nextLine());

        currentUser.getAccount().transfer(amount, recipientUser.getAccount());
    }

    private void printTransactionHistory() {
        System.out.println("\n" + currentUser.getAccount().getTransactionHistory().toString());
    }
}
