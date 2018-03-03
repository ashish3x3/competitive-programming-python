


Check if a number can be expressed as x raised to power y | Set 1

http://www.ideserve.co.in/learn/check-if-a-number-can-be-expressed-as-x-raised-to-power-y-set-1



/*
Algorithm:
1: Initialize factor = 2.
2: Check if number is divisible by 'factor'. If yes, then keep on dividing the number by factor till it is divisible by factor. 
3: After step 2, if we are left with number = 1, then number can be represented as a power of factor, so return true. Else, increment factor by 1.
4: Repeat steps 2 and 3 till factor <= √number.
If no such factor is found, then return false.

Why √number?
We want to find integers x and y (>1) such that x^y = given number 'a'.
i.e. if for any x, if x^2 = a or x^3 = a or ... x^y = a, for some integer y, return true.
Can we have upper limit on value of x from above condition?
Let's find out!
Now, we know that √a * √a = a
Then for any number, x > √a, x^2 will always be greater than a.
                x* x > √a * √a  = a
As x^2  > a, x^3  > a, x^4 > a ... i.e. any other power of x will also be greater than a. 
So the upper limit on value of x is √a.

Lets take one example to understand the algorithm.
Consider the given number as 100.

Number = 100
Initialize factor = 2
On repeated division by 2 we get: 100 -> 50 -> 25
As further division by 2 is not possible and the number(100) is not reduced to 1,
so we increment factor to 3.

factor = 3
As 100 is not divisible by 3 and the number(100) is not reduced to 1, 
so increment factor to 4.

factor = 4
On repeated division by 4 we get: 100 -> 25
As further division by 4 is not possible and the number(100) is not reduced to 1, 
so increment factor to 5.

factor = 5
On repeated division by 5 we get: 100 -> 20 -> 4
As further division by 5 is not possible and the number(100) is not reduced to 1,  
so increment factor to 6.

factor = 6
As 100 is not divisible by 6, increment to 7.

Similarly, as 100 is not divisible by 7, 8 and 9 also, 
increment factor to 10.

factor = 10
On repeated division by 10 we get: 100 -> 10 -> 1
As further division by 10 is not possible and the number is reduced to 1, therefore 100 is a power of 10.
Hence, return true.

Please checkout another solution to this problem:

*/

        
package com.ideserve.questions.saurabh;
 
/**
 * <b>IDeserve <br>
 * <a href="https://www.youtube.com/c/IDeserve">https://www.youtube.com/c/IDeserve</a>
 * Given a positive integer, find if it can be expressed by integers x and y as
 * x^y where y > 1 and x > 0.
 * 
 * Example
 * Input : 625
 * Output : true as 5^4 = 625
 * 
 * @author Saurabh
 */
public class Power {
 
    public static boolean check(int a) {
        int factor = 2;
        while (factor <= Math.sqrt(a)) {
            int number = a;
            while (number % factor == 0) {
                number /= factor;
            }
            if (number == 1) {
                return true;
            } else {
                factor++;
            }
        }
        return false;
    }
 
    public static void main(String[] args) {
        System.out.println(check(625));
    }
}
        