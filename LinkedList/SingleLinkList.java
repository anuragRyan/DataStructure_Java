package LinkedList;

public class SingleLinkList {
    Node head;

    public static class Node {
        int data;
        Node nextNode;

        public Node(int data) {
            this.data = data;
            this.nextNode = null;
        }

    }

    // To print all the element in the link list
    public void display(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "--> ");
            current = current.nextNode;
        }
        System.out.println("null");
    }

    // To print length of a single link list
    public int length() {
        int count = 0;
        for (Node current = head; current != null; current = current.nextNode) {
            count++;
        }
        return count;
    }

    // To insert an element in the beginning of the link list
    public void insertBeginning(int data) {
        Node newNode = new Node(data);
        newNode.nextNode = head;
        head = newNode;
    }

    // To insert an element in the end of the link list
    public void insertEnd(int data) {
        Node lastNode = new Node(data);
        if (head == null) {
            head = lastNode;
        }
        Node addcurrent = head;
        while (addcurrent.nextNode != null) {
            addcurrent = addcurrent.nextNode;
        }
        addcurrent.nextNode = lastNode;
    }

    // To insert an element at any position
    public void insert(int data, int position) {
        Node newNode = new Node(data);
        if (position == 1) {
            newNode.nextNode = head;
            head = newNode;
        } else {
            Node previous = head;
            int count = 1;
            while (count < position - 1) {
                previous = previous.nextNode;
                count++;
            }

            Node current = previous.nextNode;
            newNode.nextNode = current;
            previous.nextNode = newNode;
        }
    }

    // To delete the first node
    public Node deleteFirst() {
        if (head == null) {
            return null;
        }
        Node temp = head;
        head = head.nextNode;
        temp.nextNode = null;
        return temp;
    }

    // To delete the last node
    public Node deleteLast() {
        if (head == null || head.nextNode == null) {
            return head;
        }
        Node current = head;
        Node previous = null;
        while (current.nextNode != null) {
            previous = current;
            current = current.nextNode;
        }
        previous.nextNode = null;
        return current;
    }

    // To delete node at any position
    public void delete(int position) {
        if (position == 1) {
            head = head.nextNode;
        } else {
            Node previous = head;
            int count = 1;
            while (count < position - 1) {
                previous = previous.nextNode;
                count++;
            }
            Node current = previous.nextNode;
            previous.nextNode = current.nextNode;
        }

    }

    // To search a key in the link list
    public boolean search(Node head, int searchKey) {
        if (head == null) {
            return false;
        } else {
            Node current = head;
            while (current != null) {
                if (current.data == searchKey)
                    return true;
                current = current.nextNode;
            }
            return false;
        }
    }

    // To reverse a link list
    public Node reverse(Node head) {
        Node current = head;
        Node previous = null;
        Node next = null;
        while (current != null) {
            next = current.nextNode;
            current.nextNode = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    // To find the mid point of link list
    public Node getmid(Node head) {
        Node slowPtr = head;
        Node fastPtr = head;
        while (fastPtr != null && fastPtr.nextNode != null) {
            slowPtr = slowPtr.nextNode;
            fastPtr = fastPtr.nextNode.nextNode;
        }
        return slowPtr;
    }

    // To find the nth element from the end
    public Node nthFromEnd(int n) {
        Node refPtr = head;
        Node mainPtr = head;
        int count = 0;
        while (count < n) {
            refPtr = refPtr.nextNode;
            count++;
        }
        while (refPtr != null) {
            mainPtr = mainPtr.nextNode;
            refPtr = refPtr.nextNode;
        }

        return mainPtr;
    }

    // To remove duplicate element from the list
    public void removeDuplicate(Node head) {
        Node current = head;
        while (current != null && current.nextNode != null) {
            if (current.data == current.nextNode.data) {
                current.nextNode = current.nextNode.nextNode;
            } else {
                current = current.nextNode;
            }
        }
    }

    // To insert an element in a sorted list
    public Node insertIntoSorted(int data) {
        Node newNode = new Node(data);
        Node current = head;
        Node temp = null;
        while (current != null && current.data < newNode.data) {
            temp = current;
            current = current.nextNode;
        }

        newNode.nextNode = current;
        temp.nextNode = newNode;
        return head;
    }

    // To delete a given key from the list
    public void deleteKey(int key) {
        Node current = head;
        Node temp = null;
        while (current != null && current.data != key) {
            temp = current;
            current = current.nextNode;
        }

        if (current == null)
            return;

        temp.nextNode = current.nextNode;
    }

    // To detect a loop in the link list
    public boolean detectLoop(Node head) {
        Node fastPtr = head;
        Node slowPtr = head;
        while (fastPtr != null && fastPtr.nextNode != null) {
            fastPtr = fastPtr.nextNode.nextNode;
            slowPtr = slowPtr.nextNode;
            if (fastPtr == slowPtr)
                return true;
        }
        return false;
    }

    // To find the starting node of the loop
    public Node startingNodeOfLoop(Node head) {
        Node fastPtr = head;
        Node slowPtr = head;
        while (fastPtr != null && fastPtr.nextNode != null) {
            fastPtr = fastPtr.nextNode.nextNode;
            slowPtr = slowPtr.nextNode;
            if (fastPtr == slowPtr)
                return getStartingNodeofLoop(slowPtr);
        }
        return null;
    }

    private Node getStartingNodeofLoop(Node slowPtr) {
        Node temp = head;
        while (slowPtr != temp) {
            temp = temp.nextNode;
            slowPtr = slowPtr.nextNode;
        }
        return temp;
    }

    // To remove loop from single Link list
    public void removeloop() {
        Node slowPtr = head;
        Node fastPtr = head;
        while (fastPtr != null && fastPtr.nextNode != null) {
            slowPtr = slowPtr.nextNode;
            fastPtr = fastPtr.nextNode.nextNode;
            if (slowPtr == fastPtr) {
                removeLoop(slowPtr);
                return;
            }
        }

    }

    private void removeLoop(Node slowPtr) {
        Node temp = head;
        while (slowPtr.nextNode != temp.nextNode) {
            slowPtr = slowPtr.nextNode;
            temp = temp.nextNode;
        }
        slowPtr.nextNode = null;
    }

    public static void main(String[] args) {
        SingleLinkList sll = new SingleLinkList();
        sll.head = new Node(4);
        Node second = new Node(6);
        Node third = new Node(8);
        Node fourth = new Node(10);

        sll.head.nextNode = second;
        second.nextNode = third;
        third.nextNode = fourth;
        fourth.nextNode = third;

        sll.removeloop();
        sll.display(sll.head);

    }
}