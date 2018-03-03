
Convert a binary tree to its mirror tree

http://www.ideserve.co.in/learn/mirror-a-tree

Boundary condition: If root is null, then return.
Recursive step: Recursively convert left and right sub trees to their mirror.
Actual conversion to mirror: Swap left and right sub trees of the current node.

private void convertToMirror(TreeNode root) {
        if(root == null) {
            return;
        }
        // Mirror left subtree
        convertToMirror(root.getLeft());
        // Mirror right subtree
        convertToMirror(root.getRight());
         
        // Interchange left and right subtree root nodes
        TreeNode t = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(t);       
    }
 

 /*
     * Create a sample tree
     *                1
     *          2           3
     *      4           5       
     * 
     */

public void createSampleTree() {
        root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(5), null));     
    }
private void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
        inorder(root.getLeft());
        System.out.print(root.getData() + " ");
        inorder(root.getRight());
    }

    
class TreeNode {
     
    private int data;
    private TreeNode left;
    private TreeNode right;
     
    public int getData() {
        return data;
    }
 
    public void setData(int data) {
        this.data = data;
    }
 
    public TreeNode getLeft() {
        return left;
    }
 
    public void setLeft(TreeNode left) {
        this.left = left;
    }
 
    public TreeNode getRight() {
        return right;
    }
 
    public void setRight(TreeNode right) {
        this.right = right;
    }
 
    public TreeNode(int data) {
        this.data = data;
    }
     
    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }   
}