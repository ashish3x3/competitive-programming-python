/*
 
A circus is designing a tower routine consisting of people standing atop one another’s
shoulders. For practical and aesthetic reasons, each person must be both shorter and lighter than the person below him or her. Given the heights and weights of each person in the circus, write a method to compute the largest possible number of people
in such a tower.
EXAMPLE:
Input (ht, wt): (65, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)
Output: The longest tower is length 6 and includes from top to bottom: (56, 90) (60,95) (65,100) (68,110) (70,150) (75,190)

*/


/*
I think its a variation of Box stacking DP problem.
It can be done as follows:
1. Sort the input in decreasing order of weight and find the longest decreasing sequence of hight.
2. Sort the input in decreasing order of hight and find the longest decreasing sequence of weight.
Take max of 1 and 2.
Time: O(N^2), Space: O(1)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Circus {
	
	class Dimension implements Comparable<Dimension> {
		int height;
		int weight;
		sure..
		Dimension(int height, int weight) {
			this.height = height;
			this.weight = weight;
		}

		@Override
		public int compareTo(Dimension d) {
			return(this.height < d.height) ? 1 : this.height == d.height ? 0 : -1;
		}
	}
	
	private void getMaxPeople(Dimension [] dimension, int n) {
		int[] h = new int[n];
		Arrays.fill(h, 1);
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++){
				if(dimension[j].weight < dimension[i].weight && h[j] < (h[i] + 1))  {
					h[j] = h[i] + 1;
				}
			}
		}
		for(int i=0;i<n;i++) {
			System.out.print(h[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of inputs");
		int n = Integer.parseInt(br.readLine());
		Dimension [] dimension = new Dimension[n];
		System.out.println("Enter the coordinates");
		Circus circus = new Circus();
		for(int i=0;i<n;i++) {
			dimension[i] = circus.new Dimension(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()));
		}
		Arrays.sort(dimension);
		circus.getMaxPeople(dimension, n);
	}
}