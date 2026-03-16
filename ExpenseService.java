import java.sql.Connection;
import java.sql.PreparedStatement;

public class ExpenseService {

    public void addExpense(int userId, int categoryId, double amount, String desc) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO expenses(user_id,category_id,amount,description,expense_date) VALUES(?,?,?,?,CURDATE())";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, userId);
            ps.setInt(2, categoryId);
            ps.setDouble(3, amount);
            ps.setString(4, desc);

            ps.executeUpdate();

            System.out.println("Expense Added");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}