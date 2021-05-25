import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static long[] d;

	public static long go(int n) {
		System.out.println(n+" "+d[n]);
		if (n == 0)
			return 1;
		if (d[n] > 0)
			return d[n];
		d[n] = (go(n - 1) + go(n - 2))%10007;
		return d[n];
	}

	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		d = new long[n + 1];
		d[1]=1;
		System.out.println(go(n));
	}
}