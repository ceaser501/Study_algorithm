package Reculsive_Tree_Graph.Graph_7_13_GraphShortestDistance_BFS;
/**
 * 입력 :
 * 6 9
 * 1 3
 * 1 4
 * 2 1
 * 2 5
 * 3 4
 * 4 5
 * 4 6
 * 6 2
 * 6 5
 *
 * 출력 :
 * 6
 */

import java.util.*;

public class Main {
    static int n, m = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    static int[] dis;           // 최소 이동 간선수 저장 array
    public void DFS(int v){     // 출발점
        Queue<Integer> queue = new LinkedList<>();
        ch[v] = 1;
        dis[v] = 0;
        queue.offer(v);
        while(!queue.isEmpty()){
            int cv = queue.poll();
            for(int nv : graph.get(cv)){    // 이미 nv는 cv에서 갈 수 있는 인접 리스트를 말함. 즉 ch만 0인지 체크하면 됌
                if(ch[nv] == 0){
                    ch[nv] = 1;
                    queue.offer(nv);
                    dis[nv] = dis[cv] + 1;
                }
            }
        }
    }

    public static void main(String args[]){
        Main T = new Main();

        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();       // 노드 수 : 5
        m = kb.nextInt();       // 간선 수 : 9

        graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            int a = kb.nextInt();
            int b = kb.nextInt();

            graph.get(a).add(b);
        }

        ch = new int[n+1];
        dis = new int[n+1];
        ch[1] = 1;        // 초기 값은 1로 세팅하고 시작
        T.DFS(1);
        for(int i=2; i<=n; i++){
            System.out.println(i + " : " + dis[i]);
        }
    }
}
