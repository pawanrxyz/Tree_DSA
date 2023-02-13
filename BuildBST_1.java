public class BuildBST_1 {
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

    public static void inorder(Node root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String args[]) {
        int values[] = {2,1,4,5,7,6};

        Node root = null;
        for(int i=0;i<values.length;i++) {
            root = buildTree(root, values[i]);
        }
        inorder(root);
        System.out.println();        
    }
}