import java.util.*;
import java.math.*;

public class SumSquare{
		
		public static BigInteger [] arr=null;
		
		public static void main(String [] args){
				
				Scanner scan=new Scanner(System.in);
				System.out.println("Enter T");
				long T=scan.nextLong();
				arr=new BigInteger[(int)T];
				long t=0;
				BigInteger N=BigInteger.ZERO;
				while(T>0){
				//System.out.println("N");
				N=scan.nextBigInteger();
				
				arr[(int)t++]=countSquare(N);
				T--;
				}
				
				for(long i=0;i<arr.length;++i){
					System.out.println(""+ arr[(int)i]);
				
				}
		
		
		} //main
		
		public static BigInteger countSquare(BigInteger n){
				
				long c=0;
				BigInteger x=new BigInteger("0");;
				for(BigInteger i = BigInteger.valueOf(1);i.compareTo(sqrt(n)) <= 0;i = i.add(BigInteger.ONE)){
					
					x=x.add(i.pow(2));
					
						if(x.compareTo(n) <=0){
							c++;
							continue;
						}
						
						break;
				
				}
				
				return BigInteger.valueOf(c);
		
		
		} //countSquare
		
		public static BigInteger sqrt(BigInteger x) {
			BigInteger div = BigInteger.ZERO.setBit(x.bitLength()/2);
			BigInteger div2 = div;
				// Loop until we hit the same value twice in a row, or wind
				// up alternating.
			for(;;) {
				BigInteger y = div.add(x.divide(div)).shiftRight(1);
				if (y.equals(div) || y.equals(div2))
					return y;
				div2 = div;
				div = y;
    }
}


} //class