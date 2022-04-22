package String_1_2_CaseConversion;

// 문자열_대소문자변환
import java.util.*;

public class Main {
    public String solution(String str){
        String answer = "";

        for(char ch : str.toCharArray()){
            if(Character.isLowerCase(ch)) answer += Character.toUpperCase(ch);
            else answer += Character.toLowerCase(ch);
        }


        return answer;
    }

    public String solution1(String str){
        String answer = "";

        if(str.length() > 100)
            return null;

        for(char ch : str.toCharArray()){
            if(ch >= 65 && ch <= 90){
                answer += Character.toLowerCase(ch);
            }else if(ch >= 97 && ch <= 122){
                answer += Character.toUpperCase(ch);
            }
        }

        return answer;
    }

    public String solution2(String str){
        String answer = "";

        if(str.length() > 100)
            return null;

        for(char ch : str.toCharArray()){
            if(ch >= 65 && ch <= 90){
                answer += (char)(ch+32);
            }else if(ch >= 97 && ch <= 122){
                answer += (char)(ch-32);
            }
        }

        return answer;
    }


    public static void main(String args[]){
        Main T = new Main();

        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        System.out.println(T.solution(str));
    }
}
