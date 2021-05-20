import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Location {
		int x;
		int y;

		Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static final int[] dx = { 1, 0, -1, 0 };
	public static final int[] dy = { 0, 1, 0, -1 };

    public static void main(String args[]) throws IOException {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int M = Integer.parseInt(tokenizer.nextToken());
		int N = Integer.parseInt(tokenizer.nextToken());
		char[][] a = new char[N][M];
		for(int i=0; i<N; i++)
		{
			tokenizer = new StringTokenizer(reader.readLine());
			String s = tokenizer.nextToken();
			for(int j=0; j<M; j++)
				a[i][j] = s.charAt(j);
		}
        boolean[][] c = new boolean[N][M]; //방문 여부
        int[][] d = new int[N][M];
        c[0][0] = true; //수빈이 위치와 시간 배열에 넣기
        d[0][0] = 0;
        Queue<Location> q = new LinkedList<Location>();
        Queue<Location> next_queue = new LinkedList<Location>();
        q.add(new Location(0,0));
        while (!q.isEmpty()) {
        	Location now = q.remove();
			int x = now.x;
			int y = now.y;
			if(x==N-1 && y == M-1)
				 System.out.println(d[x][y]);
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				// 배열의 범위를 벗어나는가
				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					if(c[nx][ny] == false)
					{
						c[nx][ny] =true;
						if(a[nx][ny]=='1')
						{
							next_queue.add(new Location(nx, ny));
	                        d[nx][ny] = d[x][y]+1;
						}
						else
						{
							q.add(new Location(nx, ny));
	                        d[nx][ny] = d[x][y];
						}
					}

				}
            }
            if (q.isEmpty()) {
                q = next_queue; //다음큐 -> 현재 큐
                next_queue = new LinkedList<Location>();
            }
        }


    }
}