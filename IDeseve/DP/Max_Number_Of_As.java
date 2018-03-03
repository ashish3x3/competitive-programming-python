
http://www.ideserve.co.in/learn/print-maximum-number-of-a-using-four-keys-of-special-keyboard#codeSnippet


public class MaxNumberOfAs
{
    // assuming max input for 'n' won't be greater than 10.
    // you might want to change it according to your need.
    private static int MAX = 10;
 
    /*
     * f(N) = N if N < 7
     *      = max{2*f(N-3), 3*f(N-4),..., (N-2)*f(1)}
    */   
    public static int findMaxAs(int n, int[] maxAsSolution)
    {
        // base case
        if (n < 7) return n;
         
        int maxSoFar = 0, maxAsWithThis_i = 0, multiplier = 2;
         
        // choose the critical point which produces maximum number of As
        for (int i = n-3; i >=0; i--)
        {
            // make recursive call if required
            if (maxAsSolution[i] == -1)
            {
                maxAsSolution[i] = findMaxAs(i, maxAsSolution);
            }
             
            maxAsWithThis_i = multiplier*maxAsSolution[i];
             
            if(maxAsWithThis_i > maxSoFar)
            {
                maxSoFar = maxAsWithThis_i;
            }
            multiplier +=1;
        }
        return maxSoFar;
    }
     
    public static void main (String[] args) throws java.lang.Exception
    {
        // assuming input n won't be greater than 10.
        int [] maxAsSolution = new int[MAX]; 
        for (int i = 0; i < maxAsSolution.length; i++)
        {
            // maxAsSolution[i] = -1 indicates that solution for this input  = 'i' is not computed yet.
            maxAsSolution[i] = -1;
        }
         
        // find max number of As with 8 keystrokes allowed. 
        System.out.println("Max number of As possible with 8 keystrokes: " + findMaxAs(8, maxAsSolution));
    }
}
        
Order of the Algorithm

Time Complexity is O(n^2)
Space Complexity is O(n)