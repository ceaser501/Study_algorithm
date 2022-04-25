package Stack_5_3_PuppetDraw;

// 스택_인형뽑기(카카오)
import java.util.Scanner;
import java.util.Stack;

public class Main {

  public int solution(int n, int[][] arr, int m, int[] moves){
    int answer = 0;

    /**
     * peek() : 꺼내지 않고 마지막 값을 탐색만 함
     * pop() : 꺼내서 마지막 값을 가져옴 return
     */
    Stack<Integer> stack = new Stack<>();
    for(int i=0; i<m; i++){
      int index = moves[i]-1;

      for(int j=0; j<n; j++){
        if(arr[j][index] != 0){
          int tmp = arr[j][index];
          arr[j][index] = 0;
          if(!stack.isEmpty() && stack.peek() == tmp){
            answer += 2;
            stack.pop();
          }else stack.push(tmp);
          break;
        }
      }
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
