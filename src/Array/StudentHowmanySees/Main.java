package Array.StudentHowmanySees;

// 배열_보이는 학생
import java.util.*;

public class Main {
    public int solution(int[] height){
        int studentCnt = 1;
        int maxHeight = height[0];

        for(int i=1; i<height.length; i++){
            if(height[i] > maxHeight){
                studentCnt++;
                maxHeight = height[i];
            }
        }

        return studentCnt;
    }

    public static void main(String args[]){
        Main T = new Main();

        Scanner kb = new Scanner(System.in);
        int cnt = kb.nextInt();
        int[] height = new int[cnt];
        for(int i=0; i<cnt; i++){
            height[i] = kb.nextInt();
        }

        System.out.println(T.solution(height));
    }
}
