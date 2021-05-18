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
	public static final int[] dx = { 0, 0, 1, -1 };
	public static final int[] dy = { 1, -1, 0, 0 };

	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int m = Integer.parseInt(tokenizer.nextToken());// 가로
		int n = Integer.parseInt(tokenizer.nextToken());// 세로
		a = new int[n][m];
		int[][] dist = new int[n][m];
		int check_tomato = 0;
		Queue<Pair> q = new LinkedList<Pair>();
		for (int i = 0; i < n; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			for (int j = 0; j < m; j++) {
				a[i][j] = Integer.parseInt(tokenizer.nextToken());
				dist[i][j] = -1;// 거리를 -1로 초기화
				if (a[i][j] == 1) {
					q.add(new Pair(i, j));
					dist[i][j] = 0;
				}
			}
		}
		while (!q.isEmpty()) {
			Pair p = q.remove();
			int x = p.x;
			int y = p.y;
			for (int k = 0; k < 4; k++) { // 인접한 4방향
				int nx = x + dx[k];
				int ny = y + dy[k];
				// 배열의 범위를 벗어나는가
				if (0 <= nx && nx < n && 0 <= ny && ny < m) {
					if (a[nx][ny] == 0 && dist[nx][ny] == -1) {
						q.add(new Pair(nx, ny));
                        dist[nx][ny] = dist[x][y] + 1;
					}
				}
			}
		}
		int ans = 0;
		//최단 기간
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (ans < dist[i][j]) {
                    ans = dist[i][j];
                }
            }
        }
        //전체가 익지 않은ㄱ 경우 -1
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (a[i][j] == 0 && dist[i][j] == -1) {
                    ans = -1;
                }
            }
        }
        System.out.println(ans);
	}
}