import java.util.NoSuchElementException;

public class Queue {

    private Node front;
    private Node rear;
    private int length;

    private class Node{
        private int data;
        private Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private boolean isEmpty(){
        return length == 0;
    }

    private void enqueue(int value){
        Node temp = new Node(value);

        if(isEmpty())
            front = temp;
        else
            rear.next = temp;
        rear = temp;
        length++;
    }

    private int dequeue(){
        if(isEmpty())
            throw new NoSuchElementException();
        int result = front.data;
        front = front.next;
        if(front == null)
            rear = null;
        length--;
        return result;
    }

    private int peek(){
        int result = front.data;
        return result;
    }
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.peek()); 
    }
    
}
