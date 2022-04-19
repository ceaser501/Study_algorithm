package Array.ReverseNumber;

// 배열_숫자뒤집기
import java.util.Scanner;

public class Main {

    /**
     * 12345 를 뒤집어 54321을 만들려고 할 때,
     * 12345 % 10 = 5가 된다. 이렇게 구한 5를 answer[cnt] 에 넣는다
     * 이제 12345 / 10 을하면 1234만 남게되고, index ++ 해준다
     * 1234 % 10 = 4를 다시 answer[cnt]에 담는다 (반복)
     *
     * 나머지와 몫 연산을 통해, 뒤집어 배열로 만들 수 있다
     */
    public int[] solution(int num){
        // 문자열 + 숫자 = 문자열
        String a = "" + num;

        int[] answer = new int[a.length()];
        int cnt = 0;

        while(num > 0){
            answer[cnt] = num % 10;
            num /= 10;
            cnt++;
        }

        return answer;
    }


    public static void main(String args[]){
        Main T = new Main();

        Scanner kb = new Scanner(System.in);
        int num = kb.nextInt();

        for(int x : T.solution(num)){
            System.out.print(x);
        }
    }
}
