package Reculsive_Tree_Graph.Tree_7_10_ShortestPath_BFS;

import java.util.*;

class Node{
  int data;
  Node lt, rt;

  public Node(int val){
    data = val;
    lt = rt = null;
  }
}
public class Main {
  Node root;

  public int BFS(Node root){
    Queue<Node> Q = new LinkedList<>();
    Q.offer(root);
    int L = 0;
    while(!Q.isEmpty()){
     //  System.out.println(Q.size());
      int len = Q.size();               // 바로 for문에 Q.size()로 돌리면 답이안나옴, 확인 필요 (Queue사이즈가 바뀐다?)
      for(int i=0; i<len; i++){
        Node curr = Q.poll();
        if(curr.lt == null && curr.rt == null) return L;
        else{
          if(curr.lt != null) Q.offer(curr.lt);
          if(curr.rt != null) Q.offer(curr.rt);
        }
      }
      L++;
    }

    return 0;
  }

  public static void main(String args[]){
    Main tree = new Main();
    tree.root = new Node(1);
    tree.root.lt = new Node(2);
    tree.root.rt = new Node(3);
    tree.root.lt.lt = new Node(4);
    tree.root.lt.rt = new Node(5);

    System.out.println(tree.BFS(tree.root));
  }
}
