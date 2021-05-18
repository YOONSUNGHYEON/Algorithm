import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[][] a;
	public static final int[] dx = { 1, 2, -2, -1, -2, -1, 1, 2 };
	public static final int[] dy = { 2, 1, 1, 2, -1, -2, -2, -1 };

	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());
		StringBuilder builder = new StringBuilder();
		StringTokenizer tokenizer;
		int[][] dist;
		while (T-- > 0) {
			int I = Integer.parseInt(reader.readLine()); // 체스판의 한 변의 길이
			// 체스판의 크기는 l × l
			tokenizer = new StringTokenizer(reader.readLine());
			// 나이트가 현재 있는 칸
			int current_x = Integer.parseInt(tokenizer.nextToken());
			int current_y = Integer.parseInt(tokenizer.nextToken());
			tokenizer = new StringTokenizer(reader.readLine());
			// 나이트가 이동하려고 하는 칸
			int target_x = Integer.parseInt(tokenizer.nextToken());
			int target_y = Integer.parseInt(tokenizer.nextToken());
			a = new int[I][I];
			dist = new int[I][I];
			Queue<Pair> q = new LinkedList<Pair>();
			q.add(new Pair(current_x, current_y));
			dist[current_x][current_y] = 1;
			while (!q.isEmpty()) {
				Pair p = q.remove();
				int x = p.x;
				int y = p.y;
				if(x==target_x && y==target_y)
				{
					builder.append((dist[x][y]-1)+"\n");
					break;
				}
				for (int k = 0; k < 8; k++) { // 인접한 4방향
					int nx = x + dx[k];
					int ny = y + dy[k];
					if (0 <= nx && nx < I && 0 <= ny && ny < I) {
						if (dist[nx][ny] == 0) {
							q.add(new Pair(nx, ny));
							dist[nx][ny] = dist[x][y] + 1;
						}
					}
				}
			}
		}

		System.out.println(builder);
	}
}