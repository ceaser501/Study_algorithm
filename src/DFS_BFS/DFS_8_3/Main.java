package DFS_BFS.DFS_8_3;

//5 20
//        10 5
//        25 12
//        15 8
//        6 3
//        7 4

// 최대점수 구하기(DFS)
import java.util.*;

public class Main {
    static int m, n, answer = 0;
    public void DFS(int L, int sum, int[] score, int totalTime, int[] time){
        if(totalTime > m) return;
        if(L == n){
           answer = Math.max(answer, sum);
        }else{
           DFS(L+1, sum + score[L], score, totalTime + time[L], time);
           DFS(L+1, sum, score, totalTime, time);
        }
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();   // 문제수
        m = kb.nextInt();   // 제한시간         // ???????? 왜 n과 m 바꾸면안됌? 앞에문제에서도 그럼
        int[] score = new int[n];
        int[] time = new int[n];
        for(int i=0; i<n; i++){
            score[i] = kb.nextInt();
            time[i] = kb.nextInt();
        }
        T.DFS(0, 0, score, 0, time);
        System.out.println(answer);
    }
}