public class Linklist4 {
    Node head;
    Node tail;

    class Node {
        BankAccount data;
        Node next;

        Node(BankAccount data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add(BankAccount acc) {
        Node newNode = new Node(acc);
        if (tail == null) {
            head =tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public BankAccount get(int index) {
        Node current = head;
        int count = 0;
        while (current != null) {
            if (count == index) {
                return current.data;
            }
            count++;
            current = current.next;
        }
        return null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void printAll() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public BankAccount find(String username) {
        Node current = head;
        while (current != null) {
            if (current.data.username.equalsIgnoreCase(username)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }
}