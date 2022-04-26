package Stack_Queue.Queue_5_7_CurriculumDesign;

// 큐_교육과정 설계
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public String solution(String need, String plan){
        String answer = "YES";

        Queue<Character> q = new LinkedList();
        for(char c : need.toCharArray()) q.offer(c);
        for(char ch : plan.toCharArray()){
            if(q.contains(ch)){
                if(q.peek() != ch) return "NO";
                q.poll();

                // 위 17~18 라인을 합쳐서 if(ch != q.poll()) return "NO"; 로 해도 된다
            }
        }

        if(!q.isEmpty()) return "NO";
        return answer;
    }


    public static void main(String args[]){
        Main T = new Main();

        Scanner kb = new Scanner(System.in);
        String subject = kb.next();
        String curriculum = kb.next();

        System.out.println(T.solution(subject, curriculum));
    }
}
