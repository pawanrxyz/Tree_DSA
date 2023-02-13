public class TreesTraversal {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static Node buildTree(Node root,int val) {
        if(root == null) {
            return root;
        }
        if(root.data>val) {
            root.left = buildTree(root.left, val);
        }
        else {
            root.right = buildTree(root.right, val);
        }
        return root;

    }
     
    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        
    }
}