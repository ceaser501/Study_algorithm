package Efficiency_3_4_ContinuousSubsequence;

// 효율성_연속부분수열
import java.util.*;

public class Main {

    public int solution(int n, int m, int[] arr){
      int answer = 0, lt = 0, sum = 0;
      for(int rt=0; rt<n; rt++){
          sum += arr[rt];                       // rt를 계속 ++ 이동하면서 sum에 더해준다
          if(sum == m) answer++;                // sum이 m이라면 answer++
          while(sum >= m){
              sum-=arr[lt];                     // 만약 sum이 m보다 크거나 같다면, 맨 앞 arr[lt]를 빼줘야 한다
              lt++;                             // lt++를 하나 옆으로 넘긴다
              if(sum == m) answer++;            // 빼고도 m과 같을 수 있으므로 체크 해 줘야 한다
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
