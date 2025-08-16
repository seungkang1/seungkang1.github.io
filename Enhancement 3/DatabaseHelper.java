import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class DatabaseHelper {
    private static final String DB_URL = "jdbc:sqlite:rescue_animals.db";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
        return conn;
    }

    public static void createTables() {
        String dogTable = "CREATE TABLE IF NOT EXISTS dogs ("
                + "name TEXT PRIMARY KEY,"
                + "breed TEXT,"
                + "gender TEXT,"
                + "age TEXT,"
                + "weight TEXT,"
                + "acquisitionDate TEXT,"
                + "acquisitionCountry TEXT,"
                + "trainingStatus TEXT,"
                + "reserved INTEGER,"
                + "inServiceCountry TEXT"
                + ");";

        String monkeyTable = "CREATE TABLE IF NOT EXISTS monkeys ("
                + "name TEXT PRIMARY KEY,"
                + "species TEXT,"
                + "gender TEXT,"
                + "age TEXT,"
                + "acquisitionDate TEXT,"
                + "acquisitionCountry TEXT,"
                + "trainingStatus TEXT,"
                + "reserved INTEGER,"
                + "inServiceCountry TEXT"
                + ");";

        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(dogTable);
            stmt.execute(monkeyTable);
            System.out.println("Tables created (if not exist).");
        } catch (SQLException e) {
            System.out.println("Error creating tables: " + e.getMessage());
        }
    }
    public static void insertDog(Dog dog) {
        String sql = "INSERT INTO dogs(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, dog.getName());
        pstmt.setString(2, dog.getBreed());
        pstmt.setString(3, dog.getGender());
        pstmt.setString(4, dog.getAge());
        pstmt.setString(5, dog.getWeight());
        pstmt.setString(6, dog.getAcquisitionDate());
        pstmt.setString(7, dog.getAcquisitionLocation());
        pstmt.setString(8, dog.getTrainingStatus());
        pstmt.setInt(9, dog.getReserved() ? 1 : 0);  // boolean to int
        pstmt.setString(10, dog.getInServiceLocation());
        pstmt.executeUpdate();
    } catch (SQLException e) {
        System.out.println("Error inserting dog: " + e.getMessage());
    }
}
    public static void insertMonkey(Monkey monkey) {
    String sql = "INSERT INTO monkeys(name, species, gender, age, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry) "
               + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, monkey.getName());
        pstmt.setString(2, monkey.getSpecies());
        pstmt.setString(3, monkey.getGender());
        pstmt.setString(4, monkey.getAge());
        pstmt.setString(5, monkey.getAcquisitionDate());
        pstmt.setString(6, monkey.getAcquisitionLocation());
        pstmt.setString(7, monkey.getTrainingStatus());
        pstmt.setInt(8, monkey.getReserved() ? 1 : 0); // boolean to int
        pstmt.setString(9, monkey.getInServiceLocation());
        pstmt.executeUpdate();
    } catch (SQLException e) {
        System.out.println("Error inserting monkey: " + e.getMessage());
    }
}
    
}