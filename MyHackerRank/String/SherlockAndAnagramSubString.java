import java.util.*;

/*
H:\Computer Science\Java\MyHackerRank\String>java Sherl
2
abba
 list = [a, ab, abb, abba, b, bb, bba, b, ba, a]
 return true for a a
 return true for ab ba
 return true for abb bba
 return true for b b
 4
abcd
 list = [a, ab, abc, abcd, b, bc, bcd, c, cd, d]
 0
*/


public class SherlockAndAnagramSubString{

	public static ArrayList<String> list=new ArrayList<String>();

		public static void main(String [] args){

			Scanner scan=new Scanner(System.in);
			int T=scan.nextInt();
			String str;
			int res=0;

			while(T-- > 0){
				list.clear();
				res=0;

				str=scan.next();
				createList(str);   //create a list of all substring
				res=returnAnagramNo(); //return total number of anagram substring 
				System.out.println(" "+ res);


			}//T--

		}//main

		public static boolean anagramCheck(String str1,String str2){

				if(str1.length() != str2.length())
					return false;

				//String str= new StringBuilder(str1).reverse().toString();

				//return str2.containsAll(str1);

				int [] count2 = new int[26];
                for(int i = 0; i < str1.length(); i++)
                {
                    //char ch2 = input2.charAt(i);
                    count2[str1.charAt(i) - 'a']++;
                    count2[str2.charAt(i)  -'a']--;
                }

                for(int i=0;i<26;++i){
                	if(count2[i]!=0)
                		return false;


                }
                System.out.println(" return true for "+ str1 +" "+str2);
                return true;

		}//anagramCheck

		public static void createList(String str){
			String str1;

					for(int i=0;i< str.length();++i){
						for(int j=1;j<=str.length()-i;++j){
								str1=str.substring(i,i+j);
								list.add(str1);
						}
					}

					System.out.println(" list = "+ list.toString());
					//return list;

		}//create List

		public static int returnAnagramNo(){

			int c=0;
			String [] str=new String[list.size()];

				for(int i=0;i< list.size();++i)
					str[i]=list.get(i);

				for(int i=0;i<str.length;++i){
					for(int j=i+1;j<str.length;++j){
						if(anagramCheck(str[i],str[j]))
							c++;
					}
				}
				return c;

		}//returnAnagramNo

}//class