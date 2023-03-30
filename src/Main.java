package com.mycompany.atm;

/**
 *
 * @author Abdulrahman Alkhateeb
 */
import java.util.ArrayList;

public class Main {

    public static void main(String args[]) {
        User user1 = new User("Clark N. Cloer", "Norfolk, VA", "757-313-3176", Account.generateAccountNumber(), 2503.2, "1143");
        User user2 = new User("Steven S. Lucero", "Atlanta, GA", "404-869-5643", Account.generateAccountNumber(), 45356.67, "0014");

        ArrayList<User> userBase = new ArrayList<>();
        userBase.add(user1);
        userBase.add(user2);

        Machine machine = new Machine(userBase);
        machine.run();
    }
}
