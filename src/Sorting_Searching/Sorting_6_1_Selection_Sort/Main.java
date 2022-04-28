package Sorting_Searching.Sorting_6_1_Selection_Sort;

// 정렬_선택정렬
/**
 * [선택정렬]
 *  1. 주어진 리스트에서 최소값을 구한다
 *  2. 최솟 값을 맨 앞자리의 값과 교환한다
 *  3. 맨 앞 자리를 제외한 나머지 값들을 탐색하며 최솟값을 찾아 위와 같은 방법으로 반복한다
 *
 * [특징]
 * 1. 시간복잡도 : O(N2)
 * 2. 안정정렬이 아니다
 */

import java.util.Scanner;

public class Main {

  public int[] solution(int n, int[] arr){
    for(int i=0; i<n-1; i++) {
      int idx = i;                        // 맨 앞 index를 최소값을 의미하는 idx에 넣는다
      for(int j=i+1; j<n; j++){           // j는 i다음번부터 끝까지 돌린다
        if(arr[j] < arr[idx]) idx = j;    // arr[j]는 arr[최소인덱스] 보다 작다면, j가 더 작은 값이므로 idx = j로 바꾼다
      }

      int temp = arr[i];                  // 현재 arr[i]와 arr[idx]를 교체한다 -> 맨 앞에 최소 값 arr[i]이 세팅된다
      arr[i] = arr[idx];
      arr[idx] = temp;
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
