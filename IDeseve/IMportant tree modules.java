
No need to import java.lang.system.its bydefault

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Comparator;




final static int INVALID_HEIGHT = -1;
int[] height = new int[parent.length];
height[i] = INVALID_HEIGHT;

if (Math.abs(leftSubtreeHeight - rightSubtreeHeight) > 1)
Math.max(leftSubtreeHeight, rightSubtreeHeight) + 1

double value = Math.log(a) / Math.log(i);
if ((value - (int) value) < 0.000000001) {
	return true;
}










private int getLevel(Node root, Node a, int currLevel) {
        if (root == null)
            return 0;
        if (root == a)
            return currLevel;
        int level = getLevel(root.left, a, currLevel + 1);
        if (level != 0) {
            return level;
        } else
            return getLevel(root.right, a, currLevel + 1);
    }



private boolean isSibling(Node root, Node a, Node b) {
        if (root == null)
            return false;
        return ((root.left == a && root.right == b) || (root.right == a && root.left == b) ||
                isSibling(root.left, a, b) || isSibling(root.right, a, b));
    }



private void fillUpPreorderString(String[] traversalString, TreeNode node)
    {
        if (node == null)
        {
            return;
        }

        traversalString[0] += node.key;
        fillUpPreorderString(traversalString, node.left);
        fillUpPreorderString(traversalString, node.right);
    }


private void fillUpInorderString(String[] traversalString, TreeNode node)
{
    if (node == null)
    {
        return;
    }

    fillUpInorderString(traversalString, node.left);
    traversalString[0] += node.key;
    fillUpInorderString(traversalString, node.right);
}



public boolean checkIfSubtree(TreeNode bigTree, TreeNode smallTree)
    {
        String[] inorderForBigTree = {""};
        String[] inorderForSmallTree = {""};

        fillUpInorderString(inorderForBigTree, bigTree);
        fillUpInorderString(inorderForSmallTree, smallTree);

        if (inorderForBigTree[0].contains(inorderForSmallTree[0]))
        {
            String[] preorderForBigTree = {""};
            String[] preorderForSmallTree = {""};

            fillUpPreorderString(preorderForBigTree, bigTree);
            fillUpPreorderString(preorderForSmallTree, smallTree);

            return preorderForBigTree[0].contains(preorderForSmallTree[0]);
        }

        return false;
    }


http://www.ideserve.co.in/learn/mirror-of-n-ary-tree
public class MirrorTree
{
    class QueueNode
    {
        TreeNode node;
        int level;

        QueueNode(TreeNode node, int level)
        {
            this.node = node;
            this.level = level;
        }
    }

    class TreeNode
    {
        private int data;
        ArrayList<TreeNode> children;

        public TreeNode(int data)
        {
            this.data = data;
            children = new ArrayList();
        }
    }

    private TreeNode root;


 /*
     * Create a sample tree
     *                  1
     *           2      3      4
     *         5  6     7     8  9
     *
     */
public void createSampleTree()
    {
         TreeNode n1 = new TreeNode(1);
         TreeNode n2 = new TreeNode(2);
         TreeNode n3 = new TreeNode(3);
         TreeNode n4 = new TreeNode(4);

         TreeNode n5 = new TreeNode(5);
         TreeNode n6 = new TreeNode(6);
         TreeNode n7 = new TreeNode(7);
         TreeNode n8 = new TreeNode(8);
         TreeNode n9 = new TreeNode(9);

         root = n1;

         root.children.add(n2);
         root.children.add(n3);
         root.children.add(n4);

         n2.children.add(n5);
         n2.children.add(n6);

         n3.children.add(n7);

         n4.children.add(n8);
         n4.children.add(n9);
    }

class Node {

    int data;
    Node left;
    Node right;

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Node(int data) {
        this.data = data;
    }
}



http://www.ideserve.co.in/learn/mirror-of-n-ary-tree
public void printLevelOrder()
    {
        if (root == null) return;

        LinkedList<QueueNode> queue = new LinkedList();

        queue.add(new QueueNode(root, 0));

        int maxLevelVisited = -1;

        while (!queue.isEmpty())
        {
            QueueNode currentQueueNode = queue.remove();

            if (currentQueueNode.level > maxLevelVisited)
            {
                System.out.print("\n Level-" + currentQueueNode.level + ": ");
                maxLevelVisited = currentQueueNode.level;
            }
            System.out.print(currentQueueNode.node.data + " ");

            for (int i = 0; i < currentQueueNode.node.children.size(); i++)
            {
                queue.add(new QueueNode(currentQueueNode.node.children.get(i),  currentQueueNode.level + 1));
            }
        }

    }

http://www.ideserve.co.in/learn/mirror-of-n-ary-tree
private void convertToMirror(TreeNode root)
    {
        if(root == null) {
            return;
        }

        // create mirror images of sub-trees rooted at child nodes
        for (int i = 0; i < root.children.size(); i++)
        {
            convertToMirror(root.children.get(i));
        }

        // now reverse the order of child nodes
        Collections.reverse(root.children);
    }


http://www.ideserve.co.in/learn/find-sum-of-all-left-leaves-binary-tree
private boolean isLeafNode(TreeNode currentNode)
    {
        if (currentNode == null)
        {
            return false;
        }

        if (currentNode.left == null && currentNode.right == null)
        {
            return true;
        }

        return false;
    }


    public void findLeftLeavesSum(TreeNode currentNode, int[] leftLeavesSum)
    {
        if (currentNode == null)
        {
            return;
        }
        if (isLeafNode(currentNode.left))
        {
            leftLeavesSum[0] += currentNode.left.val;
        }

        findLeftLeavesSum(currentNode.left, leftLeavesSum);
        findLeftLeavesSum(currentNode.right, leftLeavesSum);
    }




http://www.ideserve.co.in/learn/depth-of-deepest-odd-level-leaf-node
assume root level = 1
return depthDeepestOddLevelLeafNode(root, 1);
private int depthDeepestOddLevelLeafNode(Node root, int currLevel) {
        if (root == null)
            return 0;

        /* currLevel & 1) != 0 means its a odd number bcz it return 1 for odd number */
        if (root.left == null && root.right == null && ((currLevel & 1) != 0))   // if the last bit is 1(in odd numbers), the result of x & 1 is 1; otherwise, it is 0
            return currLevel;
        return Integer.max(depthDeepestOddLevelLeafNode(root.left, currLevel + 1), depthDeepestOddLevelLeafNode(root.right, currLevel + 1));
    }


public static void main(String[] args) {
        Tree tree = new Tree();
        tree.createSampleTree();
        int depthDeepestOddLevelLeafNode = tree.depthDeepestOddLevelLeafNode();
        if (depthDeepestOddLevelLeafNode != 0)
            System.out.println("Depth of deepest odd level leaf node is: " + depthDeepestOddLevelLeafNode);
        else
            System.out.println("No odd level leaf node exists");
    }



http://www.ideserve.co.in/learn/check-if-a-binary-tree-is-balanced
private int checkBalance(TreeNode currentNode)
    {
        if (currentNode == null)
        {
            return 0;
        }

        // check if left sub-tree is balanced
        int leftSubtreeHeight = checkBalance(currentNode.left);
        if (leftSubtreeHeight == -1) return -1;

        // check if right sub-tree is balanced
        int rightSubtreeHeight = checkBalance(currentNode.right);
        if (rightSubtreeHeight == -1) return -1;

        // if both sub-trees are balanced, check the difference of heights
        // should be less than or equal to 1
        if (Math.abs(leftSubtreeHeight - rightSubtreeHeight) > 1)
        {
            return -1;
        }

        // if tree rooted at this node is balanced, return height if tree rooted at this this node
        return (Math.max(leftSubtreeHeight, rightSubtreeHeight) + 1);
    }





Word break..
https://www.youtube.com/watch?v=WepWFGxiwRs
create 2D table, start from length 1, fill upper half diagonal if 0..i is in dict , if present update -1(default val for each cell) with i i.e the break point.. else search for breakpoint k from i to end which will make str i,k and str(k+1,j) both true...store k to str[i,j] in such case..

public String breakWordDP(String word, Set<String> dict){
        int T[][] = new int[word.length()][word.length()];

        for(int i=0; i < T.length; i++){
            for(int j=0; j < T[i].length ; j++){
                T[i][j] = -1; //-1 indicates string between i to j cannot be split
            }
        }

        //fill up the matrix in bottom up manner
        for(int l = 1; l <= word.length(); l++){
            for(int i=0; i < word.length() -l + 1 ; i++){
                int j = i + l-1;
                String str = word.substring(i,j+1);
                //if string between i to j is in dictionary T[i][j] is true
                if(dict.contains(str)){
                    T[i][j] = i;
                    continue;
                }
                //find a k between i+1 to j such that T[i][k-1] && T[k][j] are both true
                for(int k=i+1; k <= j; k++){
                    if(T[i][k-1] != -1 && T[k][j] != -1){
                        T[i][j] = k;
                        break;
                    }
                }
            }
        }
        if(T[0][word.length()-1] == -1){
            return null;
        }

prinitng recursively from table
//create space separate word from string is possible
        StringBuffer buffer = new StringBuffer();
        int i = 0; int j = word.length() -1;
        while(i < j){
            int k = T[i][j];
            if(i == k){
                buffer.append(word.substring(i, j+1));
                break;
            }
            buffer.append(word.substring(i,k) + " ");
            i = k;
        }

        return buffer.toString();


public boolean wordBreakBottomUp(String s, List<String> wordList) {
        boolean[] T = new boolean[s.length() + 1];
        Set<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }
        T[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if(T[j] && set.contains(s.substring(j, i))) {
                    T[i] = true;
                    break;
                }
            }
        }
        return T[s.length()];
    }



public String sortChars(String s)
    {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }




public class AnagramSort implements Comparator<String>
{
    public String sortChars(String s)
    {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    @Override
    // compares its two argument strings for order
    public int compare(String s1, String s2)
    {
        return sortChars(s1).compareTo(sortChars(s2));
    }




http://sophiafeng.com/2013/11/21/lru-cache-implementation-by-linkedhashmap-leetcode/
public class LRUCache {
    private int capacity;
    // private TreeMap<Integer, Integer> map;
    final LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>() {
        @Override
        protected boolean removeEldestEntry(final Map.Entry eldest) {
            return size() > capacity;

        }
    };
    public Solution(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map == null || map.get(key) == null) return -1;
        int value = map.get(key);
        map.remove(key);
        map.put(key, value);
        return value;
    }

    public void set(int key, int value) {
        if(map == null) return;
        get(key);
        map.put(key, value);
    }
}













































