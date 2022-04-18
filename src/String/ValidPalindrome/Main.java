package String.ValidPalindrome;

// 문자열_유효한 회문 문자열
import java.util.*;

public class Main {

    public String solution(String str){
        String answer = "NO";
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        String reverseStrReplace = new StringBuilder(str).reverse().toString();
        if(str.equals(reverseStrReplace)) return "YES";

        return answer;
    }


    public static void main(String args[]){
        Main T = new Main();

        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();

        System.out.println(T.solution(str));
    }
}
