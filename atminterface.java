import java.util.Scanner;

class atm {
    int balance;
    double bank_account_no;
    String name;

    public atm() {

    }

    void withdraw(int amount) throws InterruptedException {
        if (amount < this.balance) {
            balance -= amount;
            Thread.sleep(1000);
            System.out.println("cash withdraw succesfull...");
        } else {
            Thread.sleep(1000);
            System.out.println("Not sufficient money");
        }
    }

    int check_balance() {
        return balance;
    }

    void deposit(int amount) {
        balance = balance + amount;
    }

}

class user extends atm {
    int balance;
    long bank_account_no;
    String name;

    user(String name, int balance, long bank_account_no) {
        super.balance = balance;
        super.name = name;
        super.bank_account_no = bank_account_no;
        // print_detail();
        System.out.println("");
        System.out.println("NAME OF ACCOUNT HOLDER: " + name);
        System.out.println("BANK ACCOUNT NUMBER : " + bank_account_no);
        System.out.println("");
        System.out.println("CURRENT BANK BALANCE : " + balance);
        System.out.println("");

    }

}

public class atminterface {
    public static boolean exit = false;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("welcome !\nEnjoy our atm services\n");
        Scanner sc = new Scanner(System.in);
        System.out.println("Name of account holder");
        String name = sc.nextLine();
        System.out.println("Enter the initial bank balance");
        int current_bankbalance = sc.nextInt();
        System.out.println("enter the bank account number");
        long bank_account_no = sc.nextLong();

        user user1 = new user(name, current_bankbalance, bank_account_no);

        // atm welcome screen
        while (exit == false) {
            for (int i = 0; i < 50; i++) {

                System.out.print("-");
            }
            System.out.println("\n");
            System.out.println("PRESS 1 -> for checking bank balance\n");
            System.out.println("PRESS 2 -> for deposit the amount \n");
            System.out.println("PRESS 3 -> for withdraw the amount \n");
            System.out.println("PRESS 4 -> for exit \n");

            System.out.println("Enter your choice");
            int choice = sc.nextInt();

            function fun = new function(user1);
            fun.perform_function(choice, sc);
        }

    }
}

class function {
    user user1;

    public function(user user1) {
        this.user1 = user1;
    }

    void waiting(Scanner sc) {
        System.out.println("");
        System.out.println("Enter a key  to go to main menu...");
        sc.next();
    }

    public void perform_function(int choice, Scanner sc) throws InterruptedException {
        switch (choice) {
            case 1:
                Thread.sleep(1000);
                System.out.println("Your bank balance is :\n" + user1.check_balance());
                waiting(sc);
                break;
            case 2:
                System.out.println("Enter the cash amount to deposit");
                int deposit_cash = sc.nextInt();
                System.out.println("\n");
                System.out.println("cash deposited successfull");
                user1.deposit(deposit_cash);
                Thread.sleep(1000);
                System.out.println("Your current bank balance is " + user1.check_balance());
                waiting(sc);
                break;
            case 3:
                System.out.println("Enter the cash amount to withdraw");
                int withdraw_cash = sc.nextInt();
                System.out.println("\n");

                user1.withdraw(withdraw_cash);

                System.out.println("Your current bank balance is " + user1.check_balance());
                waiting(sc);
                break;

            case 4:
                System.out.println("Thank you for using our services");
                atminterface.exit = true;
                break;
            default:
                System.out.println("Invalid choice! Try again.");
                waiting(sc);
                break;

        }

    }
}
