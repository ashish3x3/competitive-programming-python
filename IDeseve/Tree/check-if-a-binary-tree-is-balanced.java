







Check if a binary tree is balanced or not
http://www.ideserve.co.in/learn/check-if-a-binary-tree-is-balanced


/*
                            0
                      1             2
                  3      4       5  
                    6              7
                      8
    */


                      

// this function returns height of tree rooted at currentNode if the tree is balanced
    // otherwise it returns -1
    private int checkBalance(TreeNode currentNode)
    {
        if (currentNode == null) 
        {
            return 0;
        }
         
        // check if left sub-tree is balanced
        int leftSubtreeHeight = checkBalance(currentNode.left);
        if (leftSubtreeHeight == -1) return -1;
         
        // check if right sub-tree is balanced
        int rightSubtreeHeight = checkBalance(currentNode.right);
        if (rightSubtreeHeight == -1) return -1;
         
        // if both sub-trees are balanced, check the difference of heights
        // should be less than or equal to 1 
        if (Math.abs(leftSubtreeHeight - rightSubtreeHeight) > 1)
        {
            return -1;
        }
 
        // if tree rooted at this node is balanced, return height if tree rooted at this this node
        return (Math.max(leftSubtreeHeight, rightSubtreeHeight) + 1);
    }
     
     
    public boolean checkIfBalanced()
    {
        if (checkBalance(root) == -1)
        {
            return false;
        }
        return true;
    }