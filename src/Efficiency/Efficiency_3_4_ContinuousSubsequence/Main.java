package Efficiency.Efficiency_3_4_ContinuousSubsequence;

// 효율성_연속부분수열
import java.util.*;

public class Main {

    public int solution(int n, int m, int[] arr){
        int answer = 0;

        int sum = 0;                    // 합계
        int k = 0;
        for(int i=0; i<n; i++){
            sum += arr[i];

            if(sum > m){          // 합계가 합이되는 수 m보다 크다면,
                sum -= arr[k];
                k++;
            }

            if(sum == m){
                answer++;
                k++;
            }
        }
        return answer;
    }


    public static void main(String args[]){
        Main T = new Main();

        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();           // 대상 요소의 수
        int m = kb.nextInt();           // 합이 되는 수

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = kb.nextInt();
        }

        System.out.println(T.solution(n, m, arr));
    }
}
