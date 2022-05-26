package Programmers.Level1.MiddleCharacter;

// 가운데 글자 가져오기
public class Main{

  public String solution(String s) {
    String answer = "";

    if(s.length() %2  == 0){
      answer += String.valueOf(s.charAt(s.length()/2-1));
    }

    answer += String.valueOf(s.charAt(s.length()/2));

    return answer;
  }


  public static void main(String args[]){
    Main T = new Main();

    System.out.println(T.solution("abcde"));
    System.out.println(T.solution("qwer"));
  }
}
