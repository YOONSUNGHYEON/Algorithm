import java.util.*;
public class Main {
    static int[] a = new int[10];
    static boolean[] c = new boolean[10];
    //이 함수 역할 : 수 index를 선택할지 안할지 결정해야함
    static void go(int index, int selected, int n, int m) {
    	//index : 숫자
    	//selected : 선택한 수의 개수
        if (selected == m) { //선택한 수가 m개가 되었을때 return
            for (int i=0; i<m; i++) {
                System.out.print(a[i]);
                if (i != m-1) System.out.print(' ');
            }
            System.out.println();
            return;
        }
        if (index > n) return; //더이상 선택할 수가 없을 경우
        //선택했을 경우
        a[selected] = index; // 선택한 자리에 index를 넣기
        go(index+1, selected+1, n, m); //선택 했으므로 selected와 index 증가
        //선택하지 않았을 경우
        a[selected] = 0;
        go(index+1, selected, n, m);
    }   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        go(1, 0, n, m);
    }
}