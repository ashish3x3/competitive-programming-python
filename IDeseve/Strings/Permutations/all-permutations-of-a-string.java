



Find all permutations of a String



http://www.ideserve.co.in/learn/all-permutations-of-a-string



1. We use a hash set to store all permutations of the string.
2. If string is null or of 0 length, we return a hashset with "" as element 
3. We keep first character of the string and recursively call getAllPermutations on the remaining string. 
4. When the function returns, we add the first character to all positions in all the strings that we got in the hashset.



             
package com.ideserve.questions.saurabh;
 
import java.util.HashSet;
 
/**
 * <b>IDeserve <br>
 * <a href="https://www.youtube.com/c/IDeserve">https://www.youtube.com/c/IDeserve</a>
 * Given a string, find all the permutations of the string.
 * For example:
 * Input String: abc
 * Output: {bca, acb, abc, cba, bac, cab}
 *
 * @author Saurabh
 */
import java.util.HashSet;


public class AllPermutationsString {
public static HashSet<String> getAllPermutations(String str) {
// Create a hash set to prevent any duplicate entries
HashSet<String> permutations = new HashSet<String>();

if(str == null || str.length() == 0) {
    System.out.println("str.length() = " + str.length());
    permutations.add("");
    return permutations;
}

    char first = str.charAt(0);
    System.out.println("first = " + first);
    String remainingString = str.substring(1);
    System.out.println("remainingString = " + remainingString);
    System.out.println("Recursive call with Str = " + remainingString); 
    System.out.println("***********************************");
    HashSet<String> words = getAllPermutations(remainingString);
    System.out.println("***************Func Rturn********************");
    System.out.println("words = " + words);
    for(String word: words) {
        System.out.println("word.length() = " + word.length());
        for(int i = 0; i <= word.length(); i++) {
            String prefix = word.substring(0, i);
            System.out.println("prefix = " + prefix);
            String suffix = word.substring(i);
            System.out.println("suffix = " + suffix);
            System.out.println("first = " + first);
            permutations.add(prefix + first + suffix);
            System.out.println("permutations to return = " + permutations);
        }
    }
return permutations;
}

public static void main(String[] args) {
String str = "abc";
HashSet<String> permutations = getAllPermutations(str);
System.out.println(permutations.toString());
}
}  


first = a
remainingString = bc
Recursive call with Str = bc
***********************************
first = b
remainingString = c
Recursive call with Str = c
***********************************
first = c
remainingString = 
Recursive call with Str = 
***********************************
str.length() = 0
***************Func Rturn********************
words = []
word.length() = 0
prefix = 
suffix = 
first = c
permutations to return = [c]
***************Func Rturn********************
words = [c]
word.length() = 1
prefix = 
suffix = c
first = b
permutations to return = [bc]
prefix = c
suffix = 
first = b
permutations to return = [bc, cb]
***************Func Rturn********************
words = [bc, cb]
word.length() = 2
prefix = 
suffix = bc
first = a
permutations to return = [abc]
prefix = b
suffix = c
first = a
permutations to return = [abc, bac]
prefix = bc
suffix = 
first = a
permutations to return = [bca, abc, bac]
word.length() = 2
prefix = 
suffix = cb
first = a
permutations to return = [bca, acb, abc, bac]
prefix = c
suffix = b
first = a
permutations to return = [bca, acb, abc, bac, cab]
prefix = cb
suffix = 
first = a
permutations to return = [bca, acb, abc, cba, bac, cab]
[bca, acb, abc, cba, bac, cab]