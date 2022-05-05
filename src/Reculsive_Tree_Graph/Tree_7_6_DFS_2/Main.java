package Reculsive_Tree_Graph.Tree_7_6_DFS_2;

// DFS_부분집합 구하기

/**
 * 입력 : 3
 * 출력 : 공집합을 제외한 부분집합을 출력
 * 1 2 3
 * 1 2
 * 1 3
 * 1
 * 2 3
 * 2
 * 3
 */
import java.util.*;
public class Main {

    static int n = 0;
    static int[] arr;
    public void DFS(int L){
        if(L == n+1){
            String answer = "";
            for(int i=1; i<=n; i++){
                if(arr[i] == 1) answer += (i + " ");
            }
            if(answer.length() > 0) System.out.println(answer);           // 공집합 제외
       }else{
            arr[L] = 1;
            DFS(L+1);

            arr[L] = 0;
            DFS(L+1);
        }
    }

    public static void main(String args[]){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        arr = new int[n+1];           // 1번 index부터 사용하므로, 마지막 index는 n+1
        T.DFS(1);                  // 최초 root는 1 번 index
    }
}
