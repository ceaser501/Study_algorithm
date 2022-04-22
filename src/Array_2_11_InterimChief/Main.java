package Array_2_11_InterimChief;

// 배열_임시반장 정하기
import java.util.*;

public class Main {

    public int solution(int cnt, int[][] student){
        int answer = 0;
        int max = Integer.MIN_VALUE;

        /**
         * 자신을 i 로 놓고, 자신을 포함한 나머지 학생들을 j loop로 돌린다
         * k는 1~5학년 loop로 돌린다
         *
         * 즉 student[i][k] == student[j][k] 라는 의미는, 동일 학년에서 자신과 같은 반인 다른 친구가 있다는 의미이다
         * 이때 count++를 해주고, break 한다
         *
         * break하는 이유는, 2학년때 나와 동일한 반이었던 학생이 3학년때, 4학년때, 5학년때 동일하더라도 count를 하면 안되기때문이다
         * count++ 한 값을 max에 담고, answer에 해당 학생을 담는다
         *
         * count가 max보다 클 때를 조건으로 하기 때문에,
         * count가 같은 학생이 뒤이어 나와도, 최초 answer에 들어간 학생이 출력된다다
        */
        for(int i=1; i<=cnt; i++){
            int count = 0;
            for(int j=1; j<=cnt; j++){
                for(int k=1; k<=5; k++){
                    if(student[i][k] == student[j][k]){
                        count++;
                        break;
                    }
                }
            }
            if(count > max){
                max = count;
                answer = i;
            }
        }

        return answer;
    }


    public static void main(String args[]){
        Main T = new Main();

        Scanner kb = new Scanner(System.in);
        int cnt = kb.nextInt();
        int[][] student = new int[cnt+1][6];
        for(int i=1; i<=cnt; i++){
            for(int j=1; j<=5; j++){
                student[i][j] = kb.nextInt();
            }
        }

        System.out.println(T.solution(cnt, student));
    }
}

