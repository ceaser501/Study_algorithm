package Stack_5_4_Postfix;

// 스택_후위식 연산
import java.util.*;

public class Main {

  public int solution(String str){
    int answer = 0;

    Stack<Integer> stack = new Stack<>();

    /**
     * Character 의 숫자검증 : Character.isDigit(검증원하는 문자)
     */
    for(Character ch : str.toCharArray()){
      if(Character.isDigit(ch)) stack.push(Integer.parseInt(String.valueOf(ch)));
      else{
        int value = 0;
        int rt = stack.pop();
        int lt = stack.pop();

        if(ch == '+') value = lt+rt;
        else if(ch == '-') value = lt-rt;
        else if(ch == '*') value = lt*rt;
        else if(ch == '/') value = lt/rt;
        stack.push(value);
      }
    }

    answer = stack.get(0);

    return answer;
  }


  public static void main(String args[]){
    Main T = new Main();

    Scanner kb = new Scanner(System.in);
    String str = kb.nextLine();

    System.out.println(T.solution(str));
  }
}
