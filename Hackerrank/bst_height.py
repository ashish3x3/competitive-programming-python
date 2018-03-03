# https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree

class Node:
    def __init__(self,info): 
        self.info = info  
        self.left = None  
        self.right = None 
        self.level = None 

    def __str__(self):
        return str(self.info) 

class BinarySearchTree:
    def __init__(self): 
        self.root = None

    def create(self, val):  
        if self.root == None:
            self.root = Node(val)
        else:
            current = self.root
         
            while True:
                if val < current.info:
                    if current.left:
                        current = current.left
                    else:
                        current.left = Node(val)
                        break
                elif val > current.info:
                    if current.right:
                        current = current.right
                    else:
                        current.right = Node(val)
                        break
                else:
                    break





# Enter your code here. Read input from STDIN. Print output to STDOUT
'''
class Node:
      def __init__(self,info): 
          self.info = info  
          self.left = None  
          self.right = None 
           

       // this is a node of the tree , which contains info as data, left , right
'''
def height(root):
    if root == None:
        return -1
    #lHeight = 1 + height(root.left)
    #rHeight = 1 + height(root.right)
    return 1 + max(height(root.left),height(root.right))






tree = BinarySearchTree()
t = int(raw_input())

for _ in xrange(t):
    x = int(raw_input())
    tree.create(x)

print height(tree.root)

#working
# https://server4.kproxy.com/servlet/redirect.srv/syku/sboyuybdivaoihealhh/p1/raees-full-movie-online-watch/
#https://server4.kproxy.com/servlet/redirect.srv/syku/sboyuybdivaoihealhh/p1/sachin-a-billion-dreams/

'''
showing :
http://www.hopeproxy.com/browse.php?u=http%3A%2F%2Fhindimoviesonlines.net%2Fsachin-a-billion-dreams%2F&b=4
https://nl.hideproxy.me/go.php?u=xQWKNhFa9SKGD%2FW0TD5W%2Fvgia920lXBt84EDkFjK6HgplhNz2z%2BbMv5eRP3CnnF9rq4PyBKEbr0%3D&b=4&f=norefer
'''