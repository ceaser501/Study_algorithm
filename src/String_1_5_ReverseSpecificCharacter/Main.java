package String_1_5_ReverseSpecificCharacter;

// 문자열_특정 문자 뒤집기
import java.util.*;

public class Main {

    public String solution(String str){
        String answer = "";

        char[] ch = str.toCharArray();
        int lt = 0;
        int rt = str.length()-1;
        char temp = ' ';
        while(lt < rt){
            if(!Character.isAlphabetic(ch[lt])){
                lt++;
            }else if(!Character.isAlphabetic(ch[rt])){
                rt--;
            }else{
                temp = ch[lt];
                ch[lt] = ch[rt];
                ch[rt] = temp;

                lt++;
                rt--;
            }
        }
        answer = String.valueOf(ch);

        return answer;
    }


    public static void main(String args[]){
        Main T = new Main();

        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        System.out.println(T.solution(str));
    }
}
