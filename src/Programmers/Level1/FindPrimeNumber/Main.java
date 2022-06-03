package Programmers.Level1.FindPrimeNumber;

// 소수찾기_ 에라토스테네스의 체
public class Main {

  public int solution(int n) {
    int answer = 0;

    for(int i=2; i<=n; i++){
      if(isPrime(i)) answer++;
    }

    return answer;
  }

  public boolean isPrime(int n){
    // if(n == 0 || n == 1) return false;

    // 제곱근 구하기
    int limit = (int) Math.sqrt(n);

    // 2부터 제곱근 까지 탐색
    for(int i=2; i<=limit; i++){
      if(n % i == 0) return false;
    }

    return true;
  }

  public static void main(String args[]){
    Main T = new Main();
    System.out.println(T.solution(10));
   // System.out.println(T.solution(5));
  }
}
