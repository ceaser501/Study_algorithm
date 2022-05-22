package Programmers.Level1.FindKim;

// 서울에서 김서방 찾기
import java.util.*;
public class Main {
  public String solution(String[] seoul) {
    String answer = "";

    for(int i=0; i<seoul.length; i++){
      if(seoul[i].equals("Kim")) return "김서방은" + i + "에 있다";
    }

    return answer;
  }

  public static void main(String args[]){
    Main T = new Main();
    System.out.println(T.solution(new String[]{"Jane", "Kim"}));
  }
}
