package Sorting_Searching.Searching_6_9_DecisionAlgorithm;

// 결정알고리즘_뮤직비디오
/**
 * 결정알고리즘 : 답을 가정하고 답이 유효한지 확인하면서 이분검색으로 답을 좁혀나가면서 최적의 답을 찾아가는 알고리즘을 말함
 * 이분검색 : 결정알고리즘 구현을 위한 검색방법. middle 값을 답으로 가정하여, 한쪽 사이드 범위를 배제하는 방법을 통한 고속탐색 방법
 */

import java.util.*;

public class Main {

  public int check(int[] arr, int size){
    int count = 1;
    int sum = 0;
    for(int n : arr){
      if(sum + n <= size) sum += n;     // sum에 n을 더한 값이 size보다 작다면, sum에 n을 더한다
      else{                             // sum에 n을 더했더니 size보다 크다면, 장수를 늘려야 한다
        count++;                        // 장수++
        sum = n;                        // 늘린 장수에는 최초 n의 크기를 넣어준다 (계속 장수 연산을 위해)
      }
    }

    return count;
  }


  /**
   * 풀이 포인트
   * DVD의 각 장의 크기는 같고, 총 N개의 곡을 M장에 연속되도록 나눠 담는다
   * DVD 한 장의 최소 크기 용량을 구하는 문제이다
   *
   * n : 9, m : 3
   * arr : 1 2 3 4 5 6 7 8 9
   *
   * 위 예제에서 한 장의 DVD에 담을 수 있는 가장 작은 용량은 9이다
   * 9보다 작다면, 마지막 9분 곡은 담을 수가 없기 때문이다
   *
   * 반대로 가장 큰 용량은 모든 곡의 분을 합친 45가 된다
   *
   * 그 다음 이분검색 방법을 사용해서, mid 를 구하고 최소 크기 용량이라고 가정한다
   * check() 메서드에 해당 arr과 최소크기 용량 size를 넘긴 후, 몇 장에 담기는지 확인한다
   * 최소 m (3) 장에 나누어 담기는지 확인하고, 가능하다면 answer에 세팅한다
   *
   * 이분검색을 이용하여 lt가 rt와 같아질 때까지 while 문으로 돌리며, answer에 mid 를 좁혀가며 세팅한다
   */
  public int solution(int m, int[] arr){
    int answer = 0;

    int sum = Arrays.stream(arr).sum();               // stream 제공 메서드를 통해 큰 데이터로부터 의미있는 값을 뽑기 위해 사용한다. 이것을 reduction이라 한다. (예: max, min, sum)
    int max = Arrays.stream(arr).max().getAsInt();    // 엔드 메소드인 sum()과 다르게 미드 메소드인 max()는 OptionalInt 로 반환되므로, getAsInt()로 캐스팅 해주어야 한다

    int lt=max, rt = sum;
    while(lt <= rt){                                  // lt <= rt 될 때까지
      int mid = (lt+rt)/2;

      if(check(arr, mid) <= m){                       // check() 메소드의 결과가 m 보다 작거나 같다면, (나누고자 하는 장수가 m이다)
        rt = mid-1;                                   // 범위를 좁히기 위해 rt는 mid-1로 넣는다
        answer = mid;                                 // 일단은 m 의 범위로 count가 집계되기 때문에 answer에 일단 mid를 담는다
      }else lt = mid+1;                               // m을 초과한다면, 더 많은 장수로 쪼개진다는 의미기 때문에 size를 늘려줘야 하므로 lt를 mid+1로 세팅한다
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

    System.out.println(T.solution(m, arr));
  }
}
