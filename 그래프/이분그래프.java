import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	public static boolean dfs(ArrayList<Integer>[] a, int[] color, int x, int c) {
		 color[x] = c;
		for (int y : a[x]) {
			 if (color[y] == 0) {
				 if (dfs(a, color, y, 3-c) == false) {
	                    return false;
	                }
			}
			 else if (color[y] == color[x]) {
	                return false;
	            }
		}
		return true;
	}

	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer;
		int V, E;
		while (T-- > 0) {
			tokenizer = new StringTokenizer(reader.readLine());
			V = Integer.parseInt(tokenizer.nextToken());// 정점
			E = Integer.parseInt(tokenizer.nextToken());// 간선
			ArrayList<Integer>[] a = new ArrayList[V + 1];
			for (int i = 1; i <= V; i++)
				a[i] = new ArrayList<Integer>();
			for (int i = 1; i <= E; i++) {
				tokenizer = new StringTokenizer(reader.readLine());
				int u = Integer.parseInt(tokenizer.nextToken());
				int v = Integer.parseInt(tokenizer.nextToken());
				a[u].add(v);
				a[v].add(u);
			}
			 int[] color = new int[V+1];
			 boolean ok = true;
			int ans = 0;
			for (int i = 1; i <= V; i++) {
				 if (color[i] == 0) {
	                    if (dfs(a, color, i, 1) == false) {
	                        ok = false;
	                    }
	                }
			}
			if(ok == true)
				System.out.println("YES");
			else
				System.out.println("NO");
		}

	}
}