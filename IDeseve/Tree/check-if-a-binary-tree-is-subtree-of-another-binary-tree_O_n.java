


http://www.ideserve.co.in/learn/check-if-a-binary-tree-is-subtree-of-another-binary-tree-time-optimized


The algorithm is based on a simple idea that any binary tree could be uniquely represented by using in-order and pre-order traversal. 

To check if tree 'smallTree' is sub-tree of tree 'bigTree', the steps of the algorithm are as following - 
1. Find inorder traversals of 'smallTree' and 'bigTree'. Store them is string inorderForSmallTree and inorderForBigTree respectively.
2. Find preorder traversals of 'smallTree' and 'bigTree'. Store them is string preorderForSmallTree and preorderForBigTree respectively.
3. For 'smallTree' to be a sub-tree 'bigTree', string 'inorderForSmallTree' should be a substring of string 'inorderForBigTree' and string 'preorderForSmallTree' should be a substring of string 'preorderForBigTree'. 

We could have also used post-order traversal string instead of pre-order traversal string in this algorithm.
Please checkout function checkIfSubtree(TreeNode bigTree, TreeNode smallTree) in code snippet for implementation details.

The time complexity of this algorithm is O(n) since traversal string could be formed in O(n) time and using KMP algorithm substring check could also be done in O(n) time; though for simplicty in the implementation we have used in-built java string API for substring check.

Space complexity for this approach is O(n) for storing traversal strings.



private void fillUpPreorderString(String[] traversalString, TreeNode node)
    {
        if (node == null)
        {
            return;
        }
 
        traversalString[0] += node.key;
        fillUpPreorderString(traversalString, node.left);
        fillUpPreorderString(traversalString, node.right);
    }
 
     
    private void fillUpInorderString(String[] traversalString, TreeNode node)
    {
        if (node == null)
        {
            return;
        }
         
        fillUpInorderString(traversalString, node.left);
        traversalString[0] += node.key;
        fillUpInorderString(traversalString, node.right);
    }
     
     
    public boolean checkIfSubtree(TreeNode bigTree, TreeNode smallTree)
    {
        String[] inorderForBigTree = {""};
        String[] inorderForSmallTree = {""};
         
        fillUpInorderString(inorderForBigTree, bigTree);
        fillUpInorderString(inorderForSmallTree, smallTree);
         
        if (inorderForBigTree[0].contains(inorderForSmallTree[0]))
        {
            String[] preorderForBigTree = {""};
            String[] preorderForSmallTree = {""};
 
            fillUpPreorderString(preorderForBigTree, bigTree);
            fillUpPreorderString(preorderForSmallTree, smallTree);
 
            return preorderForBigTree[0].contains(preorderForSmallTree[0]);
        }
         
        return false;
    }















Time Complexity is O(n)
Space Complexity is O(n)