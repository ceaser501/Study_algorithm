package HashMap_4_2_Anagram;

// 해쉬_아나그램
// 입출력 값 : AbaAeCe / baeeACA -> YES
// 입출력 값 : abaCC / Caaab -> NO
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    // str의 map과 str2의 map2를 만들어 놓고, key를 돌면서 key의 value가 같은지 확인한다
    public String solution(String str, String str2){
        String answer = "YES";

        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for(char c : str.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(char x : str2.toCharArray()){
            map2.put(x, map2.getOrDefault(x, 0) + 1);
        }

        for(char key : map.keySet()){
            if(map.get(key) != map2.get(key)) answer = "NO";
        }

        return answer;
    }

    // str 문자열을 위한 map만 하나 생성해 놓고, str2가 탐색하며 str문자열의 map에서 개수를 -1 씩한다
    // x의 키가 존재하지 않거나, 카운트가 0을 만나면 개수가 다르다는 뜻이므로 NO를 리턴한다
    public String solution1(String str, String str2){
        String answer = "YES";

        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : str.toCharArray()){
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        for(char x : str2.toCharArray()){
            if(!map.containsKey(x) || map.get(x) == 0) return "NO";
            map.put(x, map.get(x)-1);
        }

        return answer;
    }


    public static void main(String args[]){
        Main T = new Main();

        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        String str2 = kb.next();

        System.out.println(T.solution1(str, str2));
    }
}
