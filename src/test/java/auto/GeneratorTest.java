package auto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneratorTest implements Generator {
    String generatedPassword;

    @BeforeEach
    void setUp(){
        generatedPassword = setPass();
    }

    @Test
    void setPass_generateString_assertTypeOfString(){
        Assertions.assertTrue(generatedPassword instanceof String);
    }

}