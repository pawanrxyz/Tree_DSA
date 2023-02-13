public class CreatingNewTree {
    public static class Node {
        int data;
        Node left,right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int idx = -1;
    public static Node buildtree(int[] nodes) {
        idx++;
        if(nodes[idx] == -1) {
            return null;
        }
        Node newNode = new Node(nodes[idx]); 
        newNode.left = buildtree(nodes);
        newNode.right = buildtree(nodes);

        return newNode;

    }

    public static void preorder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void postorder(Node root) {
        if(root == null) {
            return;
        }
        postorder(root.right);
        postorder(root.left);
        System.out.print(root.data+" ");
    }


    public static int height(Node root) {
        if(root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh,rh)+1;
    }
    public static void main(String args[]) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        // Node root = CreatingNewTree.buildtree(nodes);
        Node root = buildtree(nodes);
        System.out.println(root.data);

        System.out.println("Preorder traversal ");
        preorder(root);
        // System.out.println(root);
        System.out.println("");
        System.out.println("Inorder traversal ");
        inorder(root);
        // System.out.println(root);

        System.out.println();
        System.out.println("Postorder traversal ");
        postorder(root);

        System.out.println();
        System.out.println("The total height of tree is = "+height(root));
    }
    
}
