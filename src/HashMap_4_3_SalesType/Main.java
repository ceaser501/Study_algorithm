package HashMap_4_3_SalesType;

// 해쉬_매출액의 종류
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public ArrayList<Integer> solution(int n, int k, int[] sales){
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<k-1; i++){
            map.put(sales[i], map.getOrDefault(sales[i], 0)+1);
        }

        int lt = 0;
        for(int rt=k-1; rt<n; rt++){
            map.put(sales[rt], map.getOrDefault(sales[rt], 0) +1);
            answer.add(map.size());

            map.put(sales[lt], map.get(sales[lt])-1);               // lt가 rt 증가에 따라 오른쪽으로 1칸 이동해야 함 (기존 map에서 젤 앞에꺼부터 빼준다)
            if(map.get(sales[lt]) == 0) map.remove(sales[lt]);      // 0 일때는 remove해줘야 한다. 안해주면 .size()하면 0인 key도 카운트 된다
            lt++;
        }
        return answer;
    }

    // time limit exceeded (1500MS)
    public String solution1(int n, int k, int[] sales){
        String answer = "";

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n-k+1; i++){
            int j = 0;
            while(i+j <= i+k-1){
                map.put(sales[i+j], map.getOrDefault(sales[i+j], 0)+1);
                j++;
            }
            answer += map.size() + " ";
            map.clear();
        }

        return answer;
    }

    public static void main(String args[]){
        Main T = new Main();

        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();   // 전체 매출 기록
        int k = kb.nextInt();   // 연속 일수
        int[] sales = new int[n];
        for(int i=0; i<n; i++){
            sales[i] = kb.nextInt();
        }

        for(int x : T.solution(n, k, sales)){
            System.out.print(x + " ");
        }
    }
}
