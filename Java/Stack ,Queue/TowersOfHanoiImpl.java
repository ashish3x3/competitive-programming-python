import java.util.*;

public class TowersOfHanoiImpl {
     
    private static MyDynamicStack[] tower;
     
    public static void towersOfHanoi(int n) {
 
        // create three stacks, tower[0] is scratch
        tower = new MyDynamicStack[4];
        for (int i = 0; i <= 3; i++){
            tower[i] = new MyDynamicStack(4);
        }
        for (int d = n; d > 0; d--){
            // initialize
            // add disk d to tower 1
           // tower[1].push(new Integer(d));
            tower[1].push(d);
        }
        // move n disks from tower 1 to 2 using 3 as
        // intermediate tower
        showTowerStates(n, 1, 2, 3);
    }
 
    public static void showTowerStates(int n, int x, int y, int z) {
         
        if (n > 0) {
            try{
                showTowerStates(n - 1, x, z, y);
                // move d from top of tower x
               // Integer d = (Integer) tower[x].pop();
                   int d =  tower[x].pop();
                // to top of tower y
                tower[y].push(d);
                System.out.println("Move disk " + d
                        + " from tower "+ x + " to top of tower " + y);
                showTowerStates(n - 1, z, y, x);
            } catch(Exception ex){}
        }
    }
 
    public static void main(String[] args) {
        System.out.println("Running 3 disk problem:");
        towersOfHanoi(3);
    }
}
 
 class MyDynamicStack {
 
    private int stackSize;
    private int[] stackArr;
    private int top;
 
    /**
     * constructor to create stack with size
     * @param size
     */
    public MyDynamicStack(int size) {
        this.stackSize = size;
        this.stackArr = new int[stackSize];
        this.top = -1;
    }
 
    /**
     * This method adds new entry to the top
     * of the stack
     * @param entry
     * @throws Exception
     */
    public void push(int entry){
        if(this.isStackFull()){
            System.out.println(("Stack is full. Increasing the capacity."));
            this.increaseStackCapacity();
        }
        this.stackArr[++top] = entry;
    }
 
    /**
     * This method removes an entry from the
     * top of the stack.
     * @return
     * @throws Exception
     */
    public int pop() throws Exception {
        if(this.isStackEmpty()){
            throw new Exception("Stack is empty. Can not remove element.");
        }
        int entry = this.stackArr[top--];
        return entry;
    }
     
    /**
     * This method returns top of the stack
     * without removing it.
     * @return
     */
    public long peek() {
        return stackArr[top];
    }
 
    private void increaseStackCapacity(){
         
        int[] newStack = new int[this.stackSize*2];
        for(int i=0;i<stackSize;i++){
            newStack[i] = this.stackArr[i];
        }
        this.stackArr = newStack;
        this.stackSize = this.stackSize*2;
    }
     
    /**
     * This method returns true if the stack is
     * empty
     * @return
     */
    public boolean isStackEmpty() {
        return (top == -1);
    }
 
    /**
     * This method returns true if the stack is full
     * @return
     */
    public boolean isStackFull() {
        return (top == stackSize - 1);
    }
 
    public static void main(String[] args) {
        MyDynamicStack stack = new MyDynamicStack(2);
        for(int i=1;i<10;i++){
            stack.push(i);
        }
        for(int i=1;i<4;i++){
            try {
                stack.pop();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}



/*Output:

Running 3 disk problem:
Move disk 1 from tower 1 to top of tower 2
Move disk 2 from tower 1 to top of tower 3
Move disk 1 from tower 2 to top of tower 3
Move disk 3 from tower 1 to top of tower 2
Move disk 1 from tower 3 to top of tower 1
Move disk 2 from tower 3 to top of tower 2
Move disk 1 from tower 1 to top of tower 2

- See more at: http://java2novice.com/data-structures-in-java/stacks/towers-of-hanoi/#sthash.IlFHeNRk.dpuf
//- See more at: http://java2novice.com/data-structures-in-java/stacks/towers-of-hanoi/#sthash.IlFHeNRk.dpuf*/