package Programmers.Level1.AddMissingNumbers;

import java.util.Arrays;

public class Main {

    public int solution(int[] numbers) {
        int answer = 45;

        for(int i=0; i<numbers.length; i++){
            answer -= numbers[i];
        }
        return answer;
    }

    public int solution2(int[] numbers){
        int answer = 0;

        for(int i=0; i<10; i++){
            boolean flag = isContains(numbers, i);
            if(!flag){
                answer += i;
            }
        }

        return answer;
    }

    public boolean isContains(int[] arr, int key){
        return Arrays.stream(arr).anyMatch(i -> i == key);
    }


    public static void main(String args[]){
        Main T = new Main();
        System.out.print(T.solution2(new int[]{1,2,3,4,6,7,8,0}));
    }
}
