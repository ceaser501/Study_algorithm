package Array.FibonacciSequence;

// 배열_피보나치 수열
import java.util.Scanner;

public class Main {

    public int[] solution(int cnt){
        int[] answer = new int[cnt];

        answer[0] = 1;
        answer[1] = 1;
        for(int i=2; i<cnt; i++){
            answer[i] = answer[i-2] + answer[i-1];
        }
        return answer;
    }

    // array를 안쓰고 하는 경우
    public void solution1(int cnt){
        int a = 1, b = 1, c;

        for(int i=2; i<cnt; i++){
            c = a + b;
            a = b;
            b = c;
        }
    }


    public static void main(String args[]){
        Main T = new Main();

        Scanner kb = new Scanner(System.in);
        int cnt = kb.nextInt();

        for(int x : T.solution(cnt))
            System.out.print(x + " ");
    }
}
