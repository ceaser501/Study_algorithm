package DFS_BFS.DFS_8_5;

// 동전교환
/**
 * 3
 * 1 2 5
 * 15
 *
 * 3
 */

import java.util.*;

public class Main {

    static int n, m = 0;
    static int answer = Integer.MAX_VALUE;         // 동전의 개수
    public void DFS(int L, int sum, Integer[] arr){
        if(sum > m) return;
        if(L >= answer) return;
        if(sum == m){
            answer = Math.min(answer, L);
        }else{
            for(int i=0; i<n; i++){
                DFS(L+1, sum + arr[i], arr);
            }
        }
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        Integer[] arr = new Integer[n];
        for(int i=0; i<n; i++){
            arr[i] = kb.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());
        m = kb.nextInt();
        T.DFS(0, 0, arr);
        System.out.println(answer);
    }
}
