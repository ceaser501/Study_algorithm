package Programmers.Level1.Budget;

// 예산
import java.util.*;
public class Main {

  public int solution(int[] d, int budget) {
    int answer = 0;

    Arrays.sort(d);
    int sum = 0;

    for(int i : d){
      sum += i;
      if(sum > budget) return answer;
      answer++;
    }

    return answer;
  }

  public static void main(String args[]){
    Main T = new Main();
    System.out.println(T.solution(new int[]{1,3,2,5,4}, 9));
  }
}
