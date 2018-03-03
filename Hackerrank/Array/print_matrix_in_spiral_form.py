import sys

// Java program to print a given matrix in spiral form
import java.io.*;
 
class GFG 
{
    // Function print matrix in spiral form
    static void spiralPrint(int m, int n, int a[][])
    {
        int i, k = 0, l = 0;
        /*  k - starting row index
        m - ending row index
        l - starting column index
        n - ending column index
        i - iterator
        */
          
        while (k < m && l < n)
        {
            // Print the first row from the remaining rows
            for (i = l; i < n; ++i)
            {
                System.out.print(a[k][i]+" ");
            }
            k++;
  
            // Print the last column from the remaining columns 
            for (i = k; i < m; ++i)
            {
                System.out.print(a[i][n-1]+" ");
            }
            n--;
  
            // Print the last row from the remaining rows */
            if ( k < m)
            {
                for (i = n-1; i >= l; --i)
                {
                    System.out.print(a[m-1][i]+" ");
                }
                m--;
            }
  
            // Print the first column from the remaining columns */
            if (l < n)
            {
                for (i = m-1; i >= k; --i)
                {
                    System.out.print(a[i][l]+" ");
                }
                l++;    
            }        
        }
    }
     
    // driver program
    public static void main (String[] args) 
    {
        int R = 3;
        int C = 6;
        int a[][] = { {1,  2,  3,  4,  5,  6},
                      {7,  8,  9,  10, 11, 12},
                      {13, 14, 15, 16, 17, 18}
                    };
        spiralPrint(R,C,a);
    }
}

http://javabypatel.blogspot.in/2016/11/print-matrix-in-spiral-order.html

package matrix;
 
public class PrintMatrixInSpiralForm {
 
 public static void main(String[] args) {
  new PrintMatrixInSpiralForm();
 }
 
 public PrintMatrixInSpiralForm() {
  int[][] matrix = {
   {1,  2,  3,  4,  5},
   {6,  7,  8,  9,  10},
   {11, 12, 13, 14, 15},
   {16, 17, 18, 19, 20},
   {21, 22, 23, 24, 25}
  };
   
  printMatrixInSpiralWay(matrix);
 }
  
 private void printMatrixInSpiralWay(int[][] matrix){
 
  int rowStart=0;
  int rowLength=matrix.length-1;
   
  int colStart=0;
  int colLength = matrix[0].length-1;
   
  while(rowStart <= rowLength && colStart <= colLength){
   
   for (int i = rowStart; i <= colLength; i++) {
    System.out.print(matrix[rowStart][i] + " ");
   }
 
   for (int j = rowStart+1; j <= rowLength; j++) {
    System.out.print(matrix[j][colLength] + " ");
   }
    
   if(rowStart+1 <= rowLength){
    for (int k = colLength-1; k >= colStart; k--) {
     System.out.print(matrix[rowLength][k] + " ");
    }
   }
   if(colStart+1 <= colLength){
    for (int k = rowLength-1; k > rowStart; k--) {
     System.out.print(matrix[k][colStart] + " ");
    }
   }
    
   rowStart++;
   rowLength--;
   colStart++;
   colLength--;
  }
 }
}






def isPossibleMove(N, det, i, j, dr):
    #print 'dr ',dr
    if dr == 'R':
        if j < N and i < N and det[i][j] == False:
            #print 'True R ',dr
            return True,dr
        else:
            #print 'False R ',dr
            return False,'D'
    elif dr == 'D':
        #print 'i,j,det[i][j] ',N,i,j
        if i < N  and j < N and j >= 0 and det[i][j] == False:
            return True,dr
        else:
            return False,'L'
    elif dr == 'L':
        if j >= 0 and i < N and i >= 0 and det[i][j] == False:
            return True,dr
        else:
            return False,'U'
    elif dr == 'U':
        if i >= 0  and j < N and j >= 0 and det[i][j] == False:
            return True,dr
        else:
            return False,'R'

def solve(mat,det,i,j,dr, isCont, cnt):
    
    if cnt == len(mat)*len(mat):
        sys.stdout.flush()
        return
    #print i,j,dr
    mov,direction = isPossibleMove(len(mat), det, i,j,dr)
    #print 'mov, dir ',mov,direction
    if dr != direction:
        isCont = False
    if direction == 'R':
        if mov == True:
            #print(mat[i][j]))
            sys.stdout.write(str(mat[i][j])+ ' ')
            cnt+=1
            det[i][j] = True
            solve(mat,det,i,j+1,direction, True,cnt)
        else:
            solve(mat,det,i+1,j+1,direction, True,cnt)
            
    elif direction == 'D':
        if mov == True:
            sys.stdout.write(str(mat[i][j])+ ' ')
            cnt+=1
            det[i][j] = True
            solve(mat,det,i+1,j,direction, True,cnt)
        else:
            solve(mat,det,i+1,j-1,direction, True,cnt)
    elif direction == 'L':
        if mov == True:
            sys.stdout.write(str(mat[i][j])+ ' ')
            cnt+=1
            det[i][j] = True
            solve(mat,det,i,j-1,direction, True,cnt)
        else:
            solve(mat,det,i-1,j-1,direction, True,cnt)
    elif direction == 'U':
        if mov == True:
            sys.stdout.write(str(mat[i][j])+ ' ')
            cnt+=1
            det[i][j] = True
            solve(mat,det,i-1,j,direction, True,cnt)
        else:
            solve(mat,det,i-1,j+1,direction, True,cnt)
    
    

T = int(input())

mat = []
det = []

for t in range(T):
    mat = []
    det = []
    
    for _ in range(4):
        t = list(map(int,input().strip().split(' ')))
        d = [False]*4
        mat.append(t)
        det.append(d)
    solve(mat, det, 0, 0, 'R', True, 0)
    sys.stdout.write('\n')

#print(mat)
#print(det)


