
http://www.ideserve.co.in/learn/iterative-preorder-traversal-of-binary-tree

import java.util.Stack;
 
/**
 * <b>IDeserve <br>
 * <a href="https://www.youtube.com/c/IDeserve">https://www.youtube.com/c/IDeserve</a>
 * Iterative pre-order traversal of a binary tree.
 * 
 * @author Abhishek
 */
 
public class Tree {
     
    private TreeNode root;
     
    class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;
 
        public TreeNode(int data) {
            this.data = data;
        }
    };
 
    /**
     * Method creates a sample tree
     *                5
     *          4           6
     *      3       7   8       
     * 
     */
    public void createTree() {
        root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(8);
    }
     
    /**
     * Method for printing iterative pre-order traversal 
     * of a binary tree.
     */
    public void iterativePreorder() {
        TreeNode top;
        if (root == null)
            return;
 
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
 
        /*
         * Push the root and do the same process as recursive one but in this way:
         * a) Print the node's data 
         * b) Push its right child
         * c) Push its left child.
         * This is done because stack if LIFO so left child is operated first.
         */
        while (!st.empty()) {
            top = st.pop();
            System.out.print(top.data + " ");
            if (top.right != null)
                st.push(top.right);
            if (top.left != null)
                st.push(top.left);
        }
    }
 
    /**
     * Method for testing the algorithm.
     * 
     * @param args
     */
    public static void main(String args[]) {
        Tree tree = new Tree();
        tree.createTree();
        tree.iterativePreorder();
    }
}