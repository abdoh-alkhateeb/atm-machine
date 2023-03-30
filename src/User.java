package com.mycompany.atm;

/**
 *
 * @author Abdulrahman Alkhateeb
 */
class User {

    private final String name;
    private final String address;
    private final String phoneNumber;
    private final Account account;

    public User(String name, String address, String phoneNumber, String accountNumber, double accountBalance, String PIN) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.account = new Account(accountNumber, accountBalance, PIN);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Account getAccount() {
        return account;
    }

    public void authenticate(String PIN) throws Exception {
        if (!account.getPIN().equals(PIN)) {
            throw new Exception("Incorrect PIN.");
        }
    }
}
