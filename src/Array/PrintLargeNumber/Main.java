package Array.PrintLargeNumber;

// 바열_큰수 출력하기
import java.util.*;

public class Main {

    public ArrayList<Integer> solution(int[] arr){
        ArrayList answerList = new ArrayList<Integer>();

        answerList.add(arr[0]);
        for(int i=1; i<arr.length; i++){
            if(arr[i] > arr[i-1]){
                answerList.add(arr[i]);
            }
        }
        return answerList;
    }


    public static void main(String args[]){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int cnt = kb.nextInt();
        int[] arr = new int[cnt];
        for(int i=0; i<cnt; i++){
            arr[i] = kb.nextInt();
        }

        for(int x : T.solution(arr)){
            System.out.print(x + " ");
        }
    }

}
