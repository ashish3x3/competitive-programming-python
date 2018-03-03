

http://edusagar.com/questions/dynamic-programming/maximum-number-of-a-using-ctrl-a-ctrl-c-ctrl-v-keys-google-interview-question


// ================================RECURSIVE================================


F(N) = MAX(F(j) * (N - j -1)) where N-3 <= j <= 1 
Here is the recursive program:

#include <stdio.h>
#include <stdlib.h>

#define N 20

int compute_max(int i);
int main() 
{
    printf("Maximum A's for %d is %d \n", N, compute_max(N));
	
    return 0;
}

int compute_max(int i)
{
    int j;
    int max = 0;
    int temp;
	
    if (i <= 6)
        return i;
		
    for (j = i - 3; j > 0; j--) {
        temp = (i - j -1) * compute_max(j);
        if (temp > max) {
            max = temp;
        }
    }
	
    return max;
}

// ===================================DP=============================

#include <stdio.h>
#include <stdlib.h>

#define N 20

int compute_max(int i);
int main() 
{
    int i = 1, j, k, temp;
    int arr[N+1];
	
    arr[0] = 0;
    for (; i <= 6; i++) 
        arr[i] = i;
	
    for (; i <= N; i++) {
        arr[i] = i;
        for (j = i - 3; j > 0; j--) {
            temp = (i - j - 1) * arr[j];
            if (temp > arr[i])
                arr[i] = temp;
        }
    }
	
    printf("Maximum A's for %d is %d \n", i, arr[N]);
	
    return 0;
}

Dynamic programming solution with O(n) complexity
Let F(x) be the maximum number of A's we can output using x keystrokes. Now consider two possible options available to us once we have F(x):

F(x), Ctrl-A, Ctrl-C, Ctrl-V, Ctrl-V, Ctrl-V, Ctrl-V, Ctrl-V  => F(x) * 6
F(x), Ctrl-A, Ctrl-C, Ctrl-V, Ctrl-A, Ctrl-C, Ctrl-V, Ctrl-V  => F(x) * 6

But the later sequence is better, in a sense that the content which is in the copy buffer is 2*F(x) in the second case, while it is F(x) in the first case. So, if we extend this with another keystroke, the later sequence will give F(x) * 8, while the first one will result in F(x) * 7. This gives us an opportunity to optimize the above listed Dynamic Programming solution. Instead of always iterating from N-3 down to 1, we should only consider 4 consecutive Ctrl-V keystrokes to get the maximum number of A's. To achieve the same, replace the inner for loop from previous Dynamic Programming solution to this one:

for (j = i - 3, k = 1; ((k <= 4) && (j > 0)); j--, k++) {
...
}
This reduces the overall complexity from O(n2) to 4*O(n) which is effectively O(n). Do share your thoughts and comments if you feel something amiss.