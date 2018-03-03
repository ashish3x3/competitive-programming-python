# Dynamic Programming implementation of LCS problem
 
# Returns length of LCS for X[0..m-1], Y[0..n-1] 
def lcs(X, Y, m, n):
    L = [[0 for x in xrange(n+1)] for x in xrange(m+1)]
 
    # Following steps build L[m+1][n+1] in bottom up fashion. Note
    # that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] 
    for i in range(m+1):
        for j in range(n+1):
            if i == 0 or j == 0 :
                L[i][j] = 0
            elif X[i-1] == Y[j-1]:
                L[i][j] = L[i-1][j-1]+1   # whenever there is a match we trim both of them and find lcs of i-1,j-1 i.e diagonal element
            else:
                L[i][j] = max(L[i-1][j] , L[i][j-1])  # when it dosen't match, we trim one at a time from both string and check which gives the maximaum
  
 
    # Following code is used to print LCS
    index = L[m][n]
 
    # Create a character array to store the lcs string
    lcs = [""] * (index+1)
    lcs[index] = "\0"
 
    # Start from the right-most-bottom-most corner and
    # one by one store characters in lcs[]
    i = m
    j = n
    while i > 0 and j > 0:
 
        # If current character in X[] and Y are same, then
        # current character is part of LCS
        if X[i-1] == Y[j-1]:
            lcs[index-1] = X[i-1]
            i-=1
            j-=1
            index-=1
 
        # If not same, then find the larger of two and
        # go in the direction of larger value
        elif L[i-1][j] > L[i][j-1]:
            i-=1
        else:
            j-=1
 
    print "LCS of " + X + " and " + Y + " is " + "".join(lcs) 
 
# Driver program
X = "AGGTAB"
Y = "GXTXAYB"
m = len(X)
n = len(Y)
lcs(X, Y, m, n)









# java program

import java.util.ArrayList;
import java.util.List;
 
 
 
public class LongestCommonSubsequence {
    public static void commonSubsequence(String S1, String S2)
    {
        int s1_len = S1.length(); 
        int s2_len = S2.length();
        final int pick_s1_or_s2 = 0;
        final int pick_s1 = 1;
        final int pick_s2 = 2;
        int match[][] = new int[s1_len][s2_len];
        int pointer[][]  = new int[s1_len][s2_len];
         
         
        for(int i=0; i<s1_len; i++)
        {
            for(int j=0; j<s2_len; j++)
            {
                if(S1.charAt(i) ==  S2.charAt(j)) #Characters match
                {    
                    if((i==0) || (j==0)) #first row or first column
                    {
                        match[i][j] = 1; #initialize
                    }
                    else
                    {
                        match[i][j] = match[i-1][j-1] + 1;
                    }
                    pointer[i][j] = pick_s1_or_s2;  
                }
                else  #Characters mismatch
                {   
                    if((i > 0 ) && (j > 0)) #neither the first row nor first column
                    {
                        #Refer in ppt :- LCS(ACBE,ADC) = max(LCS(ACB,ADC), LCS(ACBE,AD))
                        #Thumb rule:- mismatch take max. if not in first row or column.
                        if(match[i-1][j] >= match[i][j-1])
                        {
                            match[i][j] = match[i-1][j];
                            pointer[i][j] = pick_s2; #ditch s1's character
                        }
                        else
                        {
                            match[i][j] = match[i][j-1];
                            pointer[i][j] = pick_s1; #ditch s2's character.
                        }
                    } 
                    else if ((i==0) && ( j > 0)) #first row
                    {
                        match[i][j] = match[i][j-1];
                        pointer[i][j] = pick_s1;
                    }
                    else if((j==0) && (i>0)) #first column
                         
                    {
                        match[i][j] = match[i-1][j];
                        pointer[i][j] = pick_s2;
                    }
                     
                }
                 
            }
        }
         
     
        #Printing the LCS.
        int i = s1_len - 1;
        int j = s2_len - 1;
        StringBuffer result = new StringBuffer();
         
        while(i>=0 && j>=0)
        {
            switch(pointer[i][j])
            {
               #go diagonal and collect the matched character
                case pick_s1_or_s2: 
                    result.append(S1.charAt(i));
                    i--;
                    j--;
                    break;
                case pick_s1:#go left
                    j--;
                    break;
                case pick_s2:#go up
                    i--;
                    break;
            }
        }
         
        System.out.println(result.reverse());
         
    }
     
    public static void main(String args[])
    {
        commonSubsequence("ACBEA", "ADCA");
    }
 
}
  