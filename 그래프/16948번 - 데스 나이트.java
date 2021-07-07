package 신규아이디추천;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] graph;
	static boolean[][] check;
	static int r, c;
	static int target_r, target_c;
	public static final int[] dx = { -2, -2, 0, 0, 2, 2 };
	public static final int[] dy = { -1, 1, -2, 2, -1, 1 };

	private static class Location {
		int x;
		int y;
		int dist;

		public Location(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

	public static void BFS() {
		Queue<Location> will_visit = new LinkedList<>();
		check[r][c] = true;
		will_visit.add(new Location(r, c, 0));
		while (will_visit.isEmpty() == false) {
			Location current = will_visit.remove();
			if (current.x == target_r && current.y == target_c)
			{
				System.out.println(current.dist);
				return;
			}


			for (int i = 0; i < 6; i++) {
				int dx_x = current.x + dx[i];
				int dy_y = current.y + dy[i];
				if (dx_x >= 0 && dy_y >= 0 && dx_x < N && dy_y < N && check[dx_x][dy_y] == false) {
					check[dx_x][dy_y] = true;
					will_visit.add(new Location(dx_x, dy_y, current.dist + 1));
				}
			}
		}
		System.out.println(-1);
		return;

	}

	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());
		check = new boolean[N][N];
		graph = new int[N][N];
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

		r = Integer.parseInt(tokenizer.nextToken());
		c = Integer.parseInt(tokenizer.nextToken());
		target_r = Integer.parseInt(tokenizer.nextToken());
		target_c = Integer.parseInt(tokenizer.nextToken());

		BFS();
	}
}
