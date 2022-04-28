package Sorting_Searching.Sorting_6_3_Insertion_Sort;

// 정렬_삽입정렬
/**
 * [삽입정렬]
 * 비교하고자 하는 target(타겟)과 그 이전의 원소들과 비교하여 자리를 교환(Swap)하는 정렬
 * 인접한 데이터를 비교하면서 검색 (비교정렬)
 * 정렬의 대상이 되는 데이터 외에 추가적인 공간을 필요로 하지 않음 (제자리정렬)
 * 앞에서부터 차례로 비교함 (안정정렬)
 *
 * [정렬방법]
 * 1. 현재 타겟이 되는 숫자와 이전 위치에 있는 원소들을 비교한다 (첫번째 타겟은 두번째 원소부터 시작)
 * 2. 타겟이 되는 숫자가 이전 위치에 있던 원소보다 작다면 위치를 서로 교환한다
 * 3. 그 다음 타겟을 찾아 위와 같은 방법으로 반복한다
 */

import java.util.*;

public class Main {

  public int[] solution(int n, int[] arr){
    for(int i=1; i<n; i++){
      for(int j=i; j>0; j--){
        if(arr[j] < arr[j-1]){
          int temp = arr[j];
          arr[j] = arr[j-1];
          arr[j-1] = temp;
        }
      }
    }
    return arr;
  }

  public int[] solution1(int n, int[] arr){
    for(int i=1; i<n; i++){
      int tmp = arr[i], j;
      for(j=i-1; j>=0; j--){
        if(arr[j] > tmp) arr[j+1] = arr[j];
        else break;
      }
      arr[j+1] = tmp;
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

    for(int m : T.solution1(n, arr)) System.out.print(m + " ");
  }
}
