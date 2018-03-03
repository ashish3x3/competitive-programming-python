



# Python porgram for iterative postorder traversal using
# two stacks
 
# A binary tree node
class Node:
     
    # Constructor to create a new node
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None
 


http://www.geeksforgeeks.org/iterative-postorder-traversal/

 
# An iterative function to do postorder traversal of a
# given binary tree
def postOrderIterative(root): 
 
    if root is None:
        return         
     
    # Create two stacks 
    s1 = []
    s2 = []
     
    # Push root to first stack
    s1.append(root)
     
    # Run while first stack is not empty
    while (len(s1) >0):
         
        # Pop an item from s1 and append it to s2
        node = s1.pop()
        s2.append(node)
     
        # Push left and right children of removed item to s1
        if node.left is not None:
            s1.append(node.left)
        if node.right is not None :
            s1.append(node.right)
 
        # Print all eleements of second stack
    while(len(s2) > 0):
        node = s2.pop()
        print node.data,
 
# Driver program to test above function
root = Node(1)
root.left = Node(2)
root.right = Node(3)
root.left.left = Node(4)
root.left.right = Node(5)
root.right.left = Node(6)
root.right.right = Node(7)
postOrderIterative(root)