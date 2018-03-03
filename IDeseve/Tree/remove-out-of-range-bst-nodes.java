 

http://www.ideserve.co.in/learn/remove-out-of-range-bst-nodes



import java.util.LinkedList;
 
/**
 * <b>IDeserve <br>
 * <a href="https://www.youtube.com/c/IDeserve">https://www.youtube.com/c/IDeserve</a>
 * Removes nodes of a given BST which are out of given range [n1 - n2]
 * @author Nilesh
 */
public class RemoveOutOfRangeNodesBST 
{
    private class QueueNode
    {
        BinarySearchTreeNode treeNode;
        int level;
         
        QueueNode(BinarySearchTreeNode treeNode, int level)
        {
            this.treeNode = treeNode;
            this.level = level;
        }
    }
     
    private class BinarySearchTreeNode 
    {
        int data;
        BinarySearchTreeNode left;
        BinarySearchTreeNode right;
         
        BinarySearchTreeNode(int data)
        {
            this.data = data;
        }
    }
     
    BinarySearchTreeNode root;
     
    RemoveOutOfRangeNodesBST()
    {
         
    }
     
    private BinarySearchTreeNode insert(BinarySearchTreeNode node, int key)
    {
         
        if (node == null) // base case
        {
            node = new BinarySearchTreeNode(key);
        }
         
        if (key < node.data) // insert key into left sub-tree
        {
            node.left = insert(node.left, key);
        }
        else if (key > node.data) // insert key into right sub-tree
        {
            node.right = insert(node.right, key);
        }
         
        return node;
    }
     
     
    public void insert(int key)
    {
        root = insert(this.root, key);
        return;
    }
     
 
    public void printTreeLevelOrder()
    {
        if (root == null) return;
         
        LinkedList queue = new LinkedList();
        queue.add(new QueueNode(root, 0));
         
        int maxLevelVisited = -1;
         
        while (!queue.isEmpty())
        {
            QueueNode currentNode = (QueueNode) queue.remove();
             
            if (currentNode.level > maxLevelVisited)
            {
                maxLevelVisited = currentNode.level;
                System.out.print("\nlevel-" + currentNode.level + " nodes: ");
            }
            System.out.print(" " + currentNode.treeNode.data);
             
            if (currentNode.treeNode.left != null)
            {
                queue.add(new QueueNode(currentNode.treeNode.left, currentNode.level + 1));
            }
             
            if (currentNode.treeNode.right != null)
            {
                queue.add(new QueueNode(currentNode.treeNode.right, currentNode.level + 1));
            }
        }
    }
     
    private BinarySearchTreeNode removeOutOfRangeNodes(BinarySearchTreeNode currentNode, int min, int max)
    {
        if (currentNode == null)
        {
            return null;
        }
         
        // correct left and right sub-trees first
        currentNode.left  = removeOutOfRangeNodes(currentNode.left, min, max);
        currentNode.right = removeOutOfRangeNodes(currentNode.right, min, max);
         
        /*
         * if currentNode's value is less than min threshold, it's left sub-tree would already be null
         * simply return reference to right sub-tree
         */
        if (currentNode.data < min)
        {
            return currentNode.right;
        }
 
        /*
         * if currentNode's value is more than max threshold, it's right sub-tree would already be null
         * simply return reference to left sub-tree
         */
        if (currentNode.data > max)
        {
            return currentNode.left;
        }
         
        return currentNode;
    }
     
    public void removeOutOfRangeNodes(int min, int max)
    {
        this.root = removeOutOfRangeNodes(this.root, min, max);
    }
     
    public static void main(String[] args)
    {
        RemoveOutOfRangeNodesBST tree = new RemoveOutOfRangeNodesBST();
 
        tree.insert(8);
        tree.insert(5);
        tree.insert(11);
        tree.insert(2);
        tree.insert(7);
        tree.insert(9);
        tree.insert(12);
        tree.insert(6);
        tree.insert(10);
        tree.insert(13);
 
        /*
         *          8
         *      5         11
         *   2    7    9     12
         *       6      10     13
        */
         
        tree.printTreeLevelOrder();
         
        tree.removeOutOfRangeNodes(3, 9);
         
        System.out.print("\n\nBST after removing relevant nodes");
        /*
         *          8
         *      5         9
         *        7         
         *       6           
        */
        tree.printTreeLevelOrder();
    }
}
        
Order of the Algorithm

Time Complexity is O(n)
Space Complexity is O(n)