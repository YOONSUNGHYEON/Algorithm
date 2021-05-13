import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder builder = new StringBuilder();
    static boolean[] c = new boolean[10];
    static int[] a = new int[10];
    static void go(int index, int start, int n, int m) {
    	//1부터 n까지의 자연수 중에 중복없이 m개를 고르는 수열
        if (index == m) { //m개를 다 채우면 return
            for (int i=0; i<m; i++) {
            	builder.append(a[i]);
                if (i != m-1) builder.append(' ');
            }
            builder.append("\n");
            return;
        }
        //start = index번째에 올수있는 수는 start ~ n = i + 1;
        for (int i=start; i<=n; i++) {//1~N중에
            if (c[i]) continue; //c[i]가 true이면 사용한 수 이기 때문에 건너뛰기
            c[i] = true; //i를 사용한것을 체크
            a[index] = i; //i를 index번째 자리에 위치시킴
            go(index+1,i+1, n, m);// 다음 자리로~
            c[i] = false; //다시 사용해야 하므로 false로 초기화
        }
    }
    //  c[i] 부분는 없어져도 상관 없음
    public static void main(String[] args) throws IOException {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		int m = Integer.parseInt(tokenizer.nextToken());
        go(0,1,n,m); //0번째의 수를 결정
        System.out.println(builder);
    }
}