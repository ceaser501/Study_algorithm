package Array_2_12_Mentoring;

// 배열_멘토링
import java.util.*;

public class Main {

    public int solution(int n, int m, int[][] arr){
        int answer = 0;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                int cnt = 0;                // 멘토멘티 가능한지에 대한 각 문제별 카운트
                for(int k=0; k<m; k++){     // 문제 각 회차 (m 시험수 만큼 돌아야 함)
                    int pi=0, pj=0;         // i 번 학생의 등수, j 번 학생의 등수 초기화
                    for(int s=0; s<n; s++){         // S는 등수를 나타내고 여기선 총 4등까지 있음
                        if(arr[k][s] == i) pi = s;
                        if(arr[k][s] == j) pj = s;
                    }

                    if(pi < pj) cnt++;
                }

                if(cnt == m){   // 모든 문제 회차에서 모두 pass된 경우
                    answer++;
                }
            }
        }

        return answer;
    }


    public static void main(String args[]){
        Main T = new Main();

        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();           // 학생 수
        int m = kb.nextInt();           // 시험 수
        int[][] arr = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = kb.nextInt();
            }
        }

        System.out.println(T.solution(n, m, arr));
    }
}
