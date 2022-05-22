package Programmers.Level1.SumOfDivisor;

// 약수의 개수와 덧셈
public class Main {

  public int solution(int left, int right) {
    int answer = 0;

    for(int num=left; num<=right; num++){
      // 약수의 개수가 짝수인 경우 더하고, 홀수인 경우 뺀다
      answer += num * (countDivisor(num) % 2 == 0 ? 1 : -1);
    }

    return answer;
  }

  // 약수의 개수 리턴 함수
  public int countDivisor(int num){
    int count = 1;            // 약수의 개수 (본인은 항상 포함)
    for(int divisor=1; divisor<num; divisor++){
      if(num % divisor == 0) count++;
    }

    return count;
  }

  // 제곱수를 이용한 방법
  // 제곱수는 항상 약수의 개수가 홀수다 (짝이 되지 않고 자신의 제곱이 약수이므로)
  // 쩐다................ 제곱수 구하는 메서드 .sqrt()를 알고 있다면 간단하게 풀 수 있다
  public int solution2(int left, int right) {
    int answer = 0;

    for (int i=left;i<=right;i++) {
      //제곱수인 경우 약수의 개수가 홀수
      if (i % Math.sqrt(i) == 0) {
        answer -= i;
      }
      //제곱수가 아닌 경우 약수의 개수가 짝수
      else {
        answer += i;
      }
    }

    return answer;
  }

  public static void main(String args[]){
    Main T = new Main();
    System.out.println(T.solution(13, 17));
    System.out.println(T.solution(24, 27));
    System.out.println(T.solution(1, 2));
    System.out.println(T.solution(1, 3));
  }
}
