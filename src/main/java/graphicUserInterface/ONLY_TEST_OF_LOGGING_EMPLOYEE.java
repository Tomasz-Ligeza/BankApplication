package graphicUserInterface;

import java.util.HashMap;

/**
 * THIS CLASS IS SUPPOSED TO LIVE ONLY FOR DEVELOPPING
 * SHOULD BE DELETED OR TRANSFORMATED AFTER FINISHING
 * WORKING DATABASES AND LOGIC FOR GUI
 */
public class ONLY_TEST_OF_LOGGING_EMPLOYEE {
    HashMap<String, String> loginInfo = new HashMap<String, String>();

    public ONLY_TEST_OF_LOGGING_EMPLOYEE(){
        loginInfo.put("Empl1", "empl1");
        loginInfo.put("Empl2", "empl2");
        loginInfo.put("Empl3", "empl3");
        loginInfo.put("Empl4", "empl4");
    }

    public HashMap<String, String> getLoginInfo() {
        return loginInfo;
    }
}
