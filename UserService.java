import java.sql.*;

public class UserService {

    public void registerUser(String name, String email, String password) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO users(name,email,password) VALUES(?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);

            ps.executeUpdate();

            System.out.println("User Registered Successfully");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    public int login(String email, String password) {

        int userId = -1;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT user_id FROM users WHERE email=? AND password=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                userId = rs.getInt("user_id");

                System.out.println("Login Successful");

            } else {

                System.out.println("Invalid email or password");

            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return userId;
    }


    public void changePassword(int userId, String newPassword) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "UPDATE users SET password=? WHERE user_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, newPassword);
            ps.setInt(2, userId);

            ps.executeUpdate();

            System.out.println("Password Updated Successfully");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}