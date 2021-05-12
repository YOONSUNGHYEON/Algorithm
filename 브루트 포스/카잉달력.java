import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int T = Integer.parseInt(tokenizer.nextToken());
		StringBuilder builder = new StringBuilder();
		int M,N,x,y;
		for (int i = 0; i < T; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			M = Integer.parseInt(tokenizer.nextToken());
			N = Integer.parseInt(tokenizer.nextToken());
			x = Integer.parseInt(tokenizer.nextToken());
			y = Integer.parseInt(tokenizer.nextToken());
			builder.append(find_year(M,N,x,y)+"\n");
		}

		System.out.println(builder);
	}
	private static int find_year(int m, int n, int x, int y) {
		// TODO Auto-generated method stub
		for(int i = x-1; i < (n*m); i+=m)//i에 m만큼 계속 더한다면
										//m으로 나눈 나머지 = i x값 고정
		{
			if(i%n==(y-1))//x는 고정으로 했으니 y만 맞는 지 확인
			{
				return i+1;
			}
		}
		return -1;
	}
}
