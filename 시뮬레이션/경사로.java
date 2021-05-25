import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean go(int[] a, int l) {
		//l은 경사로 길이
		int n= a.length;
		boolean[] c = new boolean[n];
		for (int i = 0; i < n-1; i++) {
			int diff = a[i]-a[i+1];

			// 낮은 칸과 높은 칸의 높이 차이는 같거나 1이어야 한다.
			if(Math.abs(diff) > 1)
				return false;
			//올라가는 경사로
			if(diff == -1)
			{
				 for (int j=0; j<l; j++) {
					 if (i-j < 0) {
                         // 경사로를 놓다가 범위를 벗어나는 경우
                         return false;
                     }
					 if (a[i] != a[i-j]) {
                         // 낮은 지점의 칸의 높이가 모두 같지 않거나, L개가 연속되지 않은 경우
                         return false;
                     }
					 if (c[i-j]) {
                         // 경사로를 놓은 곳에 또 경사로를 놓는 경우
                         return false;
                     }
					 c[i-j] = true;
				 }
			}
			//내려가는 경사로
			else if(diff == 1)
			{
				 for (int j=0; j<l; j++) {
					 if (i+j+1 >= n) {
                         // 경사로를 놓다가 범위를 벗어나는 경우
                         return false;
                     }
					 if (a[i+1] != a[i+1+j]) {
                         // 낮은 지점의 칸의 높이가 모두 같지 않거나, L개가 연속되지 않은 경우

                         return false;
                     }
					 if (c[i+j+1]) {
                         // 경사로를 놓은 곳에 또 경사로를 놓는 경우
                         return false;
                     }
                     c[i+j+1] = true;
				 }

			}
		}
		return true;
	}

	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(tokenizer.nextToken()); // N×N인 지도
		int L = Integer.parseInt(tokenizer.nextToken()); // 경사로 길이
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			for (int j = 0; j < N; j++)
				arr[i][j] = Integer.parseInt(tokenizer.nextToken());
		}
		int ans = 0;
		for (int i = 0; i < N; i++) {
			// 행 검사
			int[] d = new int[N];
			for (int j = 0; j < N; j++) {
				d[j] = arr[i][j];
			}
			if (go(d, L))
				ans += 1;
		}
		for (int j = 0; j < N; j++) {
			// 열 검사
			int[] d = new int[N];
			for (int i = 0; i < N; i++) {
				d[i] = arr[i][j];
			}
			if (go(d, L))
				ans += 1;
		}
		System.out.println(ans);

	}
}