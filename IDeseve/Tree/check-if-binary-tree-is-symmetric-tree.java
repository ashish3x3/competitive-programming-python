

Check if a given binary tree is symmetric tree or not
http://www.ideserve.co.in/learn/check-if-binary-tree-is-symmetric-tree


The algorithm is an implementation of a simple idea that - 
1. For given two trees, if both trees are empty then they are mirror images of one another.
Else they have to satisfy following conditions:
2. Root values of both trees have to be same.
3. Left sub-tree of tree1 should be mirror image of right sub-tree of tree2.
4. Right sub-tree of tree1 should be mirror image of left sub-tree of tree2.



Time complexity of this algorithm is O(n) since in the worst case each node need to be visited once.



private boolean isSymmetric(TreeNode root1, TreeNode root2)
    {
        if (root1 == null && root2 == null)
        {
            return true;
        }
        else if (root1 == null || root2 == null)
        {
            return false;
        }
         
        if (root1.value == root2.value)
        {
            if (isSymmetric(root1.left, root2.right))
            {
                return isSymmetric(root1.right, root2.left);
            }
        }
        return false;
    }
 
 
    public boolean isSymmetric(TreeNode root)
    {
        return isSymmetric(root, root);
    }





















