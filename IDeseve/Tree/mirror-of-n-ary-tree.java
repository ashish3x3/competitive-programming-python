
Convert the given n-ary tree to its mirror image
http://www.ideserve.co.in/learn/mirror-of-n-ary-tree

The idea is to use a traversal similar to post-order traversal for converting a given n-ary tree into its mirror image. The algorithm is very similar to the algorithm of creating a mirror tree for a binary tree. You might want to check out this post. 

In function convertToMirror(TreeNode root), first we convert all sub-trees rooted at child nodes of root to their mirror images(by making recursive calls) and then reverse the order of child nodes themselves.

The time complexity for this approach would be O(n). In the code snippet, checkout function convertToMirror(TreeNode root) for implementation details.



private void convertToMirror(TreeNode root) 
    {
        if(root == null) {
            return;
        }
 
        // create mirror images of sub-trees rooted at child nodes
        for (int i = 0; i < root.children.size(); i++)
        {
            convertToMirror(root.children.get(i));
        }
         
        // now reverse the order of child nodes
        Collections.reverse(root.children);
    }
 
Time Complexity is O(n)
Space Complexity is O(1)    