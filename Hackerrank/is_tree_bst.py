""" Node is defined as
class node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None
"""
import sys
def check_binary_search_tree_(root, min=-sys.maxint, max=+sys.maxint):
    
    if root is None:
        return True
    
    if root.data >= max:
        return False
        
    if root.data <= min:
        return False
    
    left = check_binary_search_tree_(root.left, min, root.data)
    right = check_binary_search_tree_(root.right, root.data, max)
    
    return left & right
  
'''

Why does he need these min and max values? I tried comparing the root with left and right nodes and then making the recursion, but it fails on 6 test cases

I started with this aproach too, however this only checks that the children nodes are correct for the parent node only.
Consider the case where your root node is 100, then we traverse down the left side a couple of times and come to a node that is 50. Let's say the left child is 10, and the right is 999. This will pass because the code only checks the immediate children, however it is not a BST because 999 is much bigger than the root node, 100.
'''

'''
# Python program to check if a binary tree is bst or not
 
INT_MAX = 4294967296
INT_MIN = -4294967296
 
# A binary tree node
class Node:
 
    # Constructor to create a new node
    def __init__(self, data):
        self.data = data 
        self.left = None
        self.right = None
 
 
# Returns true if the given tree is a binary search tree
# (efficient version)
def isBST(node):
    return (isBSTUtil(node, INT_MIN, INT_MAX))
 
# Retusn true if the given tree is a BST and its values
# >= min and <= max
def isBSTUtil(node, mini, maxi):
     
    # An empty tree is BST
    if node is None:
        return True
 
    # False if this node violates min/max constraint
    if node.data < mini or node.data > maxi:
        return False
 
    # Otherwise check the subtrees recursively
    # tightening the min or max constraint
    return (isBSTUtil(node.left, mini, node.data -1) and
          isBSTUtil(node.right, node.data+1, maxi))
 
# Driver program to test above function
root = Node(4)
root.left = Node(2)
root.right = Node(5)
root.left.left = Node(1)
root.left.right = Node(3)
 
if (isBST(root)):
    print "Is BST"
else:
    print "Not a BST"
 
'''