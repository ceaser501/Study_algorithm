package Array.RockPaperScissors;

// 배열_가위바위보
import java.util.Scanner;

public class Main {

    public String solution(int cnt, int[] chArrayA, int[] chArrayB){
        String answer = "";

        for(int i=0; i<cnt; i++){

//  단순 if문 비교
//            if(chArrayA[i] == chArrayB[i]) answer += "D";
//            else if(chArrayA[i] == 1 && chArrayB[i] == 3) answer += "A";
//            else if(chArrayA[i] == 2 && chArrayB[i] == 1) answer += "A";
//            else if(chArrayA[i] == 3 && chArrayB[i] == 2) answer += "A";
//            else answer += "B";

            // switch case 비교
            switch(chArrayA[i] - chArrayB[i]) {
                case -1: case 2:
                    answer += "B"; break;
                case 1: case -2:
                    answer += "A"; break;
                case 0:
                    answer += "D";
                    break;
            }
        }

        return answer;
    }


    public static void main(String args[]){
        Main T = new Main();

        Scanner kb = new Scanner(System.in);
        int cnt = kb.nextInt();
        int[] chArrayA = new int[cnt];
        int[] chArrayB = new int[cnt];

        for(int i=0; i<cnt; i++){
            chArrayA[i] = kb.nextInt();
        }

        for(int i=0; i<cnt; i++){
            chArrayB[i] = kb.nextInt();
        }

        for(char x : T.solution(cnt, chArrayA, chArrayB).toCharArray())
            System.out.println(x);
    }
}
