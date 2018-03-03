

http://www.ideserve.co.in/learn/check-if-n-ary-tree-is-symmetric-tree


The algorithm is an implementation of a simple idea that - 
1. For given two trees, if both trees are empty then they are mirror images of one another.
Else they have to satisfy following conditions:
2. Root values of both trees have to be same. This can be checked by comparing values of root nodes for given two trees.
3. Sub-tree rooted at the first position should be mirror image of sub-tree rooted at the last position, sub-tree rooted at second position should be mirror image of the sub-tree rooted at second last-position and so on. This can be checked by making recursive calls.

Initial call to checkSymmetry(TreeNode root1, TreeNode root2) is made with root1 = root and root2 = root.

This algorithm is similar to the algorithm for solving the problem - Check if a given binary tree is symmetric or not.

Time complexity of this algorithm is O(n) since in the worst case each node need to be visited once.




public boolean checkSymmetry(TreeNode root1, TreeNode root2)
    {
        if (root1 == null && root2 == null)
        {
            return true;
        }
        else if (root1 == null || root2 == null)
        {
            return false;
        }
        else if (root1.data == root2.data)
        {
            int i = 0, j = root2.children.size() - 1;
            while ((i < root1.children.size()) && (j >= 0))
            {
                if (!checkSymmetry(root1.children.get(i), root2.children.get(j)))
                {
                    break;
                }
                i++; j--;
            }
             
            if ((i < root1.children.size()) || (j >= 0))
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        return false;
    }


Time Complexity is O(n)
Space Complexity is O(1)
    