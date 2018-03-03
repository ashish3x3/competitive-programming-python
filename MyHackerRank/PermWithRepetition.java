import java.util.*;

public class PermWithRepetition{

	public static Set<List<Integer>> set=new  HashSet<List<Integer>>();
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

			for(int i=min;i<=max;++i){
                index=new Integer[i];
				res=find(index,i-1,0);
				if(res!=false){
					System.out.println("YES");
                break;
            }

			}
            if(res==false && T==0)
			System.out.println("NO");
		}
	} //main

	//public static boolean genratePerm(int len){
		//index=new int[len];

		//boolean res=find(index,len-1,0);

		//return res;


	//} //gen

	public static boolean find(Integer [] index,int last,int index1){
            
		boolean r;
		for(int i=0;i<data.length;++i){

			if(i<last)
			index[index1]=data[i];


			if(index1==last){
				List<Integer> list = Arrays.asList(index);
				set.add(list);
				//System.out.println(""+set.size());
				//set.add(Arrays.asList(Arrays.toString(index)));
				//System.out.println(""+set.toString());
				continue;
			}

			if(set.size()> MAX){

				//System.out.println(""+set.size());
				//System.out.println(""+set.toString());
				return true;
			}

			else if(index1<last){
			r=	find(index,last,index1+1);
			}

		}
		//if(r!=true)
		//System.out.println(""+set.size());
		return false;
	}
}