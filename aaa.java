import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
	static class Info {
		int id;
		int time;
		int grade;

		public Info(int id, int time, int grade) {
			this.id = id;
			this.time = time;
			this.grade = grade;

		}


	}

	public static void main(String[] args) throws IOException {
		int[] t = { 1, 1, 2, 2 }; // 손님 도착 시각
		int[] r = { 1, 1, 2, 2 }; // 손님의 등급
		// 정답 : 0,1,3,2
		ArrayList<Info> info_list = new ArrayList<>();
		 int[] answer = new int[t.length];
		for(int i=0;i<t.length;i++)
		{
			info_list.add(new Info(i,t[i], r[i]));
		}
        Collections.sort(info_list, new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if (o1.time < o2.time) return -1;
                if (o1.time > o2.time) return 1;
				return 0;
            }
        });

        Collections.sort(info_list, new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if(o1.time == o2.time)
                {

                	 if (o1.grade<o2.grade) {
                     	return -1;
                     }
                     if (o1.grade>o2.grade) {
                     	o1.time++;
                     	return 1;
                     }
                     if (o1.grade==o2.grade) {
                      	return o1.id-o2.id;
                      }
                }


                return 0;
            }
        });
        for(Info info: info_list)
		{
			System.out.println(info.id+" "+info.time+":"+info.grade);
		}

	}

}
