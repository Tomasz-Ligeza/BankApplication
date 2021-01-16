package person;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IDGeneratorTest {

    @Test
    void generateCustomerID() {
        IDGenerator idGenerator = IDGenerator.getInstance();
        Assertions.assertTrue(idGenerator.generateCustomerID().compareTo("000000") > 0);
    }
}