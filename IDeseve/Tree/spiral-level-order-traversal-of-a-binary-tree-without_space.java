



http://www.ideserve.co.in/learn/spiral-level-order-traversal-of-a-binary-tree-set-2


             
package com.ideserve.nilesh.questions;
 
/**
 * <b>IDeserve <br>
 * <a href="https://www.youtube.com/c/IDeserve">https://www.youtube.com/c/IDeserve</a> 
 * Visits nodes of a binary tree in spiral level order using recursion.
 * This algorithm takes O(n^2) time to run where 'n' is the depth of the given tree.
 * @author Nilesh
 */
 
public class SpiralTraversal 
{
    private class TreeNode
    {
        TreeNode left;
        TreeNode right;
        int value;
     
        public TreeNode(int value)
        {
            this.value = value;
        }
    }
     
    TreeNode root;
 
    /*
                             0
                      1              2
                   4      5       3     6
                        7   8         9  
    */
    public void createTree()
    {
        this.root = new TreeNode(0);
 
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
 
        root.left  = n1;
        root.right = n2;
         
        n1.left  =  n4;
        n1.right = n5;
         
        n2.left  = n3;
        n2.right = n6;
         
        n5.left  = n7;
        n5.right = n8;
         
        n6.left  = n9;
    }
 
    private int findDepth(TreeNode currentNode)
    {
        if (currentNode == null)
        {
            return 0;
        }
         
        return (1 + Math.max(findDepth(currentNode.left), findDepth(currentNode.right)));
    }
     
     
    /*
     * This sub-routine basically does pre-order traversal for shortened tree. 
     * Pre-order traversal could be from right-to-left order OR from left-to-right order -
     * depending on the value of parameter - 'rightToLeft'.
     * 
     * Tree shortening is done using by considering tree from level of currentNode 
     * to passed 'level'.
     * If passed level is 0, only the currentNode is considered and currentNode's value is printed.
     * If passed level is 1, currentNode and its immediate children are considered.
     * If passed level is 2, currentNode,its immediate children
     *  and children of currentNode's children are considered. 
     */
    private void printNodesAtLevel(TreeNode currentNode, int currentLevel, int maxLevel, boolean rightToLeft)
    {
        if (currentNode == null)
        {
            return;
        }
         
        // if we have reached the maximum level for this traversal
        if (currentLevel == maxLevel)
        {
            System.out.print(currentNode.value + ", ");
            return;
        }
 
        if (rightToLeft)
        {
            printNodesAtLevel(currentNode.right, currentLevel + 1, maxLevel, rightToLeft);
            printNodesAtLevel(currentNode.left, currentLevel + 1, maxLevel, rightToLeft);
        }
        else
        {
            printNodesAtLevel(currentNode.left, currentLevel + 1, maxLevel, rightToLeft);
            printNodesAtLevel(currentNode.right, currentLevel + 1, maxLevel, rightToLeft);
        }
    }
     
    public void spiralTraversal()
    {
        int maxDepth = findDepth(root);
         
        // nodes at even level are printed from right to left and
        // nodes at odd  level are printed from  left to right.
        boolean rightToLeft = true;
         
        for (int level = 0; level < maxDepth; level++)
        {
            // print nodes at given level
            printNodesAtLevel(root, 0, level, rightToLeft);
            rightToLeft = !rightToLeft;
        }
    }
     
     
    public static void main(String[] args)
    {
        SpiralTraversal solution = new SpiralTraversal();
 
        /*
                                 0
                          1              2
                       4      5       3     6
                            7   8         9  
        */
        solution.createTree();
         
        solution.spiralTraversal();
    }
}
        
Order of the Algorithm

Time Complexity is O(n^2), n: depth of the tree
Space Complexity is O(n)