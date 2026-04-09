public class BankSystem {
    Linklist4 accounts = new Linklist4();
    java.util.Stack<String> history = new java.util.Stack<>();
    CustomQueue requests = new CustomQueue();
    CustomQueueString billQueue = new CustomQueueString();

    public void addAccount(BankAccount acc) {
        accounts.add(acc);
        System.out.println("Account added successfully.");
    }

    public BankAccount findAccount(String username) {
        return accounts.find(username);
    }

    public void submitRequest(BankAccount acc) {
        requests.add(acc);
        System.out.println("Account opening request added to queue.");
    }

    public void deposit(String username, double amount) {
        BankAccount acc = findAccount(username);
        if (acc != null) {
            acc.balance += amount;
            history.push("Deposit " + amount + " to " + username);
            System.out.println("New balance: " + acc.balance);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw(String username, double amount) {
        BankAccount acc = findAccount(username);
        if (acc != null) {
            if (acc.balance >= amount) {
                acc.balance -= amount;
                history.push("Withdraw " + amount + " from " + username);
                System.out.println("New balance: " + acc.balance);
            } else {
                System.out.println("Not enough balance.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    public void checkBalance(String username) {
        BankAccount acc = findAccount(username);
        if (acc != null) {
            System.out.println("Balance: " + acc.balance);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void viewRequests() {
        if (requests.isEmpty()) {
            System.out.println("No account requests.");
        } else {
            requests.printAll();
        }
    }

    public void processRequest() {
        if (requests.isEmpty()) {
            System.out.println("No account requests.");
        } else {
            BankAccount acc = requests.poll();
            accounts.add(acc);
            System.out.println("Request processed: " + acc.username);
        }
    }

    public void viewBills() {
        if (billQueue.isEmpty()) {
            System.out.println("No bills in queue.");
        } else {
            billQueue.printAll();
        }
    }

    public void showAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts.");
        } else {
            accounts.printAll();
        }
    }
}