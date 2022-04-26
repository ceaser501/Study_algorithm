package Efficiency.Efficiency_3_6_MaximumLengthContinuousSubsequence;

// 효율성_최대 길이 연속부분수열
import java.util.*;

public class Main {

    public int solution(int n, int k, int[] arr){
        int answer = 0;
        int cnt = 0;            // 0을 1로 바꾼 횟수
        int lt = 0;

        for(int rt=0; rt<n; rt++){
            if(arr[rt] == 0) cnt++;              // rt가 0을 만나면 1로 바꾸고, cnt++
            while(cnt > k) {                     // rt가 0 -> 1로 바꾸는 횟수가 k보다 크면 lt가 따라오면서 보정
                if(arr[lt] == 0) cnt--;
                lt++;
            }

            answer = Math.max(answer, rt-lt+1);     // 길이는 rt - lt + 1 (0부터 시작이므로)
        }
        return answer;
    }


    public static void main(String args[]){
        Main T = new Main();

        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();   // 수열 길이
        int k = kb.nextInt();   // 0을 1로 변경할 수 있는 횟수

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = kb.nextInt();
        }

        System.out.println(T.solution(n, k, arr));
    }
}
