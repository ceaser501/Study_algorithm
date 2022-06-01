package Programmers.Level2.BiggestNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// 가장 큰 수
public class Main {
  public String solution(int[] numbers) {
    String answer = "";

    ArrayList<String> str = new ArrayList<>();
    for(int i=0; i<numbers.length; i++){
        str.add(String.valueOf(numbers[i]));
    }

    Collections.sort(str, (a, b) -> (b+a).compareTo(a+b));

    if(str.get(0).equals("0")) {  // 내림차순 정렬 했는데, 첫번째가 0이라면 나머지도 0이란 소리 -> 0 리턴 (000)
      return "0";
    }

    for(String s : str)
      answer += s;

    return answer;
  }

  public String solution2(int[] numbers) {
    // 숫자를 문자열로 변환
    String[] result = new String[numbers.length];
    for (int i = 0; i < numbers.length; i++) {
      result[i] = String.valueOf(numbers[i]);
    }

    // 정렬
    Arrays.sort(result, (o1, o2) -> ((o2 + o1).compareTo(o1 + o2)));

    // 0만 여러개 있는 배열의 경우 하나의 0만 리턴
    if(result[0].equals("0")) {
      return "0";
    }

    String answer = "";
    // 정렬된 문자 하나로 합치기
    for (String a : result) {
      answer += a;
    }
    return answer;
  }

  public static void main(String args[]){
    Main T = new Main();
    System.out.println(T.solution2(new int[]{6, 10, 2}));
    System.out.println(T.solution2(new int[]{3, 30, 34, 5, 9}));
  }
}
