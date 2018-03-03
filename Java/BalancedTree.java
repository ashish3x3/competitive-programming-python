import java.util.*;

 class TreeNode{
		
		TreeNode left,right;
		int val;
		
		public TreeNode(int x){
			
			val=x;
			left=right=null;
		}
	
	}//class
public class BalancedTree{
	
	

		public static TreeNode root;
		
		public BalancedTree(){
			root=null;
		}
		/*
		public void appendToEnd(int x){
			
			TreeNode n1=new TreeNode(x);
			
			
			if(root==null)
				root=n1;
				
			else{
				TreeNode curr=this.root;
				
				while(curr.next!=null)
					curr=curr.next;
				
				curr.next=n1;
			
			}//else
		
		
		}//append
		*/
		
		public static boolean findBalanced(TreeNode root){
		
			if(root==null)
				return true;			
			
			int max,min;
			
			max=heightMax(root);
			min=heightMin(root);
			
			if(max-min>1){
			System.out.println(" Diffrence is  "+ (max-min));
				return false;
				}
			else {
			System.out.println(" Diffrence is  "+ (max-min));
				return true;
				}
			
				
			
		}//find
		
		public static int heightMax(TreeNode root){
			
			if(root==null)
				 return 0;
			return 1+Math.max(heightMax(root.left),heightMax(root.right));
		
		
		}
		
		public static int heightMin(TreeNode root){
			
			if(root==null)
				 return 0;
			return 1+Math.min(heightMax(root.left),heightMax(root.right));
		
		
		}
		
		public static void printList(TreeNode t){
			
			if(t==null)
				return ;
			printList(t.left);
			System.out.println(""+t.val);
			printList(t.right);
		
		
		}
		
		public static void main(String [] args){
		
			TreeNode t=new TreeNode(1);
			t.left=new TreeNode(2);
			t.right=new TreeNode(3);
			t.left.left=new TreeNode(4);
			t.right.right=new TreeNode(5);
			t.left.right=new TreeNode(6);
			t.left.right.right=new TreeNode(7);
			t.left.right.right.left=new TreeNode(8);
			
		
			printList(t);
			boolean b=false;
			b=findBalanced(t);
			System.out.println(""+b);
		
		
		}


}//class