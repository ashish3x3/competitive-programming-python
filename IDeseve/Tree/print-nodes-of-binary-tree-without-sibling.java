


http://www.ideserve.co.in/learn/print-nodes-of-binary-tree-without-sibling


This is a simple problem solved using traversal of the tree. We can use any traversal method and while traversing we need to check if a node has only one child. If it does then we need to print that out.

In this algorithm, we have used pre-order traversal method. Time taken is O(n) and space taken is O(1) for this algorithm.

 public void printNonSiblingNodes(TreeNode currentNode)
    {
        if (currentNode == null)
        {
            return;
        }
         
        if (currentNode.left == null && currentNode.right != null)
        {
            System.out.println(currentNode.right.value);
        }
        if (currentNode.right == null && currentNode.left != null)
        {
            System.out.println(currentNode.left.value);
        }
 
        printNonSiblingNodes(currentNode.left);
        printNonSiblingNodes(currentNode.right);
    }