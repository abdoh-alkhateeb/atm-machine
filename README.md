# ATM Machine
This project simulates an ATM machine and is regarded as an implementation of its software. It is fully functional and does validate user input.

What follows is a general description of the constituent classes:
- **Machine Class**: This class represents the ATM machine and contains methods to interact with the user, such as prompting them to enter their account information and selecting a transaction.

- **User Class**: This class represents a user and contains information such as the user's name, address, and contact information. It has methods to authenticate the user's identity and retrieve their account information.

- **Account Class**: This class represents a user's account and contains information such as the account number, account balance, and PIN. It has methods to deposit, withdraw, and transfer funds, as well as methods to retrieve the account balance and transaction history.

- **Transaction Class**: This class represents a transaction, such as a withdrawal, deposit, or transfer. It contains information such as the amount of the transaction, the date and time, and any associated fees.

- **TransactionHistory Class**: This class represents the transaction history for an account and contains methods to add new transactions and retrieve the transaction history.

Finally, the __Main class__ instantiates the *Machine class* and calls its run method.
