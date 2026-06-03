import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TransactionDemo {

    String url = "jdbc:mysql://localhost:3306/studentdb1";
    String username = "root";
    String password = "Hariniguduri_51";

    public void transferMoney(int fromId,
                              int toId,
                              double amount) {

        Connection con = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    url, username, password);

            con.setAutoCommit(false);

            String debitQuery =
                    "UPDATE accounts SET balance = balance - ? WHERE id=?";

            PreparedStatement debit =
                    con.prepareStatement(debitQuery);

            debit.setDouble(1, amount);
            debit.setInt(2, fromId);

            debit.executeUpdate();

            String creditQuery =
                    "UPDATE accounts SET balance = balance + ? WHERE id=?";

            PreparedStatement credit =
                    con.prepareStatement(creditQuery);

            credit.setDouble(1, amount);
            credit.setInt(2, toId);

            credit.executeUpdate();

            con.commit();

            System.out.println("Transaction Successful");

        } catch (Exception e) {

            try {
                if (con != null)
                    con.rollback();
            } catch (Exception ex) {
            }

            System.out.println("Transaction Failed");

        }
    }
}