package soup.algorithms.boj;

import java.util.Scanner;

// # 8진수 2진수
public class boj_1212 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String[] arr = {"000", "001", "010", "011", "100", "101", "110", "111"};
        String s = sc.nextLine();

        // 2진수 0이 되는 경우
        if (s.length() == 1 && s.charAt(0) == '0') {
            sb.append(0);
        } else {
            for (int i = 0; i < s.length(); i++) {
                int n = s.charAt(i) - '0'; // 8진수 자리 뽑기

                // 8진수의 첫째 자리 에서 0 처리
                if (i == 0 && n < 4) {
                    switch (n) {
                        case 1:
                            sb.append("1");
                            break;
                        case 2:
                            sb.append("10");
                            break;
                        case 3:
                            sb.append("11");
                    }
                } else {
                    sb.append(arr[n]);
                }
            }
        }
        System.out.println(sb.toString());
    }
}
