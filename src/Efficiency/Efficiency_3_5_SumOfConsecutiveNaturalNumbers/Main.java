package Efficiency.Efficiency_3_5_SumOfConsecutiveNaturalNumbers;

// 효율성_연속된 자연수의 합
import java.util.*;

public class Main {

    public int solution(int n){
        int answer = 0;

//        12345 = 15 > 14
//        2345 = 14
//        3456 = 18 > 14
//        456 = 15 > 14
//        56 = 11 < 14
//        567 = 18 > 14
//        67 = 13 < 14
//        678 = 21 > 14
//        78 = 15 > 14
//
//
//        12345 = 15
//        2345 = 14 < 15
//        23456 = 20 > 15
//        3456 = 18 > 15
//        456 = 15
//        567 = 18 > 15
//        67 = 13 < 15
//        678 = 21 > 15
//        78 = 15



        return answer;
    }


    public static void main(String args[]){
        Main T = new Main();

        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        System.out.println(T.solution(n));
    }
}
