package Reculsive_Tree_Graph.Reculsive_7_3_Factorial;

// 재귀_팩토리얼
/**
 * 자연수 N이 입력되면, N!를 구하는 프로그램을 작성하시오
 * 5! = 5*4*3*2*1 = 120
 */
public class Main {
  public int DFS(int n){
    if(n == 1) return 1;
    else return n * DFS(n-1);
    /**
     * DFS(5) = 5 * DFS(4)
     * DFS(4) = 4 * DFS(3)
     * DFS(3) = 3 * DFS(2)
     * DFS(2) = 2 * DFS(1)
     * DFS(1) = 1
     */
  }

  public static void main(String args[]){
    Main T = new Main();
    System.out.println(T.DFS(5));
  }
}
