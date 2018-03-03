

             
http://www.ideserve.co.in/learn/maximum-element-from-each-subarray-of-size-k-set-1
AVL tree: https://www.youtube.com/watch?v=YKt1kquKScY




Method 1 (Simple)
Run two loops. In the outer loop, take all subarrays of size k. In the inner loop, get the maximum of the current subarray.



Method 2 (Use Self-Balancing BST)
1) Pick first k elements and create a Self-Balancing Binary Search Tree (BST) of size k.
2) Run a loop for i = 0 to n – k
…..a) Get the maximum element from the BST, and print it.
…..b) Search for arr[i] in the BST and delete it from the BST.
…..c) Insert arr[i+k] into the BST.

Time Complexity: Time Complexity of step 1 is O(kLogk). Time Complexity of steps 2(a), 2(b) and 2(c) is O(Logk). Since steps 2(a), 2(b) and 2(c) are in a loop that runs n-k+1 times, time complexity of the complete algorithm is O(kLogk + (n-k+1)*Logk) which can also be written as O(nLogk).




 
/**
 * <b>IDeserve <br>
 * <a href="https://www.youtube.com/c/IDeserve">https://www.youtube.com/c/IDeserve</a> 
 * In O(nlogk) time, this code finds out maximum element from each sub-array of size 'k'.
 * @author Nilesh
 */
public class MaximumfromEachSubarray 
{
    private class AVLTreeNode 
    {
        int data;
        AVLTreeNode left;
        AVLTreeNode right;
        int height;
         
        AVLTreeNode(int data)
        {
            this.data = data;
            this.height = 1;
        }
    }
     
    AVLTreeNode root;
     
    public MaximumfromEachSubarray()
    {
 
    }
     
    private int getHeight(AVLTreeNode node)
    {
        if (node == null)
            return 0;
         
        return node.height;
    }
     
    private void updateHeight(AVLTreeNode node)
    {
        if (node == null) return;
         
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
     
     
    private AVLTreeNode rotateRight(AVLTreeNode node)
    {
        if (node == null) return node;
         
        AVLTreeNode beta  = node.left;
         
        AVLTreeNode t2  = beta.right;
         
        beta.right = node;
        node.left = t2;
         
        // we first need to update the height of node because height of beta uses height of node
        updateHeight(node);
         
        // now we update height of beta
        updateHeight(beta);
         
        return beta;
    }
     
     
    private AVLTreeNode rotateLeft(AVLTreeNode node)
    {
        if (node == null) return node;
         
        AVLTreeNode beta  = node.right;
        AVLTreeNode t2  = beta.left;
         
        beta.left = node;
        node.right = t2;
         
        // we first need to update the height of node because height of beta uses height of node
        updateHeight(node);
         
        // now we update height of beta
        updateHeight(beta);
         
        return beta;
    }
     
     
    private int getBalance(AVLTreeNode node)
    {
        if (node == null)
        {
            return 0;
        }
        int balance;
         
        balance = getHeight(node.left) - getHeight(node.right);
         
        return balance;
    }
     
     
    private int getMaxValue(AVLTreeNode node)
    {
        // though this case should not be hit ever for the usecase this function is employed for
        if (node == null) return Integer.MIN_VALUE;
         
        // if this is the left-most node
        if (node.right == null) return node.data;
         
        return getMaxValue(node.right);
    }
     
    private int getMinValue(AVLTreeNode node)
    {
        // though this case should not be hit ever for the usecase this function is employed for
        if (node == null) return Integer.MIN_VALUE;
         
        // if this is the left-most node
        if (node.right == null) return node.data;
         
        return getMaxValue(node.left);
    }
     
    private AVLTreeNode delete(AVLTreeNode node, int key)
    {
        // if empty tree 
        if (node == null) return null;
         
        if (key < node.data)
        {
            node.left = delete(node.left, key);
        }
        else if (key > node.data)
        {
            node.right = delete(node.right, key);
        }
         
        else // key to be deleted is equal to node data 
        {
            // one child/no child case
            if (node.left == null)
            {
                node = node.right;
            }
            else if (node.right == null)
            {
                node = node.left;
            }
             
            // two children case
            // copy value of inorder successor into current node and delete inorder successor
            // since right sub-tree would be modified, update node.right
            else
            {
                int inorderSuccessorValue = getMinValue(node.right);
                node.data = inorderSuccessorValue;
                node.right = delete(node.right, inorderSuccessorValue);
            }
        }
 
        // if there was only one node in the tree which got deleted above return null 
        if (node == null)
        {
            return null;
        }
         
        // update the height of the node
        updateHeight(node);
         
        // check the balance at this node and perform rotations accordingly
        int balance = getBalance(node);
         
        if (balance > 1) // indicates either left-left or left-right case
        {
            if (getBalance(node.left) >= 0) // confirms left-left case
            {
                node = rotateRight(node);
            }
            else // confirms left-right case
            {
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        }
         
        else if (balance < -1) // indicates either right-right or right-left case
        {
            if (getBalance(node.right) <= 0) // confirms right-right case
            {
                node = rotateLeft(node);
            }
            else // confirms right-left case
            {
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        }
        return node;
    }
     
     
    private AVLTreeNode insert(AVLTreeNode node, int key)
    {
        // do usual BST insertion first
        if (node == null)
        {
            this.root =  new AVLTreeNode(key);
            return this.root;
        }
         
        if (key < node.data)
        {
            node.left = insert(node.left, key);
        }
        else if (key > node.data)
        {
            node.right = insert(node.right, key);
        }
        else
        {
            return node;
        }
         
        // now update the height of the node
        updateHeight(node);
         
        // check the balance at this node and perform rotations accordingly
        int balance = getBalance(node);
         
        if (balance > 1) // indicates either left-left or left-right case
        {
            if (key < node.left.data) // confirms left-left case
            {
                node = rotateRight(node);
            }
            else // confirms left-right case
            {
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        }
         
        else if (balance < -1) // indicates either right-right or right-left case
        {
            if (key > node.right.data) // confirms right-right case
            {
                node = rotateLeft(node);
            }
            else // confirms right-left case
            {
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        }
        return node;
    }
     
     
    public void insert(int key)
    {
        root = insert(this.root, key);
        return;
    }
     
     
    public void delete(int key)
    {
        root = delete(this.root, key);
        return;
    }
     
 
    public static void main(String[] args)
    {
        MaximumfromEachSubarray solution = new MaximumfromEachSubarray();
 
        int[] array = {4,2,12,34,23,35,44,55};

        for (int i = 0; i < arr.length; i++)
        {
            insert(array[i]);
        }

        delete(35); 
         
        System.out.println("Maximum elements from each sub-array of specified size are - ");
        solution.printMaxfromEachSubarray(array, k);
    }
}
        
Order of the Algorithm

Time Complexity is O(nlogk), n: size of input array, k: sub-array size