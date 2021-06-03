import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		// (1 ≤ N ≤ 1,000)
		int N = Integer.parseInt(reader.readLine());
		int[] a = new int[1001];
		int[] d = new int[1001];
		int[] c = new int[1001];
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		for(int i=1; i<=N; i++)
			a[i] = Integer.parseInt(tokenizer.nextToken());
		d[1]=1;
		for(int i=2; i<=N; i++)
		{
			d[i]=1;
			for(int j=i; j>=1; j--)
			{
				if(a[j]<a[i] && d[i]<d[j]+1)
				{
					d[i] = d[j]+1;
					c[i] = j;
				}
			}
		}
		int max=-1;
		int max_index = 0;
		for(int i=1; i<=N; i++)
			if(max<d[i])
			{
				max=d[i];
				max_index = i;
			}
		System.out.println(max);
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(true)
		{
			list.add(a[max_index]);
			if(d[max_index] == 1)
				break;
			max_index = c[max_index];
		}
		list.sort(null);
		for(int i=0; i<list.size(); i++)
			builder.append(list.get(i)+" ");
		System.out.println(builder);
	}

}