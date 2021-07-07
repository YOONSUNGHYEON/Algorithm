import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int[][] a = new int[N][N];
		StringTokenizer tokenizer;
		for (int i = 0; i < N; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			for (int j = 0; j <= i; j++)
				a[i][j] = Integer.parseInt(tokenizer.nextToken());
		}
		int[][] d = new int[N][N];
		d[0][0] = a[0][0];
		for (int i = 1; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				d[i][j] =d[i-1][j] + a[i][j];
				if(j-1 >= 0 && d[i-1][j]<d[i-1][j-1] )
					d[i][j] =d[i-1][j-1] + a[i][j];
				}
		}
		int max = -1;
		for (int i = 0; i < N; i++) {
			if (max < d[N - 1][i])
				max = d[N - 1][i];
		}
		System.out.println(max);
	}
}