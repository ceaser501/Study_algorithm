package Programmers.Level1.ReverseTernary;

import java.util.LinkedList;
import java.util.Queue;

// 3진법 뒤집기
public class Main {

  // 재귀 + Queue
  static String answer = "";
  static Queue<Integer> Q = new LinkedList();
  public int solution1(int n) {
    if(n == 0){
      while(!Q.isEmpty()){
        answer += String.valueOf(Q.poll());
      }
    }else{
      Q.offer(n%3);
      solution1(n/3);
    }

    return Integer.parseInt(answer, 3);
  }

  // StringBuilder
  public int solution2(int n) {
    String a = "";

    while(n > 0){
      a = a + (n % 3);
      n /= 3;
    }
    a = new StringBuilder(a).toString();


    return Integer.parseInt(a,3);
  }

  public static void main(String args[]){
    Main T = new Main();
    System.out.println(T.solution1(45));
    System.out.println(T.solution2(125));
  }
}
