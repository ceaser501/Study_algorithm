package Stack_Queue.Queue_5_8_EmergencyRoom;

// 큐_응급실
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public int solution(int[] em, int m){
        int answer = 0;

      

        return answer;
    }


    public static void main(String args[]){
        Main T = new Main();

        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] em = new int[n];
        for(int i=0; i<n; i++){
            em[i] = kb.nextInt();
        }

        System.out.println(T.solution(em, m));
    }
}
