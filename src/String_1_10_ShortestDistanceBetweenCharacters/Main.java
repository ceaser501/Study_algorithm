package String_1_10_ShortestDistanceBetweenCharacters;

// 문자열_가장 짧은 문자거리
import java.util.Scanner;

public class Main {

    public int[] solution(String str, char ch){
        int[] answer = new int[str.length()];
        int p = 1000;

        // 정방향
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == ch){
                p = 0;
            }else{
                p++;
            }
            answer[i] = p;
        }

        // 역방향
        p = 1000;
        for(int j=str.length()-1; j>=0; j--){
            if(str.charAt(j) == ch) p = 0;
            else{
                p++;
                answer[j] = Math.min(answer[j], p);
            }
        }
        return answer;
    }


    public static void main(String args[]){
        Main T = new Main();

        Scanner kb = new Scanner(System.in);

        String str = kb.next();
        char ch = kb.next().charAt(0);

        for(int x : T.solution(str, ch)){
            System.out.print(x + " ");
        }
    }
}
