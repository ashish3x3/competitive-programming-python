

http://www.geeksforgeeks.org/find-pairs-ab-cd-array-satisfy-ab-cd/

/*
An Efficient Solution of this problem is to use hashing. We use product as key and pair as value in hash table.

1. For i=0 to n-1
2.   For j=i+1 to n-1
       a) Find  prod = arr[i]*arr[j]       
       b) If prod is not available in hash then make 
            H[prod] = make_pair(i, j) // H is hash table
       c) If product is also available in hash 
          then print previous and current elements
          of array 

*/


// C++ program to find four elements a, b, c
// and d in array such that ab = cd
#include<bits/stdc++.h>
using namespace std;
 
// Function to find out four elements in array
// whose product is ab = cd
void findPairs(int arr[], int n)
{
    bool found = false;
    unordered_map<int, pair < int, int > > H;
    for (int i=0; i<n; i++)
    {
        for (int j=i+1; j<n; j++)
        {
            // If product of pair is not in hash table,
            // then store it
            int prod = arr[i]*arr[j];
            if (H.find(prod) == H.end())
                H[prod] = make_pair(i,j);
 
            // If product of pair is also available in
            // then print current and previous pair
            else
            {
                pair<int,int> pp = H[prod];
                cout << arr[pp.first] << " " << arr[pp.second]
                     << " and " << arr[i]<<" "<<arr[j]<<endl;
                found = true;
            }
        }
    }
    // If no pair find then print not found
    if (found == false)
        cout << "No pairs Found" << endl;
}