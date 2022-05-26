package Programmers.Level2.Country124;

// 124 나라의 숫자
public class Main {

    public String solution(int n) {
        String[] num = {"4","1","2"};
        String answer = "";

        while(n > 0){
            answer = num[n % 3] + answer;       // 일의자리 부터 빼줌
            n = (n - 1) / 3;                    // 일의자리를 빼고나서 자리수 땡겨줌
        }
        return answer;
    }

    public String solution2(int n) {
        String answer = "";

        while(n > 0){
            int rest = n % 3;
            n /= 3;
            if(rest == 0){
                rest = 4;
                n -= 1; // 나누어 떨어졌으니까
            }
            answer = rest + answer;
        }

        return answer;
    }

    public static void main(String args[]){
        Main T = new Main();
        System.out.println(T.solution(1));  // 01   1/3 = 0 ... 1
        System.out.println(T.solution(2));  // 02   2/3 = 0 ... 2
        System.out.println(T.solution(3));  // 04   3/3 = 1 ... 4

        System.out.println(T.solution(4));  // 11  4/3 = 1... 1
        System.out.println(T.solution(5));  // 12  5/3 = 1... 2
        System.out.println(T.solution(6));  // 14  6/3 = 2... 4

        System.out.println(T.solution(7));  // 21  7/3 = 2... 1
        System.out.println(T.solution(8));  // 22  8/3 = 2... 2
        System.out.println(T.solution(9));  // 24  9/3 = 3... 4

        System.out.println(T.solution(10));  // 41  10/3 = 3... 1
        System.out.println(T.solution(11)); // 42  11/3 = 3... 2
        System.out.println(T.solution(12)); // 44  12/3 = 4... 4

        System.out.println(T.solution(13)); // 111  13/3 = 3... 1
    }
}
