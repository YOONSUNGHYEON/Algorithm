import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();// 보낼려는 이모티콘 개수
        int[][] d = new int[n+1][n+1];
        //배열을  -1로 채우기
        for (int i=0; i<=n; i++) {
            Arrays.fill(d[i], -1);
        }
       
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1); 
        q.add(0);
        d[1][0] = 0; //d[현재 화면][클리보드]
        while (!q.isEmpty()) {
            int s = q.remove(); //첫타임에 0
            int c = q.remove(); //1
            System.out.println(s + " " +c);
            //화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
            if (d[s][s] == -1) {
                d[s][s] = d[s][c] + 1;
                q.add(s); q.add(s);
            }
            //클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
            if (s+c <= n && d[s+c][c] == -1) {
                d[s+c][c] = d[s][c] + 1;
                q.add(s+c); q.add(c);
            }
            //화면에 있는 이모티콘 중 하나를 삭제한다.
            if (s-1 >= 0 && d[s-1][c] == -1) {
                d[s-1][c] = d[s][c] + 1;
                q.add(s-1); q.add(c);
            }
        }
        int ans = -1;
        for (int i=0; i<=n; i++) {
            if (d[n][i] != -1) {
                if (ans == -1 || ans > d[n][i]) {
                    ans = d[n][i];
                }
            }
        }
        System.out.println(ans);
    }
}