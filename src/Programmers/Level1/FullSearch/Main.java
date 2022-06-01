package Programmers.Level1.FullSearch;


/**
 * 1번 : 1 2 3 4 5 / 1 2 3 4 5
 * 2번 : 2 1 2 3 2 4 2 5 / 2 1 2 3 2 4 2 5
 * 3번 : 3 3 1 1 2 2 4 4 5 5 / 3 3 1 1 2 2 4 4 5 5
 *
 * 문제1 : 1 2 3 4 5
 * 문제2 : 1 3 2 4 2
 */

import java.util.ArrayList;

// 완전 탐색
public class Main {

  public int[] solution(int[] answers) {
    int[] one = new int[]{1, 2, 3, 4, 5};
    int[] two = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
    int[] three = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    Integer[] score = new Integer[]{0, 0, 0};

    for(int i=0; i<answers.length; i++){
      if(answers[i] == one[i % one.length]) score[0]++;
      if(answers[i] == two[i % two.length]) score[1]++;
      if(answers[i] == three[i % three.length]) score[2]++;
    }

    int max = 0;
    for(int i : score){
      max = Math.max(i, max);
    }

    ArrayList<Integer> list = new ArrayList();
    if(max == score[0]) list.add(1);
    if(max == score[1]) list.add(2);
    if(max == score[2]) list.add(3);

    return list.stream().mapToInt(Integer::intValue).toArray();
  }


  public static void main(String args[]){
    Main T = new Main();

    for (int i : T.solution(new int[]{1, 2, 3, 4, 5})) {
      System.out.print(i + " ");    // 1
    }
    System.out.println();
    for (int i : T.solution(new int[]{1,3,2,4,2})) {
      System.out.print(i + " ");    // 1 2 3
    }
  }
}
