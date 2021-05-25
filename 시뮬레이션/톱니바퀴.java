import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = 4; // 톱니바퀴 개수
		int M = 8; // 톱니바퀴 각각 8개의 톱니를 가지고 있다.
		int[][] arr = new int[4][8];
		StringTokenizer tokenizer;
		for (int i = 0; i < N; i++) {
			String s = reader.readLine();
			for (int j = 0; j < M; j++)
				arr[i][j] = s.charAt(j) - '0';

		}
		int K = Integer.parseInt(reader.readLine());
		int[] way = new int[K];
		for (int i = 0; i < K; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int num = Integer.parseInt(tokenizer.nextToken()) - 1; // 회전시킨 톱니바퀴의 번호
			int dir = Integer.parseInt(tokenizer.nextToken()); // 방향
			// 1인 경우는 시계 방향이고, -1인 경우는 반시계 방향
			int[] d = new int[N];
			d[num] = dir;
			// 왼쪽
			for (int j = num - 1; j >= 0; j--) {
				if (arr[j+1][6] != arr[j][2])
					d[j] = -d[j+1];
				else
					break;
			}
			// 오른쪽
			for (int j = num + 1; j < N; j++) {
				if (arr[j-1][2] != arr[j][6])
					d[j] = -d[j-1];
				else
					break;
			}
			for (int j = 0; j < N; j++) {
				if (d[j] == 0)
					continue;
				if (d[j] == 1) {
					int temp = arr[j][7];
					for (int k = 7; k>=1; k--)
						arr[j][k] = arr[j][k-1];
					 arr[j][0] = temp;
				}
				else if (d[j] == -1) {
					int temp = arr[j][0];
					for (int k = 0; k<M-1; k++)
						arr[j][k] = arr[j][k+1];
					 arr[j][7] = temp;
				}
			}

		}
		int sum=0;

		for (int i = 0; i < N; i++) {

			if(arr[i][0]==1)
				 sum |= (1 << i);
		}

		System.out.println(sum);
	}
}