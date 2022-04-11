public class BinarySearchTree {

    private Node root;

    private class Node{
        int data;
        private Node left;
        private Node right;

        public Node(int data){
            this.data = data;
        }
    }

    public void insert(int value){
        root = insert(root, value);
    }

    private Node insert(Node root, int value){
        if(root == null){
            root = new Node(value);
            return root;
        }
        if(value < root.data){
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    private void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    private boolean search(Node root, int key){
        if(root == null){
            return false;
        }
        if (root.data == key)
            return true;

        if(key < root.data)
            return search(root.left, key);
        else
           return search(root.right, key);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);

        if(bst.search(bst.root, 6))
            System.out.println("Key Found..");
        else
            System.out.println("Key not found..");
    }
}
