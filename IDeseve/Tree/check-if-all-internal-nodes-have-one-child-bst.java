

http://www.ideserve.co.in/learn/check-if-all-internal-nodes-have-one-child-bst



/**
 * <b>IDeserve <br>
 * <a href="https://www.youtube.com/c/IDeserve">https://www.youtube.com/c/IDeserve</a>
 * Checks if each internal node of BST has only one child without actually building the tree. Runs in O(n) time.
 * @author Nilesh
 */
public class OneChildNodesBST 
{
    private int minimum(int a, int b)
    {
        if (a < b) return a;
        return b;
    }
 
    private int maximum(int a, int b)
    {
        if (a > b) return a;
        return b;
    }
 
    public boolean checkOneChildNodesBST(int[] preorder)
    {
        int maxSoFar = preorder[preorder.length - 1], minSoFar = preorder[preorder.length - 1];
         
        /*
         *  check if all elements in the sub-array from [i+1 to end] of the array 
         *  are less than current element - preorder[i]. If not, all these elements should
         *  be greater than the current element.  
         */
        for (int i = preorder.length - 2; i >= 0; i--)
        {
            if (!((preorder[i] < minSoFar) || (preorder[i] > maxSoFar)))
            {
                return false;
            }
            maxSoFar = maximum(preorder[i], maxSoFar);
            minSoFar = minimum(preorder[i], minSoFar);
        }
        return true;
    }
 
    public static void main(String[] args)
    {
        OneChildNodesBST solution = new OneChildNodesBST();
         
        int[] preorderTree1 = {9,8,5,7,6};
        int[] preorderTree2 = {8,5,4,7,6};
         
        System.out.println("Check if evry internal node of this BST has only one child:\n" + solution.checkOneChildNodesBST(preorderTree2));
    }
}
        
Order of the Algorithm

Time Complexity is O(n)
Space Complexity is O(1)