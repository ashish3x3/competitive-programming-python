
// http://www.geeksforgeeks.org/linked-complete-binary-tree-its-creation/

/*
How to write an insert function that always adds a new node in the last level and at the leftmost available position?
To create a linked complete binary tree, we need to keep track of the nodes in a level order fashion such that the next node to be inserted lies in the leftmost position. A queue data structure can be used to keep track of the inserted nodes.

Following are steps to insert a new node in Complete Binary Tree.
1. If the tree is empty, initialize the root with new node.

2. Else, get the front node of the queue.
…….If the left child of this front node doesn’t exist, set the left child as the new node.
…….else if the right child of this front node doesn’t exist, set the right child as the new node.

3. If the front node has both the left child and right child, Dequeue() it.

4. Enqueue() the new node.
*/

int hasBothChild(struct node* temp)
{
    return temp && temp->left && temp->right;
}
 
// Function to insert a new node in complete binary tree
void insert(struct node **root, int data, struct Queue* queue)
{
    // Create a new node for given data
    struct node *temp = newNode(data);
 
    // If the tree is empty, initialize the root with new node.
    if (!*root)
        *root = temp;
 
    else
    {
        // get the front node of the queue.
        struct node* front = getFront(queue);
 
        // If the left child of this front node doesn’t exist, set the
        // left child as the new node
        if (!front->left)
            front->left = temp;
 
        // If the right child of this front node doesn’t exist, set the
        // right child as the new node
        else if (!front->right)
            front->right = temp;
 
        // If the front node has both the left child and right child,
        // Dequeue() it.
        if (hasBothChild(front))
            Dequeue(queue);
    }
 
    // Enqueue() the new node for later insertions
    Enqueue(temp, queue);
}