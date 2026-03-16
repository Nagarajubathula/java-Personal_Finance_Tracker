# Finance Analyzer (Java + MySQL)

A console-based Personal Finance Analyzer built using Java Core, JDBC, and MySQL. The application allows users to track expenses, analyze spending by category, and generate financial reports.

## Features

1. User Registration (Create Account)
2. Login Authentication
3. Change Password
4. Add Expense with Category
5. View Available Categories
6. Category-wise Expense Report
7. Total Expense Calculation
8. Monthly Expense Report
9. Login Attempt Limit (3 attempts)
10. Logout System

## Technologies Used

1. Java Core
2. JDBC (Java Database Connectivity)
3. MySQL
4. MySQL Connector/J
5. SQL

## Project Structure

1. DBConnection.java
2. UserService.java
3. ExpenseService.java
4. ReportService.java
5. Main.java
6. mysql-connector-j-9.6.0.jar

## Database Name

finance_manager

## Tables

Users Table

1. user_id
2. name
3. email
4. password

Categories Table

1. category_id
2. category_name

Examples of categories

1. Food
2. Transport
3. Shopping
4. Bills
5. Entertainment
6. Others

Expenses Table

1. expense_id
2. user_id
3. category_id
4. amount
5. description
6. expense_date

## How to Run the Project

1. Clone the repository
   git clone https://github.com/yourusername/FinanceAnalyzer.git

2. Open the project folder
   cd FinanceAnalyzer

3. Compile the project
   javac -cp ".;mysql-connector-j-9.6.0.jar" *.java

4. Run the program
   java -cp ".;mysql-connector-j-9.6.0.jar" Main

## Example Program Flow

1. Register
2. Login

After login menu

1. Add Expense
2. Show Categories
3. Category Report
4. Total Expense
5. Monthly Report
6. Change Password
7. Logout

## Example Reports

Category Report example
Food : 200
Transport : 100
Healthcare : 500

Total Expense example
Total Spending: 800

Monthly Report example
Month 6 : 800

## Learning Outcomes

1. Java Object-Oriented Programming
2. JDBC Database Integration
3. SQL Query Execution
4. Console Application Development
5. Authentication System Implementation
6. Data Analysis using SQL

## Future Improvements

1. Graphical User Interface using Java Swing or JavaFX
2. Expense charts and graphs
3. Budget limit alerts
4. Export reports to CSV or PDF
5. Web version using Spring Boot
