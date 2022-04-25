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
    Stack<Integer> stack2 = new Stack<>();
    for(int i=0; i<m; i++){
      int index = moves[i]-1;

      for(int j=arr.length-1; j>=0; j--){
        if(arr[j][index] != 0 && arr[j-1][index] == 0){
          stack.push(arr[j][index]);
//          arr[j][index] = 0;
        }
      }

      // 기존 것과 넣으려는 것이 같으면 answer++ 하고 마지막 element삭제
      if(!stack2.isEmpty() && stack2.lastElement() == stack.lastElement()){
        answer++;
        answer++;
        stack2.remove(stack2.lastElement());
      }else{                                                // 다르면 넣기
        stack2.push(stack.lastElement());
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
