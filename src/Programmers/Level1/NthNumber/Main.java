package Programmers.Level1.NthNumber;

// x만큼 간격이 있는 n개의 숫자
public class Main {

  public long[] solution(int x, int n) {
    long[] answer = new long[n];

    long sum = 0;
    for(int i=0; i<answer.length; i++){
      answer[i] = (sum += x);
    }

    return answer;
  }

  public static void main(String args[]){
    Main T = new Main();
    for(long i : T.solution(2, 5)) System.out.print(i + " ");
    System.out.println();
    for(long i : T.solution(4, 3)) System.out.print(i + " ");
    System.out.println();
    for(long i : T.solution(-4, 2)) System.out.print(i + " ");
  }
}
