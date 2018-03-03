

http://edusagar.com/questions/dynamic-programming/find-largest-sub-square-matrix-with-all-0s#at_pco=smlwn-1.0&at_si=598ff847440a1a1f&at_ab=per-2&at_pos=0&at_tot=1

F[i][j] = 1 + MIN(F[i-1][j], F[i-1][j-1], F[i][j-1]) if F[i][j] = 1
F[i][j] = 0 otherwise


Problem Statement
Given a square matrix (n*n) which contains only 1 and 0, find the largest sub-square matrix which only contains 0s. For example:
For example:

Input #1:
0 0 0 0
0 0 0 0
0 0 0 1
1 1 1 1 
The answer is 3.

Input #2:
1 1 1 0 0
1 0 0 0 0
1 0 0 0 0
1 0 0 0 1
1 1 1 1 0
The answer is 3.

Input #2:
1 1 1 0 0
1 0 0 0 0
1 0 0 0 0
1 0 0 0 0
1 1 1 1 0
The answer is 4.


#include <stdio.h>
#include <stdlib.h>
#define ROW 6
#define COL 5

int min(int a, int b, int c)
{
    if (a < b) {
        return (a < c) ? a : c;
    } else {
        return (b < c) ? b : c;
    }
}

int main()
{
    int matrix[ROW][COL] = {
                {0, 0, 1, 1, 0}, 
                {0, 0, 0, 0, 1}, 
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1}};
                
    int output[ROW][COL] = {0};
    int i, j;
    int max = 1;
    
    for (i = 0; i < ROW; i++) {
        for (j = 0; j < COL; j++) {
            if (matrix[i][j] == 0)
                output[i][j] = 1;
        }
    }
    
    for (i = 1; i < ROW; i++) {
        for (j = 1; j < COL; j++) {
            if (output[i][j]) {
                output[i][j] = min(output[i-1][j-1], output[i-1][j], output[i][j-1]) + 1;
                if (output[i][j] > max)
                    max = output[i][j];
            }
        }
    }
    
    printf("The maximum size of sub-square matrix is : %d\n", max);

     return 0;
}




Although we used O(n2) of extra space, but the run time is drastically improved from exponential (for recursive solution) to O(n2). 