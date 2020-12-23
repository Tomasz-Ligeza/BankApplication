package runnable;

import graphicUserInterface.CreateAccountMenu;
import graphicUserInterface.LoginMenu;
import graphicUserInterface.StartPage;

import java.io.IOException;

public class Runnable {

    public static void main(String[] args) throws IOException {

        //new LoginMenu();
        //new StartPage();
        new CreateAccountMenu();

        //TODO: create singleton for menu
    }
}