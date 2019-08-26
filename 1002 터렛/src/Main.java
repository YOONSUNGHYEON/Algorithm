import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int testNum= Integer.parseInt(reader.readLine());
		int x1 = 0, y1 = 0, r1 = 0,x2 = 0, y2 = 0, r2=0;
		int[] arr = new int[testNum];
		for(int i=0; i<testNum; i++)
		{
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			x1 = Integer.parseInt(tokenizer.nextToken());
			y1 = Integer.parseInt(tokenizer.nextToken());
			r1 = Integer.parseInt(tokenizer.nextToken());
			x2 = Integer.parseInt(tokenizer.nextToken());
			y2 = Integer.parseInt(tokenizer.nextToken());
			r2 = Integer.parseInt(tokenizer.nextToken());


		double num = Math.sqrt(((x1-x2)*(x1-x2))+((y1-y2)*(y1-y2)));
		int R  = r1+ r2;
		if(R > num) {

		}
		else if(R == num)
		{
			if(R == 0)
			{

			}
		}
		else if(R > num)
		{

		}
		else
		{

		}
	}

}
}
