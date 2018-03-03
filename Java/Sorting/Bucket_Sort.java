import java.util.Random;

 

public class Bucket_Sort 

{

    static int[] sort(int[] sequence, int maxValue) 

    {

        // Bucket Sort

        int[] Bucket = new int[maxValue + 1];

        int[] sorted_sequence = new int[sequence.length];

 

        for (int i = 0; i < sequence.length; i++)

            Bucket[sequence[i]]++;

 

        int outPos = 0;

        for (int i = 0; i < Bucket.length; i++)

            for (int j = 0; j < Bucket[i]; j++)

                sorted_sequence[outPos++] = i;

 

        return sorted_sequence;

    }

 

    static void printSequence(int[] sorted_sequence) 

    {

        for (int i = 0; i < sorted_sequence.length; i++)

            System.out.print(sorted_sequence[i] + " ");

    }

 

    static int maxValue(int[] sequence) 

    {

        int maxValue = 0;

        for (int i = 0; i < sequence.length; i++)

            if (sequence[i] > maxValue)

                maxValue = sequence[i];

        return maxValue;

    }

 

    public static void main(String args[]) 

    {

        System.out

                .println("Sorting of randomly generated numbers using BUCKET SORT");

        Random random = new Random();

        int N = 20;

        int[] sequence = new int[N];

 

        for (int i = 0; i < N; i++)

            sequence[i] = Math.abs(random.nextInt(100));

 

        int maxValue = maxValue(sequence);

 

        System.out.println("\nOriginal Sequence: ");

        printSequence(sequence);

 

        System.out.println("\nSorted Sequence: ");

        printSequence(sort(sequence, maxValue));

    }

}


/*H:\Computer Science\Java\Sorting>java Bucket_Sort
Sorting of randomly generated numbers using BUCKET SORT

Original Sequence:
60 29 67 19 71 21 89 57 82 31 12 35 96 70 5 34 56 98 62 16
Sorted Sequence:
5 12 16 19 21 29 31 34 35 56 57 60 62 67 70 71 82 89 96 98*/

/*
    
    arrayList a1 =new arrayList<>[n];
    a1[i]=new LinkedList<>();
    a1[n*arr[i]].add(addLast(arr[i]));
    a1[i].sort();
    LinkedList res;
        res.addAll(bucket of buckets<arrayList>);


*/