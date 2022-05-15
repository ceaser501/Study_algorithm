package Programmers.toBinaryString;

//        String binaryString = Integer.toBinaryString(i); //2진수
//        String octalString = Integer.toOctalString(i);   //8진수
//        String hexString = Integer.toHexString(i);       //16진수

// 보물지도
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i=0; i<n; i++){
            String temp = Integer.toBinaryString(arr1[i] | arr2[i]);
            temp = String.format("%" + n + "s", temp);          // %5s 이렇게하면 오른쪽부터 5자리를 채운다
            temp = temp.replace('1', '#').replace('0', ' ');
            answer[i] = temp;
        }
//
//        for(int i=0; i<n; i++){
//            String row = String.format(String.format("%%%ds", n), Integer.toBinaryString(arr1[i] | arr2[i]));   // or연산
//            for(int j=0; j<n; j++){
//                answer[i] = row.replace('1', '#').replace('0', ' ');
//            }
//        }

        return answer;
    }

    public static void main(String args[]){
        Solution T = new Solution();

        for(String x : T.solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28})) System.out.print(x + " ");
    }
}