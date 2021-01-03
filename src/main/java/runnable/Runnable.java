package runnable;

import graphicUserInterface.*;
import graphicUserInterface.mainMenu.MainMenuCustomer;

import java.io.IOException;

public class Runnable {

    public static void main(String[] args) throws IOException {

        ONLY_TEST_OF_LOGGING_EMPLOYEE loginInfoEmployee = new ONLY_TEST_OF_LOGGING_EMPLOYEE();
        ONLY_TEST_OF_LOGGING_CUSTOMER loginInfoCustomer = new ONLY_TEST_OF_LOGGING_CUSTOMER();

        new StartPage(loginInfoCustomer.getLoginInfo(), loginInfoEmployee.getLoginInfo());

    }

}