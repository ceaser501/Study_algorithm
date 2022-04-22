package String_1_11_CharacterCompression;

// 문자열_문자열 압축
import java.util.*;

public class Main {

    public String solution(String str){
        String answer = "";

        char[] chArray = str.toCharArray();

        answer += chArray[0];
        int count = 1;
        for(int i=1; i<chArray.length; i++){
            if(chArray[i] == chArray[i-1]){
                count++;
                if(i == chArray.length-1) answer += count;
            }else{
                if(count != 1) answer += String.valueOf(count);

                answer += chArray[i];
                count = 1;
            }
        }

        return answer;
    }

    public String solution1(String s){
        String answer="";
        s=s+" ";    // boundary exception 방지
        int cnt=1;
        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i)==s.charAt(i+1)) cnt++;       // 마지막에 + " " 를 해서 에러는 안난다
            else{
                answer+=s.charAt(i);
                if(cnt>1) answer+=String.valueOf(cnt);
                cnt=1;
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
