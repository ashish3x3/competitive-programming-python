

http://edusagar.com/articles/view/75/interview-question-array-find-values-satisfy-a-b-c-d#at_pco=smlwn-1.0&at_si=599009f9a93f5812&at_ab=per-2&at_pos=0&at_tot=1

/*

The brute approach as it looks isn't efficient and thus we need to look for something better. To trade off time complexity we need to look into solutions that requires extra memory. Also, let us change the problem statement a bit. Instead of generating a quadruple, let us generate pairs of 2 integer elements from the array.

For example:

Input: [3, 4, 7, 1, 2, 9, 8]
Array containing all pairs : [7, 10, 4, 5, 12, 11, 11, 5, 6, 13, 12, 8, 9, 16, 15, 3, 10, 9, 11, 10, 17]

If you look closely at the resultant array containing sum of all possible pairs by taking 2 elements at a time from the input array, the problem now becomes much simpler. We need to find a pair of 2 elements whose values are equal. The only trick here will be maintain the conditions mentioned in the problem statement, since we have many such pairs and we need to return only one out of them.

The extra memory required here will be O(n2) . Following is a complete java solution based on this approach where I have used a HashMap to maintain the resultant pairs and evaluate the conditions listed in the original array.

*/

public class Solution {
    public ArrayList<Integer> equal(ArrayList<Integer> a) {
        ArrayList<Integer> res = null;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < a.size(); i++) {
            for (int j = i+1; j < a.size(); j++) {
                int sum = a.get(i) + a.get(j);
                
                if (map.containsKey(sum)) {
                    ArrayList<Integer> pair = map.get(sum);
                    if (pair.get(0) != i &&
                        pair.get(1) != j &&
                        pair.get(0) != j &&
                        pair.get(1) != i) {
                            ArrayList<Integer> _temp = new ArrayList<>();
                            _temp.add(pair.get(0));
                            _temp.add(pair.get(1));
                            _temp.add(i);
                            _temp.add(j);
                            
                            if (res == null) res = _temp;
                            else {
                                for (int k = 0; k < 4; k++) {
                                    if (res.get(k) < _temp.get(k)){
                                        break;
                                    } else if (res.get(k) > _temp.get(k)) {
                                        res = _temp;
                                        break;
                                    }
                                }
                            }
                            
                        }
                } else {
                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(i);
                    pair.add(j);
                    map.put(sum, pair);
                }
            }
        }
        
        return res;
    }
}