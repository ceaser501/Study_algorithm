package Programmers.Level1.KthNumber;

/**
 * Arrays.copyOf(원배열, 복사할 길이)
 * Arrays.copyOfRange(원본 배열, 복사할 시작인덱스, 복사할 끝 인덱스) : 인덱스는 0부터 시작, 복사한 배열에서 값을 바꿔도, 원본배열의 값이 바뀌지 않음
 */

import java.util.Arrays;

// K번째수
public class Main {
    // Arrays.copyOfRange 이용
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int from = commands[i][0]-1;
            int to = commands[i][1];
            int k = commands[i][2];

            int[] temp = Arrays.copyOfRange(array, from, to);
            Arrays.sort(temp);
            answer[i] = temp[k-1];
        }
        return answer;
    }

    // 일치하는 데이터 찾기 findData 함수 이용
    public int[] solution2(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int count = 0;

        for(int i=0; i<commands.length; i++){
            int from = commands[i][0];
            int to = commands[i][1];
            int k = commands[i][2];

            answer[count++] = findData(array, from, to, k);
        }
        return answer;
    }

    public int findData(int[] array, int start, int end, int key){
        int[] newArray = new int[end-start+1];
        int count = 0;

        for(int i=start-1; i<end; i++){
            newArray[count++] = array[i];
        }

        Arrays.sort(newArray);

        return newArray[key-1];
    }

    public static void main(String args[]){
        Main T = new Main();
        for(int i : T.solution2(new int[]{1,5,2,6,3,7,4}, new int[][]{{2,5,3}, {4,4,1}, {1,7,3}})){
            System.out.print(i + " ");
        }
    }
}
