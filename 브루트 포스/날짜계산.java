import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int E, S, M;
		int temp_E = 1, temp_S = 1, temp_M = 1;
		E = Integer.parseInt(tokenizer.nextToken());
		S = Integer.parseInt(tokenizer.nextToken());
		M = Integer.parseInt(tokenizer.nextToken());
		int year = 1;
		while (true) {
			if (temp_E == E && temp_S == S && temp_M == M)
				break;
			if (temp_E == 15)
				temp_E = 1;
			else
				temp_E++;

			if (temp_S == 28)
				temp_S = 1;
			else
				temp_S++;

			if (temp_M == 19)
				temp_M = 1;
			else
				temp_M++;
			year++;
		}
		System.out.println(year);
	}
}
