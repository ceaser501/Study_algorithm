package Programmers.Level1.Ascii;

/**
 * 1. 문자를 int에 담으면, 아스키코드가 담기므로 그냥 대소비교가 가능하다
 * 2. Arrays.sort 를 하게되면, 내부 아스키코드를 기준으로 정렬이 된다 (오름차순)
 * 3. 내림차순 정렬을 위해서는 StringBuilder의 정렬을 이용하면 간결하다
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 문자열 내림차순으로 배치하기
public class Main {

    // Arrays.sort와 StringBuilder를 이용
    public String solution(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        StringBuilder builder = new StringBuilder(String.valueOf(c));

        return builder.reverse().toString();
    }

    // Arrays.sort와 Collections.reverseOrder()를 이용
    public String solution2(String s) {
        String answer = "";
        String[] splitStr = s.split("");            // Z b c d e f g 가 하나하나 String[]에 담김

//        for(int i=0; i<splitStr.length; i++) System.out.print(splitStr[i] + " >>");

        Arrays.sort(splitStr, Collections.reverseOrder());

        for(int i=0; i<splitStr.length; i++) answer += splitStr[i];

        return answer;
    }

    // 정렬을 직접 구현한 버전
    public String solution3(String s) {
        char[] ch = s.toCharArray();
        for(int i=0; i<ch.length-1; i++){
            for(int j=i+1; j<ch.length; j++){
                char temp = ' ';
                if(ch[i] < ch[j]){
                    temp = ch[i];
                    ch[i] = ch[j];
                    ch[j] = temp;
                }
            }
        }

        return String.valueOf(ch);
    }

    // Stream을 이용한 방법
    public String solution4(String s) {
        return Stream.of(s.split(""))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining());
    }

    public static void main(String args[]){
        Main T = new Main();
        System.out.print(T.solution2("Zbcdefg"));
    }
}
