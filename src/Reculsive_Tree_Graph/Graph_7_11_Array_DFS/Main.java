package Reculsive_Tree_Graph.Graph_7_11_Array_DFS;

// 그래프_인접행렬(DFS)
/**
 * 입력 :
 * 5 9
 * 1 2
 * 1 3
 * 1 4
 * 2 1
 * 2 3
 * 2 5
 * 3 4
 * 4 2
 * 4 5
 *
 * 출력 :
 * 6
 */

import java.util.*;

public class Main {

  static int n, m, answer = 0;
  static int[][] graph;
  static int[] ch;
  public void DFS(int v){     // 출발점

    if(v==n) answer++;
    else{
      for(int i=1; i<=n; i++){
        if(graph[v][i] == 1 && ch[i] == 0){     // ch[i] == 0 이란 뜻은 방문한 적이 없다는 뜻
          ch[i] = 1;                            // 방문 체크
          DFS(i);                               // 하위 노드로 출발점 잡고 이동  (해당 노드가 모두 끝나면 answer++ 이후 back 되면서, 다음라인에서 방문 체크 풀기)
          ch[i] = 0;
        }
      }
    }
  }

  public static void main(String args[]){
    Main T = new Main();

    Scanner kb = new Scanner(System.in);
    n = kb.nextInt();       // 노드 수 : 5
    m = kb.nextInt();       // 간선 수 : 9

    graph = new int[n+1][n+1];    // index 1부터 시작 (노드 1,2,3,4,5)
    for(int i=0; i<m; i++){
      int a = kb.nextInt();             // 5x5 2차원 배열
      int b = kb.nextInt();
      graph[a][b] = 1;
    }

    ch = new int[n+1];
    ch[1] = 1;        // 초기 값은 1로 세팅하고 시작
    T.DFS(1);
    System.out.println(answer);
  }
}
