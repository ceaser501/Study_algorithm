package Efficiency.Efficiency_3_1_ArrayConcatenation;

// 효율성_배열합치기
import java.util.*;
import java.util.stream.Collectors;

public class Main {

  public List<Integer> solution(int n, int[] arrN, int m, int[] arrM){
    ArrayList<Integer> answer = new ArrayList<>();
    for(int i=0; i<n; i++){
      answer.add(arrN[i]);
    }

    for(int i=0; i<m; i++){
      answer.add(arrM[i]);
    }
    return answer.stream().sorted().collect(Collectors.toList());
  }


  public static void main(String args[]){
    Main T = new Main();

    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    int[] arrN = new int[n];
    for(int i=0; i<n; i++){
      arrN[i] = kb.nextInt();
    }

    int m = kb.nextInt();
    int[] arrM = new int[m];
    for(int i=0; i<m; i++){
      arrM[i] = kb.nextInt();
    }

    for(int x : T.solution(n, arrN, m, arrM)){
      System.out.print(x + " ");
    }
  }
}
