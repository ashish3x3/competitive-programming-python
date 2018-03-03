import java.util.ArrayList;


public class AVLTreeImpl {
	
	public AVLTreeNode root;
	
	
	public AVLTreeImpl(){
		root=null;
		
	}
	
	
	
	public static void preOrder(AVLTreeNode root){
		if(root!=null){
			System.out.println(""+root.data);
			preOrder(root.left);
			preOrder(root.right);
			
		}
			
		
	}
	
	final protected ArrayList<AVLTreeNode> inorder() {
		  ArrayList<AVLTreeNode> ret = new ArrayList<AVLTreeNode>();
		  inorder(this.root, ret);
		  return ret;
		 }
	
	final protected void inorder(AVLTreeNode node, ArrayList<AVLTreeNode> io) {
		  if (node == null) {
		   return;
		  }
		  inorder(node.left, io);
		 // if(node!=null)   still 0 is added first
		  io.add(node);         //storing adress n not n.data
		  System.out.println("add to io "+node.data);
		  inorder(node.right, io);
		 }
		
	
	
	
	public void insert(int x){
		
		AVLTreeNode n=new AVLTreeNode(x);
		System.out.println("x = " +x);
		insertAVL(this.root,n);
		
	}
	
	public  void insertAVL(AVLTreeNode root,AVLTreeNode node){
		if(root==null){
			this.root=node;
			System.out.println("root = " +node.data);
		}
		else {
		
		//common BST Insertion
		
		if(node.data<root.data){
			if(root.left==null){
				root.left=node;
				System.out.println("root.left at first = " +node.data);
				///recursiveBalance(root);
			//root.left=insert(root.left,x);
		} else{
			insertAVL(root.left,node);
			System.out.println("root.left = " +node.data);
		}
		}//if
		else if(node.data>root.data){
			if(root.right==null){
				root.right=node;
				System.out.println("root.right at first = " +node.data);
			//root.right=insert(root.right,x);
		} else{
			insertAVL(root.right,node);
			System.out.println("root.right at depth = " +node.data);
		}
		}
		else{
			;
		}
		//Changing height of each node
		
		root.height=max(height(root.left),height(root.right))+1;
		
		//get the balance factor
		
		int balance=getBalance(root);
		
		//check for balance value and case of rotation
		
		//L-L Case
		if(balance>1 &&  node.data<root.left.data){
			System.out.println("L L case");
			rotateRight(root);
		}
		
		//R-R Case
		if(balance <-1 && node.data>root.right.data ){
			System.out.println("R R case");
			rotateLeft(root);
		}
		
		//L-R Case
		if(balance>1 && node.data>root.left.data){
			System.out.println("L R case");
			root.left=rotateLeft(root.left);
			rotateRight(root);
			
		}
		
		//R-L Case
				if(balance<-1 && node.data<root.left.data){
					System.out.println("R L case");
					root.right=rotateRight(root.right);
					rotateLeft(root);
					
				}
		
		
		
		
	//return root;	
	
	} // end of else
  }  //end of func		
	
	
	public static AVLTreeNode rotateLeft(AVLTreeNode root){
		
		AVLTreeNode x=new AVLTreeNode();
		AVLTreeNode t2=new AVLTreeNode();
		
		if(root.left!=null)
		 x = root.left;
		
		if(x.right!=null)
	     t2 =x.right;
		
		//perform rotation
		
		x.right=root;
		if(t2!=null)
		root.left=t2;
		
		//update height
		
		root.height=max(height(root.left),height(root.right))+1;
		x.height=max(height(x.left),height(x.right))+1;
		
		//return new root
		
		return x;
		
		
	}
	
public static AVLTreeNode rotateRight(AVLTreeNode root){
		//AVLTreeNode x=new AVLTreeNode();
		//AVLTreeNode t2=new AVLTreeNode();
		AVLTreeNode x = root.right;
		AVLTreeNode t2 =x.left;
		
	      x = root.right;
	      if(x.left !=null)
	       t2 =x.left;
		//perform rotation
		
		x.left=root;
		
	    if(t2!=null)
		root.right=t2;
		
		//update height
		
		root.height=max(height(root.left),height(root.right))+1;
		x.height=max(height(x.left),height(x.right))+1;
		
		//return new root
		
		return x;
		
		
	}
	
	
	public static int getBalance(AVLTreeNode root){
		if(root!=null)
			return (height(root.left)-height(root.right));
		
		return 0;
		
	}
	
	public static int max(int lhs,int rhs){
		
		return lhs>rhs?lhs:rhs;
	}
	
	public static int height(AVLTreeNode root){
		return root==null?-1:root.height;
		
	}

}
