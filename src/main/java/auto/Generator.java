package auto;

import person.IDGenerator;

import java.security.SecureRandom;
import java.util.UUID;

public interface Generator {
    default String setPass(){
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder generatedPassword = new StringBuilder();
        for(int i = 0; i < 10; i++){
            int randomIndex = random.nextInt(chars.length());
            generatedPassword.append(chars.charAt(randomIndex));
        }

       return generatedPassword.toString();
    }

    default String setId(){
        return IDGenerator.getInstance().generateCustomerID();
    }
}
