package Sorting_Searching.Sorting_6_6_Mischief;

// 정렬_장난꾸러기
import java.util.*;

public class Main {

  public String solution(int n, int[] arr){
    String answer = "";

    int[] orgArr = arr.clone();   // arr.clone() 깊은 복사, 주소 값을 연결하지 않음
    // int[] orgArr = arr; 이렇게 하면 얕은 복사라, 주소 값이 연결되어 하단의 sort를 하면 orgArr도 바뀐다

    Arrays.sort(arr);
    for(int i=0; i<n; i++){
      if(orgArr[i] != arr[i]) answer += (i+1) + " ";
    }

    return answer;
  }


  public static void main(String args[]){
    Main T = new Main();

    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    int[] arr = new int[n];
    for(int i=0; i<n; i++) arr[i] = kb.nextInt();

    System.out.println(T.solution(n, arr));
  }
}
