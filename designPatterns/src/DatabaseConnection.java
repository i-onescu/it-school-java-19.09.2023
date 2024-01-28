package designPatterns.src;

public class DatabaseConnection {

    private static volatile DatabaseConnection dbCon;

    private String url = "jdbc:postgres://localhost:5432/mydb";
    private String type = "postgresql";

    private DatabaseConnection() {}

    public static DatabaseConnection getInstance() {
        if (dbCon == null) {
            synchronized (DatabaseConnection.class) {
                if (dbCon == null) {
                    dbCon = new DatabaseConnection();
                }
            }
        }
        return dbCon;
    }

    public void printDbDetails() {
        System.out.println("Printing Db Details...");
        System.out.println("Url: " + url + "; type: " + type);
    }
}


