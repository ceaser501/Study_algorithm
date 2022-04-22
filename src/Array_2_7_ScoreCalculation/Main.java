package Array_2_7_ScoreCalculation;

// 배열_점수계산
import java.util.*;

public class Main {

  public int solution(int num, int[] array){
    int answer = 0;
    int cnt = 0;

    for(int i=0; i<num; i++){
      if(array[i] == 0) cnt = 0;
      else cnt++;

      answer+=cnt;
    }
    return answer;
  }

  public static void main(String args[]){
    Main T = new Main();
    Scanner kb = new Scanner(System.in);
    int num = kb.nextInt();

    int[] array = new int[num];
    for(int i=0; i<array.length; i++){
      array[i] = kb.nextInt();
    }

    System.out.println(T.solution(num, array));
  }
}
