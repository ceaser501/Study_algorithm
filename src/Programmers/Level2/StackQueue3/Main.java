package Programmers.Level2.StackQueue3;


import java.util.LinkedList;
import java.util.Queue;

// 프린터
public class Main {

  class Task{
    int location;
    int priority;

   public Task(int location, int priority){
      this.location = location;
      this.priority = priority;
   }
  }
  public int solution(int[] priorities, int location) {
    int answer = 0;

    Queue<Task> queue = new LinkedList<>();

    for(int i=0; i< priorities.length; i++){
      queue.offer(new Task(i, priorities[i]));
    }

    int index = 0;
    while(!queue.isEmpty()){
      Task curr = queue.poll();
      boolean flag = false;
      for(Task k : queue){
        if(k.priority > curr.priority){
          flag = true;              // 현재 우선순위보다 queue에 큰 우선순위가 있는 경우 flag 변경
        }
      }
      if(flag){                     // 우선순위 높은게 있다
        queue.offer(curr);
      }else{                        // 현재 값이 우선순위가 가장 높다
        index++;
        if(curr.location == location){    // 현재 값의 위치 값이, 찾고자하는 위치 값이다
          answer = index;
          break;
        }
      }
    }

//    for(Task k : queue){
//      System.out.print(k.location + " ");
//      System.out.print(k.priority + " ");
//    }

    return answer;
  }

  public static void main(String args[]){
    Main T = new Main();
    System.out.println(T.solution(new int[]{2, 1, 3, 2}, 2));
   // System.out.println(T.solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
  }
}
