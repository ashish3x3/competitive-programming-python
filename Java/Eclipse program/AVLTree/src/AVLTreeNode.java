
public class AVLTreeNode {
	
	public AVLTreeNode left;
	public AVLTreeNode right;
	public int data;
	public int height;
	
	public AVLTreeNode(int x){
		
		data=x;
		height=0;
		left=right=null;
		
	}
	
public AVLTreeNode(){
		
		data=0;
		height=0;
		left=right=null;
		
	}
	
	

}
