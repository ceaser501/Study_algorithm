package String.String_1_12_Password;

// 문자열_암호
import java.util.*;

public class Main {
    public String solution(int cnt, String str){
        String answer = "";

        String password = "";
        char[] chArray = str.toCharArray();
        for(int i=0; i<chArray.length; i++){
            password += String.valueOf(chArray[i])
                    .replace('#', '1')
                    .replace('*', '0'); // #를 1로, *를 0으로 변환

            // str의 길이는 28개 문자고, cnt는 4이므로 7개씩 묶는다는 의미가 된다 (나누는 수 : 7)
            if((i % (str.length()/cnt)) == 6){                            // password에 쌓은 것이 7개가 되면,
                answer += (char)(Integer.parseInt(password,2));      // 2진수를 10진수로 전환해서 문자로 answer에 누적
                password = "";                                            // answer에 누적했으므로 비워주자
            }
        }
        return answer;
    }

    // best solution !!
    public String solution1(int cnt, String str){
        String answer = "";

        for(int i=0; i<cnt; i++){
            String tmp = str.substring(0, 7).replace('#', '1').replace('*', '0');
            answer += (char) Integer.parseInt(tmp, 2);
            str = str.substring(7);
        }

        return answer;
    }

    public static void main(String args[]){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);

        int cnt = kb.nextInt();
        String str = kb.next();

        System.out.println(T.solution1(cnt, str));
    }
}
