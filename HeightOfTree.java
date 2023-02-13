public class HeightOfTree {
    static class Node {
        int data;
        Node left,right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int height(Node root) {
        if(root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh)+1;
    }
    public static void main(String args[]) {
        int size = 0;
        Node  root = new Node(1);
        size++;
        root.left = new Node(2);
        size++;
        root.right = new Node(3);
        size++;
        root.left.left = new Node(4);
        size++;
        root.left.right = new Node(5);
        size++;
        root.right.left = new Node(6);
        size++;
        root.right.right = new Node(7);
        size++;
        root.right.right.right = new Node(8);
        size++;

        System.out.println("The maximum height of tree is = "+height(root));
        System.out.println("The number of node is = "+size);
    }
    
}
