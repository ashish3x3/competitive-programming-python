

http://www.ideserve.co.in/learn/spiral-level-order-traversal-of-a-binary-tree-set-1

/**
 * <b>IDeserve <br>
 * <a href="https://www.youtube.com/c/IDeserve">https://www.youtube.com/c/IDeserve</a> 
 * Visits nodes of a binary tree in spiral level order using stacks. 
 * @author Nilesh
 */
 
import java.util.Stack;
 
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
 
     
    private void spiralTraversal(TreeNode root)
    {
        if (root == null)
        {
            return;
        }
         
        // for storing and printing nodes at even level
        Stack<TreeNode> stackEven = new Stack();
         
        // for storing and printing nodes at odd level
        Stack<TreeNode> stackOdd = new Stack(); 
         
        // root node is considered at level 0.
        stackEven.push(root);
         
        boolean evenLevel = true;
         
        // traverse while there are nodes to visit in the current-level stack
        // empty current-level stack indicates that all nodes of the tree are visited
        while ((evenLevel && !stackEven.isEmpty()) || (!stackOdd.isEmpty()))
        {
            if (evenLevel) // if current level to be visited is even
            {
                // visit nodes at even level and push their children in odd level stack
                while (!stackEven.isEmpty())
                {
                    TreeNode currentNode = stackEven.pop();
                     
                    System.out.print(" " + currentNode.value);
                     
                    // first push the right child
                    if (currentNode.right != null)
                    {
                        stackOdd.push(currentNode.right);
                    }
                     
                    // then push the left child
                    if (currentNode.left != null)
                    {
                        stackOdd.push(currentNode.left);
                    }
                }
            }
            else // if current level to be visited is odd
            {
             // visit nodes at odd level and push their children in even level stack
                while (!stackOdd.isEmpty())
                {
                    TreeNode currentNode = stackOdd.pop();
                     
                    System.out.print(" " + currentNode.value);
                     
                    // first push the left child
                    if (currentNode.left != null)
                    {
                        stackEven.push(currentNode.left);
                    }
                     
                    // then push the right child
                    if (currentNode.right != null)
                    {
                        stackEven.push(currentNode.right);
                    }
                }
            }
             
            // if current level is even switch to odd and vice versa
            evenLevel = !evenLevel;
            System.out.println();
        }
    }
     
    public void spiralTraversal()
    {
        spiralTraversal(this.root);
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
   


   Time Complexity is O(n)
Space Complexity is O(n)