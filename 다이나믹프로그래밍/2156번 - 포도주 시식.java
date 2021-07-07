import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int[] a = new int[N];
		for (int i = 0; i < N; i++)
			a[i] = Integer.parseInt(reader.readLine());

		int[][] d = new int[N][3];
		d[0][0] = 0;
		d[0][1] = a[0];
		d[0][2] = 0;
		for(int i=1; i<N; i++)
		{
			if(d[i-1][0] > d[i-1][1])
			{
				if(d[i-1][0]>d[i-1][2])
					d[i][0] = d[i-1][0];
				else
					d[i][0] = d[i-1][2];
			}
			else
			{
				if(d[i-1][1]>d[i-1][2])
					d[i][0] = d[i-1][1];
				else
					d[i][0] = d[i-1][2];
			}
			d[i][1] = d[i-1][0] + a[i];
			d[i][2] = d[i-1][1] + a[i];
		}
		int max = -1;
		for(int i=0; i<3; i++)
		{
			if(max<d[N-1][i])
				max = d[N-1][i];
		}
		System.out.println(max);
	}
}