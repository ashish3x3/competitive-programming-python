

Check if a number can be expressed as x raised to power y | Set 2
http://www.ideserve.co.in/learn/check-if-a-number-can-be-expressed-as-x-raised-to-power-y-set-2

/*
Instead of repeated divisions as given in previous method, we can apply mathematical formula as described:
Given a number a, we have to find integers x and y, such that:
     a = x^y
If we take log on both sides, we get:
     log a = log (x^y)
     log a = y log x
     y = log a / log x
Hence, we have to find an integer x for which RHS gives an integer y.

Algorithm:
1: Starting with i = 2, if (log a / log i) is an integer then return true.
2: Else increment i by 1 till i < √a.
3: If no such i is found, return false.

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
Number = 100, iterate for i = 2 to √100 = 10
log 100 / log 2   = 6.643856189774725
log 100 / log 3   = 4.19180654857877
log 100 / log 4   = 3.3219280948873626
log 100 / log 5   = 2.8613531161467867
log 100 / log 6   = 2.570194417876938
log 100 / log 7   = 2.366589324909877
log 100 / log 8   = 2.2146187299249087
log 100 / log 9   = 2.095903274289385
log 100 / log 10 = 2.0
As 2 is an integer, return true.

Lets take another example.
Number = 625, iterate for i = 2 to √625 = 25
log 625 / log 2 = 9.287712379549449
log 625 / log 3 = 5.859894082871707
log 625 / log 4 = 4.643856189774724
log 625 / log 5 = 4.0
As 4 is an integer, return true.


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
        if (a == 1)
            return true;
        for (int i = 2; i <= Math.sqrt(a); i++) {
            double value = Math.log(a) / Math.log(i);
            if ((value - (int) value) < 0.000000001) {
                return true;
            }
        }
        return false;
    }
 
    public static void main(String[] args) {
        System.out.println(check(625));
    }
}
        

