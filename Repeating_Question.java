public class Repeating_Question {
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
    public static int idx = -1;

    public static Node buildBinarytree(int nodes[]) {
        idx++;if(nodes[idx] == -1) {
            return null;
        }
        Node newNode = new Node(nodes[idx]);
        newNode.left = buildBinarytree(nodes);
        newNode.right = buildBinarytree(nodes);

        return newNode;
    }

    //preorder traversal
    public static void preoorder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data+" ");
        preoorder(root.left);
        preoorder(root.right);
    }

    //inorder teversal
    public static void inorder(Node root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    //post ordertraversal
    public static void postorder(Node root) {
        if(root == null) {
            return;
        }
        postorder(root.right);
        postorder(root.left);
        System.out.print(root.data+" ");
    }
    public static void main(String args[]) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = buildBinarytree(nodes);
        System.out.println(root.data);

        System.out.println("Preorder Traversal ");
        preoorder(root);

        System.out.println();
        System.out.println("Inorder Traversal ");
        inorder(root);

        System.out.println();
        System.out.println("POst Order traversal ");
        postorder(root);
    }
}