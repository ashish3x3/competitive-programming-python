import java.util.*;

public class PermTest{

	public static Set<List<String>> set=new  HashSet<List<String>>();
	public static int [] index=null;
	public static int [] data={0,1,2,3,4,5,6,7,8,9};
	public static int MAX=100000;
    public static  int sum=0;

	public static void main(String [] args){

		Scanner scan=new Scanner(System.in);

		int T=scan.nextInt();
		int min,max;
		boolean res=false;
		while(T-- > 0){
            sum=0;
			//System.out.println("Enetr min max");
			min=scan.nextInt();
			max=scan.nextInt();

			System.out.println("" +min + " "+ max);
            
            for(int i=min;i<=max;++i){
            	System.out.println("enetr");
                sum+=(int)Math.pow((double)10,i);
                System.out.println("sum ="+sum);

                if(sum>MAX)
                System.out.println("YES for min max"+min+" "+max +" "+ sum);
                break;
           
                
            }
            
            if(sum<=MAX){
            	System.out.println("enetr NO");
             System.out.println("NO");
         }
            
            } //T
                
        /*
			for(int i=min;i<=max;++i){
                index=new int[i];
				res=find(index,i-1,0);
				if(res!=false){
					System.out.println("YES");
                break;
            }

			}
            if(res==false)
			System.out.println("NO");
		}
        */
	
    }//main

	//public static boolean genratePerm(int len){
		//index=new int[len];

		//boolean res=find(index,len-1,0);

		//return res;


	//} //gen 

	public static boolean find(int [] index,int last,int index1){
            

		for(int i=0;i<data.length;++i){

			if(i<last)
			index[index1]=data[i];


			if(index1==last){
				//List<Integer> list = Arrays.asList(index);
				set.add(Arrays.asList(Arrays.toString(index)));
				continue;
			}

			if(set.size()> MAX){

				//System.out.println(""+set.size());
				return true;
			}

			else if(index1<last){
				find(index,last,index1+1);
			}

		}
		return false;
	}
}