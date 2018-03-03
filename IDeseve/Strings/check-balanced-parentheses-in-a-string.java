
Check balanced parentheses in a string
http://www.ideserve.co.in/learn/check-balanced-parentheses-in-a-string





Given a string with parentheses (round brackets) and letters, validate the parentheses:
1. An opening parentheses '(' should have a closing matching parentheses ')'.
2. Closing matching parentheses should not come before an opening parentheses.
Note: Assume that the string has alphabets and numbers and round brackets only.

For example:
((BCD)AE) - Valid
)(PH)N(X) - Invalid


             
package com.ideserve.questions.saurabh;
 
/**
 * <b>IDeserve <br>
 * <a href="https://www.youtube.com/c/IDeserve">https://www.youtube.com/c/IDeserve</a>
 * Given a string with parentheses (round brackets) and letters, validate the parentheses.
 *
 * @author Saurabh
 */
public class Parentheses {
 
    public static boolean isValid(String str) {
 
        if (str == null || str.length() == 0) {
            return true;
        }
 
        int count = 0;
        int i = 0;
        while (i < str.length()) {
            char ch = str.charAt(i);
            if (ch == '(') {
                count++;
            } else if (ch == ')') {
                if (count == 0)
                    return false;
                else
                    count--;
            }
            i++;
        }
 
        if(count != 0) 
            return false;
         
        return true;
    }
     
    public static void main(String[] args) {
        String str = "((BCD)AE)";
        System.out.println("isValid: " + isValid(str));
        str = ")(PH)N(X)";
        System.out.println("isValid: " + isValid(str));
    }
}
        


























