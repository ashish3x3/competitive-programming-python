import java.util.Stack;


public class StackEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<String> stack=new Stack<String>();
		stack.push("Ashish");
		printStack(stack);
		stack.push("Manish");
		printStack(stack);
		stack.push("Rohit");
		printStack(stack);
		
		stack.pop();
		printStack(stack);
		stack.pop();
		printStack(stack);
		stack.pop();
		printStack(stack);
	}
	
	public static void printStack(Stack<String> s){
		
		if(s.isEmpty())
			System.out.println("Stack is Empty");
		else
		System.out.println("-->BOTTOM"+s + "-->TOP");
		
		
	}

}
