


http://www.ideserve.co.in/learn/diagonal-sum-of-a-binary-tree

python
http://www.geeksforgeeks.org/diagonal-traversal-of-binary-tree/






# Python program for diagonal traversal of Binary Tree
 
# A binary tree node
class Node:
 
    # Constructor to create a new binary tree node
    def __init__(self, data):
        self.data = data 
        self.left = None
        self.right = None
 
 
""" root - root of the binary tree
   d -  distance of current line from rightmost
        -topmost slope.
   diagonalPrint - multimap to store Diagonal
                   elements (Passed by Reference) """
def diagonalPrintUtil(root, d, diagonalPrintMap):
     
    # Base Case 
    if root is None:
        return
 
    # Store all nodes of same line together as a vector
    try :
        diagonalPrintMap[d].append(root.data)
    except KeyError:
        diagonalPrintMap[d] = [root.data]
 
    # Increase the vertical distance if left child
    diagonalPrintUtil(root.left, d+1, diagonalPrintMap)
     
    # Vertical distance remains same for right child
    diagonalPrintUtil(root.right, d, diagonalPrintMap)
 
 
 
# Print diagonal traversal of given binary tree
def diagonalPrint(root):
 
    # Create a dict to store diagnoal elements 
    diagonalPrintMap = dict()
     
    # Find the diagonal traversal
    diagonalPrintUtil(root, 0, diagonalPrintMap)
 
    print "Diagonal Traversal of binary tree : "
    for i in diagonalPrintMap:
        for j in diagonalPrintMap[i]:
            print j,
        print ""
 
 
# Driver Program 
root = Node(8)
root.left = Node(3)
root.right = Node(10)
root.left.left = Node(1)
root.left.right = Node(6)
root.right.right = Node(14)
root.right.right.left = Node(13)
root.left.right.left = Node(4)
root.left.right.right = Node(7)
 
diagonalPrint(root)
 
# This code is contributed by Nikhil Kumar Singh(nickzuck_007)
Run on IDE

Output :
Diagonal Traversal of binary tree : 
 8 10 14
 3 6 7 13
 1 4


package com.ideserve.nilesh.questions;
 
/**
 * <b>IDeserve <br>
 * <a href="https://www.youtube.com/c/IDeserve">https://www.youtube.com/c/IDeserve</a> 
 * Computes sum of nodes in each diagonal using inorder traversal. 
 * @author Nilesh
 */
 
import java.util.HashMap;
import java.util.Map;
 
public class DiagonalSumTree 
{
    private class TreeNode
    {
        TreeNode left;
        TreeNode right;
        int value;
     
        public TreeNode(int value)
        {
            this.value = value;
        }
    }
     
    TreeNode root;
 
    /*
                             0
                      1              2
                   4      5        3    6
                        7                
    */
    public void createTree()
    {
        this.root = new TreeNode(0);
 
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
 
        root.left  = n1;
        root.right = n2;
         
        n1.left  =  n4;
        n1.right = n5;
         
        n2.left  = n3;
        n2.right = n6;
         
        n5.left = n7;
    }
 
     
    private void computeDiagSum(TreeNode currentNode, int currDiag, HashMap<Integer, Integer> diagSum) 
    {
        if (currentNode == null)
        {
            return;
        }
         
        // compute diagonal sum for the tree rooted at the left child
        // left child would be placed in 'currDiag + 1'
        computeDiagSum(currentNode.left, currDiag + 1, diagSum);
         
        // now add current node's value to its diagonal sum 
        int prevSum = (diagSum.get(currDiag) == null) ? 0 : diagSum.get(currDiag) ;
        diagSum.put(currDiag, prevSum + currentNode.value);
 
        // compute diagonal sum for the tree rooted at the right child
        // right child would be placed in the same diagonal as that of current node
        computeDiagSum(currentNode.right, currDiag, diagSum);
    }
 
    public void computeDiagSum(HashMap<Integer, Integer> diagSum)
    {
        computeDiagSum(root, 0, diagSum);
    }
     
    public static void main(String[] args) 
    {
        DiagonalSumTree solution = new DiagonalSumTree();
 
        /*
                                 0
                          1              2
                       4      5        3    6
                            7                
        */
        solution.createTree();
 
        HashMap<Integer, Integer> diagSum = new HashMap();
 
        // this call populates diagSum HashMap with sum for all diagonals
        solution.computeDiagSum(diagSum);
 
        // print sum for each diagonal
        for (Map.Entry<Integer, Integer> entry : diagSum.entrySet()) 
        {
            System.out.println("Diagonal Sum for level " + entry.getKey() + " :" + entry.getValue());
        }
    }
}
   