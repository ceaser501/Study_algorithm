package Reculsive_Tree_Graph.Reculsive_7_1_StackFrame;

// 재귀_스택프레임
public class Main {

  /**
   * 재귀함수 (스택프레임을 사용한다)
   * 왜 sout을 위에서 하면 321이 출력되고 DFS(n-1); 밑에서는 123이 출력 되는가?
   *
   * 스택에 Frame이 생성되어, DFS(3), DFS(2), DFS(1) DFS(0) 이렇게 들어가게 된다
   * Frmae에는 매개변수정보, 지역변수정보, 복귀주소 등.. 의 정보가 저장된다
   *
   * DFS(3), DFS(2), DFS(1), DFS(0) 이 Stack Frame에 쌓이게 되고, DFS(0)은 return;을 만나 pop된 후,
   * 복귀주소에 따라 DFS(1)로 복귀하여, DFS(1)이 pop된다 (이때 line22 으로 복귀하므로, 바로 line23이 출력되고 pop된다)
   * 이후 DFS(1)이 pop된 후 다시 복귀 주소에 따라 DFS(2)로 복귀하여, DFS(2)가 pop된다
   * 반복,,
   */
  public void DFS(int n){
    if(n==0) return;
    else{
      // System.out.print(n + " ");   3 2 1 이 출력 된다
      DFS(n-1);
      System.out.print(n + " ");      // 1 2 3 이 출력 된다
    }
  }

  public static void main(String args[]){
    Main T = new Main();
    T.DFS(3);
  }
}
