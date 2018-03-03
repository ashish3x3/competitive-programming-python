
// https://www.hackerrank.com/challenges/tree-top-view

void top_view(Node root) {

  if(root==null)
    return;
  
  Stack<Integer> s=new Stack<Integer>();
  s.push(root.data);
  Node root2=root;

  while(root.left!=null) {

    s.push(root.left.data);
    root=root.left;

  }


  while(s.size()!=0)
    System.out.print(s.pop()+" ");

  Queue<Integer> q=new LinkedList<Integer>(); 

  q.add(root2.right.data);
  root2=root2.right;     
  while(root2.right!=null) {

    q.add(root2.right.data);
    root2=root2.right;
  }

  while(q.size()!=0)
    System.out.print(q.poll()+" ");
}

/*
//http://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/
// http://www.ideserve.co.in/learn/top-view-of-a-binary-tree
better approach

import java.util.*;

 class Node 
     int data;
     Node left;
     Node right;



class QItem
{
   Node node;
   int hd;
   public QItem(Node n, int h)
   {
        node = n;
        hd = h;
   }
}

void top_view(Node root) {
    if(root == null) {
        return;
    }
    
    HashSet<Integer> set = new HashSet<Integer>();
    Queue<QItem> Q = new Queue<QItem>();
    
    Q.add(new QItem(root, 0));
    
    while(!q.isEmpty()) {
        QItem qi = Q.remove();
        int hd = qi.hd;
        Node n = qi.node;
        
        if (!set.contains(hd)) {
            set.add(hd);
            System.out.print(n.key + " ");
        }

        // Enqueue left and right children of current node
        if (n.left != null)
            Q.add(new QItem(n.left, hd-1));
        if (n.right != null)
            Q.add(new QItem(n.right, hd+1));

    }
 
}

*/
