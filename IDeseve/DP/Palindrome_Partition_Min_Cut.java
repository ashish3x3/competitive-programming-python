

Algorithm/Insights

1. Initialize a palindrome DP table of size nxn where n is the length of the given String
2. Set single length palindrome values to 1
3. Loop from lengths 2 to n and check palindrome for each length using the following rule
    palindrome[i][j] = palindrome[i+1][j-1] + 2, if s[i] == s[j]
    palindrome[i][j] = Math.max(palindrome[i+1][j], palindrome[i][j-1]), if s[i] != s[j]
4. after the loop, return palindrome[0][n-1]

The three cuts are “a|babbbab|b|ababa”. If a string is palindrome, then minimum 0 cuts are needed. If a string of length n containing all different characters, then minimum n-1 cuts are needed.

This problem is a variation of Matrix Chain Multiplication problem. If the string is palindrome, then we simply return 0. Else, like the Matrix Chain Multiplication problem, we try making cuts at all possible places, recursively calculate the cost for each cut and return the minimum value.

// i is the starting index and j is the ending index. i must be passed as 0 and j as n-1
minPalPartion(str, i, j) = 0 if i == j. // When string is of length 1.
minPalPartion(str, i, j) = 0 if str[i..j] is palindrome.

// If none of the above conditions is true, then minPalPartion(str, i, j) can be 
// calculated recursively using the following formula.
minPalPartion(str, i, j) = Min { minPalPartion(str, i, k) + 1 +
                                 minPalPartion(str, k+1, j) } 
                           where k varies from i to j-1

http://www.ideserve.co.in/learn/palindrome-min-cut#codeSnippet


public class PalindromePartitionMinCut {
     
    public static int partition(String s) {
          int n = s.length();
          boolean palindrome[][] = new boolean[n][n]; //boolean table
           
          //Trivial case: single letter palindromes
          for (int i = 0; i < n; i++) {
              palindrome[i][i] = true;
          }
           
          //Finding palindromes of two characters.
          for (int i = 0; i < n-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
              palindrome[i][i+1] = true;
            }
          }
           
          //Finding palindromes of length 3 to n
          for (int curr_len = 3; curr_len <= n; curr_len++) {
            for (int i = 0; i < n-curr_len+1; i++) {
              int j = i+curr_len-1;
              if (s.charAt(i) == s.charAt(j) //1. The first and last characters should match 
                  && palindrome[i+1][j-1]) //2. Rest of the substring should be a palindrome
              {
                palindrome[i][j] = true; 
              }
            }
          }
           
          int[] cuts = new int[n];
          for(int i=0; i<n; i++)
          {
              int temp = Integer.MAX_VALUE;
              if(palindrome[0][i])
                  cuts[i] = 0;
              else
              {
                  for(int j=0; j<i; j++)
                  {
                     if((palindrome[j+1][i]) && temp > cuts[j] + 1) 
                     {
                         temp = cuts[j] + 1;
                     }
                  }
                  cuts[i] = temp;
              }           
          }
          return cuts[n-1];
        }
 
    public static void main(String args[])
    {
        System.out.println(partition("bananna"));
    }
}
        
Order of the Algorithm

Time Complexity is O(n^2)
Space Complexity is O(n^2)