noplease m,/*
http://www.programcreek.com/2014/03/leetcode-word-break-ii-java/

http://yucoding.blogspot.in/2014/01/leetcode-question-word-break-ii.html

http://www.danielbit.com/blog/puzzle/leetcode/leetcode-word-break-ii

https://psyking841.wordpress.com/2014/09/21/leetcode-word-break-ii/

http://mattcb.blogspot.in/2015/04/word-break-ii.html
*/



public static ArrayList<String> wordBreak(String s, Set<String> dict){
    //use res to store a list with each sublist marked by the index of each char in the string, 
    //each substring record the previous index or indexes that have seen match
 ArrayList<ArrayList<Integer>> prevres = new ArrayList<ArrayList<Integer>>();
    //separate the string to checked and current, checked stores whether or not there is/are valid word/words found in the checked section
    ArrayList<Boolean> checked = new ArrayList<Boolean>(s.length()+1);
    //initiate them
    for(int i=0;i<s.length()+1;i++){
        ArrayList<Integer> temp = new ArrayList<Integer>();
        prevres.add(temp);
    }
    for(int i=0;i<s.length()+1;i++){
        checked.add(false);
    }
    //set the checked[0] to true
    checked.set(0,true);
    //i is the end of the current section, note s[0:1] return s[0]
    for(int i=1; i<=s.length();i++){
        //j is the start of the current section this also means j is the end of the checked section
        for(int j=0;j<i;j++){
            //if we see true in checked and valid word in current section
            if(checked.get(j) && dict.contains(s.substring(j, i))){
                //if current index is not set to true then do it
                if(!checked.get(i)) checked.set(i, true);
                //update the res, the sublist in res will be updated with indexes with valid words before index i
                prevres.get(i).add(j);
            }
        }
    }
     
    //using backtracking to get the results
    ArrayList<String> r = new ArrayList<String>();
    backtracking(s, dict, prevres, s.length(), r);
    return r;
}
 
public static void backtracking(String s, Set<String> dict, ArrayList<ArrayList<Integer>> prevres, int index, ArrayList<String> btres){
    //the idea of backtracking is that we start from index = s.length
    //  0  1  2  3  4  5  6   7   8  9  10 // int index
    //     c  a  t  s  a  n   d   d  o  g  // String s
    //[[ ][ ][ ][0][0][ ][ ][3,4][ ][ ][7]] // ArrayList<ArrayList<Integer>> prevres //this is the res get from the dp
     
    //each elements in res.get[i] is the root of a tree/subtree, for e.g. 7-3-0; or 7-4-0
    //so we loop for the number of elements in prevres.get[index]
    for(int i=0;i<prevres.get(index).size();i++){
        //if we see 0 in res.get(i) which means we have reached the leaves, each of which represents the end of a new string in the string arraylist
        if(prevres.get(index).get(0) == 0){
            btres.add(s.substring(0, index));
        } else {
        //else we track down the tree, and save the result in btres
            backtracking(s, dict, prevres, prevres.get(index).get(i), btres);
            //for the return results of previous sections, add current string to each string
            for(int j=0;j<btres.size();j++){
                String tempS = btres.get(j);
                //get rid of the spaces in the string
                String tempS2 = tempS.replaceAll("\\s", "");
                //get the right string then append the new string, the right string will be the length indicated by prevres.get(index).get(i)
                if(tempS2.length() == prevres.get(index).get(i)){
                    //append the new string to the right string with space
                    btres.set(j, btres.get(j)+ " " + s.substring(prevres.get(index).get(i), index));
                }
            }
        }
    }
}