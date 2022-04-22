package HashMap_4_4_FindAllAnagram_2;

// 해쉬_모든 아나그램 찾기 (시간복잡도 O(n))
// 최적화
import java.util.*;

public class Main {

    /**
     * 입력값 : bacaAacba
     * 출력값 : abc
     */
    public int solution(String s, String t){
        int answer = 0;

        // 비교군 t에 해당하는 map 생성
        HashMap<Character, Integer> tmap = new HashMap<>();
        for(char c : t.toCharArray()){
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }

        // 대상 s에 해당하는 map 생성 (단, t 길이보다 -1 만큼만 세팅)
        HashMap<Character, Integer> smap = new HashMap<>();
        for(int i=0; i<t.length()-1; i++){
            smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0)+1);         // 0번째, 1번째만 세팅
        }

        int lt=0;
        for(int rt=t.length()-1; rt<s.length(); rt++){
            smap.put(s.charAt(rt), smap.getOrDefault(s.charAt(rt), 0)+1);       // 2번째 세팅
            if(smap.equals(tmap)) answer++;                                                // smap과 tmap을 비교 (equals는 key, value 모두 비교 됨)

            smap.put(s.charAt(lt), smap.get(s.charAt(lt))-1);                       // 최초 lt 위치의 값을 -1 한다
            if(smap.get(s.charAt(lt)) == 0) smap.remove(s.charAt(lt));                        // 값이 0인 lt key를 삭제
            lt++;
        }

        return answer;
    }
    public static void main(String args[]){
        Main T = new Main();

        Scanner kb = new Scanner(System.in);
        String s = kb.next();         // 대상 문자열
        String t = kb.next();         // 찾을 문자열

        System.out.println(T.solution(s, t));
    }
}
