/*


private final int maxSize;
private ConcurrentHashMap<Key, Value> map;
private ConcurrentLinkedQueue<Key> queue;
 
public ConcurrentLRUCache(final int maxSize) {
    this.maxSize = maxSize;
    map = new ConcurrentHashMap<Key, Value>(maxSize);
    queue = new ConcurrentLinkedQueue<Key>();
}
 

public void put(final Key key, final Value value) {
    if (map.containsKey(key)) {
        queue.remove(key); // remove the key from the FIFO queue
    }
 
    while (queue.size() >= maxSize) {
        Key oldestKey = queue.poll();  //from last
        if (null != oldestKey) {
            map.remove(oldestKey);
        }
    }
    queue.add(key);
    map.put(key, value);
}
 

public Value get(final Key key) {
    return map.get(key);
}
}
*/

/*
least_recently_used  -> A <-> B <-> C <-> D <-> E <- most_recently_used
*/

public LRUCache(int maxSize){
        this.maxSize = maxSize;
        this.currentSize = 0;
        leastRecentlyUsed = new Node<K, V>(null, null, null, null);
        mostRecentlyUsed = leastRecentlyUsed;
        cache = new HashMap<K, Node<K, V>>();
    }

    public V get(K key){
        Node<K, V> tempNode = cache.get(key);
        if (tempNode == null){
            return null;
        }
        // If MRU leave the list as it is
        else if (tempNode.key == mostRecentlyUsed.key){
            return mostRecentlyUsed.value;
        }

        // Get the next and previous nodes
        Node<K, V> nextNode = tempNode.next;
        Node<K, V> previousNode = tempNode.previous;

        // If at the left-most, we update LRU 
        if (tempNode.key == leastRecentlyUsed.key){
            nextNode.previous = null;
            leastRecentlyUsed = nextNode;
        }

        // If we are in the middle, we need to update the items before and after our item
        else if (tempNode.key != mostRecentlyUsed.key){
            previousNode.next = nextNode;
            previousNode.previous = nextNode;
        }

        // Finally move our item to the MRU
        tempNode.previous = mostRecentlyUsed;
        mostRecentlyUsed.next = tempNode;
        mostRecentlyUsed = tempNode;
        mostRecentlyUsed.next = null;

        return tempNode.value;

    }

    public void put(K key, V value){
        if (cache.containsKey(key)){
            return;
        }

        // Put the new node at the right-most end of the linked-list
        Node<K, V> myNode = new Node<K, V>(mostRecentlyUsed, null, key, value);
        mostRecentlyUsed.next = myNode;
        cache.put(key, myNode);
        mostRecentlyUsed = myNode;

        // Delete the left-most entry and update the LRU pointer
        if (currentSize == maxSize){
            cache.remove(leastRecentlyUsed.key);
            leastRecentlyUsed = leastRecentlyUsed.next;
            leastRecentlyUsed.previous = null;
        }

        // Update cache size, for the first added entry update the LRU pointer
        else if (currentSize < maxSize){
            if (currentSize == 0){
                leastRecentlyUsed = myNode;
            }
            currentSize++;
        }
    }

    public static void main(String[] args) {
LruCache cache = new LruCache(3);
cache.put("mayur");   //just fromm demonstration
cache.put("sumit");
cache.put("amit");
cache.printqueue();
cache.put("sumit");
cache.printqueue();
cache.put("ankit");
cache.printqueue();

}

/*
Lucky for us, JDK already provides a class that is very suitable for our purpose - LinkedHashMap. This class maintains the entries in a HashMap for fast lookup at the same time maintains a doubly linked list of the entries either in AccessOrder or InsertionOrder. This is configurable so use use AccessOrder as true. It also has a method removeOldestEntry() which we can override to return true when the cache size exceeds the specified capacity(upper limit). So here is the implementation. Enjoy.
Implementation

    
import java.util.LinkedHashMap;
import java.util.Map.Entry;
 
public class LRUCache < K, V > extends LinkedHashMap < K, V > {
 
    private int capacity; // Maximum number of items in the cache.
     
    public LRUCache(int capacity) { 
        super(capacity+1, 1.0f, true); // Pass 'true' for accessOrder.
        this.capacity = capacity;
    }
     
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest ) {
        // remove the oldest element when size limit is reached
        return (size() > this.capacity);
    } 
}
*/