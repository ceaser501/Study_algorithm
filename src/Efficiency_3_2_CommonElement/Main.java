package Efficiency_3_2_CommonElement;

// 효율성_공통원소구하기
import java.util.*;

public class Main {

  public ArrayList<Integer> solution(int n, int[] arrN, int m, int[] arrM){
    ArrayList<Integer> answer = new ArrayList<>();
    /**
     * 리스트 생성 ~ array read 해서 세팅하는 방법
    // 1. 일반적인 방법
    List<Integer> list = new ArrayList<>();
    for(int i=0; i<arrN.length; i++){
      list.add(arrN[i]);
    }

    // 2. java 8
    List<Integer> list1 = Arrays.stream(arrN).boxed().collect(Collectors.toList());
    **/

    Arrays.sort(arrN);
    Arrays.sort(arrM);

    // https://yuja-kong.tistory.com/183
    // Collections.sort(Arrays.stream(arrN).boxed().collect(Collectors.toList()));
    // Collections.sort(Arrays.stream(arrM).boxed().collect(Collectors.toList()));

    int p1=0, p2=0;
    while(p1<n && p2<m){
      if(arrN[p1] == arrM[p2]){
        answer.add(arrN[p1]);
        p1++;
        p2++;
      }else if(arrN[p1] < arrM[p2]){
        p1++;
      }else{
        p2++;
      }
    }

    return answer;
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
