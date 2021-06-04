import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// 우리의 크기 N(1≤N≤100,000)
		int N = Integer.parseInt(reader.readLine());
		int mod = 9901;

		long[][] d = new long[N][3];
		d[0][0] = 1;
		d[0][1] = 1;
		d[0][2] = 1;
		for (int i = 1; i < N; i++) {
			d[i][0] = (d[i - 1][0] + d[i - 1][1] + d[i - 1][2])%mod;
			d[i][1] = (d[i - 1][0] + d[i - 1][2])%mod;
			d[i][2] = (d[i - 1][0] + d[i - 1][1])%mod;
		}
		System.out.println((d[N-1][0]+d[N-1][1]+d[N-1][2])%mod);
	}
}