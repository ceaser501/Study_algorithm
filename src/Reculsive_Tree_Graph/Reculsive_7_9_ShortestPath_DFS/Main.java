package Reculsive_Tree_Graph.Reculsive_7_9_ShortestPath_DFS;

/**
 * 이진트리에서 루트 노드 1에서 말단노드까지의 길이 중 가장 짧은 길이를 구하시오
 *
 * 원래는 BFS로 푸는 문제이지만, DFS로도 풀어보며 비교한다
 * 이때는 lt/rt중 하나만 있으면 DFS로 풀 수 없다
 * 아래 tree 구조를 입력으로 받고, 출력은 길이 1이다 (3노드)
 *       1
 *   2      3
 * 4   5
 */

class Node{
  int data;
  Node lt, rt;
  public Node(int val){
    data = val;
    lt=rt=null;
  }
}
public class Main {
  Node root;
  public int DFS(int L, Node root){
    if(root.lt == null && root.rt == null) return L;
    else return Math.min(DFS(L+1, root.lt), DFS(L+1, root.rt));
  }
  public static void main(String args[]){
    Main tree = new Main();
    tree.root = new Node(1);
    tree.root.lt = new Node(2);
    tree.root.rt = new Node(3);
    tree.root.lt.lt = new Node(4);
    tree.root.lt.rt = new Node(5);

    System.out.println(tree.DFS(0, tree.root));
  }
}
