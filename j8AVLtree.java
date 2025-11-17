import java.util.Scanner;

class AVLNode {
    int key, height;
    AVLNode left, right;
    AVLNode(int k) { key = k; height = 1; }
}

public class AVLTreeDemo {
    static AVLNode root;

    static int height(AVLNode n) { return n == null ? 0 : n.height; }
    static int balance(AVLNode n) { return n == null ? 0 : height(n.left) - height(n.right); }

    static AVLNode rotateRight(AVLNode y) {
        AVLNode x = y.left; AVLNode T2 = x.right;
        x.right = y; y.left = T2;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    static AVLNode rotateLeft(AVLNode x) {
        AVLNode y = x.right; AVLNode T2 = y.left;
        y.left = x; x.right = T2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    static AVLNode insert(AVLNode node, int key) {
        if (node == null) return new AVLNode(key);
        if (key < node.key) node.left = insert(node.left, key);
        else if (key > node.key) node.right = insert(node.right, key);
        else return node;
        node.height = 1 + Math.max(height(node.left), height(node.right));
        int bal = balance(node);
        if (bal > 1 && key < node.left.key) return rotateRight(node);
        if (bal < -1 && key > node.right.key) return rotateLeft(node);
        if (bal > 1 && key > node.left.key) { node.left = rotateLeft(node.left); return rotateRight(node); }
        if (bal < -1 && key < node.right.key) { node.right = rotateRight(node.right); return rotateLeft(node); }
        return node;
    }

    static void inorder(AVLNode n) {
        if (n != null) { inorder(n.left); System.out.print(n.key + " "); inorder(n.right); }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes to insert: ");
        int k = sc.nextInt();
        System.out.println("Enter keys:");
        for (int i = 0; i < k; i++) root = insert(root, sc.nextInt());
        System.out.print("Inorder (sorted): ");
        inorder(root);
        System.out.println();
    }
}
