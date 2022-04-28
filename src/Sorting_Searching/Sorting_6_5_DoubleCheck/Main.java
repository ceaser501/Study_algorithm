package Sorting_Searching.Sorting_6_5_DoubleCheck;

// 정렬_중복 확인
import java.util.*;

public class Main {

  // hashset을 이용한 방법 (복잡도 : O(n))
  public String solution(int num, int[] arr){
    String answer = "U";

    Set<Integer> hs = new HashSet();
    for(int i=0; i<num; i++){
      hs.add(arr[i]);
    }

    if(arr.length != hs.size()) return "D";

    return answer;
  }

  // hashmap 을 이용한 방법 (복잡도 : O(n))
  public String solution1(int num, int[] arr){
    String answer = "U";

    HashMap<Integer, Integer> map = new HashMap();
    for(int i=0; i<num; i++){
      map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
      if(map.get(arr[i]) > 1) return "D";
    }

    return answer;
  }

  // 정렬을 이용한 방법 (복잡도 : O(nlogn) 으로 성능은 떨어짐)
  public String solution2(int num, int[] arr){
    String answer = "U";

    Arrays.sort(arr);         // 오름차순
    for(int i=0; i<num-1; i++){
      if(arr[i] == arr[i+1]) return "D";
    }

    return answer;
  }

  public static void main(String args[]){
    Main T = new Main();

    Scanner kb = new Scanner(System.in);
    int num = kb.nextInt();
    int[] arr = new int[num];
    for(int i=0; i<num; i++) arr[i] = kb.nextInt();

    System.out.println(T.solution1(num, arr));
  }
}
