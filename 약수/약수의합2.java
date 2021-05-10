import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(reader.readLine());
		int g = 0;
		for(int i=1; i<=N;i++)
			g += i*(N/i);

		System.out.println(g);
	}

}
