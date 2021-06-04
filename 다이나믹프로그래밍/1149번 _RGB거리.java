import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// 집의 수 N(2 ≤ N ≤ 1,000)
		int N = Integer.parseInt(reader.readLine());
		// N개의 줄에는 각 집을 빨강(0), 초록(1), 파랑(2)으로 칠하는 비용
		int[][] a = new int[N][3];
		int[][] d = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			a[i][0] = Integer.parseInt(tokenizer.nextToken());
			a[i][1] = Integer.parseInt(tokenizer.nextToken());
			a[i][2] = Integer.parseInt(tokenizer.nextToken());
		}
		d[0][0] = a[0][0];
		d[0][1] = a[0][1];
		d[0][2] = a[0][2];

		for (int i = 1; i < N; i++) {
			if(d[i - 1][1]<d[i - 1][2])
				d[i][0] = d[i - 1][1] + a[i][0];
			else
				d[i][0] = d[i - 1][2] + a[i][0];

			if(d[i - 1][0]<d[i - 1][2])
				d[i][1] = d[i - 1][0] + a[i][1];
			else
				d[i][1] = d[i - 1][2] + a[i][1];

			if(d[i - 1][0]<d[i - 1][1])
				d[i][2] = d[i - 1][0] + a[i][2];
			else
				d[i][2] = d[i - 1][1] + a[i][2];

		}

		int min=1000000;
		for (int i = 0; i < 3; i++) {
			if(min>d[N-1][i])
				min = d[N-1][i];
		}
		System.out.println(min);
	}
}