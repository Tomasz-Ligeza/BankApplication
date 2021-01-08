package databases;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseBackuperTests {
    @BeforeEach
    void setUp() {
        DatabaseBackuper databaseBackuper = DatabaseBackuper.getInstance();
        databaseBackuper.saveApplicationData();
    }

    @Test
    public void customersDataFileExistsAfterSavingDataMethodTest() {
        Assertions.assertTrue(Files.exists(Path.of(System.getProperty("user.dir") + "\\src\\main\\resources\\customers.data")));

    }

    @Test void employeesDataFileExistsAfterSavingDataMethodTest() {
        Assertions.assertTrue(Files.exists(Path.of(System.getProperty("user.dir") + "\\src\\main\\resources\\employees.data")));
    }

    @Test
    public void accountsDataFileExistsAfterSavingDataMethodTest() {
        Assertions.assertTrue(Files.exists(Path.of(System.getProperty("user.dir") + "\\src\\main\\resources\\accounts.data")));
    }

    @Test
    public void customersDataFileGreaterThanZeroTest() {
        long size = 0;
        try {
            size = Files.size(Path.of(System.getProperty("user.dir") + "\\src\\main\\resources\\customers.data"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        Assertions.assertTrue(size > 0);
    }

    @Test
    public void employeesDataFileGreaterThanZeroTest() {
        long size = 0;
        try {
            size = Files.size(Path.of(System.getProperty("user.dir") + "\\src\\main\\resources\\employees.data"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        Assertions.assertTrue(size > 0);
    }

    @Test
    public void accountsDataFileGreaterThanZeroTest() {
        long size = 0;
        try {
            size = Files.size(Path.of(System.getProperty("user.dir") + "\\src\\main\\resources\\accounts.data"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        Assertions.assertTrue(size > 0);
    }

}