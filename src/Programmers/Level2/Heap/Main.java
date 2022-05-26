package Programmers.Level2.Heap;

// 더 맵게 (Heap)
import java.util.PriorityQueue;

/**
 * 오름차순 정렬되어 (우선순위가 낮은 숫자 순) .peek()으로 꺼내면 가장 작은 수를 가져온다
 * PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
 *
 * 내림차순 정렬되어 (우선순위가 높은 숫자 순) .peek()으로 꺼내면 가장 큰 수를 가져온다
 * PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
 *
 * priorityQueue.add(value) or .offer(value) // priorityQueue에 값을 추가
 * 단, add로 추가시 성공하면 true를 반환하고, 큐에 여유가 없으면 IllegalStateException 발생
 *
 * priorityQueue.poll();       // priorityQueue에 첫번째 값을 반환하고 제거 비어있다면 null
 * priorityQueue.remove();     // priorityQueue에 첫번째 값 제거
 * priorityQueue.clear();      // priorityQueue에 초기화
 */
public class Main {

  public int solution(int[] scoville, int K) {
    int answer = 0;

    PriorityQueue<Integer> queue = new PriorityQueue();
    for(int i=0; i<scoville.length; i++){
      queue.offer(scoville[i]);
    }

//    while(!queue.isEmpty()){
//      int curr = queue.poll();
//      if(curr < K){     // 현재 값이 K보다 작을 때
//        if(queue.size() == 0) return -1;
//        else{
//          int next = queue.poll();
//
//          int sum = curr + next * 2;
//          queue.offer(sum);
//          answer++;
//        }
//      }
//    }

    while (queue.peek() <= K) {     // 우선순위가 가장 낮은 가장 작은 수가 K보다 작거나 같다
      if (queue.size() == 1) {      // 더할 다음 값이 없으므로 -1
        return -1;
      }
      int curr = queue.poll();
      int next = queue.poll();
      int result = curr + (next * 2);

      queue.offer(result);
      answer ++;
    }

    return answer;
  }

  public static void main(String args[]){
    Main T = new Main();
    System.out.println(T.solution(new int[]{1,2,3,9,10,12}, 7));
  }
}
