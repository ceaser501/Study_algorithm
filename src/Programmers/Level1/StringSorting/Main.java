package Programmers.Level1.StringSorting;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
  public String[] solution(String[] strings, int n) {
    String[] answer = new String[strings.length];

//    StringBuilder 를 사용한 예 (속도면에서 훨씬 빠름)
//    StringBuilder sb = new StringBuilder();
//    for(int i = 0; i<strings.length ; i++){
//      sb.append(strings[i].charAt(n));
//      sb.append(strings[i]);
//
//      answer[i] = sb.toString();
//      sb.setLength(0);      // string builder 초기화
//    }


    for(int i = 0; i<strings.length ; i++){
      answer[i] = strings[i].charAt(n) + strings[i];
    }

    Arrays.sort(answer);
    for(int i = 0; i<answer.length; i++){
      answer[i] = answer[i].substring(1);
    }

    return answer;
  }

  // compareTo를 이용
  public String[] solution2(String[] strings, int n) {
    Arrays.sort(strings, (o1, o2) -> {
      if(o1.charAt(n) > o2.charAt(n)) return 1;
      else if(o1.charAt(n) < o2.charAt(n)) return -1;
      return o1.compareTo(o2);
    });

    return strings;
  }

  // compareTo를 이용 (람다식 안쓴 버전)
  public String[] solution3(String[] strings, int n) {
    Arrays.sort(strings, new Comparator<String>(){
      @Override
      public int compare(String s1, String s2){
        if(s1.charAt(n) > s2.charAt(n)) return 1;
        else if(s1.charAt(n) < s2.charAt(n)) return -1;
        return s1.compareTo(s2);
      }
    });
    return strings;
  }

  public static void main(String args[]){
    Main T = new Main();

    for(String s : T.solution(new String[]{"sun", "bed", "car"}, 1)){
      System.out.print(s + " ");
    }
    System.out.println();
    for(String s : T.solution2(new String[]{"abce", "abcd", "cdx"}, 1)){
      System.out.print(s + " ");
    }
  }
}
