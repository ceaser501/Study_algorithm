package Sorting_Searching.Sorting_6_2_Bubble_Sort;

// 정렬_버블정렬
/**
 * [버블정렬]
 * 인접한 데이터를 비교하면서 검색 (비교정렬)
 * 정렬의 대상이 되는 데이터 외에 추가적인 공간을 필요로 하지 않음 (제자리정렬)
 * 앞에서부터 차례로 비교함 (안정정렬)
 *
 * [정렬방법]
 * 1. 앞에서부터 현재 원소와 바로 다음의 원소를 비교한다
 * 2. 현재 원소가 다음원소보다 크면 원소를 교환한다
 * 3. 다음 원소로 이동하여 해당 원소와 그 다음 원소를 비교한다
 */

import java.util.Scanner;

public class Main {

  public int[] solution(int n, int[] arr){

    for(int i=0; i<n-1; i++){
      for(int j=0; j<n-i-1; j++){
        if(arr[j] > arr[j+1]){
          int temp = arr[j+1];
          arr[j+1] = arr[j];
          arr[j] = temp;
        }
      }
    }

    return arr;
  }


  public static void main(String args[]){
    Main T = new Main();

    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    int[] arr = new int[n];
    for(int i=0; i<n; i++){
      arr[i] = kb.nextInt();
    }

    for(int m : T.solution(n, arr)) System.out.print(m + " ");
  }
}
