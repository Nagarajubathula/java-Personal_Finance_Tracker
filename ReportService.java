import java.sql.*;

public class ReportService {

    // Show all categories
    public void showCategories(){

        try{

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM categories";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            System.out.println("\nAvailable Categories:");

            while(rs.next()){

                System.out.println(
                    rs.getInt("category_id") + " - " +
                    rs.getString("category_name")
                );
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    // Category wise spending
    public void showCategoryReport(){

        try{

            Connection con = DBConnection.getConnection();

            String sql =
            "SELECT c.category_name, SUM(e.amount) AS total " +
            "FROM expenses e JOIN categories c " +
            "ON e.category_id=c.category_id " +
            "GROUP BY c.category_name";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            System.out.println("\nCategory Wise Report:");

            while(rs.next()){

                System.out.println(
                        rs.getString("category_name")+" : "+
                        rs.getDouble("total")
                );
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    // Total expense
    public void showTotalExpense(){

        try{

            Connection con = DBConnection.getConnection();

            String sql = "SELECT SUM(amount) AS total_spent FROM expenses";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            if(rs.next()){

                System.out.println("\nTotal Spending: " +
                        rs.getDouble("total_spent"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    // Monthly report
    public void monthlyReport(){

        try{

            Connection con = DBConnection.getConnection();

            String sql =
            "SELECT MONTH(expense_date) AS month, SUM(amount) AS total " +
            "FROM expenses GROUP BY MONTH(expense_date)";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            System.out.println("\nMonthly Report:");

            while(rs.next()){

                System.out.println(
                    "Month " + rs.getInt("month") +
                    " : " + rs.getDouble("total")
                );
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}