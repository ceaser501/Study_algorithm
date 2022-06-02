package Programmers.Level2.StackQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 기능개발
public class Main {

  // Queue 안쓴 버전
  public int[] solution(int[] progresses, int[] speeds) {
    ArrayList<Integer> answer = new ArrayList<>();

    // n일 = (100 - 작업률) / 하루 작업 스피드
    int[] schedule = new int[progresses.length];
    for(int i=0; i< progresses.length; i++){
      int day = (100 - progresses[i]) / speeds[i];
      if((100 - progresses[i]) % speeds[i] != 0) ++day;

      schedule[i] = day;
    }

    // 순서대로 탐색해서, 나보다 큰 n일이 나올때 까지 count++
    // 나보다 큰 n일이 나오면, answer에 add
    int start = schedule[0];
    int count = 0;
    for(int i=0; i < schedule.length; i++){
      if(start >= schedule[i]) ++count;
      else{
        // 현재까지 count를 answer에 add
        answer.add(count);

        // 현재 i를 다시 스타트로 지정
        start = schedule[i];
        count = 1;
      }

      if(i == schedule.length-1){
        answer.add(count);
        break;
      }
    }

    return answer.stream().mapToInt(Integer::intValue).toArray();
  }

  // Queue 쓴 버전
  public int[] solution2(int[] progresses, int[] speeds) {
    ArrayList<Integer> answer = new ArrayList<>();

    // (double) 남은 작업일 = (100 - 진행률) / speeds
    // Math.ceil(남은 작업일)
    Queue<Integer> queue = new LinkedList<>();
    int count = 0;
    for(int i=0; i<progresses.length; i++){
      int day = (100 - progresses[i]) / speeds[i];
      if((100 - progresses[i]) % speeds[i] != 0) ++day;

      if(!queue.isEmpty() && queue.peek() < day){
        answer.add(queue.size());   // 큐에 포함된 size가 같이 배포되는 수
        queue.clear();              // 큐 비우기
      }

      queue.offer(day);
    }

    answer.add(queue.size());       // 마지막 큐에남은거 answer에 담기


    return answer.stream().mapToInt(Integer::intValue).toArray();
  }

  public static void main(String args[]){
    Main T = new Main();
//    for(int i : T.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5}))
//      System.out.println(i);
//
//    for(int i : T.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}))
//      System.out.println(i);

    for(int i : T.solution2(new int[]{96,94}, new int[]{3,3}))
      System.out.println(i);
  }
}
