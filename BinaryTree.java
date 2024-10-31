package DSA;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static Node root = null;

    static int idx = -1;
    public static Node buildTree(int[] nodes) {
        idx++;
        if(nodes[idx] == -1) return null;
        Node newNode = new Node(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);
        return newNode;
    }

    public static void inorder(Node root) {
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void preorder(Node root) {
        if(root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void postorder(Node root) {
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelOrder() {
        Queue<Node> q = new LinkedList<Node> ();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()) {
            Node temp = q.remove();
            if(temp == null) {
                System.out.println();
                if(q.isEmpty()) break;
                else q.add(null);
            } else {
                System.out.print(temp.data + " ");
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
        }
    }

    public static int height(Node root) {
        if(root == null) return 0;
        int leftHeight = 1 + height(root.left);
        int rightHeight = 1 + height(root.right);
        int ans = Math.max(leftHeight, rightHeight);
        return ans;
    }
    
    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        root = buildTree(nodes);
        System.out.print("preorer traversal: ");
        preorder(root);
        System.out.println();
        System.out.print("postorder traversal: ");
        postorder(root);
        System.out.println();
        System.out.print("inorder traversal: ");
        inorder(root);
        System.out.println();
        System.out.println("levelorder traversal: ");
        levelOrder();
        System.out.print("Height of the tree: ");
        System.out.println(height(root));
    }
}
