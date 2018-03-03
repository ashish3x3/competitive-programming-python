import java.util.*;



public class BigFileSystemSearch{

		public static ArrayList<Integer> one=new ArrayList<Integer>();
		public static ArrayList<Integer> two=new ArrayList<Integer>();
		public static HashMap<Integer,ArrayList<Integer>> map=new HashMap<Integer,ArrayList<Integer>>();


	public static void main(String [] args){

		Scanner scan=new Scanner(System.in);
		//System.out.println("Enter Number of File System  T");
		int T=scan.nextInt();
		int N,Q;
		int i=0;

		while(T-- > 0 ){

		//	System.out.println("Enter  N --number of item  in a file");
			N=scan.nextInt();
			one=new ArrayList<Integer>();

			while(N-- > 0){

				one.add(scan.nextInt());

			} //while N--

			map.put(i++,one);


		} //while T--

		Q=scan.nextInt();
		int type,K;
		 while(Q-- > 0){

		 //	System.out.println("Enter type 1=full, 2=atleast  3=not All");
		 	type=scan.nextInt();
		 //	System.out.println("Enetr K--length of array");
		 	K=scan.nextInt();

		 	two=new ArrayList<Integer>(); 

		 	while(K-- > 0){

		 		two.add(scan.nextInt());
		 	}//K--

		 	search(type);


		 } //while Q--

		 

	} //main

	public static void search(int type){
		boolean res=false;
		int count=0;

			switch(type){

				case 1:		 res=false;
							 count=0;
							for(Integer i : map.keySet()){
								ArrayList<Integer> l=map.get(i);
								res=containAll(l,two);
								if(res==true){
									//System.out.println("");
									count++;
								}


						} //for l :map
						System.out.println(""+count);
						break;


				case 2:  res=false;
							 count=0;
							for(Integer i : map.keySet()){
								ArrayList<Integer> l=map.get(i);
								res=atLeastOne(l,two);
								if(res==false){
									//System.out.println("");
									count++;
								}


						} //for l :map
						System.out.println(""+count);
						break;
				case 3:  res=false;
							 count=0;
							for(Integer i : map.keySet()){
								ArrayList<Integer> l=map.get(i);
								res=notAll(l,two);
								if(res==true){
									//System.out.println("");
									count++;
								}


						} //for l :map
						System.out.println(""+count);
						break;

			}//switch

	}//search

	public static boolean containAll(ArrayList<Integer> l1,ArrayList<Integer> l2){

		if(l1==null & l2==null)
			return true;

		if(l1==null && l2!=null  || l1 !=null && l2==null)
			return false;

		boolean res=l1.containsAll(l2);

		return res;

	}//containAll

	public static boolean atLeastOne(ArrayList<Integer> l1,ArrayList<Integer> l2){


			boolean res=Collections.disjoint(l1,l2);

			return res;



	}//atLeast

	public static boolean notAll(ArrayList<Integer> l1,ArrayList<Integer> l2){

				//System.out.println(l1.toString()+" " +  l2.toString() + " atleast "+ atLeastOne(l1,l2));
				//System.out.println(l1.toString()+" " +  l2.toString() + " atleast "+ containAll(l1,l2));
				if(atLeastOne(l1,l2)==false && containAll(l1,l2)==false)
					return true;

				return false;





	}//atLeast

}//class
