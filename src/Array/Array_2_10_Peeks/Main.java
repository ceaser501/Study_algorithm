package Array.Array_2_10_Peeks;

// 배열_봉우리
import java.util.*;

public class Main {

  public int solution(int num, int[][] matrix){
    int answer = 0;

    int[][] newMatrix = new int[num+2][num+2];

    // 테두리에 0 포함한 가로세로 만들기
    for(int i=0; i<newMatrix.length; i++){
      for(int j=0; j<newMatrix.length; j++){
        if(i == 0 || i == newMatrix.length-1){
          newMatrix[i][j] = 0;
        }else{
          if(j == 0 || j == newMatrix.length-1){
            newMatrix[i][j] = 0;
          }else{
            newMatrix[i][j] = matrix[i-1][j-1];
          }
        }
      }
    }

    // 현재 위치 값이 상하좌우에 있는 수보다 클 때 answer ++
    for(int i=1; i< newMatrix.length-1; i++){
      for(int j=1; j< newMatrix.length-1; j++){
        if(newMatrix[i][j] > newMatrix[i-1][j] &&
            newMatrix[i][j] > newMatrix[i+1][j] &&
            newMatrix[i][j] > newMatrix[i][j+1] &&
            newMatrix[i][j] > newMatrix[i][j-1]){
          answer++;
        }
      }
    }

//    for(int i=0; i<newMatrix.length; i++){
//      for(int j=0; j<newMatrix.length; j++){
//        System.out.print(newMatrix[i][j] + " ");
//
//        if(j == 6){
//          System.out.println();
//        }
//      }
//    }

    return answer;
  }

  public static void main(String args[]){
    Main T = new Main();
    Scanner kb = new Scanner(System.in);
    int num = kb.nextInt();
    int[][] matrix = new int[num][num];
    for(int i=0; i<num; i++){
      for(int j=0; j<num; j++){
        matrix[i][j] = kb.nextInt();
      }
    }

    System.out.println(T.solution(num, matrix));
  }
}
