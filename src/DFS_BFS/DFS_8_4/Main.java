package DFS_BFS.DFS_8_4;

// 중복순열_DFS

import java.util.*;
public class Main {

    static int[] pm;
    static int n, m;
    public void DFS(int L){

        if(L==m){
            for(int x : pm) System.out.print(x + " ");
            System.out.println();
        }else{
            for(int i=1; i<=n; i++){
                pm[L] = i;
                DFS(L+1);
            }
        }

    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();           // 1~n
        m = kb.nextInt();           // 뽑는 횟수
        pm = new int[m];
        T.DFS(0);
    }
}
