package HashMap_4_1_ClassPresident;

// 해쉬_학급 회장
// 입력 값 : BACBACCACCBDEDE
// 출력 값 : C
import java.util.*;

public class Main {

    public char solution(String s){
        char answer = ' ';

        /**
         * 1. map.getOrDefault(key, defaultValue) : key에 따른 value를 가져오거나, 없으면 defaultValue를 가져온다
         * 2. map.containsKey('A') : 해당 key 가 있는지 판별한다 (true/false)
         * 3. map.size : map에 속한 key값의 개수를 출력한다
         * 4. map.remove('A') : 해당 key-value set을 삭제한다
         * 5. map.keySet() : for문을 돌 때, key를 돌린다
         */

        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : s.toCharArray()){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        for(char key : map.keySet()){
            if(map.get(key) > max){
                max = map.get(key);             // public V get(Object key) 이므로 int로 자동 캐스팅
                answer = key;
            }
        }

        return answer;
    }


    public static void main(String args[]){
        Main T = new Main();

        Scanner kb = new Scanner(System.in);
        String s = kb.next();

        System.out.println(T.solution(s));
    }
}
