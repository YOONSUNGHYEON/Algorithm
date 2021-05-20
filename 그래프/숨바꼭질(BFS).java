import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int max = 100001;
		int N = Integer.parseInt(tokenizer.nextToken());
		int K = Integer.parseInt(tokenizer.nextToken());
		int[] check =new int[max];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(N);
		check[N] = 1;
		while(!q.isEmpty())
		{
			int current = q.remove();
			if(current == K)
			{
				System.out.println(check[current]-1);
				break;
			}
			if(current-1>=0&&check[current-1]==0 )
			{
				q.add(current-1);
				check[current-1]=check[current]+1;
			}
			if(current+1<max&&check[current+1]==0 )
			{
				q.add(current+1);
				check[current+1]=check[current]+1;
			}
			if(current*2<max&&check[current*2]==0 )
			{
				q.add(current*2);
				check[current*2]=check[current]+1;
			}
		}
	}
}