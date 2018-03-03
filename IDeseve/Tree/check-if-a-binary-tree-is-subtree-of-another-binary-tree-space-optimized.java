

http://www.ideserve.co.in/learn/check-if-a-binary-tree-is-subtree-of-another-binary-tree-space-optimized
http://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree/
http://www.geeksforgeeks.org/check-binary-tree-subtree-another-binary-tree-set-2/


/* This function returns true if S is a subtree of T, otherwise false */
bool isSubtree(struct node *T, struct node *S)
{
    /* base cases */
    if (S == NULL)
        return true;
 
    if (T == NULL)
        return false;
 
    /* Check the tree with root as current node */
    if (areIdentical(T, S))
        return true;
 
    /* If the tree with root as current node doesn't match then
       try left and right subtrees one by one */
    return isSubtree(T->left, S) ||
           isSubtree(T->right, S);
}



bool areIdentical(struct node * root1, struct node *root2)
{
    /* base cases */
    if (root1 == NULL && root2 == NULL)
        return true;
 
    if (root1 == NULL || root2 == NULL)
        return false;
 
    /* Check if the data of both roots is same and data of left and right
       subtrees are also same */
    return (root1->data == root2->data   &&
            areIdentical(root1->left, root2->left) &&
            areIdentical(root1->right, root2->right) );
}

Time Complexity: Time worst case complexity of above solution is O(mn) where m and n are number of nodes in given two trees.

private boolean completeMatch(TreeNode bigTreeRoot, TreeNode smallTreeRoot)
    {
        if ((bigTreeRoot == null) && (smallTreeRoot == null))
        {
            return true;
        }
         
        if ((bigTreeRoot == null) || (smallTreeRoot == null))
        {
            return false;
        }
 
        if (bigTreeRoot.key == smallTreeRoot.key)
        {
            return completeMatch(bigTreeRoot.left, smallTreeRoot.left) && completeMatch(bigTreeRoot.right, smallTreeRoot.right);
        }
         
        return false;
    }
     
     
    public boolean checkIfSubtree(TreeNode bigTreeRoot, TreeNode smallTreeRoot)
    {
        if (smallTreeRoot == null)
        {
            return true;
        }
        if (bigTreeRoot == null)
        {
            return false;
        }
         
        if (bigTreeRoot.key == smallTreeRoot.key)
        {
            if (completeMatch(bigTreeRoot, smallTreeRoot))
            {
                return true;
            }
        }
         
        return checkIfSubtree(bigTreeRoot.left, smallTreeRoot) || checkIfSubtree(bigTreeRoot.right, smallTreeRoot);
    }
 


 We can solve the above problem in O(n) time. Please refer Check if a binary tree is subtree of another binary tree | Set 2 for O(n) solution.