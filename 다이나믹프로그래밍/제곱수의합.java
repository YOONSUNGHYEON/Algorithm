import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		int N = Integer.parseInt(reader.readLine());
		int[] d = new int[N+1];
		for (int i = 1; i <= N; i++) {
			d[i] = i; //d[7] = 1^2+1^2+1^2+1^2+1^2+1^2+1^2 = 7항
			for (int j = 1; j*j <= i; j++) {
				if(d[i-(j*j)]+1<d[i])
					d[i] = d[i-(j*j)]+1;
			}
		}

        System.out.println(d[N]);

	}

}