public class BucketSort
{
    /**
     * Sorts an array of <code>DoubleValued</code>.
     *
     * @param array The array of <code>DoubleValued</code> objects to
     * be sorted.
     * @throws ArrayIndexOutOfBoundsException if any element of
     * <code>array</code> has a value outside the half-open interval
     * [0,1).
     */
    public void sort (DoubleValued[] array) 
    {
    // Determine length of array and instantiate buckets.
    int n = array.length;
    SortableSentinelDLL[] buckets = new SortableSentinelDLL[n];

    // Initialize each bucket with a new linked list.
    for (int i = 0; i < n; i++)
        buckets[i] = new SortableSentinelDLL();
    
    // Add each element in array to its specific bucket.
    for (int i = 0; i < n; i++)
        buckets[(int) (n * array[i].getKey())].
        insert(array[i]);

    // Sort the buckets.
    for (int i = 0; i < n; i++)
        buckets[i].sort();

    // Concatenate the buckets together into buckets[0].
    for (int i = 1; i < n; i++)
        buckets[0].concatenate(buckets[i]);

    // Convert the LinkedList of sorted values back into array.
    buckets[0].toArray(array);
    }
}