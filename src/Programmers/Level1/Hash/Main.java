package Programmers.Level1.Hash;

// 완주하지 못한 선수
import java.util.*;

public class Main {
  public String solution(String[] participant, String[] completion) {
    String answer = "";

    if(participant.length < 1 || participant.length > 100000){
      return "마라톤 경기에 참여한 선수의 수는 1명이상 100,000명 이하입니다.";
    }
    if(completion.length != participant.length - 1){
      return "completion의 길이는 participant의 길이보다 1 작습니다.";
    }

    HashMap<String, Integer> map = new HashMap<>();

    for(String player : participant){
      map.put(player, map.getOrDefault(player, 0) + 1);
    }

    for(String player : completion){
      map.put(player, map.get(player)-1);
    }

    // https://fullstatck.tistory.com/10 : map for each
    for(Map.Entry<String, Integer> entry : map.entrySet()){
      if(entry.getValue() > 0){
        answer += entry.getKey();
      }
    }

//    Arrays.stream(participant).filter(p -> !Arrays.asList(completion).contains(p)).forEach(
//      a -> {
//        if (a.length() >= 1) {
//          answer += a + "는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.";
//        }
//      }
//    );


    // 옵셔널로 체크 가능
//    Optional.ofNullable(participant[0]).ifPresent(
//        a -> {
//          answer = a + "는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.";
//        }
//    );

    return answer;
  }

  public static void main(String args[]){
    Main T = new Main();
    System.out.println(T.solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
    System.out.println(T.solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));

  }
}
