package Array.Array_2_5_PrimeNumber;

// 배열_소수(에라토스테네스 체)
import java.util.Scanner;

public class Main {
    public int solution(int num){
        int answer = 0;

        /**
         * 소수 에라토스테네스의 체는,
         * 1은 제외하고 2부터 정해진 숫자만큼 돌면서 초기 0값이 유지되는 것의 count를 ++ 해서 return 하면 된다
         * 단, 2를 체크하고나면 2의 배수는 지워줘야 하기 때문에, 2부터 2씩 더한 (j=i+j) index는 1로 바꿔주면 된다
         * 2의 배수를 지우고, 3의 배수를 지우고, 4의배수를 지우고 하는 방식으로 지워나가는 것을 에라토스테네스 체 라고 한다
          */


        int[] iArray = new int[num+1];

        for(int i=2; i<=num; i++){
            if(iArray[i] == 0){
                answer++;
                for(int j=i; j<=num; j=i+j) iArray[j] = 1;
            }
        }

        return answer;
    }

    // 에라토스테네스의 체 적용해서 소수인지 체크하는 func
    public boolean isPrime1(int num) {
        if(num == 1 || num == 0) {
            // 1과 0은 소수에서 제외되니 false처리
            return false;
        }

        //⭐⭐ 소수를 찾을때는 에라토스테네스의 체의 limit을 계산한다.
        // 소수인지 확인하려고 하는 값의 제곱근을 구한다. => Math.sqrt(number)
        int limit = (int) Math.sqrt(num);

        // 에라토스테네스의 체에 따라 limit까지만 배수 여부를 확인한다.
        for(int i=2; i<=limit; i++) {
            if(num % i == 0) {
                return false;
            }
        }

        return true;
    }


    public static void main(String args[]){
        Main T = new Main();

        Scanner kb = new Scanner(System.in);
        int num = kb.nextInt();

        System.out.println(T.solution(num));
    }
}
