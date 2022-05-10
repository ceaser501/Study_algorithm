package DFS_BFS.DFS_8_2;

// 바둑이 승차
import java.util.*;
public class Main {

  static int w, n, answer = 0;
  public void DFS(int L, int sum, int[] arr){
    if(sum > w){

    }else{
      DFS(L+1, sum+arr[L], arr);
    }
    
  }

  public static void main(String args[]){
    Main T = new Main();
    Scanner kb = new Scanner(System.in);
    n = kb.nextInt();     // 바둑이 수
    w = kb.nextInt();     // 전체 싣을 수 있는 하중
    int[] arr = new int[n]; // 바둑이 정보
    for(int i=0; i<n; i++){
      arr[i] = kb.nextInt();
    }

    T.DFS(0, 0, arr);
    System.out.println(answer);
  }

}
