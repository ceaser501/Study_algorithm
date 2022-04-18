package String.FlipWord;

// 문자열_단어뒤집기
import java.util.*;

public class Main {

  public ArrayList<String> solution(String[] str){
    ArrayList<String> answer = new ArrayList<>();

    for(String s : str){
      s = new StringBuilder(s).reverse().toString();
      answer.add(s);
    }

    return answer;
  }

  public ArrayList<String> solution1(String[] str){
    ArrayList<String> answer = new ArrayList<>();

    for(String s : str){
      char[] ch = s.toCharArray();
      int lt = 0;
      int rt = ch.length-1;
      char temp = ' ';

      while(lt < rt){
        temp = ch[lt];
        ch[lt] = ch[rt];
        ch[rt] = temp;

        lt++;
        rt--;
      }
      answer.add(String.valueOf(ch));
    }

    return answer;
  }


  public static void main(String args[]){
    Main T = new Main();

    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();

    String[] str = new String[n];
    for(int i=0; i<str.length; i++){
      str[i] = kb.next();
    }

    for(String x : T.solution1(str)){
      System.out.println(x);
    }
  }
}
