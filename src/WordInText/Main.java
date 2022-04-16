package WordInText;

// 문자열_문자 속 단어
import java.util.*;

public class Main {

    // split
    public String solution(String str){
        String answer = "";
        int m = 0;

        String[] sArray = str.split(" ");
        for(String s : sArray){
            if(s.length() > m){
                m = s.length();
                answer = s;
            }
        }

        return answer;
    }

    // indexOf + substring
    public String solution1(String str){
        String answer = "";
        int m = 0, pos;
        while((pos = str.indexOf(' ')) != -1){  // 띄어쓰기를 찾지 못할때까지만 돈다
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if(len > m){
                m = len;
                answer = tmp;
            }

            str = str.substring(pos+1);
        }

        if(str.length() > m)
            answer = str;

        return answer;
    }

    public static void main(String args[]){
        Main T = new Main();

        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();

        System.out.println(T.solution(str));
    }

}
