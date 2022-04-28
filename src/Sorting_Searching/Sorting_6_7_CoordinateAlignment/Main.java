package Sorting_Searching.Sorting_6_7_CoordinateAlignment;

// 정렬_좌표정렬
import java.util.*;

class Point implements Comparable<Point>{   // Point 타입의 Comparable implement (모든 좌표문제는 이와 같이 풀면 됌)
  public int x, y;
  Point(int x, int y){
    this.x = x;
    this.y = y;
  }

  @Override
  public int compareTo(Point o) {
    // o.y-this.y 는 내림차순 / o.x-this.x는 내림차순
    if(this.x == o.x) return this.y-o.y;    // return의 결과가 음수 일 경우 오름차순 정렬, 양수 일 경우는 내림차순 정렬
    else return this.x-o.x;
  }
}

class Main {
  public static void main(String args[]){
    Main T = new Main();

    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    ArrayList<Point> arr = new ArrayList<>();
    for(int i=0; i<n; i++){
      int x = kb.nextInt();
      int y = kb.nextInt();

      arr.add(new Point(x, y));
    }

    Collections.sort(arr);
    for(Point o : arr) System.out.println(o.x + " " + o.y);
  }
}
