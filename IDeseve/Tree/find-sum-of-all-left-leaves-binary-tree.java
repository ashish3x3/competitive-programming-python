



Find sum of all left leaves of a binary tree
http://www.ideserve.co.in/learn/find-sum-of-all-left-leaves-binary-tree


/*
The solution to this problem is as simple as traversing the complete tree using any traversal method in order to visit all nodes and checking if a node has a left-child which is also a leaf node. If that is the case then add that left-child's value to the sum. As you can see in code snippet, we have used pre-order traversal to 
	implement this algorithm.

*/




private boolean isLeafNode(TreeNode currentNode)
    {
        if (currentNode == null)
        {
            return false;
        }
         
        if (currentNode.left == null && currentNode.right == null)
        {
            return true;
        }
         
        return false;
    }
     
     
    public void findLeftLeavesSum(TreeNode currentNode, int[] leftLeavesSum)
    {
        if (currentNode == null)
        {
            return;
        }
        if (isLeafNode(currentNode.left))
        {
            leftLeavesSum[0] += currentNode.left.val;
        }
         
        findLeftLeavesSum(currentNode.left, leftLeavesSum);
        findLeftLeavesSum(currentNode.right, leftLeavesSum);
    }



public static void main(String[] args)
    {
        SumOfAllLeftLeavesBinaryTree tree = new SumOfAllLeftLeavesBinaryTree();
         
         
        /*
                                1
                          2             3
                      4      5       6     7
                        8              
                      9
        */
        tree.createTree();
         
        int[] leftLeavesSum = new int[1];
        tree.findLeftLeavesSum(tree.root, leftLeavesSum);
         
        System.out.println(leftLeavesSum[0]);
    }























