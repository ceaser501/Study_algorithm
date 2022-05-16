package DFS_BFS.DFS_8_6;

import java.util.*;

public class Main {

    static int n, m = 0;
    static int[] arr, ch, pm;
    public void DFS(int L){
        if(L == m){
            for(int x : pm) System.out.print(x + " ");
            System.out.println();
        }else{
            for(int i=0; i<n; i++){
                if(ch[i] == 0){         // 해당 위치 상태 체크 0
                    ch[i] = 1;          // arr i위치 사용했으므로 1
                    pm[L] = arr[i];
                    DFS(L+1);
                    ch[i] = 0;
                }
            }
        }
    }
    public static void main(String args[]){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();           // 조합 개수
        m = kb.nextInt();           // 출력 자리수
        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = kb.nextInt();
        }

        ch = new int[n];        // 상태체크 배열
        pm = new int[m];        // 출력 배열

        T.DFS(0);
    }
}
