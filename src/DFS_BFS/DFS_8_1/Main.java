package DFS_BFS.DFS_8_1;

// BFS활용_서로소 (두 부분집합으로 나누었을때, 부분집합끼리의 합이 같은 케이스가 있는가?)
import java.util.*;
public class Main {

  static String answer = "NO";
  static int n, total = 0;
  static boolean flag = false;
  public void DFS(int L, int sum, int[] arr){
    if(flag) return;
    if((total/2) < sum) return;
    if(L == n){     // 레벨이 입력한 것과 같으면, 부분집합 만들기 끝
      if((total-sum) == sum){   // total / 2 == sum 도 가능
        answer = "YES";
        flag = true;
      }
    }else{
      DFS(L+1, sum + arr[L], arr);
      DFS(L+1, sum, arr);
    }
  }

  public static void main(String args[]){
    Main T = new Main();
    Scanner kb = new Scanner(System.in);
    n = kb.nextInt();
    int arr[] = new int[n];
    for(int i=0; i<n; i++){
      arr[i] = kb.nextInt();
      total += arr[i];      // 전체 합
    }

    T.DFS(0, 0, arr);
    System.out.println(answer);
  }
}
