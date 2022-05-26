package Programmers.Level1.InsufficientAmount;

// 부족한 금액 계산하기
public class Main{

  public long solution(int price, int money, int count) {
    long answer = money;

    for(int i=1; i<=count; i++){
      answer -= (price * i);
    }


    return answer > 0 ? 0 : answer * -1;
  }


  public static void main(String args[]){
    Main T = new Main();

    System.out.println(T.solution(3, 20, 4));
  }
}
