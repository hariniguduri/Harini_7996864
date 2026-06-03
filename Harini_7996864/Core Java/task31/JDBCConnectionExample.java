import java.sql.*;

public class JDBCConnectionExample {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/studentdb4";
        String username = "root";
        String password = "Hariniguduri_51";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =
                DriverManager.getConnection(url, username, password);

            Statement stmt = con.createStatement();

            ResultSet rs =
                stmt.executeQuery("SELECT * FROM students");

            while (rs.next()) {

                System.out.println(
                    rs.getInt("id") + " " +
                    rs.getString("name") + " " +
                    rs.getInt("age")
                );
            }

            con.close();

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}