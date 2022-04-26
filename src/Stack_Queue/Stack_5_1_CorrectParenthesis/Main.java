package Stack_Queue.Stack_5_1_CorrectParenthesis;

// 스택_올바른 괄호
import java.util.*;

public class Main {

  public String solution(String str){
    String answer = "YES";
    Stack<Character> stack = new Stack();

    for(char c : str.toCharArray()){
      if(c == '(') stack.push(c);             // ( 라면 stack 에 push 한다
      else{
        // )가 더 많은 경우
        if(stack.isEmpty()) return "NO";      // pop 하려고 했으나, stack이 비어있다면 짝이 안맞으므로 return "NO"
        stack.pop();                          // ) 라면 stack에서 pop 한다
      }
    }
    // (가 더 많은 경우
    if(!stack.isEmpty()) return "NO";         // ) 에 맞는 모든 (를 pop 했으나, 남은게 있다는 것은 짝이 안맞는 다는 것으로 return "NO"

    return answer;
  }


  public static void main(String args[]){
    Main T = new Main();

    Scanner kb = new Scanner(System.in);
    String str = kb.next();

    System.out.println(T.solution(str));
  }
}
