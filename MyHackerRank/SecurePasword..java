import java.util.*;

public class Solution{


    //public static Set<List<String>> set=new  HashSet<List<String>>();
    public static Set<String> set=new  HashSet<String>();
    public static Integer [] index=null;
    public static int [] data={0,1,2,3,4,5,6,7,8,9};
    public static int MAX=100000;

    public static void main(String [] args){

        Scanner scan=new Scanner(System.in);

        int T=scan.nextInt();
        int min,max;
        boolean res=false;
        while(T-- > 0){
            //System.out.println("Enetr min max");
            min=scan.nextInt();
            max=scan.nextInt();

            
    ;
    if(max > 6 || (max == 6 && min <6)){
        System.out.println("YES");
    }else {
        System.out.println("NO");
    }
}
        
    } //main

    
  


}//class

/*
Password security is a very important topic today. We define a password system here as a set of requirements that a valid password in this system must fulfill. In each such system every valid password consists only of digits [0−9]. In addition, for each such system there are two requirements which a valid password must fulfill:

    Minimum length of a valid password.
    Maximum length of a valid password.

We say that a password system is secure if and only if there are more than one million (106) different possible passwords in this system. Your task, as a security expert, is to decide for a given password system if it is secure.

Note

    Repetition of digits are allowed. That is 111 is a valid password of length 3.
    Leading 0's are allowed. That is 001 and 000 are valid password of length 3.
    You have to consider the sum of all passwords whose length lies in range of minimum and maximum value. That is if minimum length is 3 and maximum length is 5, then you have to find total count of passwords whose length are either 3, 4 or 5.

Input Format

In the first line there is a single integer, T, denoting the number of test cases. T lines follow. The ith line denotes a single test case and describes a given password system. It consists of two integers, m and M, denoting the minimum password length and the maximum password length in this system.

Constraints

    1≤T≤100
    1≤m≤M≤10

Output Format

Print exactly T lines. In the ith of them print "YES" (without quotes) if the ith password system is secure, otherwise print "NO" (without quotes).

Sample Input

2
5 5
7 8

Sample Output

NO
YES

Explanation

    Sample Case #00
        All valid passwords have length 5, hence there are exactly 100000 different passwords; this system in insecure, because we need more than a million different passwords for a system to be secure. 

    Sample Case #01
        We are allowed to have passwords of length 7 or 8 and since there are more than a million different such passwords, this system is secure
*/