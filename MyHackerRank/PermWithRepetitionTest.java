import java.util.*;

public class PermWithRepetitionTest{

	public static Set<List<Integer>> set=new  HashSet<List<Integer>>();
	public static Integer [] index=null;
	public static int [] data={1,2,3};
	public static int MAX=100000;

	public static void main(String [] args){

		Scanner scan=new Scanner(System.in);
		ArrayList<ArrayList<Integer>> ret=new ArrayList<ArrayList<Integer>>();
		ret=permuteUnique(data);
		System.out.println(""+ ret.toString());

		
	} //main

	public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
	ArrayList<ArrayList<Integer>> returnList = new ArrayList<ArrayList<Integer>>();

	returnList.add(new ArrayList<Integer>());

	System.out.println("1.   empty list"+ returnList.toString());
	System.out.println();
 
	for (int i = 0; i < num.length; i++) {
		Set<ArrayList<Integer>> currentSet = new HashSet<ArrayList<Integer>>();

		System.out.println("2.  Empty hashSet with i = "+ i);
		System.out.println();

		for (List<Integer> l : returnList) {

			System.out.println(" new L for i ="+" " +i+""+l.toString());
			System.out.println();

			for (int j = 0; j < l.size() + 1; j++) {
				l.add(j, num[i]);

				System.out.println("3...Add to l "+num[i] +" " + l.toString());
				System.out.println();

				ArrayList<Integer> T = new ArrayList<Integer>(l);

				l.remove(j);
				System.out.println("3..remove at j. "+num[i] +" " + l.toString());
				System.out.println();

				currentSet.add(T);

				System.out.println("4..after add to ..currentSet"+ currentSet.toString());
				System.out.println();
			}
		}
		returnList = new ArrayList<ArrayList<Integer>>(currentSet);
		System.out.println("5.....returnList with i = " +i +" " + returnList.toString());
		System.out.println();
	}
 
	return returnList;
}

}
/*

H:\Computer Science\Java\MyHackerRank>javac PermWithRepetitionTest.java

H:\Computer Science\Java\MyHackerRank>java PermWithRepetitionTest
1.   empty list[[]]

2.  Empty hashSet with i = 0

 new L for i = 0[]

3...Add to l 1 [1]

3..remove at j. 1 []

4..after add to ..currentSet[[1]]

5.....returnList with i = 0 [[1]]

2.  Empty hashSet with i = 1

 new L for i = 1[1]

3...Add to l 2 [2, 1]

3..remove at j. 2 [1]

4..after add to ..currentSet[[2, 1]]

3...Add to l 2 [1, 2]

3..remove at j. 2 [1]

4..after add to ..currentSet[[2, 1], [1, 2]]

5.....returnList with i = 1 [[2, 1], [1, 2]]

2.  Empty hashSet with i = 2

 new L for i = 2[2, 1]

3...Add to l 3 [3, 2, 1]

3..remove at j. 3 [2, 1]

4..after add to ..currentSet[[3, 2, 1]]

3...Add to l 3 [2, 3, 1]

3..remove at j. 3 [2, 1]

4..after add to ..currentSet[[3, 2, 1], [2, 3, 1]]

3...Add to l 3 [2, 1, 3]

3..remove at j. 3 [2, 1]

4..after add to ..currentSet[[3, 2, 1], [2, 1, 3], [2, 3, 1]]

 new L for i = 2[1, 2]

3...Add to l 3 [3, 1, 2]

3..remove at j. 3 [1, 2]

4..after add to ..currentSet[[3, 2, 1], [2, 1, 3], [3, 1, 2], [2, 3, 1]]

3...Add to l 3 [1, 3, 2]

3..remove at j. 3 [1, 2]

4..after add to ..currentSet[[3, 2, 1], [2, 1, 3], [3, 1, 2], [2, 3, 1], [1, 3,
2]]

3...Add to l 3 [1, 2, 3]

3..remove at j. 3 [1, 2]

4..after add to ..currentSet[[3, 2, 1], [1, 2, 3], [2, 1, 3], [3, 1, 2], [2, 3,
1], [1, 3, 2]]

5.....returnList with i = 2 [[3, 2, 1], [1, 2, 3], [2, 1, 3], [3, 1, 2], [2, 3,
1], [1, 3, 2]]

[[3, 2, 1], [1, 2, 3], [2, 1, 3], [3, 1, 2], [2, 3, 1], [1, 3, 2]]

H:\Computer Science\Java\MyHackerRank>


*/















