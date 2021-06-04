import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder builder = new StringBuilder();
	public static long mod = 1000000000L;

	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(tokenizer.nextToken());
		int K = Integer.parseInt(tokenizer.nextToken());
		long[][] d = new long[K + 1][N + 1];

		 d[0][0] = 1;
		  for (int i=1; i<=K; i++) {
	            for (int j=0; j<=N; j++) {
	                for (int l=0; l<=j; l++) { //l은 마지막 숫자 경우의 수
	                    d[i][j] += d[i-1][j-l];
	                    d[i][j] %= mod;
	                }
	            }
	        }

		System.out.println(d[K][N]);

	}

}