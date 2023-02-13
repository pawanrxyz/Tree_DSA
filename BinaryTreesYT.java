import java.util.*;

public class BinaryTreesYT {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public class BinaryTree1 {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        // Preorder traversal

        public static void preorder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        // Inorder tree
        public static void inorder(Node root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        // Postorder Tree
        public static void postorder(Node root) {
            if (root == null) {
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        // Level order raversal
        public static void leveOrder(Node root) {
            if (root == null) {
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);

            q.add(null);

            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }

    }

    public static int count(Node root) {
        if (root == null) {
            return 0;
        }
        int leftCount = count(root.left);
        int rightCount = count(root.right);
        return leftCount + rightCount + 1;
    }

    // Calculate Total Sum of tree Node

    public static int sum(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        int treeSum = leftSum + rightSum + root.data;
        return treeSum;
    }

    // Calculate total height of node
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Calculate Diameter of tree

    public static int diameter(Node root) {
        if (root == null) {
            return 0;
        }

        int leftDiam = diameter(root.left);
        int leftHt = height(root.left);
        int rightDiam = diameter(root.right);
        int rightHt = height(root.right);

        int selfDiam = leftHt + rightHt + 1;
        return Math.max(selfDiam, Math.max(leftDiam, rightDiam));
    }

    // check is an Identical
    public static boolean isIdentical(Node node, Node subRoot) {
        if (node == null && subRoot == null) {
            return true;
        } else if (node == null || subRoot == null || node.data != subRoot.data) {
            return false;
        }
        if (!isIdentical(node.left, subRoot.left)) {
            return false;
        }
        if (!isIdentical(node.right, subRoot.right)) {
            return false;
        }
        return true;
    }

    public static boolean isSubtree(Node root, Node subRoot) {
        if (root == null) {
            return false;
        }

        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // //Buiding BST

    // public static void inorder(Node root) {
    // if(root == null) {
    // return;
    // }
    // inorder(root.left);
    // System.out.print(root.data+" ");
    // inorder(root.right);
    // }

    // public static Node insert(Node root,int val) {
    // if(root == null) {
    // root = new Node(val);
    // return root;
    // }

    // if(root.data>val) {
    // root.left = insert(root.left, val);
    // } else {
    // root.right = insert(root.right, val);
    // }
    // return root;
    // }

    // //Binary Search in tree
    // public static boolean serach(Node root,int key) {
    // if(root == null) {
    // return false;
    // }
    // if(root.data>key) {
    // return serach(root.left, key);
    // }
    // else if(root.data == key) {
    // return true;
    // }
    // else{
    // return serach(root.right, key);
    // }
    // }

    // Deletign Node from BST
    // Deleting node frome BST

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static Node delete(Node root, int val) {
        if (root.data > val) {
            root.left = delete(root.left, val);
        } else if (root.data < val) {
            root.right = delete(root.right, val);
        }

        // case 1
        if (root.left == null && root.right == null) {
            return null;
        }

        // Case 2
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        }

        // Case 3
        Node IS = inorderSuccessor(root.right);
        root.data = IS.data;
        root.right = delete(root.right, IS.data);

        return root;
    }

    public static Node inorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String args[]) {
        // int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        // Node root = BinaryTree1.buildTree(nodes);

        // // Node root = tree.buildTree(nodes);
        // System.out.println(root.data);

        // System.out.println("Preoder traversal Tree ");
        // BinaryTree1.preorder(root);
        // System.out.println();

        // System.out.println("Inorder Traversal Tree ");
        // BinaryTree1.inorder(root);
        // System.out.println();

        // System.out.println("Postorder Traversal Tree");
        // System.out.println();
        // BinaryTree1.postorder(root);

        // System.out.println();
        // System.out.println("LevelOrder Traversal : ");
        // BinaryTree1.leveOrder(root);

        // System.out.println();

        // System.out.println("The total node is = "+count(root));

        // System.out.println("The total sum of tree of Node is = "+sum(root));

        // System.out.println("The total height of tree is = "+height(root));

        // System.out.println("The Diameter of tree is = "+diameter(root));

        // Node root = new Node(1);
        // root.left = new Node(2);
        // root.right = new Node(3);
        // root.left.left = new Node(4);
        // root.left.right = new Node(5);
        // root.right.left = new Node(6);
        // root.right.right = new Node(7);

        // Node subRoot = new Node(2);
        // subRoot.left = new Node(4);
        // subRoot.right = new Node(5);

        // System.out.println(isSubtree(root, subRoot));

        // Building BST

        // int values[] = {3,5,6,1,2,7};

        // Node root = null;
        // for(int i=0;i<values.length;i++) {
        // root = insert(root, values[i]);
        // }
        // inorder(root);
        // System.out.println();

        // //Binary search in BST key search
        // int values[] = {8,5,3,1,4,11,14};

        // Node root = null;
        // for(int i=0;i<values.length;i++) {
        // root = insert(root, values[i]);
        // }
        // inorder(root);
        // System.out.println();

        // if(serach(root, 1)) {
        // System.out.println("found");
        // } else{
        // System.out.println("not found");
        // }
        // boolean s = serach(root, 1);
        // System.out.println(s);

        // Deleting Node From BST
        int values[] = { 8, 5, 3, 1, 4, 11, 14, 7 };

        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        inorder(root);
        System.out.println();

        delete(root, 8);
        inorder(root);

    }

}
