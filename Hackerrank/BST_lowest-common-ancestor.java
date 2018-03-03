// https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor

 /* Node is defined as :
 class Node 
    int data;
    Node left;
    Node right;
    
    */
static HashMap<Node, Integer> find(Node root,int v1, HashMap<Node, Integer> h) {
    
    while(root != null) {
        if(v1 < root.data){
            if(h.containsKey(root)){
                h.put(root, h.get(root)+1);
            } else {
                h.put(root, 1);
            }
            
            root = root.left;
        } else if(v1 > root.data) {
            if(h.containsKey(root)){
                h.put(root, h.get(root)+1);
            } else {
                h.put(root, 1);
            }
            
            root = root.right;
        } else if(root.data == v1) {
            if(h.containsKey(root)){
                h.put(root, h.get(root)+1);
            } else {
                h.put(root, 1);
            }
            break;
        }
    }
    
    return h;
    
}

static Node lca(Node root,int v1,int v2)
    {
    HashMap<Node, Integer> h = new HashMap<>();
    Node newR = root;
    h = find(root,v1,h);
    h = find(root,v2,h);
    Node newlca = newR;
    for (Map.Entry<Node, Integer> entry : h.entrySet()) {
       // System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        if(entry.getValue() == 2){
            newlca = entry.getKey();
        }
        
    }
    //System.out.println(newlca+"");
   return newlca;

       
    }

/*
    test failed earlier :
    2
    1 2
    1 2
*/




static Node lca(Node root,int v1,int v2)
{
    //Decide if you have to call recursively
    //Samller than both
    if(root.data < v1 && root.data < v2){
        return lca(root.right,v1,v2);
    }
    //Bigger than both
    if(root.data > v1 && root.data > v2){
        return lca(root.left,v1,v2);
    }

    //Else solution already found
    return root;
}



"""
Node is defined as
self.left (the left child of the node)
self.right (the right child of the node)
self.data (the value of the node)
"""
def lca(root , v1 , v2):
  while root is not None:
    if root.data > v1 and root.data > v2:
      root = root.left
    elif root.data < v1 and root.data < v2:
      root = root.right
    else:
      return root
  return root
    



    

"""
Node is defined as
self.left (the left child of the node)
self.right (the right child of the node)
self.data (the value of the node)
"""
def lca(root , v1 , v2):
    if not root: 
        return None
    if root.data == v1 or root.data == v2:
        return root
    left_lca = lca(root.left, v1, v2)
    right_lca = lca(root.right, v1, v2)
    if left_lca and right_lca:
        return root
    if left_lca:
        return left_lca
    else:
        return right_lca






























