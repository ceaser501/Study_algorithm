package Stack_Queue.Queue_5_8_EmergencyRoom;

// 큐_응급실
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Class 로 환자번호 index와 위험도점수를 같이 주는 이유는
 * 위험도 점수만 주면 70 60 90 60 60 60 와 같은 케이스에서 60이 몇번째 60인지 모르기 때문에
 * 번호가 필요하다
 */
class Person{
    int id;
    int priority;
    public Person(int id, int priority){
        this.id = id;
        this.priority = priority;
    }
}

class Main {
    public int solution(int[] em, int m){
        int answer = 0;

        Queue<Person> Q = new LinkedList();
        for(int i=0; i<em.length; i++){
            Q.offer(new Person(i, em[i]));    // (0, 60), (1, 50) ... 형태로 index, 값 으로 들어 감
        }

        while(!Q.isEmpty()){
            Person temp = Q.poll();
            for(Person q : Q){         // Queue 내부 모든 element 탐색
                if(q.priority > temp.priority){
                    Q.offer(temp);    // temp보다 응급환자 있을 때, 해당 element는 queue 뒤에 offer
                    temp = null;
                    break;
                }
            }
            if(temp != null){           // 더이상 해당 element 보다 위험도가 큰건 없다
                answer++;
                if(temp.id == m) return answer;    // 찾고자 하는 index의 환자번호가 temp와 같으면 return
            }
        }

        return answer;
    }


    public static void main(String args[]){
        Main T = new Main();

        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] em = new int[n];
        for(int i=0; i<n; i++){
            em[i] = kb.nextInt();
        }

        System.out.println(T.solution(em, m));
    }
}
