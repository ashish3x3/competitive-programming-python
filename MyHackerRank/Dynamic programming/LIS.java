import java.util.*;

public class LIS{

  public static void main(String [] args){

    int [] seq;
    int N,res=0;
    Scanner scan=new Scanner(System.in);

    System.out.println("Enetr T");
    int T=scan.nextInt();

    while(T-->0){
          System.out.println("Enetr N");
          N=scan.nextInt();
          seq=new int[N];

          for(int i=0;i<N;++i)
            seq[i]=scan.nextInt();


          res=increasingSubsequence(seq);
              System.out.println("res =" +res);


    }

  }



public static int increasingSubsequence(int[]seq){
    int[]L=new int[seq.length];
    L[0]=1;
    for(int i=1;i<L.length;i++){
      int maxn=0;
      for(int j=0;j<i;j++){
        if(seq[j]<seq[i]&&L[j]>maxn){
          maxn=L[j];
        }
      }
      L[i]=maxn+1;
    }
    int maxi=0;
    for(int i=0;i<L.length;i++){
      if(L[i]>maxi){
        maxi=L[i];
      }
    }
    return(maxi);
  }

}