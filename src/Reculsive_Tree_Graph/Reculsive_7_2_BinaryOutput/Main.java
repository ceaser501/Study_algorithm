package Reculsive_Tree_Graph.Reculsive_7_2_BinaryOutput;

// 재귀_이진수출력
/**
 * 첫번째 줄에 11이 입력되면, 1011 으로 2진수 변환이 되어 출력되도록 한다
 */
public class Main {
  public void DFS(int n){
    if (n == 0) return;
    else{
//      System.out.print(n%2 + " ");      1101 이 나오는데, 2진수변환은 나머지를 밑에서 위로 출력해야 한다
      DFS(n/2);
      System.out.print(n%2 + " ");        // DFS 재귀 이후에 sout을 출력하면 1011이 나온다 (StackFrame이용)
    }
  }

  public static void main(String args[]){
    Main T = new Main();
    T.DFS(11);
  }
}
