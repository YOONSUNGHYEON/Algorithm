import java.util.*;
public class Main {
    static int[] cnt = new int[10]; //cnt[i] : 수 i를 사용한 횟수
    static StringBuilder go(int index, int selected, int n, int m) {
        if (selected == m) {//선택한 수가 m개가 되었을때 return
            StringBuilder sb = new StringBuilder();
            for (int i=1; i<=n; i++) {
                for (int j=1; j<=cnt[i]; j++) {
                    sb.append(i);
                    sb.append(" ");
                }
            }
            sb.append("\n");
            return sb;
        }
        StringBuilder ans = new StringBuilder();
        if (index > n) return ans;//더이상 선택할 수가 없을 경우
        //수를 사용하는 경우
        for (int i=m-selected; i>=1; i--) { //거꾸로 i가 시작하는 이유->사전순 정의 때문에
            cnt[index] = i;
            ans.append(go(index+1, selected+i, n, m));
        }
        cnt[index] = 0;
        //수를 사용하지 않는 경우
        ans.append(go(index+1, selected, n, m));
        return ans;
    }   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.print(go(1, 0, n, m));
    }
}