package Reculsive_Tree_Graph.Reculsive_7_8_FindACalf_BFS;

/**
 * 송아지 찾기 (BFS) - 상태트리검색
 * 현수의 위치 : S, 송아지위치 : E
 * 스카이 콩콩은 앞으로 1, 뒤로1, 앞으로 5 갈 수 있다
 * 직선의 좌표점은 1부터 10,000 까지 이다
 * 점프의 최소 횟수를 구하세요
 *
 * 입력 : 5(현수위치), 14(송아지위치)
 * 출력 : 3
 */

import java.util.*;
public class Main {

  public int BFS(int s, int e){
    int L = 0;
    int[] mv = {1, -1, 5};
    int[] ch = new int[10001];
    ch[s] = 1;                      // ch[5] 에 1 세팅 (들어온 현수 위치 값을 탐색해야 하는지 체크하기 위함)
    Queue<Integer> Q = new LinkedList<>();
    Q.offer(s);                     // 현수 위치를 Q에 offer

    while(!Q.isEmpty()){
      int len = Q.size();
      for(int i=0; i<len; i++){
        int curr = Q.poll();

        for(int j=0; j<mv.length; j++){
          int nx = curr + mv[j];    // 현재 poll 값에 mv 값을 1개씩 더해서 nx 생성
          if(nx == e) return L+1;   // 다음번 값이 return 되는 것이므로 Level + 1
          if(nx >= 1 && nx <= 10000 && ch[nx] == 0){ // 직선의 좌표점은 1~10,000까지이고, 이전에 탐색한 적이 없는 좌표라면,
            ch[j] = 1;            // 신규탐색이므로 1
            Q.offer(nx);          // Q에 nx 추가
          }
        }
      }
      L++;                          // Q 한 사이클을 전부 돌았으므로 Level ++
    }

    return L;
  }

  public static void main(String args[]){
    Main T = new Main();
    Scanner kb = new Scanner(System.in);
    int s = kb.nextInt();
    int e = kb.nextInt();

    System.out.println(T.BFS(s, e));
  }
}
