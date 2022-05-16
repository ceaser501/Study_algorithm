package Programmers.Level1.AddTwoNumbers;

import java.util.*;

public class Main {
    public int[] solution(int[] numbers) {
        int[] ch = new int[numbers.length];

        TreeSet<Integer> ts = new TreeSet<>();

        for(int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length; j++){
                ts.add(numbers[i] + numbers[j]);
            }
        }

//        for(int i=0; i<numbers.length; i++){
//            ch[i] = 1;          // 기준 인덱스는 사용했으므로 1
//            for(int j=0; j<numbers.length; j++){
//                if(ch[j] != 1){     // 기준 인덱스 아닌 것만 비교 인덱스로 사용 가능
//                   ts.add(numbers[i] + numbers[j]);
//                }
//            }
//            ch[i] = 0;          // 기준 인덱스는 다시 0으로 초기화
//        }
//
        int[] answer = new int[ts.size()];

        int count = 0;
        for(int x : ts){
            answer[count++] = x;
        }

        // Integer intvalue로 map을 변경 후 toArray
//        return ts.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    public static void main(String args[]){
        Main T = new Main();
        for(int x : T.solution(new int[]{5,0,2,7})) System.out.print(x + " ");
    }
}
