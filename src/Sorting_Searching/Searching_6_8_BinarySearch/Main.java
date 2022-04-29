package Sorting_Searching.Searching_6_8_BinarySearch;

// 검색_이분검색
/**
 * https://minhamina.tistory.com/127
 *
 * 이진탐색 = 이분탐색 (Binary Search)
 * 정렬된 배열 또는 리스트에 적합한 고속 탐색 방법
 *
 * [특징]
 * 1. 배열의 중앙에 있는 값을 조사하여, 찾고자 하는 항목이 왼쪽 또는 오른쪽 배열에 있는지 알아내어 탐색의 범위를 반으로 줄인다
 * 2. 찾고자 하는 값이 속해있지 않은 부분은 전혀 고려할 필요가 없으므로, 검색할 리스트 크기를 반으로 줄일 수 있다
 * 3. 데이터의 삽입이나 삭제가 빈번할 때에 적합하지 않고, 고정된 데이터에 대한 탐색에 적합하다
 *
 * [탐색방법]
 * 1. 탐색 시작값 low와 종료값 high 사이의 중간값 mid는 (low+high)/2 로 구한다
 * 2. arr[mid] 과 구하고자 하는 key 값을 비교한다
 * 3. 1) key가 arr[mid] 와 같다면 바로 return한다
 *    2) key가 arr[mid] 보다 크다면, low를 mid+1로 만들고 loop 반복한다
 *    3) key가 arr[mid] 보다 작다면, high를 mid-1로 만들고 loop 반복한다
 *
 * [복잡도]
 * log2n 이 되므로, 시간 복잡도는 O(log n)이 된다
 **/

import java.util.*;

public class Main {

  public int solution(int n, int m, int[] arr){
    int answer = 0;

    Arrays.sort(arr);
    int lt = 0;
    int rt = n-1;
    while(lt <= rt){
      int mid = (rt+lt) / 2;

      if(arr[mid] == m) return mid+1;
      else if(arr[mid] > m) rt = mid-1;
      else lt = mid+1;
    }

    return answer;
  }


  public static void main(String args[]){
    Main T = new Main();

    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    int m = kb.nextInt();

    int[] arr = new int[n];
    for(int i=0; i<n; i++) arr[i] = kb.nextInt();

    System.out.println(T.solution(n, m, arr));
  }
}
