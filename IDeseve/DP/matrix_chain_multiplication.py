
http://www.geeksforgeeks.org/dynamic-programming-set-8-matrix-chain-multiplication/
https://www.youtube.com/watch?v=GMzVeWpyTN0&list=PLyEvk8ZeQDMVbsg7CEfT0NV3s3GkMx1vN&index=4


/* A naive recursive implementation that simply follows
   the above optimal substructure property */
class MatrixChainMultiplication
{
    // Matrix Ai has dimension p[i-1] x p[i] for i = 1..n
    static int MatrixChainOrder(int p[], int i, int j)
    {
        if (i == j)
            return 0;
 
        int min = Integer.MAX_VALUE;
 
        // place parenthesis at different places between first
        // and last matrix, recursively calculate count of
        // multiplications for each parenthesis placement and
        // return the minimum count
        for (int k=i; k<j; k++)
        {
            int count = MatrixChainOrder(p, i, k) +
                        MatrixChainOrder(p, k+1, j) +
                        p[i-1]*p[k]*p[j];
 
            if (count < min)
                min = count;
        }
 
        // Return minimum count
        return min;
    }
 
    // Driver program to test above function
    public static void main(String args[])
    {
        int arr[] = new int[] {1, 2, 3, 4, 3};
        int n = arr.length;
 
        System.out.println("Minimum number of multiplications is "+
                           MatrixChainOrder(arr, 1, n-1));
 
    }
}


# Dynamic Programming Python implementation of Matrix
# Chain Multiplication. See the Cormen book for details
# of the following algorithm
import sys
 
# Matrix Ai has dimension p[i-1] x p[i] for i = 1..n
def MatrixChainOrder(p, n):
    # For simplicity of the program, one extra row and one
    # extra column are allocated in m[][].  0th row and 0th
    # column of m[][] are not used
    m = [[0 for x in range(n)] for x in range(n)]
 
    # m[i,j] = Minimum number of scalar multiplications needed
    # to compute the matrix A[i]A[i+1]...A[j] = A[i..j] where
    # dimension of A[i] is p[i-1] x p[i]
 
    # cost is zero when multiplying one matrix.
    for i in range(1, n):
        m[i][i] = 0
 
    # L is chain length.
    for L in range(2, n):
        for i in range(1, n-L+1):
            j = i+L-1
            m[i][j] = sys.maxint
            for k in range(i, j):
 
                # q = cost/scalar multiplications
                q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j]
                if q < m[i][j]:
                    m[i][j] = q
                    # Each entry bracket[i,j]=k shows
                    # where to split the product arr
                    # i,i+1....j for the minimum cost.
                    bracket[i][j] = k;
 
    return m[1][n-1]
 
# Driver program to test above function
arr = [1, 2, 3 ,4]
size = len(arr)
 
print("Minimum number of multiplications is " +
       str(MatrixChainOrder(arr, size)))

Time Complexity: O(n^3)
Auxiliary Space: O(n^2)



// Prints parenthesization in subexpression (i, j)
printParenthesis(i, j, bracket[n][n], name)
{
    // If only one matrix left in current segment
    if (i == j)
    {
        print name;
        name++;
        return;
    }

    print "(";

    // Recursively put brackets around subexpression
    // from i to bracket[i][j].
    printParenthesis(i, bracket[i][j], bracket, name);

    // Recursively put brackets around subexpression
    // from bracket[i][j] + 1 to j.
    printParenthesis(bracket[i][j]+1, j, bracket, name);

    print ")";
}
