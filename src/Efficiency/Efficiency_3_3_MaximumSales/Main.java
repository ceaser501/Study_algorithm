package Efficiency.Efficiency_3_3_MaximumSales;

// 효율성_최대매출
import java.util.*;

public class Main {

  public int solution(int day, int findDay, int[] sales){
    int answer = 0;

    int max = 0;
    for(int i=0; i<=day-findDay; i++){
      int sum = 0;
      for(int j=i; j<i+findDay; j++){
        sum += sales[j];
      }

      if(sum > max){
        max = sum;
        answer = sum;
      }
    }

    return answer;
  }

  public int solution1(int day, int findDay, int[] sales){
    int answer = 0;


    return answer;
  }


  public static void main(String args[]){
    Main T = new Main();

    Scanner kb = new Scanner(System.in);
    int day = kb.nextInt();
    int findDay = kb.nextInt();

    int[] sales = new int[day];
    for(int i=0; i<day; i++){
      sales[i] = kb.nextInt();
    }

    System.out.println(T.solution(day, findDay, sales));
  }
}
