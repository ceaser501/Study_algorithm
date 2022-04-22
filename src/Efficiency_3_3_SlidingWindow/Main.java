package Efficiency_3_3_SlidingWindow;

// 효율성_최대매출 (SlidingWindow)
import java.util.*;

public class Main {
  public int solution(int n, int k, int[] arr){
    int answer = 0;
    int sum = 0;        // SlidingWindow 합계 저장 변수

    for(int i=0; i<k; i++){
      sum += arr[i];    // 0 ~ k-1 까지의 최초 SlidingWindow 합계 값 sum 변수에 저장
    }
    answer = sum;       // 일단 결과 값에 sum 세팅

    for(int i=k; i<n; i++){
      // sliding window가 오른쪽으로 한칸 이동
      sum += arr[i] - arr[i-k];       // 다음 번에 들어올 i 번째 arr[i]를 더하고, 맨앞 i-k 번째 arr[i-k]를 sum에서 빼 준다
      answer = Math.max(answer, sum); // 현재 answer와 새롭게 한칸 이동한 sliding window의 합 중에 큰 것을 answer에 교체한다
    }

    return answer;
  }


  public static void main(String args[]){
    Main T = new Main();

    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    int k = kb.nextInt();
    int arr[] = new int[n];

    for(int i=0; i<n; i++){
      arr[i] = kb.nextInt();
    }

    System.out.println(T.solution(n, k, arr));
  }
}
