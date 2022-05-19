package Programmers.Level1.AddNegativeNumbers;

// 음양더하기
public class Main {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for(int i=0; i<absolutes.length; i++)
            answer += absolutes[i] * (signs[i] ? 1 : -1);
        return answer;
    }

    public static void main(String args[]){
        Main T = new Main();
        System.out.println(T.solution(new int[]{4,7,12}, new boolean[]{true,false,true}));
        System.out.println(T.solution(new int[]{1,2,3}, new boolean[]{false,false,true}));
    }
}
