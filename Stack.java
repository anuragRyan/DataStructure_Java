import java.util.EmptyStackException;

public class Stack {

    private Node top;
    private int length;

    private class Node{
        private int data;
        private Node next;

        private Node(int data){
            this.data = data;
        }
    }

    public Stack(){
        top = null;
        length =0;
    }

    private boolean isEmpty(){
        return length == 0;
    }

    public void push(int value){
        Node temp = new Node(value);
        temp.next = top;
        top = temp;
        length++;
    }

    public int pop(){
        if(isEmpty())
            throw new EmptyStackException();

        int result = top.data;
        top = top.next;
        length--;
        return result;
    }

    public int peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }

        int result = top.data;
        return result;
    }

    public static void main(String[] args) {

        Stack stack = new Stack();
        stack.push(20);
        stack.push(30);
        stack.push(40);
        
        stack.pop();
        System.out.println(stack.peek());
    }
    
}
