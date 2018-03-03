import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class EvenTree{

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int N,M;    //m=edges   n=vertex
        N=scan.nextInt();
        M=scan.nextInt();
        int [][] arr=new int[M][2];

        for(int i=0;i<M;++i){
        	arr[i][0]=scan.nextInt();
        	arr[i][1]=scan.nextInt();

        }

        int [] count=new int[N+1];

        Arrays.fill(count,1);

        for(int i=0;i<M;++i){		//M=edges

        	count[arr[i][1]]=0;
        }
        int total=0;
        int first,f,answer=0;

       // Queue<Integer> q=new Queue<Integer>();
        Queue<Integer> q = new PriorityQueue<Integer>();

        for(int i=N;i>=0;--i){
    

        if(count[i]==0)
        {
            //q.add((Integer)i);
            q.add(i);
            total=0;

            while(!q.isEmpty())
            {
                // first=(int)q.peek();
                first=q.peek();
                q.poll();
                f=0;
                if(count[first]!=0)
                {
                    total+=count[first];
                    f=1;
                }
                else
                {
                    total++;
                }

                if(f==0)
                for(int j=0;j<M;++j)
                {
                    if(arr[j][1]==first)
                    q.add(arr[j][0]);
                }

            }
            count[i]=total;

        }
      } //for

      for(int i=2;i<=N;++i)
    {
        if(count[i]%2==0)
        ++answer;
    }
    System.out.println(""+answer);

    
    /*  Using DFS
    vector<int> al[105];
    bool visit[105];
    int n,m;
    int ans;

    int dfs(int node)
    {
    	visit[node]=true;
    	int num_vertex=0;
    	for(int i=0;i<al[node].size();i++)
    	{
    		if(!visit[al[node][i]])
    		{
    			int num_nodes=dfs(al[node][i]);
    			if(num_nodes%2==0)
    				ans++;
    			else
    				num_vertex+=num_nodes;
    		}
    	}
    	return num_vertex+1;
    }

    int main() {
    	int x,y;
    	cin>>n>>m;
    	for(int i=0;i<m;i++)
    	{
    		cin>>x>>y;
    		al[x].push_back(y);
    		al[y].push_back(x);
    	}
    	dfs(1);
    	cout<<ans;
    	return 0;
    }*/
    


        
    }  //main
}

/*

H:\Computer Science\Java\Tree>java EvenTree
10 9
2 1
3 1
4 3
5 2
6 1
7 2
8 6
9 8
10 8
2
*/