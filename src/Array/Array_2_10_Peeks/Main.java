package Array.Array_2_10_Peeks;

// 배열_봉우리
import java.util.*;

public class Main {

  // 강사쌤이 푼 답
  int[] dx = {-1, 0, 1, 0};
  int[] dy = {0, 1, 0, -1};
  public int solution1(int num, int[][] matrix){
    int answer = 0;

    for(int i=0; i<num; i++){
      for(int j=0; j<num; j++){
        boolean flag = true;

        /**
         * nx, ny = 검증할 행/열을 표시
         * dx[k]는 다음 검증 행을, dy[k]는 다음 검증 열을 결정한다
         *
         * 예를 들어 (2,3) 위치의 값은 12시, 3시, 6시, 9시 총 4개의 방향을 검증해야한다
         * (1,3) (2,4) (3,3) (2,2)을 검증해야한다는 의미다
         * 각각 행은 -1, 0, 1, 0, 열은 0 1 0 -1 순서대로 변화하는 것을 알수 있다
         *
         * dx, dy를 위 순서대로 정의해 주고, 0~4를 순회하면서 다음 검증 행열을 만들어 주는 과정이다
         */
        for(int k=0; k<4; k++){
          int nx = i + dx[k];       // 다음 검증 행을 결정한다
          int ny = j + dy[k];       // 다음 검증 열을 결정한다

          if(nx>=0 && nx<num && ny>=0 && ny<num && matrix[nx][ny] >= matrix[i][j]){
            flag = false;
            break;
          }
        }
        if(flag) answer++;
      }
    }

    return answer;
  }

  // 내가 푼 답
  public int solution(int num, int[][] matrix){
    int answer = 0;

    int[][] newMatrix = new int[num+2][num+2];

    // 테두리에 0 포함한 가로세로 만들기
    for(int i=1; i<newMatrix.length-1; i++){
      for(int j=1; j<newMatrix.length-1; j++)
        newMatrix[i][j] = matrix[i-1][j-1];
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

    System.out.println(T.solution1(num, matrix));
  }
}
