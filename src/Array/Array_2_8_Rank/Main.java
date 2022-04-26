package Array.Array_2_8_Rank;

// 배열_등수구하기
import java.util.*;
import java.util.stream.Collectors;

public class Main {

  // 내림차순 정렬 후에, 원래 점수 배열과 비교해서 index를 이용하는 방법
  public int[] solution(int cnt, int[] score){
    int[] answer = new int[cnt];

    // 입력된 점수를 내림차순 정렬해서 rankArray List에 순서대로 세팅
    List<Integer> rankArray = Arrays.stream(score)
        .boxed()
        .sorted(Collections.reverseOrder())
        .collect(Collectors.toList());

    // 전체 점수 중에서 rank[] 배열과 같은 것이 있는지 보고, 있으면 index+1 이 등수임
    for(int i=0; i<cnt; i++){
      answer[i] = rankArray.indexOf(score[i]) + 1;
    }
    return answer;
  }

  // 전체 입력된 점수가, 나머지를 탐색하면서 rank를 ++ 한 뒤 대입하는 방법
  public int[] solution1(int cnt, int[] score){
    int[] answer = new int[cnt];

    for(int i=0; i<cnt; i++){
      int rank = 1;
      for(int j=0; j<cnt; j++){
        if(score[i] < score[j]){
          rank++;
        }
      }

      answer[i] = rank;
    }

    return answer;
  }

  public static void main(String args[]){
    Main T = new Main();
    Scanner kb = new Scanner(System.in);
    int cnt = kb.nextInt();
    int[] score = new int[cnt];
    for(int i=0; i<cnt; i++){
      score[i] = kb.nextInt();
    }

    for(int x : T.solution(cnt, score)){
      System.out.print(x + " ");
    }
  }

}
