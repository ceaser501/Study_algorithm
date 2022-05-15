// 10. 가장짧은 문자거리
import java.util.*;

public class Main{

    public int[] solution(char c, String str){
        int[] answer = new int[str.length()];

        int dist = 1000;
        char[] ch = str.toCharArray();

        // 정방향
        for(int i=0; i<ch.length; i++){
            if(ch[i] == c) dist = 0;
            else dist++;

            answer[i] = dist;
        }

        // 역방향
        dist = 1000;
        for(int j=ch.length-1; j>=0; j--){
            if(ch[j] == c) dist = 0;
            else{
                dist++;
                answer[j] = Math.min(answer[j], dist);
            }
        }
        return answer;
    }

    public static void main(String args[]){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0);

        for(int x : T.solution(c, str)) System.out.print(x + " ");
    }
}