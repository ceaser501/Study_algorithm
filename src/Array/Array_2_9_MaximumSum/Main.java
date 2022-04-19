package Array.Array_2_9_MaximumSum;

// 배열_격차판 최대합
import java.util.*;

public class Main {

  public int solution(int cnt, int[][] matrix){
    int answer = 0;
    int sum1, sum2;

    // 가로, 세로
    for(int i=0; i<cnt; i++){
      sum1 = 0;   // 가로의 합
      sum2 = 0;   // 세로의 합
      for(int j=0; j<cnt; j++){
        sum1 += matrix[i][j];
        sum2 += matrix[j][i];
      }
      answer = Math.max(answer, sum1);
      answer = Math.max(answer, sum2);
    }

    // 대각A, 대각 B
    sum1 = 0;   // 대각A의 합
    sum2 = 0;   // 대각B의 합
    for(int i=0; i<cnt; i++){
      sum1 += matrix[i][i];
      sum2 += matrix[i][cnt-i-1];
    }

    answer = Math.max(answer, sum1);
    answer = Math.max(answer, sum2);

    return answer;
  }

  public static void main(String args[]){
    Main T = new Main();
    Scanner kb = new Scanner(System.in);

    int cnt = kb.nextInt();
    int[][] matrix = new int[cnt][cnt];
    for(int i=0; i<cnt; i++){
      for(int j=0; j<cnt; j++){
        matrix[i][j] = kb.nextInt();
      }
    }

    System.out.println(T.solution(cnt, matrix));

//    for(int i=0; i<cnt; i++){
//      for(int j=0; j<cnt; j++){
//        System.out.print(matrix[i][j] + " ");
//
//        if(j == 4){
//          System.out.println();
//        }
//      }
//    }
  }
}
