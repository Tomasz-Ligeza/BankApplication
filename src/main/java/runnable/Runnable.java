package runnable;

import databases.DatabaseBackuper;
import graphicUserInterface.*;
import graphicUserInterface.mainMenu.MainMenuCustomer;

import java.io.IOException;

public class Runnable {

    public static void main(String[] args) throws IOException {
        new StartPage();
        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            @Override
            public void run()
            {
                DatabaseBackuper.getInstance().saveApplicationData();
            }
        });
    }

}