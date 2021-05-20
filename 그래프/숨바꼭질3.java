import java.util.*;

public class Main {
    public static final int MAX = 1000000;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //수빈이가 있는 위치
        int m = sc.nextInt(); //동생이 있는 위치 K
        boolean[] c = new boolean[MAX]; //방문 여부
        int[] d = new int[MAX]; //시간
        c[n] = true; //수빈이 위치와 시간 배열에 넣기
        d[n] = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        Queue<Integer> next_queue = new LinkedList<Integer>();
        q.add(n);
        while (!q.isEmpty()) {
            int now = q.remove();
            for (int next : new int[]{now*2, now-1, now+1}) {
                if (next >= 0 && next < MAX) {
                    if (c[next] == false) { //방문 안했다면
                        c[next] = true; //방문 했다고 바꾸기
                        if (now*2 == next) { //가중치가 0인 경우
                            q.add(next); //현재 큐에 넣기
                            d[next] = d[now]; //가중치 0
                        } else {
                            next_queue.add(next);//다음 큐에 넣기
                            d[next] = d[now] + 1;//가중치 1
                        }                    
                    }
                }  
            }
            if (q.isEmpty()) {
                q = next_queue; //다음큐 -> 현재 큐
                next_queue = new LinkedList<Integer>();
            }
        }
        //수빈이가 동생을 찾는 가장 빠른 시간을 출력
        System.out.println(d[m]);
    }
}