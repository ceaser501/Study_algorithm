package Reculsive_Tree_Graph.Graph_7_11_DFS;

// 그래프_인접행렬(DFS)

import java.util.*;

public class Main {

  public void DFS(int v){

  }

  public static void main(String args[]){
    Main T = new Main();

    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    int m = kb.nextInt();

    int[][] arr = new int[n+1][n+1];
    for(int i=0; i<m; i++){
      int a = kb.nextInt();
      int b = kb.nextInt();
      arr[a][b] = 1;
    }

    int[] ch = new int[n+1];
    ch[1] = 1;        // 초기 값은 1로 세팅하고 시작

  }
}
