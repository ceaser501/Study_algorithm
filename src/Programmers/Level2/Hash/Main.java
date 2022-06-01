package Programmers.Level2.Hash;

import java.util.Arrays;
import java.util.HashMap;

// 전화번호 목록
public class Main {

  public boolean solution(String[] phone_book) {
    // 오름차순 정렬
    // String 정렬을 이용하면, a ab abc 와 같이 뒤에 문자가 더 붙어있는 경우, 그 뒤로 순차적으로 정렬 해준다
    // 즉 바로뒤의 것과만 비교하면 된다!
    Arrays.sort(phone_book);

    // String을 길이 기준으로 오름차순 정렬
    //Arrays.sort(phone_book, Comparator.comparingInt(String::length));

    // 접두사이므로 바로 뒤의 것과, 현재의 것만 비교하면 된다 (String 배열의 sort 정렬)
    for(int i=0; i<phone_book.length-1; i++){
      if(phone_book[i+1].startsWith(phone_book[i])) return false;
    }

    return true;
  }

  public boolean solution2(String[] phone_book) {

    HashMap<String, Integer> map = new HashMap<>();
    for(String s : phone_book){
      map.put(s, 0);      // value는 의미없음
    }

    // 모든 전화번호의 substring이 HashMap에 존재하는지 확인한다.
    for (int i = 0; i < phone_book.length; i++) {
      for (int j = 0; j < phone_book[i].length(); j++) {
        if (map.containsKey(phone_book[i].substring(0, j)))
          return false;
      }
    }

    return true;
  }

  public static void main(String args[]){
    Main T = new Main();
    System.out.println(T.solution2(new String[]{"119", "97674223", "1195524421"}));
    //System.out.println(T.solution(new String[]{"123","456","789"}));
    //System.out.println(T.solution(new String[]{"12","123","567","88", "1235"}));
  }
}
