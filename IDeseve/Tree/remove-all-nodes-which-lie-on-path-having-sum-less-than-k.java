

http://www.ideserve.co.in/learn/remove-all-nodes-which-lie-on-path-having-sum-less-than-k


It is recommended to go through Post-order Traversal of a binary tree first because deleting nodes of a binary tree is done in bottom-up manner by first deleting children and then parent.
While traversing down we pass sum as a parameter which is the sum of all the nodes on the current path including the current node.
Recursively traverse left and right subtrees passing the sum. 
Once we reach a leaf node, we check if its path sum is less than k. If it is, then return null.
While backtracking from recursive steps, find maximum of left and right path sum. If the maximum sum becomes less than k, then we delete the current node by setting it to null.
Please note that by the time we come to delete a node, its children would have already been deleted and hence the current node which we will be deleting will be a leaf node.

public void deleteKLessPath(int k) {
        int sum[] = new int[1];
        deleteKLessPath(this.root, sum, k);
        if (sum[0] < k)
            root = null;
    }
 
    public Node deleteKLessPath(Node node, int[] sum, int k) {
        if (node == null)
            return null;
 
        int[] ls = new int[1];
        int[] rs = new int[1];
        ls[0] = rs[0] = sum[0] + node.data;
 
        node.left = deleteKLessPath(node.left, ls, k);
        node.right = deleteKLessPath(node.right, rs, k);
 
        sum[0] = ls[0] > rs[0] ? ls[0] : rs[0];
        if (sum[0] < k) {
            node = null;
        }
        return node;
    }


    Time Complexity is O(n)
Space Complexity is O(1)