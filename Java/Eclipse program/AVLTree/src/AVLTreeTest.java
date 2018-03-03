import java.util.ArrayList;


public class AVLTreeTest {
	
public static void main(String [] args){
		
		AVLTreeImpl root=new AVLTreeImpl();
		root.insert(10);
		root.insert(20);
		root.insert(30);
		root.insert(30);
		root.insert(50);
		root.insert(25);
		
		//root=insert(root,150);
		//root=insert(root,5);
		//root=insert(root,1);
		
		System.out.println("avl tree pre order traversal\n");
		
		//root.preOrder(root);
		ArrayList<AVLTreeNode> ret=root.inorder();
		//System.out.println(""+ret.toString());
		for(int i=0;i<ret.size();++i)
			System.out.print(" " + ret.get(i).data);
		
	}

}
