package Sorting_Searching.Sorting_6_1_Selection_Sort;

// 정렬_선택정렬
import java.util.Scanner;

public class Main {

  public int[] solution(int n, int[] arr){
    int[] answer = new int[n];

    return answer;
  }


  public static void main(String args[]){
    Main T = new Main();

    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    int[] arr = new int[n];
    for(int i=0; i<n; i++){
      arr[n] = kb.nextInt();
    }

    for(int m : T.solution(n, arr)) System.out.println(m + " ");
  }
}
