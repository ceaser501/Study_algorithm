package HashMap.HashMap_4_4_FindAllAnagram;

// 해쉬_모든 아나그램 찾기
// 내가 푼 답
import java.util.*;

public class Main {

    /**
     * 입력값 : bacaAacba
     * 출력값 : abc
     */
    public int solution(String s, String t){
        int answer = 0;

        // s 문자열 저장용 map
        char[] sArr = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<t.length(); i++){                                    // t의 크기만큼 최초 map에 세팅
            map.put(sArr[i], map.getOrDefault(sArr[i], 0)+1);     // b a c
        }

        // t 문자열 저장용 map
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(char c : t.toCharArray()){
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        if(this.isAnagram(map, map2)) answer++;                                // 최초 anagram 체크

        int lt=0;
        for(int rt=t.length(); rt<sArr.length; rt++){
            map.put(sArr[rt], map.getOrDefault(sArr[rt], 0)+1);     // 다음번 sArr[rt] 추가
            map.put(sArr[lt], map.get(sArr[lt])-1);                           // 맨 앞 sArr[lt] 해당 하는 값을 map에서 -1
            if(map.get(sArr[lt]) == 0) map.remove(sArr[lt]);                  // map 안에 sArr[lt] 의 value가 0이면 키 삭제
            lt++;

            if(this.isAnagram(map, map2)) answer++;
        }
        return answer;
    }

    // 아나그램 검증용 function
    public boolean isAnagram(HashMap<Character, Integer> map, HashMap<Character, Integer> map2){
        boolean flag = true;

        for(char x : map2.keySet()){
            if(!map2.containsKey(x) || map2.get(x) != map.get(x)) flag = false;
        }

        return flag;
    }


    public static void main(String args[]){
        Main T = new Main();

        Scanner kb = new Scanner(System.in);
        String s = kb.next();         // 대상 문자열
        String t = kb.next();         // 찾을 문자열

        System.out.println(T.solution(s, t));
    }
}
