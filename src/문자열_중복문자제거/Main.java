package 문자열_중복문자제거;

import java.util.*;

public class Main {

    public String solution(String str){
        String answer = "";

        for(char c : str.toCharArray()){
            if (!answer.contains(String.valueOf(c))){
                answer += c;
            }
        }
        return answer;
    }

    public String solution1(String str) {
        String answer = "";

        char[] charArr = str.toCharArray();
        for(char c : charArr) {
            // c에 해당되지 않으면 +=
            if(answer.indexOf(c) == -1) answer += c;
        }
        return answer;
    }

    public String solution2(String str){
        String answer="";
        for(int i=0; i<str.length(); i++){
            //System.out.println(str.charAt(i)+" "+i+" "+str.indexOf(str.charAt(i)));
            if(str.indexOf(str.charAt(i))==i) answer+=str.charAt(i);
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
