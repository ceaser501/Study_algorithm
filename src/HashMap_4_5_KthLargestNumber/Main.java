package HashMap_4_5_KthLargestNumber;

// 해쉬_K번째 큰 수 찾기
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public int solution(int n, int k, int[] arr){
        int answer = -1;

        /**
         * Set : 중복을 제거
         * TreeSet : 중복을 제거하면서 Sort를 같이 하고 싶을때 주로 사용.
         *   + Collections.reverseOrder() : 내림차순
         *   + 안쓰면 오름차순
         * HashMap : key-value
         * HashSet : key-value 형태로 중복을 제거
         *
         *
         * TreeSet methods
         * ts.add() : 특정 값을 더함
         * ts.remove() : 특정 값을 지움
         * ts.size() : TreeSet 원소 개수 카운트
         * ts.first() : TreeSet의 원소 중 첫번째 값
         * ts.last() : TreeSet의 원소 중 마지막 값
         */


        TreeSet<Integer> ts = new TreeSet<>(Collections.reverseOrder());
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int l=j+1; l<n; l++){
                    ts.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }

        int cnt = 0;
        for(int x : ts){
            cnt++;
            if(cnt == k) return x;
        }

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
