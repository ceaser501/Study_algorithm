package Programmers.Level1.MaskingPhoneNumber;

// 전화번호 마스킹
public class Main {
  public String solution(String phone_number) {
    int index = phone_number.length()-4;

    return phone_number.substring(0, index).replaceAll("[0-9]", "*")
        + phone_number.substring(index);
  }

  public String solution2(String phone_number) {
    char[] ch = phone_number.toCharArray();
    for(int i=0; i<ch.length-4; i++) ch[i] = '*';

    return String.valueOf(ch);
  }

  public static void main(String args[]){
    Main T = new Main();

    System.out.println(T.solution2("01033334444"));
    System.out.println(T.solution2("027778888"));
  }

}
