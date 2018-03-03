

http://www.geeksforgeeks.org/iterative-postorder-traversal-using-stack/

'''
1.1 Create an empty stack
2.1 Do following while root is not NULL
    a) Push root's right child and then root to stack.
    b) Set root as root's left child.
2.2 Pop an item from stack and set it as root.
    a) If the popped item has a right child and the right child 
       is at top of stack, then remove the right child from stack,
       push the root back and set root as root's right child.
    b) Else print root's data and set root as NULL.
2.3 Repeat steps 2.1 and 2.2 while stack is not empty.
'''

# Python program for iterative postorder traversal
# using one stack
 
# Stores the answer
ans = []
 
# A Binary tree node
class Node:
     
    # Constructor to create a new node
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None
 
def peek(stack):
    if len(stack) > 0:
        return stack[-1]
    return None
# A iterative function to do postorder traversal of 
# a given binary tree
def postOrderIterative(root):
         
    # Check for empty tree
    if root is None:
        return
 
    stack = []
     
    while(True):
         
        while (root):
             # Push root's right child and then root to stack
             if root.right is not None:
                stack.append(root.right)
             stack.append(root)
 
             # Set root as root's left child
             root = root.left
         
        # Pop an item from stack and set it as root
        root = stack.pop()
 
        # If the popped item has a right child and the
        # right child is not processed yet, then make sure
        # right child is processed before root
        if (root.right is not None and
            peek(stack) == root.right):
            stack.pop() # Remove right child from stack 
            stack.append(root) # Push root back to stack
            root = root.right # change root so that the 
                             # righ childis processed next
 
        # Else print root's data and set root as None
        else:
            ans.append(root.data) 
            root = None
 
        if (len(stack) <= 0):
                break
 
# Driver pogram to test above function
root = Node(1)
root.left = Node(2)
root.right = Node(3)
root.left.left = Node(4)
root.left.right = Node(5)
root.right.left = Node(6)
root.right.right = Node(7)
 
print "Post Order traversal of binary tree is"
postOrderIterative(root)
print ans
 





// A java program for iterative postorder traversal using stack
 
import java.util.ArrayList;
import java.util.Stack;
  
// A binary tree node
class Node 
{
    int data;
    Node left, right;
  
    Node(int item) 
    {
        data = item;
        left = right;
    }
}
  
class BinaryTree 
{
    Node root;
    ArrayList<Integer> list = new ArrayList<Integer>();
  
    // An iterative function to do postorder traversal 
    // of a given binary tree
    ArrayList<Integer> postOrderIterative(Node node) 
    {
        Stack<Node> S = new Stack<Node>();
          
        // Check for empty tree
        if (node == null)
            return list;
        S.push(node);
        Node prev = null;
        while (!S.isEmpty()) 
        {
            Node current = S.peek();
  
            /* go down the tree in search of a leaf an if so process it 
            and pop stack otherwise move down */
            if (prev == null || prev.left == current || 
                                        prev.right == current) 
            {
                if (current.left != null)
                    S.push(current.left);
                else if (current.right != null)
                    S.push(current.right);
                else
                {
                    S.pop();
                    list.add(current.data);
                }
  
                /* go up the tree from left node, if the child is right 
                   push it onto stack otherwise process parent and pop 
                   stack */
            } 
            else if (current.left == prev) 
            {
                if (current.right != null)
                    S.push(current.right);
                else
                {
                    S.pop();
                    list.add(current.data);
                }
                  
                /* go up the tree from right node and after coming back
                 from right node process parent and pop stack */
            } 
            else if (current.right == prev) 
            {
                S.pop();
                list.add(current.data);
            }
  
            prev = current;
        }
  
        return list;
    }
  
    // Driver program to test above functions
    public static void main(String args[]) 
    {
     BinaryTree tree = new BinaryTree();
  
        // Let us create trees shown in above diagram
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
  
        ArrayList<Integer> mylist = tree.postOrderIterative(tree.root);
          
        System.out.println("Post order traversal of binary tree is :");
        System.out.println(mylist);
    }
}