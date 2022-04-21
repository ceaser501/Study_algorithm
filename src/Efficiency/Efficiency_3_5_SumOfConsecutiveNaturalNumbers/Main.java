package Efficiency.Efficiency_3_5_SumOfConsecutiveNaturalNumbers;

// 효율성_연속된 자연수의 합
import java.util.*;

public class Main {

    /**
     * 문제
     * 입력 값 : 15, 출력 값 : 3
     * 예)
     * 1 2 3 4 5 = 15
     * 4 5 6 = 15
     * 7 8 = 15
     */

    public int solution(int n){
        int answer = 0;
        int sum = 0, lt = 0;
        /**
         * 최대로 검색해야 하는 값은, 0 부터 2/n + 1 전까지 이고, 2 pointer 알고리즘으로 푼다
         * 가장 크게 조합될 수 있는건 n/2 와 n/2+1 의 합이므로, n/2+1 길이의 arr을 하나 만들고, 값을 넣는다
         * rt 는 0부터 n/2+1 까지 돌게 된다
         *
         * 값을 하나씩 더하며, sum이 n이 되면 answer++
         * sum 이 n 보다 크면, arr[lt] 를 하나씩 sum에서 빼면서 sum이 n과 같거나 작을때까지 돈다
         * 작아지게 되면 다시 for loop를 돌면서 다음 arr[rt] 값을 더하고 반복한다
         */
        int m = n/2 + 1;
        int[] arr = new int[m];
        for(int i=0; i<m; i++) arr[i] = (i+1); // int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};

        for(int rt=0; rt<m; rt++){
            sum += arr[rt];
            if(sum == n) answer++;
            while(sum >= n){
                sum -= arr[lt];
                lt++;
                if(sum == n) answer++;
            }
        }
        return answer;
    }

    public int solution1(int n) {
        int answer = 0, cnt=1;      // cnt는 연속된 숫자의 개수
        /**
         * 수학적인 방법
         * 15를 2개의 연속된 숫자로 나눈다면, 1-2를 세팅하고 15에서 3을 뺀 12를 2등분해서 나누어 떨어지면 된다고 본다
         * 15를 3개의 연속된 숫자로 나눈다면, 1-2-3을 세팅하고 15에서 6을 뺀 9를 3등분해서 나누어 떨어지면 된다고 본다
         * 반복해서 4개의 연속된 숫자, 5개의 연속된 숫자로 해보면 된다
         *
         */

        n--;                        // 1 을 빼고
        while(n>0){
            cnt++;                  // 연속된 숫자이므로, 최소 2개로 나누어본다
            n = n-cnt;              // n에서 1과 2를 빼고 세팅, 이후에 3부터도 마찬가지로 빼고 세팅
            if(n%cnt == 0) answer++;
        }

        return answer;
    };

    public static void main(String args[]){
        Main T = new Main();

        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        System.out.println(T.solution(n));
    }
}
