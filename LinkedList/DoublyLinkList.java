package LinkedList;

import java.util.NoSuchElementException;

public class DoublyLinkList {

    private Node head;
    private Node tail;
    private int length;

    public class Node {
        int data;
        Node previous;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public DoublyLinkList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int length() {
        return length;
    }

    // To insert node in the beginning of the list
    public void insertBeginning(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            tail = newNode;
        } else {
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    // To insert node in the end of list
    public void insertLast(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        newNode.previous = tail;
        tail = newNode;
        length++;
    }

    // To display the element is forward direction.
    public void displayForward() {
        if (head == null) {
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.print("null");
    }

    // To display the element is backward direction.
    public void displayBackward() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.previous;
        }
        System.out.println("null");
    }

    // To delete the first node in the list
    public void deleteFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node temp = head;
        if (head == tail) {
            tail = null;
        } else {
            head.next.previous = null;
        }
        head = head.next;
        temp.next = null;
    }

    // To delete the last node in the list
    public void deleteLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node temp = tail;
        if (tail == head) {
            head = null;
        } else {
            tail.previous.next = null;
        }
        tail = tail.previous;
        temp.previous = null;
    }

    public static void main(String[] args) {
        DoublyLinkList dll = new DoublyLinkList();
        dll.insertBeginning(1);
        dll.insertBeginning(3);
        dll.insertBeginning(5);
        dll.insertBeginning(7);
        dll.insertBeginning(9);

        dll.deleteLast();
        dll.displayForward();

    }

}
