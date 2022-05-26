package Programmers.Level1.RemoveSmallestNumber;

import java.util.ArrayList;
import java.util.Arrays;

// 제일 작은 수 제거하기
public class Main {

  public int[] solution(int[] arr) {
    // array 정렬
    // 범위 자르기
    Arrays.sort(arr);
    return arr.length == 1 ? new int[]{-1} : Arrays.copyOfRange(arr, 1, arr.length);
  }

  public int[] solution2(int[] arr) {
    if(arr.length == 1) return new int[]{-1};

    // Array 최소값 구하기 -> int로 바꾸기
    // stream filter로 걸러내고, toArray
    int min = Arrays.stream(arr).min().getAsInt();
    return Arrays.stream(arr).filter(n -> n != min).toArray();
  }

  public int[] solution3(int[] arr) {
    int[] answer = new int[arr.length-1];

    if(arr.length == 1) return new int[]{-1};
    else{
      int min = arr[0];
      for(int i=1; i<arr.length; i++){
        if(min > arr[i]){
          min = arr[i];
        }
      }
      int count=0;
      for(int i=0; i<arr.length; i++){
        if(arr[i] != min){
          answer[count++] = arr[i];
        }
      }
    }

    return answer;
  }

  public static void main(String args[]){
    Main T = new Main();

    for(int i : T.solution2(new int[]{4, 3, 2, 1})) System.out.print(i + " ");
    for(int i : T.solution2(new int[]{10})) System.out.print(i + " ");
  }
}
