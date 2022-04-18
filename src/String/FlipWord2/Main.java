package String.FlipWord2;

// 문자열_단어뒤집기2
import java.util.*;

public class Main {

    public String[] solution(String[] sArray){
        String[] answer = new String[sArray.length];

        for(int i=0; i<sArray.length; i++){
            answer[i] = new StringBuilder(sArray[i]).reverse().toString();
        }

        return answer;
    }


    public static void main(String args[]){
        Main T = new Main();

        Scanner kb = new Scanner(System.in);
        int cnt = kb.nextInt();
        String[] sArray = new String[cnt];
        for(int i=0; i<sArray.length; i++){
            sArray[i] = kb.next();
        }

        String[] sResult = T.solution(sArray);
        for(int i=0; i<sResult.length; i++){
            System.out.println(sResult[i]);
        }
    }
}
