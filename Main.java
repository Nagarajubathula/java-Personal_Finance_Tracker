import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        UserService userService = new UserService();
        ExpenseService expenseService = new ExpenseService();
        ReportService reportService = new ReportService();

        int loggedInUser = -1;

        System.out.println("------ Finance Analyzer ------");
        System.out.println("1 Register");
        System.out.println("2 Login");

        System.out.print("Enter choice: ");
        int option = sc.nextInt();
        sc.nextLine();

        if(option == 1){

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter email: ");
            String email = sc.nextLine();

            System.out.print("Enter password: ");
            String password = sc.nextLine();

            userService.registerUser(name,email,password);
        }

        int attempts = 0;

        while(attempts < 3 && loggedInUser == -1){

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            loggedInUser = userService.login(email,password);

            if(loggedInUser == -1){

                attempts++;
                System.out.println("Login attempt "+attempts+" failed");
            }
        }

        if(loggedInUser == -1){

            System.out.println("Too many failed attempts");
            return;
        }

        int choice;

        do{

            System.out.println("\n------ Finance Analyzer ------");
            System.out.println("1 Add Expense");
            System.out.println("2 Show Categories");
            System.out.println("3 Category Report");
            System.out.println("4 Total Expense");
            System.out.println("5 Monthly Report");
            System.out.println("6 Change Password");
            System.out.println("7 Logout");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch(choice){

                case 1:

    // show categories first
    reportService.showCategories();

    System.out.print("Enter category ID: ");
    int cat = sc.nextInt();

    System.out.print("Enter amount: ");
    double amount = sc.nextDouble();

    sc.nextLine();

    System.out.print("Enter description: ");
    String desc = sc.nextLine();

    expenseService.addExpense(loggedInUser,cat,amount,desc);

    break;

                case 2:

                    reportService.showCategories();

                    break;

                case 3:

                    reportService.showCategoryReport();

                    break;

                case 4:

                    reportService.showTotalExpense();

                    break;

                case 5:

                    reportService.monthlyReport();

                    break;

                case 6:

                    sc.nextLine();

                    System.out.print("Enter new password: ");
                    String newPass = sc.nextLine();

                    userService.changePassword(loggedInUser,newPass);

                    break;

                case 7:

                    System.out.println("Logged out successfully");

                    break;

                default:

                    System.out.println("Invalid option");
            }

        }while(choice != 7);

        sc.close();
    }
}