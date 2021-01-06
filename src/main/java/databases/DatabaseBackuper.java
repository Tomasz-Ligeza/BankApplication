package databases;

public class DatabaseBackuper {
    private static DatabaseBackuper databaseBackuper;

    public static DatabaseBackuper getInstance() {
        if(databaseBackuper == null) {
            databaseBackuper = new DatabaseBackuper();
        }
        return databaseBackuper;

    }

    private DatabaseBackuper() {
    }



}
