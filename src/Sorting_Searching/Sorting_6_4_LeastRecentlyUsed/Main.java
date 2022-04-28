package Sorting_Searching.Sorting_6_4_LeastRecentlyUsed;

// 정렬_Least Recently Used
/**
 * ArrayList set 으로 특정 값을 대체하는 방법이 아닌, 로직을 세워서 짜보자
 */

import java.util.*;

public class Main {

  public int[] solution(int size, int n, int[] arr){
    int[] cache = new int[size];

    for(int x : arr){
      int pos = -1;       // 캐시 미스인지 캐시 히트인지 확인을 위한 변수
      for(int i=0; i<size; i++)  if(x==cache[i]) pos = i; // 기존 cache 배열에 있다면, pos에 해당 index를 넣음
      if(pos == -1){      // pos 가 -1이라면 (캐시 미스)
        for(int i=size-1; i>=1; i--){   // 전체 arr길이-1부터 1까지 값 복사
          cache[i] = cache[i-1];
        }
      }else{              // 캐시 히트
        for(int i=pos; i>=1; i--){    // 히트된 index부터 1까지 값 복사
          cache[i] = cache[i-1];
        }
      }
      cache[0] = x;       // 최초 값을 0 index에 추가
    }

    return cache;
  }


  public static void main(String args[]){
    Main T = new Main();

    Scanner kb = new Scanner(System.in);
    int size = kb.nextInt();
    int n = kb.nextInt();
    int[] arr = new int[n];
    for(int i=0; i<n; i++) arr[i] = kb.nextInt();

    for (int m : T.solution(size, n, arr)) {
      System.out.print(m + " ");
    }
  }
}
