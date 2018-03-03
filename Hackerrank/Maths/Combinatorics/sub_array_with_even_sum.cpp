

http://www.geeksforgeeks.org/find-number-subarrays-even-sum/


Find number of subarrays with even sum

pls explain difference about....
sum = (sum + arr[i]) % 2;
sum = ( (sum + arr[i]) % 2 + 2) % 2;
Both are same or not....
 
•Reply•Share ›
Avatar
abcd  Saha Hinley • a year ago
if the number is even yes it is same but in case of negative number no it is not....try finding out mod of negative number say x by an number -n...so mod will be in range 0....-n-1...to make this positive we use second one




i m not able the understand the need to initialize temp[0]=1 and also what is it that is actually done in this code...plz can anyone summarize it in brief.





i m not able the understand the need to initialize temp[0]=1 and also what is it that is actually done in this code...plz can anyone summarize it in brief.
 
•Reply•Share ›
Avatar
abcd  Amey Nakat • a year ago
see it it there because of the reason that even if a single even element is there it can contribute to even subarray but there is a necessity of atleast 2n+0 odd elements to get even subarrays
i hope u got ur point
 
•Reply•Share ›
Avatar
Rachit Belwariar  Amey Nakat • a year ago
Amey Nakat
temp[0] is initialized to 1 always to handle the corner case so that our handshake formula gives the desired results.

This problem can be extended to a more general problem-
Find the number of subarrays with sum divisible by 'k'. (This problem has k=2)

In the above problem also you have to initialise temp[0]=1.

So this is just to handle corner case so that the handshake formula will give accurate results (Try experimenting by making temp[0] equal to a value other than 1 and you feel the disaster you have done !)











O(n2) time and O(1) space method [Brute Force]
We can simply generate all the possible sub-arrays and find whether the sum of all the elements in them is an even or not. If it is even then we will count that sub-array otherwise neglect it.

/* C++ program to count number of sub-arrays
  whose sum is even using brute force
 Time Complexity - O(N^2)
 Space Complexity - O(1) */
#include<iostream>
using namespace std;
 
int countEvenSum(int arr[], int n)
{
    int result = 0;
 
    // Find sum of all subarrays and increment
    // result if sum is even
    for (int i=0; i<=n-1; i++)
    {
        int sum = 0;
        for (int j=i; j<=n-1; j++)
        {
            sum = sum + arr[j];
            if (sum % 2 == 0)
                    result++;
        }
    }
 
    return (result);
}
 
// Driver code
int main()
{
    int arr[] = {1, 2, 2, 3, 4, 1};
    int n = sizeof (arr) / sizeof (arr[0]);
 
    cout << "The Number of Subarrays with even"
            " sum is " << countEvenSum (arr, n);
 
    return (0);
}
Run on IDE
Output :

The Number of Subarrays with even sum is 9
 
O(n) Time and O(1) Space Method [Efficient]
If we do compute the cumulative sum array in temp[] of our input array, then we can see that the sub-array starting from i and ending at j, has an even sum if temp[] if (temp[j] – temp[i]) % 2 = 0. So, instead of building a cumulative sum array we build a cumulative sum modulo 2 array, and find how many times 0 and 1 appears in temp[] array using handshake formula. [n * (n-1) /2]

/* C++ program to count number of sub-arrays
with even sum using an efficient algorithm
Time Complexity - O(N)
Space Complexity - O(1)*/
#include<iostream>
using namespace std;
 
int countEvenSum(int arr[], int n)
{
    // A temporary array of size 2. temp[0] is
    // going to store count of even subarrays
    // and temp[1] count of odd.
    // temp[0] is initialized as 1 because there
    // a single even element is also counted as
    // a subarray
    int temp[2] = {1, 0};
 
    // Initialize count.  sum is sum of elements
    // under modulo 2 and ending with arr[i].
    int result = 0, sum = 0;
 
    // i'th iteration computes sum of arr[0..i]
    // under modulo 2 and increments even/odd count
    // according to sum's value
    for (int i=0; i<=n-1; i++)
    {
        // 2 is added to handle negative numbers
        sum = ( (sum + arr[i]) % 2 + 2) % 2;
 
        // Increment even/odd count
        temp[sum]++;
    }
 
    // Use handshake lemma to count even subarrays
    // (Note that an even cam be formed by two even
    // or two odd)
    result = result + (temp[0]*(temp[0]-1)/2);
    result = result + (temp[1]*(temp[1]-1)/2);
 
    return (result);
}
 
// Driver code
int main()
{
    int arr[] = {1, 2, 2, 3, 4, 1};
    int n = sizeof (arr) / sizeof (arr[0]);
 
    cout << "The Number of Subarrays with even"
            " sum is " << countEvenSum (arr, n);
 
    return (0);
}
Run on IDE
Output :

The Number of Subarrays with even sum is 9










// http://www.geeksforgeeks.org/find-number-subarrays-even-sum/
// http://www.practice.geeksforgeeks.org/problem-page.php?pid=948

/*
Input
3

6
1 2 2 3 4 1

7
8 1 3 7 4 2 9

10
8 7 6 5 7 7 6 0 7 2

Output
9
12
25
*/

/*
Explanation
Let array and cumulative sum arrays be:
Ind			[0]	[1]	[2]	[3]	[4]	[5]	[6]	[7]	[8]	[9]
Arr			8	7	6	5	7	7	6	0	7	2
CS		0	8	15	21	26	33	40	46	46	53	55
CS-Typ	E	E	O	O	E	O	E	E	E	O	O

cumulative sum is even at 6 places (including sum = 0 before beginning of array) and odd at 5
places. now if we pick any two places where CS is odd and take the difference, we find the
subarray between these two locations will have even sum. there are 5C2 such subarrays.

similarly, we can pick 6C2 subarrays terminating at points having even cumulative sum which
will have even sum. so in all there are 6C2 + 5C2 = 25 such subarrays
*/

#include <iostream>
#include <cstdio>
#include <climits>
#include <cstring>
#include <cmath>

using namespace std;

int nCr(int n, int r) {
	if (n < r) {
		return 0;
	}

	if (n - r < r) {
		r = n - r;
	}

	int prod = 1;
	for (int div = 1; div <= r; div++) {
		prod *= n;
		prod /= div;

		n--;
	}

	return prod;
}

int main() {
	int T;

	scanf("%d", &T);
	while (T-- > 0) {
		int ele;
		int N;
		int sum, eCount, oCount;

		scanf("%d", &N);
		sum = 0;
		eCount = 1; // as initially, sum is 0 (even)
		oCount = 0;

		for (int i = 0; i < N; i++) {
			cin >> ele;
			sum += ele;

			if (sum & 1) {
				oCount++;
			} else {
				eCount++;
			}
		}

		printf("%d\n", (nCr(eCount, 2) + nCr(oCount, 2)));
	}

	return 0;
}







