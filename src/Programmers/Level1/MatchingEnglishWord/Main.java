package Programmers.Level1.MatchingEnglishWord;

// 숫자 문자열과 영단어
public class Main {
    public int solution(String s) {
        String answer = "";
        String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String temp = "";
        for(int i=0; i<s.length(); i++){
            if(!Character.isDigit(s.charAt(i))){
                temp += s.charAt(i);

                for(int j=0; j<num.length; j++){
                    if(temp.equals(num[j])){
                        answer += j;
                        temp = "";
                    }
                }
            }else{
                answer += s.charAt(i);
            }
        }

        return Integer.parseInt(answer);
    }

    public int solution2(String s) {
        String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i=0; i<s.length(); i++){
            s = s.replace(num[i], Integer.toString(i));
        }

        int answer = Integer.parseInt(s);

        return answer;
    }


    public static void main(String args[]){
        Main T = new Main();
        System.out.print(T.solution("one4seveneight"));
    }
}