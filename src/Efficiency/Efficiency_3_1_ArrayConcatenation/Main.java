package Efficiency.Efficiency_3_1_ArrayConcatenation;

// 효율성_배열합치기
import java.util.*;
import java.util.stream.Collectors;

public class Main {

  // 기존 sorted를 이용한 방식 (복잡도 : nlogn)
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

  // 2 pointers를 이용한 방법 (복잡도 : n)
  public ArrayList<Integer> solution1(int n, int[] arrN, int m, int[] arrM){
    ArrayList<Integer> answer = new ArrayList<>();

    int p1 = 0, p2 = 0;

    while(p1 < n && p2 < m){
      if(arrN[p1] < arrM[p2]){
        answer.add(arrN[p1]);       // answer.add(arrN[p1++]) 로 써도 된다
        p1++;
      }else{
        answer.add(arrM[p2]);
        p2++;
      }
    }
    // 한쪽 포인터가 n-1 또는 m-1에 도달하면, 위 while문이 종료되고
    // 남은 배열의 값이 answer에 add되면 된다
    // 근데 어떤게 먼저 도달했는지 모르므로 둘다 해줘야 함
    // p2가 도달했다면 p1 < n에 해당하는 것들이 있을 것이고, 그럼 answer에 넣어주면 된다 (반대 동일)
    while(p1<n) answer.add(arrN[p1++]);
    while(p2<m) answer.add(arrM[p2++]);


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
