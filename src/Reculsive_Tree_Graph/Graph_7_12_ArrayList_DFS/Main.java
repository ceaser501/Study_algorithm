package Reculsive_Tree_Graph.Graph_7_12_ArrayList_DFS;

// 7_11 인접 행렬로는 10000개 이상의 정점을 갖는 다면 풀어내기가 어렵다 (복잡도도 높다)
// >> 정점의 개수가 많을때는 인접 행렬보다는 arrayList를 활용하자!!
// 경로탐색_인접리스트
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
    static ArrayList<ArrayList<Integer>> graph;             // 각 노드가 갈 수 있는 다른 노드들을 ArrayList에 add해서, 그 ArrayList의 SET을 graph에 담는다
    static int[] ch;
    public void DFS(int v){     // 출발점
        if(v==n) answer++;
        else{
            for(int nv : graph.get(v)){     // v번 arraylist를 가져와, 그 안의 element를 nv로 꺼낸다
                if(ch[nv] == 0){
                    ch[nv] = 1;
                    DFS(nv);
                    ch[nv] = 0;
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
        for(int i=0; i<=n; i++){                            // 노드의 수 만큼 arraylist를 생성해서 graph에 담는다
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            int a = kb.nextInt();
            int b = kb.nextInt();

            graph.get(a).add(b);                            // 1번 노드로 갈 수 있는 다른 노드들 (b)를 입력받아 1번 arraylist 안에 add한다 (2,3,4,5동일)
        }

        ch = new int[n+1];
        ch[1] = 1;        // 초기 값은 1로 세팅하고 시작
        T.DFS(1);
        System.out.println(answer);
    }
}
