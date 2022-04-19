package String.String_1_1_FindCharacter;

// 문자열_단어찾기
import java.util.*;

public class Main{
    public int solution(String str, char c){
        int answer = 0;
        str = str.toUpperCase();
        c = Character.toUpperCase(c);   // Character 클래스의 toUpperCase

        for(char ch : str.toCharArray()){
            if(ch == c)
                answer++;
        }

        return answer;
    }

    public static void main(String args[]){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0);
        System.out.println(T.solution(str, c));
    }
}



