public class Tree_2 {
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
    
    static int  idx = -1;
    public static Node buildTree(int [] nodes) {
        idx++;
        if(nodes[idx] == -1) {
            return null;
        }
        Node newNode = new Node(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);
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
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }
    public static int height(Node root) {
        if(root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        
        return Math.max(lh, rh)+1;
    }

    public static int countNode(Node root) {
        if(root == null) {
            return 0;
        }
        int lc = countNode(root.left);
        int rc = countNode(root.right);
        int totalCount = lc+rc+1;
        return totalCount;
    }
    public static void main(String args[]) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = buildTree(nodes);
        System.out.println(root.data);

        System.out.println();
        System.out.println("Preorder Traversal");
        preorder(root);

        System.out.println();
        System.out.println("INORDER traversal ");
        inorder(root);

        System.out.println();
        System.out.println("Post Order Traversal ");
        postorder(root);

        int ans = height(root);
        System.out.println();
        System.out.println("The Maximum height of tree is = "+ans);

        System.out.println("The Total number of node are = "+countNode(root));
    }
    
}
