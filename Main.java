
public class Main {
    public static void main(String[] args) {

        DLL dll = new DLL();
        dll.insertFirst(3);
        dll.insertFirst(2);
        dll.insertFirst(1);
        dll.insertLast(4);
        dll.insertLast(5);
        dll.delete(4);
        dll.display();

    }
}

class DLL {
    int size;
    Node head;
    Node tail;

    // insert at first
    public void insertFirst(int value) {
        Node node = new Node(value);
        node.prev = null;
        node.next = head;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    // insert at last
    public void insertLast(int value) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node node = new Node(value);
        node.prev = temp;
        node.next = null;
        temp.next = node;
        tail = node;
        size++;
    }

    // insert at any position
    public void insert(int value, int index) {
        if (index == 0) {
            insertFirst(value);
            return;
        }
        if (index == size - 1) {
            insertLast(value);
            return;
        }
        Node node = new Node(value);
        Node temp = head;
        for (int i = 1; i < index - 1; i++) {
            temp = temp.next;
        }
        node.prev = temp;
        node.next = temp.next;
        temp.next.prev = node;
        temp.next = node;
        size++;
    }

    // delete at first
    public int deleteFirst() {
        Node temp = head;
        temp.next.prev = null;
        head = temp.next;
        temp.next = null;
        int val = temp.value;
        return val;

    }

    // delete at last
    public int deleteLast() {
        Node temp = tail;
        temp.prev.next = null;
        tail = temp.prev;
        temp.prev = null;
        int val = temp.value;
        return val;
    }

    // delete at any position
    public int delete(int pos) {

        if (pos == 1) {
            return deleteFirst();
        }
        if (pos == size) {
            return deleteLast();
        }
        Node temp = head;
        for (int i = 2; i < pos; i++) {
            temp = temp.next;
        }
        int val = temp.next.value;
        temp.next = temp.next.next;
        temp.next.prev = temp;
        return val;

    }

    // displaying
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.print("end");
    }

    // display reverse
    public void displayReverse() {
        System.out.println("");
        Node temp = tail;
        while (temp != null) {

            System.out.print(temp.value + "->");
            temp = temp.prev;
        }
        System.out.print("end");
    }

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }

        Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
