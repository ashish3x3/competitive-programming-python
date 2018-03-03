

// https://www.hackerrank.com/challenges/tree-level-order-traversal

   /* 
    
    class Node 
       int data;
       Node left;
       Node right;
   */
   Queue<Node> Q = new LinkedList<>();

   void LevelOrder(Node root)
    {
       if(root == null) {
           return;
       }
       
       Q.add(root);
       while(!Q.isEmpty()) {
           Node n = Q.remove();
           System.out.print(n.data+ " ");
           
           if(n.left != null) {
               Q.add(n.left);
           } 
           
           if(n.right != null) {
               Q.add(n.right);
           }
       }
       
      
      
    }
