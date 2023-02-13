public class SumOfNode {
    public static class Node {
        int data;
        Node left,right;


        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int sum(Node root) {
        if(root == null) {
            return 0;
        }
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        int treeSum = leftSum+rightSum+root.data;
        return treeSum;
    }

    public static void main(String  args[]) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right = new Node(5);
        root.right.left = new Node(6);

        System.out.println("The total sum of tree of Node = "+sum(root));
    }
    
}
