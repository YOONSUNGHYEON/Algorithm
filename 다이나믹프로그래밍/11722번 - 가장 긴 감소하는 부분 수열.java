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
		d[0] = 1;
		for (int i = 1; i < N; i++) {
			d[i] = 1;
			for (int j = i-1; j >= 0; j--) {
				if(a[i]<a[j] && d[i]<d[j]+1)
					d[i]=d[j]+1;

			}
		}
		int max = -1;
		for (int i = 0; i < N; i++) {
			//System.out.println(d[i]);
			if (max < d[i])
				max = d[i];
		}
		System.out.println(max);
	}
}