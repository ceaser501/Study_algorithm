package Reculsive_Tree_Graph.Reculsive_7_4_FibonaciReculsive;

// 재귀_피보나치 재귀(메모이제이션)
/**
 * 단순히 DFS를 계속 돌려 sout 하는 것보다 int[] fibo를 선언해서,
 * 담은 뒤에 바로 전전과 전을 비교해서 array에 담는 것이 훨씬 개선된 형태이다
 *
 * 여기에 메모이제이션을 적용하면, 훨씬 개선된 형태가 된다
 * 기본적으로 int array는 new로 생성하면 0으로 초기화 되어 있다
 * 앞선 DFS에서 값이 생성되서 fibo[n]에 세팅이 되어 있다면, 0이아니라 0보다 큰 값이 저장되어 있을 것이다
 *
 * 즉 fibo[n]값이 우선생성됐다면, 다시 DFS로 탐색하지 않고 바로 그 값을 가져오도록
 * if(fibo[n] > 0) return fibo[n]; 을 해주면 된다
 *
 * 성능상으로는 for문을 그냥 돌리는 것이 훨씬 빠르고 경제적이다
 * 스택 프레임을 쓰는 것만으로도 성능이 좋지않다 (대신 방법은 알고 있으면 좋다)
 */
public class Main {

  // 1 2 3 5 8 13
  static int[] fibo;
  public int DFS(int n){
    if(fibo[n] > 0) return fibo[n];
    if(n==1)  return fibo[n] = 1;
    else if(n==2) return fibo[n] = 1;
    else return fibo[n] = DFS(n-2) + DFS(n-1);
  }

  public static void main(String args[]){
    Main T = new Main();
    int n = 45;
    fibo = new int[n+1];      // 1부터 시작하고 n이 포함되어야 하므로 length는 n+1
    T.DFS(n);
    for(int i=1; i<=n; i++) System.out.print(fibo[i] + " ");
  }
}
