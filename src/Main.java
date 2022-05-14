// 매일 문제 복습 풀기 (5번 완료)
import java.util.*;

public class Main {

    public String solution(String s){
        String answer = "";

        char[] ch = s.toCharArray();
        int lt=0;
        int rt=ch.length-1;
        char temp = ' ';
        while(lt<rt){
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

    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String s = kb.next();

        System.out.println(T.solution(s));
    }
}
