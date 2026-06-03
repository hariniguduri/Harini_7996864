import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class STUDENTDAO {

    String url = "jdbc:mysql://localhost:3306/studentdb2";
    String username = "root";
    String password = "Hariniguduri_51";

    // Insert Student
    public void insertStudent(int id, String name, int age) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);

            String query = "INSERT INTO students VALUES (?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setInt(3, age);

            int rows = pst.executeUpdate();

            System.out.println(rows + " row inserted");

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Update Student
    public void updateStudent(int id, String newName) {

        try {

            Connection con = DriverManager.getConnection(url, username, password);

            String query = "UPDATE students SET name=? WHERE id=?";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, newName);
            pst.setInt(2, id);

            int rows = pst.executeUpdate();

            System.out.println(rows + " row updated");

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}