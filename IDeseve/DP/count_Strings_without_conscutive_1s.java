



http://www.geeksforgeeks.org/count-number-binary-strings-without-consecutive-1s/
http://www.ideserve.co.in/learn/distinct-binary-strings-of-length-n-with-no-consecutive-1s


class count_Strings
{
    static  int countStrings(int n)
    {
        int a[] = new int [n];
        int b[] = new int [n];
        a[0] = b[0] = 1;
        for (int i = 1; i < n; i++)
        {
            a[i] = a[i-1] + b[i-1];
            b[i] = a[i-1];
        }
        return a[n-1] + b[n-1];
    }
    /* Driver program to test above function */
    public static void main (String args[])
    {
          System.out.println(countStrings(3));
    }
}