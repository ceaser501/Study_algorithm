package Reculsive_Tree_Graph.Tree_7_5_DFS;

// DFS_이진트리순회(DFS : Depth-First Search)

class Node{
  int data;
  Node lt, rt;      // Node 클래스의 객체 주소를 저장하는 변수 lt, rt

  // 기본형 변수가 값을 저장한다면, 클래스형 변수는 객체의 주소를 저장함함
  public Node(int val){
    data = val;
    lt=rt=null;
  }
}
public class Main {
  Node root;
  public void DFS(Node root){
    if(root == null)  return; // 말단 노드
    else{
      // System.out.print(root.data + " ");       // 전위  : 1 2 4 5 3 6 7
      DFS(root.lt);           // 최초 root 주소인 100번지로 와서, DFS 재귀 호출 하면서 lt 주소인 200번지가 넘어감 -> 이후 lt 주소인 400번지가 넘어감
      // System.out.print(root.data + " ");       // 중위 순회 : 4 2 5 1 6 3 7
      DFS(root.rt);
      System.out.print(root.data + " ");           // 후위 순회 : 4 5 2 6 7 3 1
    }
  }

  public static void main(String args[]){
    Main tree = new Main();
    tree.root = new Node(1);
    tree.root.lt = new Node(2);
    tree.root.rt = new Node(3);
    tree.root.lt.lt = new Node(4);
    tree.root.lt.rt = new Node(5);
    tree.root.rt.lt = new Node(6);
    tree.root.rt.rt = new Node(7);
    tree.DFS(tree.root); // tree.root 를 root 매개변수에 넘김
  }
}
