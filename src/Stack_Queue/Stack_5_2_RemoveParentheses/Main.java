package Stack_Queue.Stack_5_2_RemoveParentheses;

// 스택_괄호문자제거
import java.util.*;

public class Main {

  public String solution(String str){
    String answer = "";

    // stack 에 push를 하다가, )를 넣을때, while을 돌면서
    // (를 만날때까지 돌면서 pop 한다
    Stack<Character> stack = new Stack<>();
    for(char c : str.toCharArray()){
      if(c != ')') stack.push(c);
      else{
        while(stack.pop() != '(');    //stack.pop 하고 한 것을 꺼냈을 때 ( 일때까지 돈다
      }
    }

    for(char c : stack) answer += c;

//    for(int i=0; i<stack.size(); i++){
//      answer += stack.get(i);
//    }

    return answer;
  }

  public static void main(String args[]){
    Main T = new Main();

    Scanner kb = new Scanner(System.in);
    String str = kb.next();

    System.out.println(T.solution(str));
  }
}
