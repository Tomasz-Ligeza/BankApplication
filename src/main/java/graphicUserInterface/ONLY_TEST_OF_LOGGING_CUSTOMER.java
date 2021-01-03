package graphicUserInterface;

import java.util.HashMap;

/**
 * THIS CLASS IS SUPPOSED TO LIVE ONLY FOR DEVELOPPING
 * SHOULD BE DELETED OR TRANSFORMATED AFTER FINISHING
 * WORKING DATABASES AND LOGIC FOR GUI
 */
public class ONLY_TEST_OF_LOGGING_CUSTOMER {
    HashMap<String, String> loginInfo = new HashMap<String, String>();

    public ONLY_TEST_OF_LOGGING_CUSTOMER(){
        loginInfo.put("Client1", "client1");
        loginInfo.put("Client2", "client2");
        loginInfo.put("Client3", "client3");
        loginInfo.put("Client4", "client4");
    }

    public HashMap<String, String> getLoginInfo() {
        return loginInfo;
    }
}
