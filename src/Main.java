import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankSystem bank = new BankSystem();

        while (true) {
            System.out.println("\n1 - Bank");
            System.out.println("2 - ATM");
            System.out.println("3 - Admin");
            System.out.println("4 - Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.println("\n BANK MENU ");
                System.out.println("1 - Add account");
                System.out.println("2 - Show accounts");
                System.out.println("3 - Search account");
                System.out.println("4 - Deposit");
                System.out.println("5 - Withdraw");
                System.out.println("6 - Show last transaction");
                System.out.println("7 - Undo transaction");
                System.out.println("8 - Add bill");
                System.out.println("9 - Add account request");
                System.out.print("Choose: ");

                int c = sc.nextInt();
                sc.nextLine();

                switch (c) {
                    case 1:
                        System.out.print("Account number: ");
                        int num = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Username: ");
                        String user = sc.nextLine();
                        System.out.print("Balance: ");
                        double bal = sc.nextDouble();
                        sc.nextLine();
                        bank.addAccount(new BankAccount(num, user, bal));
                        break;

                    case 2:
                        bank.showAllAccounts();
                        break;

                    case 3:
                        System.out.print("Enter username: ");
                        System.out.println(bank.findAccount(sc.nextLine()));
                        break;

                    case 4:
                        System.out.print("Enter username: ");
                        String dUser = sc.nextLine();
                        System.out.print("Amount: ");
                        double dep = sc.nextDouble();
                        sc.nextLine();
                        bank.deposit(dUser, dep);
                        break;

                    case 5:
                        System.out.print("Enter username: ");
                        String wUser = sc.nextLine();
                        System.out.print("Amount: ");
                        double w = sc.nextDouble();
                        sc.nextLine();
                        bank.withdraw(wUser, w);
                        break;

                    case 6:
                        if (!bank.history.isEmpty())
                            System.out.println("Last: " + bank.history.peek());
                        else
                            System.out.println("No transactions.");
                        break;

                    case 7:
                        if (!bank.history.isEmpty())
                            System.out.println("Removed: " + bank.history.pop());
                        else
                            System.out.println("No transactions.");
                        break;

                    case 8:
                        System.out.print("Enter bill name: ");
                        bank.billQueue.add(sc.nextLine());
                        break;

                    case 9:
                        System.out.print("Enter username: ");
                        String rUser = sc.nextLine();
                        bank.submitRequest(new BankAccount(0, rUser, 0));
                        break;
                }

            } else if (choice == 2) {
                System.out.println("\n ATM MENU ");
                System.out.println("1 - Balance enquiry");
                System.out.println("2 - Withdraw");
                System.out.print("Choose: ");

                int m = sc.nextInt();
                sc.nextLine();

                if (m == 1) {
                    System.out.print("Enter username: ");
                    bank.checkBalance(sc.nextLine());
                } else if (m == 2) {
                    System.out.print("Enter username: ");
                    String u = sc.nextLine();
                    System.out.print("Amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();
                    bank.withdraw(u, amount);
                }

            } else if (choice == 3) {
                System.out.println("\n ADMIN MENU ");
                System.out.println("1 - Show requests");
                System.out.println("2 - Process request");
                System.out.println("3 - Show bills");
                System.out.println("4 - Process bill");
                System.out.print("Choose: ");

                int m1 = sc.nextInt();
                sc.nextLine();

                if (m1 == 1) {
                    bank.viewRequests();
                } else if (m1 == 2) {
                    bank.processRequest();
                } else if (m1 == 3) {
                    bank.viewBills();
                } else if (m1 == 4) {
                    if (!bank.billQueue.isEmpty())
                        System.out.println("Processing: " + bank.billQueue.poll());
                    else
                        System.out.println("No bills.");
                }

            } else if (choice == 4) {
                System.out.println("Goodbye!");
                break;
            }
            else {
                System.out.println("Error number");
                continue;
            }
        }
        sc.close();
    }
}