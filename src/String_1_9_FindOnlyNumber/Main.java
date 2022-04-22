package String_1_9_FindOnlyNumber;

// 문자열_숫자만 추출
import java.util.*;

public class Main {

    // 1. 정규식을 이용한 방법
    public int solution(String str){
        int answer = Integer.parseInt(str.replaceAll("[^0-9]", ""));
        return answer;
    }

    // 2. 아스키코드를 이용한 방법
    public int solution1(String str){
        int answer = 0;

        for(char x : str.toCharArray()){
            // 문자 X가 숫자 0~9 사이 값이 되려면, 아스키 코드로 48~57 사이여야 한다
            // X가 숫자라면, 10진수로 전환하는 공식이다 ( 10을 곱하여, 0의 아스키코드 48을 빼준다 )
            if(x >= 48 && x <= 57) answer = answer * 10 + (x-48);
        }

        return answer;
    }

    // 3. Character.isDigit
    public int solution2(String str){
        String answer = "";

        for(char x : str.toCharArray()){
            // 해당 문자가 숫자인지 체크하는 idDigit
            if(Character.isDigit(x)) answer+=x;
        }

        return Integer.parseInt(answer);
    }

    public static void main(String args[]){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
