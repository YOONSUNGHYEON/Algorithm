import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int[] nums = new int[N];
		for(int i=0; i<N;i++)
		{
			nums[i] = Integer.parseInt(tokenizer.nextToken());
		}
		Arrays.sort(nums);
		System.out.println(nums[0]*nums[N-1]);
	}

}