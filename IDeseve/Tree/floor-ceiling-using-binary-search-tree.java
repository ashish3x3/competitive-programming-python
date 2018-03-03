
http://www.ideserve.co.in/learn/floor-ceiling-using-binary-search-tree

/*
Let's first understand the algorithm for finding out the floor of an element. Once we understand this algorithm, algorithm for finding out ceiling is very similar.

First step is to construct a binary search tree from a given dataset. Now, to find out floor of an element 'a' using this BST we use following steps - 

In the function findFloor(TreeNode currentNode, int a)
1. If currentNode is null then we know that floor of value 'a' does not exist in the sub-tree rooted at currentNode. Therefore we return INVALID_VALUE in this case.
2. If value of currentNode is equal to value 'a', then currentNode's value is the floor of 'a' and we return currentNode's value.
3. If value of currentNode is greater than value 'a', then we must search for floor of 'a' in the left sub-tree of currentNode(Recall the BST property). We return the value returned by search for the floor of 'a' in the left sub-tree.
4. If value of currentNode is less than value 'a', then right sub-tree of currentNode might have a value which is greater than currentNode value and less than value 'a'. Therefore, we search for floor of value 'a' in right sub-tree of currentNode. If floor is found in right sub-tree, we return that otherwise this currentNode's value must be the floor of value 'a' and we return that accordingly.

Let's look at an example which uses above steps. For dataset {0,2,4,6,8,9} a BST would look like following tree.


Now if are to find floor for value 10 in the above dataset using the constructed BST
1. We start at the root node 6. Since 6 is less than 10, the floor of 10 right might be in the right sub-tree. We search for that accordingly in right sub-tree.
2. Not currentNode is 9. Since 9 is again less than 10, the floor of 10 might be in right sub-tree of 9. We search for it accordingly in its right sub-tree.
3. Now as you can see, currentNode now becomes null and we return INVALID_VALUE to step #2.
4. When step#3 returns to step#2, currentNode is 9 again and with the knowledge that right sub-tree does not have the floor of 10. Because this is BST, all values in the left sub-tree(and all values of parent nodes) are less than 9 and hence 9 must be the floor of 10. Therefore, we return the value 9 as floor of 10.

Checkout function getCeiling(BinarySearchTreeNode currentNode, int key) in code snippet for implementation details.


The algorithm for finding the floor of a given value from given dataset is very similar and you should be able to understand it by looking at function getFloor(BinarySearchTreeNode currentNode, int key) in code snippet.

Both these algorithm run in O(logn) time with extra space of order O(1). Note that construction of BST takes O(n) time but that is not the core algorithm assuming that finding floor/ceiling operations would be performed multiple times on a BST which would be constructed once.
*/

             
package com.ideserve.questions.nilesh;
 
import java.util.LinkedList;
 
/**
 * <b>IDeserve <br>
 * <a href="https://www.youtube.com/c/IDeserve">https://www.youtube.com/c/IDeserve</a>
 * Finds floor and ceiling of an element from given dataset using BST in log(n) time.
 * @author Nilesh
 */
 
public class CeilingFloorBST 
{
    final static int INVALID_VALUE = -1;
     
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
     
    // default value for root node is 5
    CeilingFloorBST()
    {
        this.root = new BinarySearchTreeNode(5);
    }
     
    CeilingFloorBST(int rootValue)
    {
        this.root = new BinarySearchTreeNode(rootValue);
    }
 
 
    int getCeiling(BinarySearchTreeNode currentNode, int key)
    {
        if (currentNode == null)
        {
            return INVALID_VALUE; 
        }
 
        int ceiling;
 
        if (currentNode.data == key)
        {
            ceiling = currentNode.data;
        }
         
        // if currentNode is less than the key for which ceiling is to be found,
        // then we must search for the ceiling in the right sub-tree
        else if (currentNode.data < key)
        {
            ceiling = getCeiling(currentNode.right, key);
        }
         
        // if currentNode is greater than key, then we first search for ceiling in the left sub-tree
        // if not found then the currentNode must be the ceiling for this key
        else
        {
            ceiling = getCeiling(currentNode.left, key);
            if (ceiling == INVALID_VALUE)
            {
                ceiling = currentNode.data;
            }
        }
         
        return ceiling;
    }
 
    int getCeiling(int key)
    {
        return getCeiling(root, key);
    }
 
     
    int getFloor(BinarySearchTreeNode currentNode, int key)
    {
        if (currentNode == null)
        {
            return INVALID_VALUE; 
        }
 
        int floor;
 
        if (currentNode.data == key)
        {
            floor = currentNode.data;
        }
 
        // if currentNode is less than key then we might find floor in right sub-tree
        // if not found then currentNode itself must be the floor
        else if (currentNode.data < key)
        {
            floor = getFloor(currentNode.right, key);
            if (floor == INVALID_VALUE)
            {
                floor = currentNode.data;
            }
        }
         
        // if currentNode is greater than key then we must search for the floor in left sub-tree
        else
        {
            floor = getFloor(currentNode.left, key);
        }
        return floor;
    }
 
    int getFloor(int key)
    {
        return getFloor(root, key);
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
 
    public static void main(String[] args)
    {
        // dataset : {0,2,4,6,8,9}
         
        CeilingFloorBST tree = new CeilingFloorBST(6);
 
        tree.insert(2);
        tree.insert(9);
        tree.insert(0);
        tree.insert(4);
        tree.insert(8);
 
        /*
         *        6
         *     2     9
         *   0   4  8 
         * 
        */
        tree.printTreeLevelOrder();
 
        System.out.print("\n");
 
        System.out.println("\nCeiling of value '3' in the above BST is: "+ tree.getCeiling(3));
        System.out.println("Floor of value '10' in the above BST is: " + tree.getFloor(10));
    }
}