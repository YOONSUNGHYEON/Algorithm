import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static void south() {
		int temp_dice = dice[4];
		dice[4] = dice[5];
		dice[5] = dice[1];
		dice[1] = dice[0];
		dice[0] =temp_dice;
	}

	static void  north(){
		int temp_dice =dice[1];
		dice[1] = dice[5];
		dice[5] = dice[4];
		dice[4] = dice[0];
		dice[0] = temp_dice;
	}

	static void east() {
		int temp_dice =dice[2];
		dice[2] = dice[0];
		dice[0] = dice[3];
		dice[3] = dice[5];
		dice[5] = temp_dice;

	}

	static void west() {
		int temp_dice =dice[3];
		dice[3] = dice[0];
		dice[0] = dice[2];
		dice[2] = dice[5];
		dice[5] = temp_dice;

	}

	static int[] dice = new int[6];

	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(tokenizer.nextToken()); // 지도의 세로
		int M = Integer.parseInt(tokenizer.nextToken()); // 지도의 가로
		int x = Integer.parseInt(tokenizer.nextToken()); // 주사위를 놓은 곳의 좌표 x
		int y = Integer.parseInt(tokenizer.nextToken()); // 주사위를 놓은 곳의 좌표 y
		int k = Integer.parseInt(tokenizer.nextToken()); // 명령의 개수
		int[][] a = new int[N][M];
		dice = new int[6];
		int[][] b = null;
		int[] r = new int[k];
		for (int i = 0; i < N; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			for (int j = 0; j < M; j++)
				a[i][j] = Integer.parseInt(tokenizer.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		tokenizer = new StringTokenizer(reader.readLine());
		for (int i = 0; i < k; i++) {
			int num = Integer.parseInt(tokenizer.nextToken());
			if (num == 3) {
				if (x - 1 < 0)
					continue;
				x = x - 1;
				north();
			} else if (num == 4) {
				if (x + 1 >= N)
					continue;
				x = x + 1;
				south();
			} else if (num == 1) { // 동쪽
				if (y + 1 >= M)
					continue;
				y =y + 1;
				west();
			} else if (num == 2) {
				if (y - 1 < 0)
					continue;
				y =y-1;
				east();

			}

			if (a[x][y] != 0) {
				dice[5] = a[x][y];
				a[x][y] = 0;
			} else
				a[x][y] = dice[5];
			sb.append(dice[0]).append("\n");
		}
		System.out.println(sb.toString());

	}
}