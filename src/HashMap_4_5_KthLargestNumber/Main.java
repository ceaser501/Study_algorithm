package HashMap_4_5_KthLargestNumber;

// 해쉬_K번째 큰 수 찾기
import java.util.Scanner;

public class Main {
    public int solution(int n, int k, int[] arr){
        int answer = 0;



        return answer;
    }


    public static void main(String args[]){
        Main T = new Main();

        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();           // 자연수 개수
        int k = kb.nextInt();           // K번째 큰 수

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = kb.nextInt();
        }

        System.out.println(T.solution(n, k, arr));
    }
}
