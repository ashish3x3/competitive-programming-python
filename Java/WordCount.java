import java.util.*;


public class WordCount{

			public static void main(String [] args){

				Scanner scan=new Scanner(System.in);
				System.out.println("Enetr the Line of String");
				String words=scan.nextLine();
				long startTime = System.currentTimeMillis();

				wordCount(words);
				

				long endTime   = System.currentTimeMillis();
				long totalTime = endTime - startTime;
				System.out.println("\n TotalTime =  "+totalTime + " mills");

			}//main

			public static  void wordCount(String words){
				Integer c=0;
				String wor[]=words.split(" ");

				//System.out.println(""+Arrays.toString(wor));
				

				HashMap<String,Integer> hm=new HashMap<String,Integer>();
				for(String word: wor){
					// c=(Integer)hm.get(word);
					  c=hm.get(word);
					c=(c==null)?1:c+1;    //no c++
					hm.put(word,c);
				}

				Set keySet=hm.keySet();

				Iterator it=keySet.iterator();

				while(it.hasNext()){
					String key=(String)it.next();

					System.out.println(""+key+" = " + hm.get(key));
				}


			}//wordCount

}//class