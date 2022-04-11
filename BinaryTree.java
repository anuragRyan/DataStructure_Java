import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    private static Node root;

    public static class Node{
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

        private void createBinaryTree(){                                      //         1      --> root
        Node first = new Node(1);                                             //        /  \
        Node second = new Node(2);                                            //      2       3
        Node third = new Node(3);                                             //    /   \    /  \
        Node fourth = new Node(4);                                            //  4    null 5    6
        Node fifth = new Node(5);
        Node sixth = new Node(6);

        root = first;
        root.left = second;
        root.right = third;
        second.left = fourth;
        third.left = fifth;
        third.right = sixth;
    }

    private void preorderRecurrsion(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorderRecurrsion(root.left);
        preorderRecurrsion(root.right);
    }

    // private void preorderIteration(Node root){
    //     if(root == null)
    //         return;
            
    //     Stack<Node> stack = new Stack<>();
    //     stack.push(root);
    //     while(!stack.isEmpty()){
    //         Node temp = stack.pop();
    //         System.out.print(temp.data + " ");
    //         if(temp.right != null){
    //             stack.push(temp.right);
    //         }
    //         if(temp.left != null){
    //             stack.push(temp.left);
    //         }
    //     }
    // }

    private void inorderRecurrsion(Node root){
        if(root == null)
            return;
        
        inorderRecurrsion(root.left);
        System.out.print(root.data + " ");
        inorderRecurrsion(root.right);
    }

    // private void inorderIteration(Node root){
    //     if(root == null)
    //         return;

    //     Stack<Node> stack = new Stack<>();
    //     Node temp = root;
    //     while(!stack.isEmpty() || temp != null){
    //         if(temp != null){
    //             stack.push(temp);
    //             temp = temp.left;
    //         } else {
    //             temp = stack.pop();
    //             System.out.print(temp.data + " ");
    //             temp = temp.right;
    //         }
    //     }
    // }

    private void postorderRecurrsion(Node root){
        if(root == null)
            return;

        postorderRecurrsion(root.left);
        postorderRecurrsion(root.right);
        System.out.print(root.data + " ");
    }

    // private void postorderIteration(Node root){
    //     if(root == null)
    //         return;

    //     Stack<Node> stack = new Stack<>();
    //     Node current = root;
    //     while(!stack.isEmpty() || current != null){
    //         if(current != null){
    //             stack.push(current);
    //             current = current.left;
    //         } else {
    //             Node temp = stack.peek().right;
    //             if(temp == null){
    //                 temp = stack.pop();
    //                 System.out.print(temp.data + " ");
    //                 while(!stack.isEmpty() && temp == stack.peek().right){
    //                     temp = stack.pop();
    //                     System.out.print(temp.data + " ");
    //                 }
    //             } else {
    //                 current = temp;
    //             }
    //         }
    //     }
    // }

    private void levelorder(Node root){
        if(root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.print(temp.data + " ");
            if(temp.left != null){
                queue.offer(temp.left);
            }
            if(temp.right != null){
                queue.offer(temp.right);
            }
        }
    }

    private int findmax(Node root){
        if(root == null)
            return Integer.MIN_VALUE;

        int result = root.data;
        int left = findmax(root.left);
        int right = findmax(root.right);
        if(left > result)
            result = left;
        if(right > result)
            result = right;

        return result;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createBinaryTree();
        System.out.print("Level: ");
        binaryTree.levelorder(root);
        System.out.println();
        System.out.println(binaryTree.findmax(root));
    }
    
}
