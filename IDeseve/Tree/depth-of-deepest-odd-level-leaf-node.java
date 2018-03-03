



Find depth of deepest odd level leaf node
http://www.ideserve.co.in/learn/depth-of-deepest-odd-level-leaf-node



/*
     * Create a sample tree
     *
     *         1
     *       /   \
     *      2     3
     *           /  \  
     *          4    5
     *         /      \
     *        6        7
     *         \      /  
     *          8    9    
     *              /
     *             10
     *
     */





Traverse the tree and keep track of current level of the node.
Current level of a node can be easily tracked by maintaining a variable 'currLevel'. Level of Root node is 1. Increment 'currLevel' while traversing for left and right subtrees. 
While traversing:
1: If root is null, return 0.
2: Else if we find a leaf node and the current level is odd, return the current level.
3: Else return maximum of (maximum depth of odd level leaf node found in left subtree, maximum depth of odd level leaf node found in right subtree).




public class Tree {
 
    private Node root;
 
    public int depthDeepestOddLevelLeafNode() {
        return depthDeepestOddLevelLeafNode(root, 1);
    }
 
    private int depthDeepestOddLevelLeafNode(Node root, int currLevel) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null && ((currLevel & 1) != 0))
            return currLevel;
        return Integer.max(depthDeepestOddLevelLeafNode(root.left, currLevel + 1), depthDeepestOddLevelLeafNode(root.right, currLevel + 1));
    }
     
    /*
     * Create a sample tree
     *
     *         1
     *       /   \
     *      2     3
     *           /  \  
     *          4    5
     *         /      \
     *        6        7
     *         \      /  
     *          8    9    
     *              /
     *             10
     *
     */
    public void createSampleTree() {
        root = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);
 
        root.left = n2;
        root.right = n3;
 
        n3.left = n4;
        n3.right = n5;
 
        n4.left = n6;
 
        n5.right = n7;
 
        n6.right = n8;
 
        n7.left = n9;
 
        n9.left = n10;
    }
 
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.createSampleTree();
        int depthDeepestOddLevelLeafNode = tree.depthDeepestOddLevelLeafNode();
        if (depthDeepestOddLevelLeafNode != 0)
            System.out.println("Depth of deepest odd level leaf node is: " + depthDeepestOddLevelLeafNode);
        else
            System.out.println("No odd level leaf node exists");
    }
}
 
class Node {
 
    int data;
    Node left;
    Node right;
 
    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
 
    public Node(int data) {
        this.data = data;
    }
}