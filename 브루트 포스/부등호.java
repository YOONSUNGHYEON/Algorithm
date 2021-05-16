import java.util.*;

public class Main {
	static int n;
	static char[] a = new char[20];
	static ArrayList<String> ans = new ArrayList<>();
	static boolean[] check = new boolean[10];

	//두 숫자가 부등호 관계가 맞으면  true 아니면 false
	static boolean good(char x, char y, char op) {
		if (op == '<') {
			if (x > y)
				return false;
		}
		if (op == '>') {
			if (x < y)
				return false;
		}
		return true;
	}

	static void go(int index, String num) {
        if (index == n+1) { //끝까지 수 선택
             ans.add(num);//최소최대는 나중에 검사
             return;
        }
        for (int i=0; i<=9; i++) {
        	 if (check[i]) continue;
        	 //대소관계 조건
        	 //index == 0일때는 대소관계 검사 안해도 됨
             if (index == 0 || good(num.charAt(index-1), (char)(i+'0'), a[index-1])) {
                 check[i] = true;
                 go(index+1, num+Integer.toString(i));
                 check[i] = false;
        }
    }

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			a[i] = sc.next().toCharArray()[0];
		}
		go(0, "");
		Collections.sort(ans);
		int m = ans.size();
		System.out.println(ans.get(m - 1));
		System.out.println(ans.get(0));
	}
}