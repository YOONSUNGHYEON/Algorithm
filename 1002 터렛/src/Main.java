import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int testNum = Integer.parseInt(reader.readLine());
		int x1 = 0, y1 = 0, r1 = 0, x2 = 0, y2 = 0, r2 = 0;
		int[] arr = new int[testNum];
		for (int i = 0; i < testNum; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			x1 = Integer.parseInt(tokenizer.nextToken());
			y1 = Integer.parseInt(tokenizer.nextToken());
			r1 = Integer.parseInt(tokenizer.nextToken());
			x2 = Integer.parseInt(tokenizer.nextToken());
			y2 = Integer.parseInt(tokenizer.nextToken());
			r2 = Integer.parseInt(tokenizer.nextToken());

			double R = Math.sqrt(((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2)));
			 if (r1 > r2) {
		    	  int temp = r1;
		    	  r1 = r2;
		    	  r2 = temp;
		    	  }
			if (R > r2 )
			{
				if(r1+r2<R)
					arr[i] = 0;
				else if(r1+r2 == R)
					arr[i] = 1;
				else if(r1+r2 > R)
					arr[i] = 2;

			}
			else if (R <= r2 && R>0)
			{
				if(r2>R+r1)
					arr[i] = 0;
				else if(r2 == R+r1)
					arr[i] = 1;
				else if(r2 < R+r1)
					arr[i] = 2;
			}
			else if (R ==0)
			{
				if(r2!=r1)
					arr[i] = 0;
				else if(r2==r1)
					arr[i] = -1;
			}

		}

		for(int i = 0; i < testNum; i++)
		{
			System.out.println(arr[i]);
		}

	}
}
