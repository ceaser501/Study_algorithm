package Programmers.Level1.Distinct;


import java.util.ArrayList;

// 같은 숫자는 싫어
public class Main {

  public int[] solution(int []arr) {
    ArrayList<Integer> answer = new ArrayList();

    answer.add(arr[0]);
    int curr = arr[0];
    for(int i=1; i<arr.length; i++){
      if(arr[i] != curr){
        answer.add(arr[i]);
        curr = arr[i];
      }
    }

    return answer.stream().mapToInt(Integer::intValue).toArray();
  }

  public static void main(String args[]){
    Main T = new Main();

    for (int i : T.solution(new int[]{1, 1, 3, 3, 0, 1, 1})) {
      System.out.print(i + " ");
    }
    System.out.println();
    for (int i : T.solution(new int[]{4,4,4,3,3})) {
      System.out.print(i + " ");
    }
  }
}
