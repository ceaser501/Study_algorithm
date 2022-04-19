package Array.ReversePrimeNumber;

// 배열_뒤집은 소수
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public boolean isPrime(int num){
        if(num == 1) return false;
        for(int i=2; i<num; i++){
            if(num % i == 0)
                return false;
        }
        return true;
    }

    // 나머지 연산을 이용해서 변환
    public ArrayList<Integer> solution1(int num, int[] intArray){
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i=0; i<num; i++){
            int tmp  = intArray[i];
            int res = 0;        // 뒤집혀서 대입할 변수
            while(tmp > 0 ){
                int t = tmp%10;
                res = res * 10 + t;
                tmp = tmp / 10;
            }

            if(isPrime(res)) answer.add(res);
        }

        return answer;
    }


    // string 변환 후 -> int로 변환
    public ArrayList<Integer> solution(int num, int[] intArray){
        ArrayList<Integer> answer = new ArrayList<>();

        int[] reverseArray = new int[num+1];
        for(int i=0; i<num; i++){
            reverseArray[i] = Integer.parseInt(new StringBuilder(String.valueOf(intArray[i])).reverse().toString());
            if(isPrime(reverseArray[i])) answer.add(reverseArray[i]);
        }

        return answer;
    }

    public static void main(String args[]){
        Main T = new Main();

        Scanner kb = new Scanner(System.in);
        int num = kb.nextInt();
        int[] intArray = new int[num];

        for(int i=0; i<num; i++){
            intArray[i] = kb.nextInt();
        }

        for(int x : T.solution(num, intArray)){
            System.out.print(x + " ");
        }
    }
}
