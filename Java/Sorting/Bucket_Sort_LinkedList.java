import java.util.*;


public interface Indexable {
    public int getIndex();
}

public static <T extends Indexable> LinkedList<T> BucketSort( ArrayList<T> listToSort )
{
    // work out how many buckets you need.
    int max = 0;
    for ( T listElement : listToSort )
        max = Math.max( max, listElement.getIndex() );

    // initialise the buckets.
    ArrayList<LinkedList<T>> buckets = 
        new ArrayList<LinkedList<T>>( max );
    for ( int i = 0; i <= max; ++i )
        buckets.add( new LinkedList<T>() );

    // add items to the buckets.
    for ( T listElement : listToSort )
        buckets.get( listElement.getIndex() ).addLast( listElement );

    // concatenate the buckets into a single list.
    LinkedList<T> result = new LinkedList<T>();
    for ( LinkedList<T> bucket : buckets )
        result.addAll( bucket );

    return result;
}

public static class IndexableInteger implements Indexable {
    private final int value;

    public IndexableInteger( int value ) {
        this.value = value;
    }

    public int getIndex() {
        return value % 10;
    }

    public String toString(){
        return Integer.toString( value );
    }


    public static void main(String[] args) {
    ArrayList<IndexableInteger> ints = new ArrayList<IndexableInteger>();
    int[] values = { 45, 71, 16, 31, 0, 25, 6, 51, 40, 81 };
    for ( int v : values )
        ints.add( new IndexableInteger( v ) );

    LinkedList<IndexableInteger> sorted = BucketSort( ints );
    System.out.println( sorted );
}


}  //class