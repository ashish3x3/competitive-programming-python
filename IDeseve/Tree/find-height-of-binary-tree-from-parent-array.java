

Find height of the binary tree from its parent array representation
http://www.ideserve.co.in/learn/find-height-of-binary-tree-from-parent-array

similar to approach 2 of above creating tree from parent array.. we have height[i] array yhat will fill the height of the node with value i... here we make root node as height 1 and recursivly incremtn by 1+height[parent[i]]..in  the end we scan height array for the max value..


There are two main approaches to solve this problem. First very intuitive approach would be to construct the complete tree from its parent array representation and simply compute the height of that tree. We have discussed the solution to constructing a tree from its parent array representation here in this post. This algorithm could be run in O(n) time when the tree is constructed in bottom-up manner.

Now let's look at the approach where we don't need to construct the binary tree to find the height of it from its parent array representation. The steps of this algorithm are as following - 
1. Create height array of size same as parent array. For all legal values of 'i' make height[i] = INVALID_HEIGHT. height[i] denotes the height of node with value 'i'.
2. To compute the height for all nodes of this tree, we call computeHeight(i, height, parent) for all values of legal values of 'i'.
3. In computeHeight(i, height, parent) recursive function, 
3a. If height[i] is already computed, we return to the calling function.
3b. If parent[i] == -1, then that means this index corresponds to root node. Hence we make height[i] = 1 and return. Note that, as against the conventional notion of height here we have height of root node as minimum and height of leaf node as maximum.
3c. If conditions 3a and 3b are not true, then first we compute the height of the parent node by making a recursive call computeHeight(parent[i], height, parent). This parent height would be used to compute the height of the current node.
3d. Once we compute height of parent node, we compute height of current node with value 'i' as height[i] = 1 + height[parent[i]] and return.
4. After computeHeight() call sequence is complete, we have heights for all tree nodes. Now all we do is scan the height array to find and return the maximum height from this height array.



             
package com.ideserve.questions.nilesh;
 
/**
 * <b>IDeserve <br>
 * <a href="https://www.youtube.com/c/IDeserve">https://www.youtube.com/c/IDeserve</a>
 * O(n) solution to find height of the binary tree from its parent array representation.
 * @author Nilesh
 */
 
public class HeightOfTreeFromParentArray {
     
    final static int INVALID_HEIGHT = -1;
 
    private void computeHeight(int i, int[] height, int[] parent)
    {
        // height already computed for node with value as index 'i'
        if (height[i] != INVALID_HEIGHT)
        {
            return;
        }
         
        // if this is index 'i' corresponds to the root node, 
        // then make height[i] = 1 
        if (parent[i] == -1)
        {
            height[i] = 1;
            return;
        }
 
        // first compute the height for the parent node
        if (height[parent[i]] == INVALID_HEIGHT)
        {
            computeHeight(parent[i], height, parent);
        }
 
        // now compute the height of the current node using height of its parent node
        if (height[parent[i]] != INVALID_HEIGHT) // sanity check
        {
            height[i] = 1 + height[parent[i]];
        }
    }
     
     
    public int computeHeight(int[] parent)
    {
        int[] height = new int[parent.length]; 
         
        for (int i = 0; i < height.length; i++)
        {
            height[i] = INVALID_HEIGHT;
        }
         
        // compute height for all nodes
        for (int i = 0; i < height.length; i++)
        {
            computeHeight(i, height, parent);
        }
 
        // return the maximum of them
        int maxHeight = -1;
        for (int i = 0; i < height.length; i++)
        {
            if (height[i] > maxHeight)
            {
                maxHeight = height[i];
            }
        }
         
        return maxHeight;
    }
 
 
    public static void main(String[] args)
    {
        HeightOfTreeFromParentArray solution = new HeightOfTreeFromParentArray();
         
        int[] parent = {3, 5, 0, -1, 5, 3, 0};
         
        /*
                                3
                           0         5
                         2   6     1   4
        */
 
        System.out.println("Height of constructed tree would be: " + solution.computeHeight(parent));
         
    }
}
        

Time Complexity is O(n)
Space Complexity is O(1)