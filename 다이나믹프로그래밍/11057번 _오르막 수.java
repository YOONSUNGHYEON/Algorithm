import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int mod = 10007;

		long[][] d = new long[N][10];
		for (int i = 0; i < 10; i++) {
			d[0][i]=1;
		}
		for (int i = 1; i < N; i++) {	//자릿수
			for (int j = 0; j < 10; j++) {//마지막 수
				for (int l = 0; l <= j; l++) {
					d[i][j]+=d[i-1][l];
				}
				d[i][j]%=mod;
			}
		}
		int sum=0;
		for (int i = 0; i < 10; i++) {
			sum+=d[N-1][i];
		}
		System.out.println(sum%mod);
	}
}