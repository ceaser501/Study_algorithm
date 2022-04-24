package Stack_5_3_PuppetDraw;

// 스택_인형뽑기(카카오)
//    [입력]
//    5
//    0 0 0 0 0
//    0 0 1 0 3
//    0 2 5 0 1
//    4 2 4 4 2
//    3 5 1 3 1
//    8
//    1 5 3 5 1 2 1 4
//
//    [출력]
//    4




import java.util.Scanner;
import java.util.Stack;

public class Main {

  public int solution(int n, int[][] arr, int m, int[] moves){
    int answer = 0;

    Stack<Integer> stack = new Stack<>();

    for(int i=0; i<m; i++){
      int index = moves[i]-1;

      for(int j=arr.length-1; j>=0; j--){
        if(arr[index][j] != 0) stack.push(arr[index][j]);
      }
    }

    for(int i : stack){
      System.out.print(" " + i);
    }

    return answer;
  }


  public static void main(String args[]){
    Main T = new Main();

    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    int[][] arr = new int[n][n];
    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        arr[i][j] = kb.nextInt();
      }
    }

    int m = kb.nextInt();
    int[] moves = new int[m];
    for(int i=0; i<m; i++){
      moves[i] = kb.nextInt();
    }

    System.out.println(T.solution(n, arr, m, moves));
  }
}
