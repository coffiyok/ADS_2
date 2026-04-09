public class CustomQueue {
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
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public BankAccount poll() {
        if (head == null) {
            return null;
        }
        BankAccount data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printAll() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
