

Group all anagrams together from a given array of strings | Set 1

http://www.ideserve.co.in/learn/group-all-anagrams-together-set-1

Given an array of strings, sort the array in such a way that all anagrams are grouped together. For example, if the given array input is {"abcd","abc","abce", "acd","abdc"} then output array should be {"abc","abcd","abdc","abce","acd"}. Note that order among non-anagram strings is not important here. Instead of returning above array as output, your program could have returned an array having different order of strings but strings "abcd" and "abdc" must be placed next to each other with no specific ordering requirement among them. So the output array - {"abdc","abcd","abc","abce","acd"} would also be a correct output.

Amazon, Facebook, Microsoft, Jane Street

implement a coparator..


The idea to sort string array in order to group anagrams together is simple. A regular sort method on string array would put all strings in their increasing alphabetical/dictionary order. We change this order by implementing a custom comparator in which instead of comparing two strings 'S1' and 'S2' directly, we compare the sorted versions of 'S1' and 'S2'. This sorted version comparison makes sure that if 'S1' and 'S2' are anagrams of each other then they would be placed next to each other in sorted array (since custom compare method would return 0). 

For implementing a custom Comparator, our java class must implement 'compare(Object obj1, Object obj2)' method of Comparator interface with its object type as String. In the implementation of 'compare(String S1, String S2)' method, all that needs to be done is to sort both strings S1 and S2 and then return the result of their comparison. If they are anagrams of each other, 0 would be returned.

Note that implementing 'compare(Object obj1, Object obj2)' method of Comparator interface makes our java class a Comparator. And then this Comparator can be passed to a sort method (Arrays.sort) to allow precise control over the sort order. Please checkout class AnagramSort in code snippet for implementation details. We need to make call - Arrays.sort(strArray, new AnagramSort()) to sort array which does grouping of anagrams.

The time complexity of this algorithm is O(nlogn) where n is the size of the input string array. Its space complexity is O(n). This is because Arrays.sort uses mergesort for sorting as specified in java 7 documentation. Here is the relevant excerpt from documentation of this method - "Implementation note: This implementation is a stable, adaptive, iterative mergesort that requires far fewer than n lg(n) comparisons when the input array is partially sorted"

             
package com.ideserve.questions.nilesh;
 
 
import java.util.Arrays;
import java.util.Comparator;
 
public class AnagramSort implements Comparator<String> 
{
    public String sortChars(String s) 
    {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
 
    @Override
    // compares its two argument strings for order 
    public int compare(String s1, String s2) 
    {	
	// this only return -1,0,1 so even if I change the stirgn to char and sort them, it still after this function will place original s1,s2 based onthis resutl tot his func..so existing arry elem will o tbe srted.. 
        return sortChars(s1).compareTo(sortChars(s2));
    }
 
     
    public static void main(String[] args) 
    {
        String[] strArray = {"abcd","abc","abce", "acd","abdc"};
         
        Arrays.sort(strArray, new AnagramSort());
         
        for (int i = 0; i < strArray.length; i++)
        {
            System.out.println(strArray[i]);
        }
    }
}
        
Time Complexity is O(nlogn)
Space Complexity is O(n)