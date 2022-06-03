package Programmers.Level1.NumberArray;

import java.util.ArrayList;
import java.util.Arrays;

// 나누어 떨어지는 숫자 배열
public class Main {
  public int[] solution(int[] arr, int divisor) {
    ArrayList<Integer> answer = new ArrayList();

    for(int i : arr){
      if(i % divisor == 0) answer.add(i);
    }

    return answer.size() == 0 ? new int[]{-1} : answer.stream().mapToInt(Integer::intValue).sorted().toArray();
  }

  public int[] solution2(int[] arr, int divisor) {

    int[] array = Arrays.stream(arr).filter(i -> i % divisor == 0).sorted().toArray();

    return array.length == 0 ? new int[]{-1} : array;
  }


  public static void main(String args[]){
    Main T = new Main();

    for (int i : T.solution2(new int[]{5, 9, 7, 10}, 5)) {
      System.out.print(i + " ");
    }
//    System.out.println(T.solution(new int[]{5, 9, 7, 10}, 5));
//    System.out.println(T.solution(new int[]{2, 36, 1, 3}, 1));
    for (int i : T.solution2(new int[]{3,2,6}, 10)) {
      System.out.print(i + " ");
    }
  }
}
