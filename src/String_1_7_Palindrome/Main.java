package String_1_7_Palindrome;

// 문자열_회문 문자열
import java.util.Scanner;

public class Main {

    // best solution!!!
    public String solution(String str){
        String answer = "NO";

        String reverseStr = new StringBuilder(str).reverse().toString();
        if(str.equalsIgnoreCase(reverseStr)) answer = "YES";

        return answer;
    }

    // O(n)
    public String solution1(String str){
        String answer = "YES";

        str = str.toUpperCase();
        int len = str.length();
        for(int i=0; i<len/2; i++){
            if(str.charAt(i) != str.charAt(len-i-1)) return "NO";
        }

        return answer;
    }

    // O(nlgn)
    public String solution2(String str){
        String answer = "YES";

        String s = str.toLowerCase();
        char[] ch = s.toCharArray();

        int lt = 0;
        int rt = ch.length-1;
        for(int i=0; i<ch.length; i++){
            while(lt < rt){
                if(ch[lt] != ch[rt]){
                    answer = "NO";
                    break;
                }

                lt++;
                rt--;
            }
        }
        return answer;
    }
    public static void main(String args[]){
        Main T = new Main();

        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();

        System.out.println(T.solution2(str));
    }
}
