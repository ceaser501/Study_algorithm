package Programmers.Level2.StackQueue2;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

  public int solution(int bridge_length, int weight, int[] truck_weights) {
    int totWeight = 0;     // 총 중량
    int time = 0;          // 걸린시간
    Queue<Integer> q = new LinkedList<>();

    for(int i=0; i<truck_weights.length; i++){
      int truck = truck_weights[i];

      while(true){
        // 큐에 아무것도 없는 경우 = 어떤 트럭도 다리 위에 없음
        if(q.isEmpty()){
          q.offer(truck);
          totWeight += truck;
          time++;     // 다리에 오를때 time 추가
          break;
        }else if(q.size() == bridge_length){  // q가 다리 길이만큼 트럭이 찬 경우
          totWeight -= q.poll();
        }else{      // 다리길이 만큼 q에 트럭이 차지 않은 경우
          // totWeight가 넘지 않는 선에서 새로운 트럭을 다리에 올림
          if(totWeight + truck <= weight){
            q.offer(truck);
            totWeight += truck;
            time++;
            break;
          }else{
            // 넘는다면 0을 넣어서 이미 q에 있는 트럭을 건너게 만듬
            q.offer(0);
            time++;
          }
        }
      }
    }

    // 마지막 트럭에서 반복문이 끝나는데, 마지막 역시 다리 길이만큼 지나가야 하기에 + 다리 길이를 해줌
    return time + bridge_length;
  }

  public static void main(String args[]){
    Main T = new Main();
    System.out.println(T.solution(2, 10, new int[]{7, 4, 5, 6}));
   // System.out.println(T.solution(100, 100, new int[]{10}));
   // System.out.println(T.solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}));
  }
}
