// 10. 가장짧은 문자거리
import java.util.*;

public class Main{

    public int solution(int[] a, int[] b) {
        int answer = 0;

        for(int i=0; i<a.length; i++){
            answer += (a[i] * b[i]);
        }

        return answer;
    }

    public static void main(String args[]){
        Main T = new Main();
        System.out.print(T.solution(new int[]{1, 2, 3, 4}, new int[]{-3, -1, 0, 2}));
    }
}