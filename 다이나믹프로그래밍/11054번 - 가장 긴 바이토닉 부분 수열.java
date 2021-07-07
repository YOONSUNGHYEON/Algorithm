import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int[] a = new int[N];
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(tokenizer.nextToken());
		}
		int[] d = new int[N];
		int[] d2 = new int[N];
		for (int i = 0; i < N; i++) {
			d[i] = a[i];
			if (i > 0 && d[i] < d[i - 1] + a[i])
				d[i] = d[i - 1] + a[i];

		}
		for (int i = N - 1; i >= 0; i--) {
			d2[i] = a[i];
			if (i < n - 1 && d2[i + 1] + a[i] > d2[i]) {
				d2[i] = d2[i + 1] + a[i];
			}

		}
		int ans = d[0];
		for (int i = 1; i < n; i++) {
			if (ans < d[i]) {
				ans = d[i];
			}
		}
		for (int i = 1; i < n - 1; i++) {
			if (ans < d[i - 1] + dr[i + 1]) {
				ans = d[i - 1] + dr[i + 1];
			}
		}
		System.out.println(max);
	}
}