package 문자열_회문문자열;

import java.util.Scanner;

public class Main {
    public String solution(String str){
        String answer = "";

        str = str.toLowerCase();
        int lt = 0;
        int rt = str.length()-1;
        char[] cArray = str.toCharArray();

        while(lt < rt){
            if(cArray[lt] != cArray[rt]){
                answer = "NO";
            }

            if(lt == rt){
                answer = "YES";
                break;
            }else{
                lt++;
                rt--;
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
