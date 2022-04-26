package Stack_Queue.Queue_5_6_SaveThePrincess;

// 큐_공주 구하기
import java.util.*;

public class Main {

    /**
     * Queue (FIFO)
     * .offer(x) : element 추가
     * .poll() : element 삭제 (꺼내고 return 받음, stack에서 pop처럼)
     * .peek() : 가장마지막 element 확인
     * .contains(x) : 포함여부 확인
     * .isEmpty()   : 비어있는지 확인
     */
    public int solution(int n, int k){
        int answer = 0;

        Queue<Integer> queue = new LinkedList();
        for(int i=0; i<n; i++){
            queue.offer(i+1);
        }

        int cnt = 1;
        while(!queue.isEmpty()){
            for(int i=1; i<k; i++) queue.offer(queue.poll());       // i가 1번째 2번째는 offer
            queue.poll();                                           // 3번째는 poll
            if(queue.size() == 1) answer = queue.poll();
        }

//      내가 푼 답답
//       while(!queue.isEmpty()){
//            int temp = queue.peek();
//            queue.poll();
//            if(cnt != k) queue.offer(temp);
//            else cnt = 0;
//            cnt++;
//        }
//
//        answer = queue.peek();
        return answer;
    }


    public static void main(String args[]){
        Main T = new Main();

        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();           // 왕자 수
        int k = kb.nextInt();           // K번째

        System.out.println(T.solution(n, k));
    }
}
