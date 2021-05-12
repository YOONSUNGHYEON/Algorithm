import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int start=1;
		int end=0;
		int len=1;
		int num=0;
		for(int i=1; i<=N; i*=10)
		{
			end = (i*10)-1;
			if(N<=end)
				end = N;
			num += (end-i+1)*len;
			len++;
		}
		System.out.println(num);
	}
}