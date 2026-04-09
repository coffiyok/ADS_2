public class Task6 {
    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[3];

        accounts[0] = new BankAccount(1001, "Alice", 5000.0);
        accounts[1] = new BankAccount(1002, "Bob", 3200.0);
        accounts[2] = new BankAccount(1003, "Charlie", 7800.0);

        System.out.println("Predef accounts:");
        for (BankAccount acc : accounts) {
            System.out.println(acc);
        }
    }
}