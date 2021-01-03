package runnable;

import graphicUserInterface.*;
import java.io.IOException;

public class Runnable {

    public static void main(String[] args) throws IOException {

        ONLY_TEST_OF_LOGGING_EMPLOYEE loginInfoEmployee = new ONLY_TEST_OF_LOGGING_EMPLOYEE();
        ONLY_TEST_OF_LOGGING_CUSTOMER loginInfoCustomer = new ONLY_TEST_OF_LOGGING_CUSTOMER();

        StartPage start = new StartPage(loginInfoCustomer.getLoginInfo(), loginInfoEmployee.getLoginInfo());

    }

}