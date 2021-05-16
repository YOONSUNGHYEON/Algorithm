import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	static StringBuilder builder = new StringBuilder();
    static int[] T = new int[15];
    static int[] P = new int[15];
    static boolean[] c = new boolean[15];
    static int sum;
    static void go(int index, int temp_sum, int n) {
        if (index == n) {
        	if(temp_sum>sum)
        		sum = temp_sum;
            return;
        }
        if (index > n) return;
        go(index+T[index], temp_sum+P[index],n);
        go(index+1, temp_sum, n);
    }

    public static void main(String args[]) throws NumberFormatException, IOException {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(reader.readLine());
    	StringTokenizer tokenizer;
    	for(int i=0; i<N;i++)
    	{
    		tokenizer = new StringTokenizer(reader.readLine());
    		T[i] = Integer.parseInt(tokenizer.nextToken());
    		P[i] = Integer.parseInt(tokenizer.nextToken());
    	}
    	sum = -1;
 		go(0,0,N);
    	System.out.println(sum);

    }
}
