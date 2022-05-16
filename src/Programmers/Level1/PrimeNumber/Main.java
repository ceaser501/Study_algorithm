package Programmers.Level1.PrimeNumber;

// 소수 만들기(에라토스테네스의 체 미적용)
public class Main {
    public int solution(int[] nums) {
        int answer = 0;

        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int k=j+1; k<nums.length; k++){
                    int sum = nums[i] + nums[j] + nums[k];
                    // System.out.println(nums[i] + " + " + nums[j] + " + " + nums[k] + " = " + sum);
                    if(isPrimeNumber(sum)) answer++;
                }
            }
        }

        return answer;
    }

    public boolean isPrimeNumber(int sum){
        for(int i=2; i<sum; i++){
            if(sum%i == 0) return false;
        }

        return true;
    }

    public static void main(String args[]){
        Main T = new Main();
        System.out.print(T.solution(new int[]{1,2,7,6,4}));
    }
}
