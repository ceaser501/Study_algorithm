package Reculsive_Tree_Graph.GraphShortestDistance_BFS_Level;

import java.util.*;

public class Main{

    static int[] ch;
    static int n, m;
    static int[][] mat;
    static int[] vertexLevel;
    Queue<Integer> Q = new LinkedList<>();
    public static void main(String args[]) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        ch = new int[n + 1];
        mat = new int[n + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            mat[a][b] = 1;
        }

        vertexLevel = new int[n + 1];

        T.Solution();

        for (int i = 2; i <= n; i++) {
            System.out.println(i + " : " + vertexLevel[i]);
        }
    }

    private void Solution() {
        int level = 0;
        Q.offer(1);
        ch[1] = 1;
        while (!Q.isEmpty()) {
            int size = Q.size();
            for (int i = 0; i < size; i++) { // 큐 안의 개수만큼
                int x = Q.poll();
                vertexLevel[x] = level;
                for (int j = 1; j <= n; j++) {
                    if (ch[j] == 0 && mat[x][j] == 1) {
                        ch[j] = 1;
                        Q.offer(j);
                    }
                }
            }
            level++;
        }
    }
}