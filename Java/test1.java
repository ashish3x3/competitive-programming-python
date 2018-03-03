import java.util.*;
class Solution {
    public static int getpos(long n,long[] arr){
        int k=Arrays.binarySearch(arr,n);
        if(k<0) return -k-2;
        else return k;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int big=320000;
        long[] sqrsums=new long[big];
        for(int i=0;i<big;i++){
            sqrsums[i]=((long)i*(i+1)*(i+i+1))/6;
        }
        int t=in.nextInt();
        while(t-->0){
            long n=in.nextLong();
            System.out.println(getpos(n,sqrsums));
        }
    }
}