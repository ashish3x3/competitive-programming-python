



public class MatrixWithAllOneDP {
    public static void main(String[] args)
    {
        /*int nRows = 5, nCols = 6;
        int[][] boolMatrix = {      //o/p =size=3  start at 1,2
                {1,0,0,1,1,0}, 
                {0,1,1,1,1,0},
                {0,1,1,1,1,1},
                {1,0,1,1,1,0},
                {0,1,1,0,1,1}
        };*/
        int nRows = 4, nCols = 4;
        int[][] boolMatrix = {    //o/p =size=2  start at 0,2
            {1,0,1,1},
            {1,0,1,1},
            {1,1,0,1},
            {1,1,1,1}};

        printMaxSubMatrixIndex(boolMatrix, nRows, nCols);
    }
    public static void printMaxSubMatrixIndex(int[][] bMatrix, int nRows, int nCols)
    {
        int[][] temp = new int[nRows][nCols];
        int i,j;
        //copy the first column as it is
        for( i = 0; i < nRows; i++ )
        {
            temp[i][0] = bMatrix[i][0];
        }
        //copy the first row as it is
        for( i = 0; i < nCols; i++ )
        {
            temp[0][i] = bMatrix[0][i];
        }
        //calculate temp table
        for( i = 1; i < nRows; i++ )
        {
            for( j = 1; j < nCols; j++ )
            {
                int minEntry = Math.min(temp[i][j-1],temp[i-1][j]);
                minEntry = Math.min(minEntry, temp[i-1][j-1]);
                 

                if( bMatrix[i][j] == 1)
                    temp[i][j] = minEntry+1;
                else
                    temp[i][j] = 0;
            }
        }
        //iterate through the temp matrix to get the max size and indices
        int maxSize = 0;
        int r = -1;
        int c = -1;
        for( i = 0; i < nRows; i++ )
        {
            for( j = 0; j < nCols; j++ )
            {
                if( maxSize < temp[i][j] )
                {
                    maxSize = temp[i][j];
                    r = i;
                    c = j;
                }
            }
        }
        //r-maxSize+1, c-maxSize+1 indicates starting point for required sub-matrix
        System.out.println("Size of the Biggest square sub-matrix: "+ maxSize);
        System.out.println("It starts at (" + (r-maxSize+1) + "," + (c-maxSize+1) + ")");

        /*printf("Maximum size sub-matrix is: \n");
        for(i = r; i > r - nRows; i--)
        {
          for(j = c; j > c - nCols; j--)
          {
           System.out.print(" "+boolMatrix[i][j]);
       } 
      System.out.println(" ");
   } */ 
        }
}


//This method takes O(n2) time and O(m x n) space for the temp matrix